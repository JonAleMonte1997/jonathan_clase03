package com.desafios.desafio3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.desafios.desafio3.enums.Estado;

@Entity
@Table(name = "tbt_pasajero")
public class Pasajero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pasajero")
	private Integer id;

	@Column(name = "nombre_pasajero")
	@Size(max = 255)
	private String nombre;
	
	@Column(name = "apellido_pasajero")
	@Size(max = 255)
	private String apellido;
	
	@Column(name = "dni_pasajero")
	@Size(min = 8, max = 8)
	private String dni;
	
	@ManyToOne
	@JoinColumn(name = "id_viaje")
	private Viaje viaje;

	@Column(name = "estado_vuelo")
	@Enumerated(EnumType.STRING)
	private Estado estado = Estado.HABILITADO;
	
	public Pasajero() {
	}

	public Pasajero(@Size(max = 255) String nombre, @Size(max = 255) String apellido,
			@Size(min = 8, max = 8) String dni, Viaje viaje) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.viaje = viaje;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Viaje getViaje() {
		return viaje;
	}

	public void setViaje(Viaje viaje) {
		this.viaje = viaje;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
