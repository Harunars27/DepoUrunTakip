package com.madmed.depo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "stock_movements")
public class StockMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Ürünler tablosu ile ilişki kuruyoruz (Foreign Key)
    @ManyToOne
    @JoinColumn(name = "urun_id", nullable = false)
    private Product product;

    // Sadece GİRİŞ veya ÇIKIŞ olabileceğini belirtiyoruz
    @Enumerated(EnumType.STRING)
    @Column(name = "islem_tipi", nullable = false)
    private IslemTipi islemTipi;

    @Column(nullable = false)
    private Integer miktar;

    @Column(name = "islem_tarihi")
    private LocalDateTime islemTarihi;

    // Veritabanına kaydedilmeden hemen önce tarihi otomatik atar
    @PrePersist
    protected void onCreate() {
        this.islemTarihi = LocalDateTime.now();
    }

    public enum IslemTipi {
        GIRIS, CIKIS
    }

    // --- Getter ve Setter Metotları ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public IslemTipi getIslemTipi() { return islemTipi; }
    public void setIslemTipi(IslemTipi islemTipi) { this.islemTipi = islemTipi; }

    public Integer getMiktar() { return miktar; }
    public void setMiktar(Integer miktar) { this.miktar = miktar; }

    public LocalDateTime getIslemTarihi() { return islemTarihi; }
    public void setIslemTarihi(LocalDateTime islemTarihi) { this.islemTarihi = islemTarihi; }
}