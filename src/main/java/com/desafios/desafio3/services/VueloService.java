package com.desafios.desafio3.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio3.entities.Avion;
import com.desafios.desafio3.entities.Pasajero;
import com.desafios.desafio3.entities.Vuelo;
import com.desafios.desafio3.enums.Estado;
import com.desafios.desafio3.exceptions.EntityNotFoundException;
import com.desafios.desafio3.repositories.VueloRepository;

@Service
public class VueloService {

	@Autowired
	VueloRepository vueloRepository;
	
	public List<Vuelo> getVuelos() {
		
		return vueloRepository.findAllByEstado(Estado.HABILITADO);
	}
	
	public Vuelo getVuelo(Integer id) {

		Optional<Vuelo> vueloOptional = vueloRepository.findByIdAndEstado(id, Estado.HABILITADO);
		
		if (!vueloOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		return vueloOptional.get();
	}
	
	public Vuelo addVuelo(Vuelo vuelo) {
		
		return vueloRepository.save(vuelo);
	}
	
	public Vuelo assingPasajeros(Set<Pasajero> pasajeros, Integer id) {
		
		Vuelo vuelo = getVuelo(id);
		
		vuelo.setPasajeros(pasajeros);
		
		return vueloRepository.save(vuelo);
	}
	
	public Vuelo updateVuelo(Vuelo vuelo, Integer id) {
		
		Vuelo vueloToUpdate = getVuelo(id);

		vueloToUpdate.setAeropuertoDestino(vuelo.getAeropuertoDestino());
		vueloToUpdate.setAeropuertoOrigen(vuelo.getAeropuertoOrigen());
		
		return vueloRepository.save(vueloToUpdate);
	}
	
	public void disableVuelo(Integer id) {
		
		Vuelo vueloToDisable = getVuelo(id);
		
		vueloToDisable.setEstado(Estado.DESHABILIDADO);
		
		vueloRepository.save(vueloToDisable);
	}

	public Vuelo assingAvion(@Valid Avion avion, Integer id) {
		
		Vuelo vuelo = getVuelo(id);
		
		vuelo.setAvion(avion);
		
		return vueloRepository.save(vuelo);
	}
}
