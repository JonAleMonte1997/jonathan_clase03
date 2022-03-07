package com.desafios.desafio3.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.desafios.desafio3.entities.Avion;
import com.desafios.desafio3.enums.Estado;

public interface AvionRespository extends CrudRepository<Avion, Integer> {

	List<Avion> findAllByEstado(Estado estado);
	
	Optional<Avion> findByIdAndEstado(Integer id, Estado estado);
}
