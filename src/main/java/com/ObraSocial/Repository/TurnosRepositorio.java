package com.ObraSocial.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ObraSocial.Entity.Turnos;

@Repository
public interface TurnosRepositorio extends JpaRepository<Turnos, Long> {

}
