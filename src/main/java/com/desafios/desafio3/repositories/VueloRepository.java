package com.desafios.desafio3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.desafios.desafio3.entities.Vuelo;
import com.desafios.desafio3.enums.Estado;

public interface VueloRepository extends CrudRepository<Vuelo, Integer> {

	List<Vuelo> findAllByEstado(Estado estado);
	
	Optional<Vuelo> findByIdAndEstado(Integer id, Estado estado);
}
