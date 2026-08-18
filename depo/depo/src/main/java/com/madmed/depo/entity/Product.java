package com.madmed.depo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ad;

    private String kategori;

    @Column(nullable = false)
    private String birim;

    @Column(name = "mevcut_stok")
    private Integer mevcutStok = 0;

    @Column(name = "minimum_stok")
    private Integer minimumStok = 0;

    // --- Getter ve Setter Metotları ---

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }

    public String getKategori() { return kategori; }
    public void setKategori(String kategori) { this.kategori = kategori; }

    public String getBirim() { return birim; }
    public void setBirim(String birim) { this.birim = birim; }

    public Integer getMevcutStok() { return mevcutStok; }
    public void setMevcutStok(Integer mevcutStok) { this.mevcutStok = mevcutStok; }

    public Integer getMinimumStok() { return minimumStok; }
    public void setMinimumStok(Integer minimumStok) { this.minimumStok = minimumStok; }
}