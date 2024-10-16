package com.ObraSocial.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ObraSocial.Entity.Receta;
import com.ObraSocial.Entity.Turnos;
import com.ObraSocial.Exceptions.RecetaNotFoundException;
import com.ObraSocial.Repository.RecetaRepositorio;
import com.ObraSocial.Repository.TurnosRepositorio;

import jakarta.transaction.Transactional;

@Service
public class RecetaService {

	@Autowired
	private RecetaRepositorio RecetaRepository;

	@Autowired
	private TurnosRepositorio TurnoRepository;

	@Transactional
	public Receta FindRecetaByID(Long idPaciente, Long idReceta) {
		Optional<Receta> recetaOptional = RecetaRepository.findById(idReceta);
		if (recetaOptional.isPresent()) {
			Receta receta = recetaOptional.get();
			Long Idturno = receta.getTurno().getId();
			Optional<Turnos> turnoOpt = TurnoRepository.findById(Idturno);
			if (turnoOpt.isPresent()) {
				Turnos turnos = turnoOpt.get();
				if (turnos.getPaciente().getId().equals(idPaciente)) {
					return receta;
				}
				throw new RecetaNotFoundException(
						"No se encontró la receta con ID " + idReceta + " para el paciente con ID " + idPaciente);
			}
			throw new RecetaNotFoundException("No se encontró el turno con ID " + Idturno);
		}
		throw new RecetaNotFoundException("No se encontró la receta con ID " + idReceta);
	}
}