package com.desafios.desafio3.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafios.desafio3.entities.Avion;
import com.desafios.desafio3.services.AvionService;

@RestController
@RequestMapping("/api/v1/aviones")
@Validated
public class AvionController {

	@Autowired
	AvionService avionService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Avion> findAll() {
		
		return avionService.getAviones();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Avion findById(@PathVariable Integer id) {
		
		return avionService.getAvion(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Avion createAvion(@Valid @RequestBody Avion avion) {
		
		return avionService.addAvion(avion);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Avion updateAvion(@Valid @RequestBody Avion avion, @PathVariable Integer id) {
		
		return avionService.updateAvion(avion, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void disableAvion(@PathVariable Integer id) {
		
		avionService.disableAvion(id);
	}
}
