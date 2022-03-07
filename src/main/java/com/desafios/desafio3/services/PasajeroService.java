package com.desafios.desafio3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio3.entities.Pasajero;
import com.desafios.desafio3.enums.Estado;
import com.desafios.desafio3.exceptions.EntityNotFoundException;
import com.desafios.desafio3.repositories.PasajeroRepository;

@Service
public class PasajeroService {

	@Autowired
	PasajeroRepository pasajeroRepository;
	
	public List<Pasajero> getPasajeros() {
		
		return pasajeroRepository.findAllByEstado(Estado.HABILITADO);
	}
	
	public Pasajero getPasajero(Integer id) {

		Optional<Pasajero> pasajeroOptional = pasajeroRepository.findByIdAndEstado(id, Estado.HABILITADO);
		
		if (!pasajeroOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		return pasajeroOptional.get();
	}
	
	public Pasajero addPasajero(Pasajero pasajero) {
		
		return pasajeroRepository.save(pasajero);
	}
	
	public Pasajero updatePasajero(Pasajero pasajero, Integer id) {
		
		Pasajero pasajeroToUpdate = getPasajero(id);

		pasajeroToUpdate.setApellido(pasajero.getApellido());
		pasajeroToUpdate.setDni(pasajero.getDni());
		pasajeroToUpdate.setNombre(pasajero.getNombre());
		pasajeroToUpdate.setViaje(pasajero.getViaje());
		
		return pasajeroRepository.save(pasajeroToUpdate);
	}
	
	public void disablePasajero(Integer id) {
		
		Pasajero pasajeroToDisable = getPasajero(id);
		
		pasajeroToDisable.setEstado(Estado.DESHABILIDADO);
		
		pasajeroRepository.save(pasajeroToDisable);
	}
}
