package com.desafios.desafio3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio3.entities.Avion;
import com.desafios.desafio3.enums.Estado;
import com.desafios.desafio3.exceptions.EntityNotFoundException;
import com.desafios.desafio3.repositories.AvionRespository;

@Service
public class AvionService {

	@Autowired
	AvionRespository avionRespository;
	
	public List<Avion> getAviones() {
		
		return avionRespository.findAllByEstado(Estado.HABILITADO);
	}
	
	public Avion getAvion(Integer id) {

		Optional<Avion> avionOptional = avionRespository.findByIdAndEstado(id, Estado.HABILITADO);
		
		if (!avionOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		return avionOptional.get();
	}
	
	public Avion addAvion(Avion avion) {
	
		return avionRespository.save(avion);
	}
	
	public Avion updateAvion(Avion avion, Integer id) {
		
		Avion avionToUpdate = getAvion(id);
		
		avionToUpdate.setCapacidad(avion.getCapacidad());
		avionToUpdate.setModelo(avion.getModelo());
		avionToUpdate.setVelocidad(avion.getVelocidad());
		
		return avionRespository.save(avionToUpdate);
	}
	
	public void disableAvion(Integer id) {
		
		Avion avionToDisable = getAvion(id);
		
		avionToDisable.setEstado(Estado.DESHABILIDADO);
		
		avionRespository.save(avionToDisable);
	}
}
