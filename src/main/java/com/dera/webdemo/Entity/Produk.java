package com.dera.webdemo.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Produk {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String deskripsi;
    private String gambar;
    @JoinColumn
    @ManyToOne
    private Kategori kategori;
    private BigDecimal harga;
    private Double stok;



    
}
