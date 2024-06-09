package com.dera.webdemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dera.webdemo.Entity.Kategori;


public interface KategoriRepository extends JpaRepository<Kategori, String> {
    
}
