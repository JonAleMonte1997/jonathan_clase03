package com.desafios.desafio3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.desafios.desafio3.entities.Viaje;
import com.desafios.desafio3.enums.Estado;

public interface ViajeRepository extends CrudRepository<Viaje, Integer> {

	List<Viaje> findAllByEstado(Estado estado);
	
	Optional<Viaje> findByIdAndEstado(Integer id, Estado estado);
}
