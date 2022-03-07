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

import com.desafios.desafio3.entities.Pasajero;
import com.desafios.desafio3.services.PasajeroService;

@RestController
@RequestMapping("/api/v1/pasajeros")
@Validated
public class PasajeroController {

	@Autowired
	PasajeroService pasajeroService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Pasajero> findAll() {
		
		return pasajeroService.getPasajeros();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pasajero findById(@PathVariable Integer id) {
		
		return pasajeroService.getPasajero(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pasajero createPasajero(@Valid @RequestBody Pasajero pasajero) {
		
		return pasajeroService.addPasajero(pasajero);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Pasajero updatePasajero(@Valid @RequestBody Pasajero pasajero, @PathVariable Integer id) {
		
		return pasajeroService.updatePasajero(pasajero, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void disablePasajero(@PathVariable Integer id) {
		
		pasajeroService.disablePasajero(id);
	}
}
