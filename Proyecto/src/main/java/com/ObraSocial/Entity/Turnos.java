package com.ObraSocial.Entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private Medicos medico;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	@NotNull(message = "La fecha y hora son obligatorias")
	private LocalDateTime fechaHora;

	@NotBlank(message = "El motivo de la consulta es obligatorio")
	@Size(max = 255, message = "El motivo de la consulta no puede tener más de 255 caracteres")
	private String motivoConsulta;

	public Turnos() {

	}

	public Turnos(Long id, @NotNull(message = "El paciente es obligatorio") Paciente paciente,
			@NotNull(message = "El medico es obligatorio") Medicos medico,
			@NotNull(message = "La fecha y hora son obligatorias") LocalDateTime fechaHora,
			@NotBlank(message = "El motivo de la consulta es obligatorio") @Size(max = 255, message = "El motivo de la consulta no puede tener más de 255 caracteres") String motivoConsulta) {
		super();
		this.id = id;
		this.paciente = paciente;
		this.medico = medico;
		this.fechaHora = fechaHora;
		this.motivoConsulta = motivoConsulta;
	}

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

	public Medicos getMedico() {
		return medico;
	}

	public void setMedico(Medicos medico) {
		this.medico = medico;
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