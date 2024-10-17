package com.ObraSocial.Service;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ObraSocial.Entity.Medicos;
import com.ObraSocial.Entity.Turnos;
import com.ObraSocial.Exceptions.ResourceNotFoundException;
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
		Turnos turno = turnoRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado con id: " + id));

		if (updatedTurno.getFechaHora() != null) {
			turno.setFechaHora(updatedTurno.getFechaHora());
		}

		if (updatedTurno.getMedico() != null && updatedTurno.getMedico().getId() != null) {
			Medicos medico = medicoRepository.findById(updatedTurno.getMedico().getId())
					.orElseThrow(() -> new ResourceNotFoundException(
							"Medico no encontrado con id: " + updatedTurno.getMedico().getId()));
			turno.setMedico(medico);
		}

		if (updatedTurno.getMotivoConsulta() != null) {
			turno.setMotivoConsulta(updatedTurno.getMotivoConsulta());
		}

		return turnoRepository.save(turno);
	}

	@Transactional
	public Turnos deleteTurno(Long id) {
	    Turnos turno = turnoRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException("Turno no encontrado con id: " + id));
	    turnoRepository.deleteById(id);
	    return turno;
	}

}
