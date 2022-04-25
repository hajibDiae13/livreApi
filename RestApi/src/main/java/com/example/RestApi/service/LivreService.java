package com.example.RestApi.service;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.RestApi.entities.Livre;
import com.example.RestApi.repos.LivreRepo;
@Service
public class LivreService {
	
	@Autowired
	LivreRepo livreRepository;
	
	public List<Livre> findByOrderByTitleAsc(){
		return livreRepository.findByOrderByTitleAsc();
	}
	
	public Livre findById(Integer Id) {
		return livreRepository.findById(Id).orElseThrow();
	}
	
	public Livre getLivre(Integer id) {
		Livre newLivre=new Livre();
        Livre oldLivre=livreRepository.findById(id).get();
        BeanUtils.copyProperties(oldLivre,newLivre);
        oldLivre.setLastChecked(new Date());
        livreRepository.save(oldLivre);
        return newLivre;
	}
	
	public void saveLivre(Livre l)
	{
		livreRepository.save(l);
	}
	
	public void deleteLivre(Integer id) {
		livreRepository.deleteById(id);
	}
	
	public void updateLivre(Livre newlivre,Integer id) {
		Livre livre=livreRepository.findById(id).orElseThrow();
		
		livre.setTitle( newlivre.getTitle()!=null ? newlivre.getTitle() : livre.getTitle() );
		livre.setAuthor( newlivre.getAuthor()!=null ? newlivre.getAuthor() : livre.getAuthor() );
		livre.setNumberOfPages( newlivre.getNumberOfPages()!=null ? newlivre.getNumberOfPages() : livre.getNumberOfPages() );
		livre.setAvailable( newlivre.getAvailable()!=null ? newlivre.getAvailable() : livre.getAvailable() );
		livre.setLastChecked( newlivre.getLastChecked()!=null ? newlivre.getLastChecked() : livre.getLastChecked() );
		livre.setReleaseDate( newlivre.getReleaseDate()!=null ? newlivre.getReleaseDate() : livre.getReleaseDate() );
		livreRepository.save(livre); 
	}
}

