package com.madmed.depo.repository;

import com.madmed.depo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // JpaRepository sayesinde temel CRUD (Ekle, Sil, Güncelle, Getir) işlemleri otomatik gelir.
    // Ekstra SQL yazmamıza gerek kalmaz.
}