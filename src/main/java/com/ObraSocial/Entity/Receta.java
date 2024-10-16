package com.ObraSocial.Entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "El turno es obligatorio")
	@OneToOne
	@JoinColumn(name = "turno_id", referencedColumnName = "id")
	private Turnos turno;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "La fecha de emisión es obligatoria")
	private LocalDate fechaEmision;

	@NotBlank(message = "Los detalles de la receta son obligatorios")
	@Column(columnDefinition = "TEXT")
	private String detalles;

	public Receta() {

	}

	public Receta(Long id, @NotNull(message = "El turno es obligatorio") Turnos turno,
			@NotNull(message = "La fecha de emisión es obligatoria") LocalDate fechaEmision,
			@NotBlank(message = "Los detalles de la receta son obligatorios") String detalles) {
		super();
		this.id = id;
		this.turno = turno;
		this.fechaEmision = fechaEmision;
		this.detalles = detalles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Turnos getTurno() {
		return turno;
	}

	public void setTurno(Turnos turno) {
		this.turno = turno;
	}

	public LocalDate getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDate fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

}