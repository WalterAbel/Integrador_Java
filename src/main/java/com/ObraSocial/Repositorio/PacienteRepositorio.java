package com.ObraSocial.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ObraSocial.Modelo.Paciente;

public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {

}
