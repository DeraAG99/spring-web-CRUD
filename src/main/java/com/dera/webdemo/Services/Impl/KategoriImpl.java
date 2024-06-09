package com.dera.webdemo.Services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dera.webdemo.Entity.Kategori;
import com.dera.webdemo.Repository.KategoriRepository;
import com.dera.webdemo.Services.KategoriManagement;

@Service
public class KategoriImpl implements KategoriManagement {

    @Autowired
    KategoriRepository kategoriRepository;

    @Override
    public List<Kategori> getAllKategori() {
        return kategoriRepository.findAll();
    }

    @Override
    public Kategori saveKategori(Kategori kategori) {
        kategori.setId(UUID.randomUUID().toString());
        return kategoriRepository.save(kategori);
    }

    @Override
    public Kategori getKategoriById(String id) {
       return kategoriRepository.findById(id).get();
    }

    @Override
    public Kategori updateKategori(Kategori kategori) {
        return kategoriRepository.save(kategori);
    }

    @Override
    public void deleteKategoriById(String id) {
       kategoriRepository.deleteById(id);
    }
    
}
