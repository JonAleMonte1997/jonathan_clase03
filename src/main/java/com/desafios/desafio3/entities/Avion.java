package com.desafios.desafio3.entities;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.desafios.desafio3.enums.Estado;

@Entity
@Table(name = "tbt_avion")
public class Avion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_avion")
	private Integer id;
	
	@Column(name = "modelo_avion")
	@Size(max = 40)
	private String modelo;
	
	@Column(name = "velocidad_avion")
	@Positive
	@Max(value = 1000)
	private BigDecimal velocidad;		//En km/h
	
	@Column(name = "capacidad_avion")
	@Max(value = 1000)
	private Integer capacidad;
	
	@Column(name = "estado_avion")
	@Enumerated(EnumType.STRING)
	private Estado estado = Estado.HABILITADO;

	public Avion() {
	}

	public Avion(@Size(max = 40) String modelo, @Positive @Max(1000) BigDecimal velocidad,
			@Max(1000) Integer capacidad) {
		this.modelo = modelo;
		this.velocidad = velocidad;
		this.capacidad = capacidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public BigDecimal getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(BigDecimal velocidad) {
		this.velocidad = velocidad;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
