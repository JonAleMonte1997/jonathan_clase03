package com.desafios.desafio3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.desafios.desafio3.entities.Pasajero;
import com.desafios.desafio3.enums.Estado;

public interface PasajeroRepository extends CrudRepository<Pasajero , Integer> {

	List<Pasajero> findAllByEstado(Estado estado);
	
	Optional<Pasajero> findByIdAndEstado(Integer id, Estado estado);
}
