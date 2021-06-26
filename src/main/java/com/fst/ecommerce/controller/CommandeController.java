package com.fst.ecommerce.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fst.ecommerce.dao.CommandeRepository;
import com.fst.ecommerce.model.Commande;

@RestController
@RequestMapping(value="/rest/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CommandeController {

		@Autowired
		CommandeRepository commandeRepository;
		
	    @GetMapping(value="/allCommand")
	    public List<Commande> allCommande(){
	        return commandeRepository.findAll();
	    }
	
	    @PostMapping(value="/addCommande")
	    public Commande addCommande(@Valid @RequestBody Commande c){
	        return commandeRepository.save(c);
	    }

	    @GetMapping(value="/commande/{id}")
	    public ResponseEntity<Commande> getCommande(@PathVariable Integer id) throws Exception{
	        Commande c = commandeRepository.findById(id).orElseThrow(()->new Exception("La commande n'existe pas"));
	        return ResponseEntity.ok().body(c);
	    }
	    
	    @DeleteMapping(value="/commande/{id}")
	    public Map<String,Boolean> deleteCommande(@PathVariable Integer id) throws Exception {
	        Commande cat = commandeRepository.findById(id).orElseThrow(()->new Exception("La commande n'existe pas"));
	        commandeRepository.delete(cat);
	        Map<String,Boolean> response = new HashMap<>();
	        response.put("Commande est supprimé!",Boolean.TRUE);
	        return response;
	    }  	
}