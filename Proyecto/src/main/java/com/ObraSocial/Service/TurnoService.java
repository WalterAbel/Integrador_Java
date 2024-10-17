package com.ObraSocial.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ObraSocial.DTO.TurnoDTO;
import com.ObraSocial.DTO.TurnoMapper;
import com.ObraSocial.Entity.Turnos;
import com.ObraSocial.Repository.TurnosRepositorio;

@Service
public class TurnoService {

	@Autowired
	private TurnosRepositorio turnoRepository;

	@Transactional(readOnly = true)
	public List<TurnoDTO> getAllTurnos() {
		return turnoRepository.findAll().stream().map(TurnoMapper.INSTANCE::turnoToTurnoDTO)
				.collect(Collectors.toList());
	}

	@Transactional
	public Turnos saveTurnos(Turnos turnos) {
		return turnoRepository.save(turnos);
	}

	@Transactional
	public TurnoDTO saveTurno(TurnoDTO turnoDTO) {
		Turnos turno = TurnoMapper.INSTANCE.turnoDTOToTurno(turnoDTO);
		Turnos savedTurno = turnoRepository.save(turno);
		return TurnoMapper.INSTANCE.turnoToTurnoDTO(savedTurno);
	}

	@Transactional
	public TurnoDTO updateTurno(Long id, TurnoDTO updatedTurnoDTO) {
		Optional<Turnos> turnOptional = turnoRepository.findById(id);
		if (turnOptional.isPresent()) {
			Turnos turnoActual = turnOptional.get();
			Turnos updatedTurno = TurnoMapper.INSTANCE.turnoDTOToTurno(updatedTurnoDTO);
			updatedTurno.setId(turnoActual.getId());
			Turnos savedTurno = turnoRepository.save(updatedTurno);
			return TurnoMapper.INSTANCE.turnoToTurnoDTO(savedTurno);
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
