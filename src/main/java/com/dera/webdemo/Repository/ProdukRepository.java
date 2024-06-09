package com.dera.webdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dera.webdemo.Entity.Produk;

public interface ProdukRepository extends JpaRepository<Produk, String>{
    
}
