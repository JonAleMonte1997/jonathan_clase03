package com.desafios.desafio3.controllers;

import java.util.List;
import java.util.Set;

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
import com.desafios.desafio3.entities.Pasajero;
import com.desafios.desafio3.entities.Vuelo;
import com.desafios.desafio3.services.VueloService;

@RestController
@RequestMapping("/api/v1/vuelos")
@Validated
public class VueloController {

	@Autowired
	VueloService vueloService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Vuelo> findAll() {
		
		return vueloService.getVuelos();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vuelo findById(@PathVariable Integer id) {
		
		return vueloService.getVuelo(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Vuelo createVuelo(@Valid @RequestBody Vuelo vuelo) {
		
		return vueloService.addVuelo(vuelo);
	}
	
	//El updateVuelo solo actualiza los atributos de origen y destino, para actualizar pasajeros y avion se
	//debe usar los otros endpoints correspondientes.
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Vuelo updateVuelo(@Valid @RequestBody Vuelo vuelo, @PathVariable Integer id) {
		
		return vueloService.updateVuelo(vuelo, id);
	}
	
	@PutMapping("/{id}/pasajeros")
	@ResponseStatus(HttpStatus.OK)
	public Vuelo assingPasajeros(@Valid @RequestBody Set<Pasajero> pasajeros, @PathVariable Integer id) {
		
		return vueloService.assingPasajeros(pasajeros, id);
	}
	
	@PutMapping("/{id}/avion")
	@ResponseStatus(HttpStatus.OK)
	public Vuelo assignAvion(@Valid @RequestBody Avion avion, @PathVariable Integer id) {
		
		return vueloService.assingAvion(avion, id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void disableVuelo(@PathVariable Integer id) {
		
		vueloService.disableVuelo(id);
	}
}
