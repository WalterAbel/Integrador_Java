package com.ObraSocial.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Pacientes")
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;

	@Email(message = "El email debe ser válido")
	@NotBlank(message = "El email es obligatorio")
	@Column(unique = true)
	private String email;

	private String telefono;
	private String direccion;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	@OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
	private List<Turnos> turnos = new ArrayList<>();

	public Paciente() {

	}

	public Paciente(Long id, @NotBlank(message = "El nombre es obligatorio") String nombre,
			@Email(message = "El email debe ser válido") @NotBlank(message = "El email es obligatorio") String email,
			String telefono, String direccion, LocalDate fechaNacimiento, List<Turnos> turnos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaNacimiento = fechaNacimiento;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public List<Turnos> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turnos> turnos) {
		this.turnos = turnos;
	}

}
