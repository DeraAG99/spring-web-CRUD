package com.dera.webdemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dera.webdemo.Entity.Kategori;
import com.dera.webdemo.Services.KategoriManagement;



@Controller
public class KategoriController {

  @Autowired
  KategoriManagement kategoriManagement;

  @GetMapping("/")
  public String Home(Model model) {
    List<Kategori> kategoriList = kategoriManagement.getAllKategori();
    model.addAttribute("kategori", kategoriList);
    return "kategori"; // Thymeleaf template name
  }

  @GetMapping("/kategori/add")
	public String addForm(Model model) {
		
		// create student object to hold student form data
		Kategori kategori = new Kategori();
		model.addAttribute("kategori", kategori);
		return "create_kategori";
		
	}

  @GetMapping("/kategori")
  public String listKategori(Model model) {
      List<Kategori> kategoriList = kategoriManagement.getAllKategori();
      model.addAttribute("kategori", kategoriList);
      return "kategori";
  }

  @PostMapping("/kategori/add")
	public String addKategori(@ModelAttribute("kategori") Kategori kategori) {
    kategori.setKategori(kategori.getKategori());
		kategoriManagement.saveKategori(kategori);
		return "redirect:/kategori";
	}

  @GetMapping("/kategori/{id}")
	public String editForm(@PathVariable String id, Model model) {
		model.addAttribute("kategori", kategoriManagement.getKategoriById(id));
		return "edit_kategori";
	}

  @PostMapping("/kategori/{id}")
  public String updateKategori(@PathVariable String id,
			@ModelAttribute("kategori") Kategori kategori,
			Model model) {
		
		// get student from database by id
		Kategori existing= kategoriManagement.getKategoriById(id);
    existing.setId(id);
    existing.setKategori(kategori.getKategori());

		// save updated student object
		kategoriManagement.saveKategori(kategori);
		return "redirect:/kategori";		
	}

  @GetMapping("/kategori/delete/{id}")
	public String deleteKategori(@PathVariable String id) {
		kategoriManagement.deleteKategoriById(id);;
		return "redirect:/kategori";
	}
  
}
