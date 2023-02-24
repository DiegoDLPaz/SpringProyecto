package com.example.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modelo.Shows;
import com.example.repositorio.ShowsRepository;

@RestController
public class ShowsController {
	
	@Autowired
	private ShowsRepository repo;
	
	// GET + POST + DELETE + PUT
	@GetMapping("shows")
	List<Shows> getAllshows(@RequestParam(name = "tipo",required = false)
	String tipoParametro){
		if(tipoParametro == null) return repo.findAll();
		else {
			return repo.findBytipoStartingWith(tipoParametro);
		}
	}
	
	@GetMapping("shows/{showId}")
	Shows getShowById(@PathVariable("showId") String idRecibido) {
		return repo.findById(idRecibido).get();
	}
	
	@DeleteMapping("shows/{showid}")
	ResponseEntity<String> borrarShows(@PathVariable("showId") String idRecibido){
		this.repo.deleteById(idRecibido);
		return new ResponseEntity<String>("El show se ha borrado correctamente",HttpStatus.OK);
	}
	
	@PostMapping("shows")
	ResponseEntity<String> anadirShow(@RequestBody Shows nuevosShow){
			this.repo.save(nuevosShow);
			return new ResponseEntity<String>("El show se ha añadido correctamente",HttpStatus.OK);
	}
	
}
