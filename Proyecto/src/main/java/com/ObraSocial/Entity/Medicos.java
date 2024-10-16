package com.ObraSocial.Entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "Medicos")
public class Medicos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;

	@NotBlank(message = "La especialidad es obligatoria")
	@ManyToOne
	@JoinColumn(name = "especialidad_id", nullable = false)
	private Especialidad especialidad;

	private String ubicacion;

	@Column(columnDefinition = "TEXT")
	private String horarios;

	@JsonIgnore
	@OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
	private List<Turnos> turnos = new ArrayList<>();

	public Medicos() {

	}

	public Medicos(Long id, @NotBlank(message = "El nombre es obligatorio") String nombre,
			@NotBlank(message = "La especialidad es obligatoria") Especialidad especialidad, String ubicacion,
			String horarios, List<Turnos> turnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.especialidad = especialidad;
		this.ubicacion = ubicacion;
		this.horarios = horarios;
		this.turnos = turnos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getHorarios() {
		return horarios;
	}

	public void setHorarios(String horarios) {
		this.horarios = horarios;
	}

	public List<Turnos> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turnos> turnos) {
		this.turnos = turnos;
	}

}