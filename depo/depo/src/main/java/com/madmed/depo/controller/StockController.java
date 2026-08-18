package com.madmed.depo.controller;

import com.madmed.depo.entity.Product;
import com.madmed.depo.entity.StockMovement;
import com.madmed.depo.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stok")
@CrossOrigin(origins = "*") // Web sayfamızın bu API'ye erişebilmesi için güvenlik kilidini açıyoruz
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    // 1. Web sayfası depodaki ürünleri listelemek istediğinde bu çalışır
    @GetMapping("/urunler")
    public List<Product> getAllProducts() {
        return stockService.getAllProducts();
    }

    // 2. Web sayfasından sisteme yeni bir malzeme eklendiğinde bu çalışır
    @PostMapping("/urun-ekle")
    public Product addProduct(@RequestBody Product product) {
        return stockService.addProduct(product);
    }

    // 3. Web sayfasından mal çekme veya verme işlemi yapıldığında bu çalışır
    @PostMapping("/hareket")
    public String processMovement(
            @RequestParam Long productId,
            @RequestParam StockMovement.IslemTipi islemTipi,
            @RequestParam Integer miktar) {

        stockService.processStockMovement(productId, islemTipi, miktar);
        return "İşlem başarıyla kaydedildi!";
    }
    // Web sayfasından silme isteği geldiğinde çalışır
    @DeleteMapping("/sil/{id}")
    public String deleteProduct(@PathVariable Long id) {
        stockService.urunSil(id);
        return "Ürün başarıyla silindi.";
    }
}