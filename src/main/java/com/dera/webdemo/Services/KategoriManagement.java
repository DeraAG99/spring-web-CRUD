package com.dera.webdemo.Services;

import java.util.List;
import java.util.Optional;

import com.dera.webdemo.Entity.Kategori;


public interface KategoriManagement {

    List<Kategori> getAllKategori();
	
	Kategori saveKategori(Kategori kategori);
	
	Kategori getKategoriById(String id);
	
	Kategori updateKategori(Kategori kategori);
	
	void deleteKategoriById(String id);
    
}
