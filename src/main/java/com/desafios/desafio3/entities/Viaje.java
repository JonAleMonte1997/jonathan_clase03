package com.desafios.desafio3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.desafios.desafio3.enums.Estado;

@Entity
@Table(name = "tbt_viaje")
public class Viaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_viaje")
	private Integer id;

	@Column(name = "destino_viaje")
	@Size(max = 255)
	private String destino;
	
	@Column(name = "agencia_viaje")
	@Size(max = 255)
	private String agencia;

	@Column(name = "estado_viaje")
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	public Viaje() {
	}

	public Viaje(@Size(max = 255) String destino, @Size(max = 255) String agencia) {
		this.destino = destino;
		this.agencia = agencia;
		this.estado = Estado.HABILITADO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
