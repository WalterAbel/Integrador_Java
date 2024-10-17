package com.ObraSocial.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ObraSocial.Entity.*;
import com.ObraSocial.Service.TurnoService;
import com.ObraSocial.DTO.TurnoDTO;
import com.ObraSocial.DTO.TurnoMapper;

@RestController
@RequestMapping
public class TurnosControlador {

	@Autowired
	private TurnoService turnosService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<TurnoDTO>> getAllTurnos() {
		List<TurnoDTO> turnos = turnosService.getAllTurnos().stream().map(TurnoMapper.INSTANCE::turnoToTurnoDTO).collect(Collectors.toList());
		if (turnos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(turnos);
	}

	@CrossOrigin
	@PostMapping("/turnos")
	public ResponseEntity<TurnoDTO> crateTurnos(@RequestBody TurnoDTO turnoDTO) {
	Turnos turno = TurnoMapper.INSTANCE.turnoDTOToTurno(turnoDTO);
	Turnos savedTurno = turnosService.saveTurnos(turno);
	TurnoDTO savedTurnoDTO = TurnoMapper.INSTANCE.turnoToTurnoDTO(savedTurno);
	return ResponseEntity.status(HttpStatus.CREATED).body(savedTurnoDTO);
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<TurnoDTO> updateTurno(@PathVariable Long id, @RequestBody TurnoDTO updatedTurnoDTO) {
		Turnos updatedTurno = TurnoMapper.INSTANCE.turnoDTOToTurno(updatedTurnoDTO);
		Turnos turno = turnosService.updateTurno(id, updatedTurno);
		if (turno == null) {
			return ResponseEntity.notFound().build();
		}
		TurnoDTO turnoDTO = TurnoMapper.INSTANCE.turnoToTurnoDTO(turno);
		return ResponseEntity.ok(turnoDTO);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTurno(@PathVariable Long id) {
		boolean isDeleted = turnosService.deleteTurno(id);
		if (isDeleted) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turno no encontrado");
		}
	}
}
