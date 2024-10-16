package com.ObraSocial.Entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Especialidades")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre de la especialidad es obligatorio")
	@Column(unique = true, nullable = false)
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy = "especialidad", cascade = CascadeType.MERGE)
	private List<Medicos> medicos = new ArrayList<>();

	public Especialidad() {

	}

	public Especialidad(Long id, @NotBlank(message = "El nombre de la especialidad es obligatorio") String nombre,
			List<Medicos> medicos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.medicos = medicos;
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

	public List<Medicos> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medicos> medicos) {
		this.medicos = medicos;
	}

}
