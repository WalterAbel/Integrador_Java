package com.ObraSocial.Modelo;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.*;

@Entity
@Table(name = "Turnos")
public class Turnos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El paciente es obligatorio")
	@ManyToOne
	@JoinColumn(name = "paciente_id", nullable = false)
	private Paciente paciente;

	@NotNull(message = "El medico es obligatorio")
	@ManyToOne
	@JoinColumn(name = "medico_id", nullable = false)
	private Medicos especialista;

	@NotNull(message = "La fecha y hora son obligatorias")
	private LocalDateTime fechaHora;

	@NotBlank(message = "El motivo de la consulta es obligatorio")
	@Size(max = 255, message = "El motivo de la consulta no puede tener más de 255 caracteres")
	private String motivoConsulta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medicos getEspecialista() {
		return especialista;
	}

	public void setEspecialista(Medicos especialista) {
		this.especialista = especialista;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoConsulta() {
		return motivoConsulta;
	}

	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}

}