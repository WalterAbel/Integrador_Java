package com.ObraSocial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ObraSocial.Entity.Paciente;

public interface PacienteRepositorio extends JpaRepository<Paciente, Long> {

}
