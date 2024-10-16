package com.ObraSocial.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ObraSocial.Entity.Medicos;
import com.ObraSocial.Entity.Turnos;
import com.ObraSocial.Repository.MedicosRepositorio;
import com.ObraSocial.Repository.TurnosRepositorio;

@Service
public class TurnoService {

	@Autowired
	private TurnosRepositorio turnoRepository;

	@Autowired
	private MedicosRepositorio medicoRepository;

	@Transactional(readOnly = true)
	public List<Turnos> getAllTurnos() {
		return (List<Turnos>) turnoRepository.findAll();
	}
	
	@Transactional
	public Turnos saveTurnos(Turnos turnos) {
		return turnoRepository.save(turnos);
	}

	@Transactional
	public Turnos updateTurno(Long id, Turnos updatedTurno) {
		Optional<Turnos> turnOptional = turnoRepository.findById(id);

		if (turnOptional.isPresent()) {
			Turnos turno = turnOptional.get();

			if (updatedTurno.getFechaHora() != null) {
				turno.setFechaHora(updatedTurno.getFechaHora());
			}

			if (updatedTurno.getMedico() != null && updatedTurno.getMedico().getId() != null) {
				Optional<Medicos> medicoOpt = medicoRepository.findById(updatedTurno.getMedico().getId());
				if (medicoOpt.isPresent()) {
					turno.setMedico(medicoOpt.get());
				}
			}
			if (updatedTurno.getMotivoConsulta() != null) {
				turno.setMotivoConsulta(updatedTurno.getMotivoConsulta());
			}
			return turnoRepository.save(turno);
		} else {
			return null;
		}
	}

	@Transactional
	public boolean deleteTurno(Long id) {
		if (turnoRepository.existsById(id)) {
			turnoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
