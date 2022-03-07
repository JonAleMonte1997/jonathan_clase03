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

import com.desafios.desafio3.entities.Viaje;
import com.desafios.desafio3.services.ViajeService;

@RestController
@RequestMapping("/api/v1/viajes")
@Validated
public class ViajeController {

	@Autowired
	ViajeService viajeService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Viaje> findAll() {
		
		return viajeService.getViajes();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Viaje findById(@PathVariable Integer id) {
		
		return viajeService.getViaje(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Viaje createViaje(@Valid @RequestBody Viaje viaje) {
		
		return viajeService.addViaje(viaje);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Viaje updateViaje(@Valid @RequestBody Viaje viaje, @PathVariable Integer id) {
		
		return viajeService.updateViaje(viaje, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void disableViaje(@PathVariable Integer id) {
		
		viajeService.disableViaje(id);
	}
}
