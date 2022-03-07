package com.desafios.desafio3.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafios.desafio3.entities.Viaje;
import com.desafios.desafio3.enums.Estado;
import com.desafios.desafio3.exceptions.EntityNotFoundException;
import com.desafios.desafio3.repositories.ViajeRepository;

@Service
public class ViajeService {

	@Autowired
	ViajeRepository viajeRepository;
	
	public List<Viaje> getViajes() {
		
		return viajeRepository.findAllByEstado(Estado.HABILITADO);
	}
	
	public Viaje getViaje(Integer id) {

		Optional<Viaje> viajeOptional = viajeRepository.findByIdAndEstado(id, Estado.HABILITADO);
		
		if (!viajeOptional.isPresent()) {
			throw new EntityNotFoundException();
		}
		
		return viajeOptional.get();
	}
	
	public Viaje addViaje(Viaje viaje) {
		
		return viajeRepository.save(viaje);
	}
	
	public Viaje updateViaje(Viaje viaje, Integer id) {
		
		Viaje viajeToUpdate = getViaje(id);

		viajeToUpdate.setAgencia(viaje.getAgencia());
		viajeToUpdate.setDestino(viaje.getDestino());
		
		return viajeRepository.save(viajeToUpdate);
	}
	
	public void disableViaje(Integer id) {
		
		Viaje viajeToDisable = getViaje(id);
		
		viajeToDisable.setEstado(Estado.DESHABILIDADO);
		
		viajeRepository.save(viajeToDisable);
	}
}
