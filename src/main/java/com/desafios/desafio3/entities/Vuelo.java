package com.desafios.desafio3.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.desafios.desafio3.enums.Estado;


@Entity
@Table(name = "tbt_vuelo")
public class Vuelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_vuelo")
	private Integer id;
	
	@Column(name = "aeropuerto_origen_vuelo")
	@Size(max = 255)
	private String aeropuertoOrigen;
	
	@Column(name = "aeropuerto_destino_vuelo")
	@Size(max = 255)
	private String aeropuertoDestino;

	@OneToOne
	@JoinColumn(name = "id_avion")
	private Avion avion;
	
	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pasajero> pasajeros;
	
	@Column(name = "estado_vuelo")
	@Enumerated(EnumType.STRING)
	private Estado estado;

	public Vuelo() {
	}

	public Vuelo(@Size(max = 255) String aeropuertoOrigen, @Size(max = 255) String aeropuertoDestino, Avion avion,
			Set<Pasajero> pasajeros) {
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.avion = avion;
		this.pasajeros = pasajeros;
		this.estado = Estado.HABILITADO;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(String aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	public String getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(String aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Set<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
