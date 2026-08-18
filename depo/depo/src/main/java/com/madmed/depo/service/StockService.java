package com.madmed.depo.service;

import com.madmed.depo.entity.Product;
import com.madmed.depo.entity.StockMovement;
import com.madmed.depo.repository.ProductRepository;
import com.madmed.depo.repository.StockMovementRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StockService {

    private final ProductRepository productRepository;
    private final StockMovementRepository stockMovementRepository;

    // Repository'leri projeye dahil ediyoruz (Dependency Injection)
    public StockService(ProductRepository productRepository, StockMovementRepository stockMovementRepository) {
        this.productRepository = productRepository;
        this.stockMovementRepository = stockMovementRepository;
    }

    // 1. Depodaki tüm ürünleri listele
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Sisteme yeni bir malzeme tanımla (Örn: Logolu Bardak)
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // 3. ANA İŞLEM: Ana depodan mal çekme (GİRİŞ) veya Mutfak/Bara mal verme (ÇIKIŞ)
    @Transactional // Bu anatomi çok önemli: Bir hata olursa işlemi yarıda keser ve veritabanını bozmaz.
    public void processStockMovement(Long productId, StockMovement.IslemTipi islemTipi, Integer miktar) {

        // Önce işlemi yapacağımız ürünü buluyoruz
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Ürün bulunamadı!"));

        // Stok miktarını güncelliyoruz
        if (islemTipi == StockMovement.IslemTipi.GIRIS) {
            product.setMevcutStok(product.getMevcutStok() + miktar);
        } else if (islemTipi == StockMovement.IslemTipi.CIKIS) {
            // Çıkış yapılacak ama depoda o kadar mal var mı? Kontrol et.
            if (product.getMevcutStok() < miktar) {
                throw new RuntimeException("Uyarı: Depoda yeterli stok yok! Mevcut: " + product.getMevcutStok());
            }
            product.setMevcutStok(product.getMevcutStok() - miktar);
        }

        // Ürünün yeni stok durumunu kaydediyoruz
        productRepository.save(product);

        // Gelecekte rapor alabilmek için bu hareketi arşive kaydediyoruz
        StockMovement movement = new StockMovement();
        movement.setProduct(product);
        movement.setIslemTipi(islemTipi);
        movement.setMiktar(miktar);

        stockMovementRepository.save(movement);
    }
    // Ürünü sistemden tamamen sil
    public void urunSil(Long productId) {
        productRepository.deleteById(productId);
    }
}