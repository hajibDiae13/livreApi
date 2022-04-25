package com.example.RestApi.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.RestApi.service.LivreService;
import com.example.RestApi.entities.Livre;
import java.util.*;
@RestController @RequestMapping("/emsi_api")
public class LivreController {
	
	@Autowired 
	LivreService livreService;
	
	@GetMapping("/livres")
	  public List<Livre> findByOrderByTitleAsc() {
	    return livreService.findByOrderByTitleAsc();
	  }
	
	@GetMapping("/livres/{id}")
	  public Livre findById(@PathVariable("id") Integer id) {
	    return livreService.findById(id);
	  }
	
	@PostMapping("/CreateLivre")
	  public void createLivre(@RequestBody Livre livre) {
	    livreService.saveLivre(livre);
	  }
	
	@DeleteMapping("delete/{id}")
	public void deleteLivre(@PathVariable("id") Integer id) {
		livreService.deleteLivre(id);
	}
	
	@PutMapping("/update/{id}")
	public void updateLivre(@RequestBody Livre livre,@PathVariable("id") Integer id) {
		livreService.updateLivre(livre,id);
	}
}
