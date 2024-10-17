package com.ObraSocial.Controller;

import java.util.List;

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
import com.ObraSocial.Service.TurnoService;
import com.ObraSocial.DTO.TurnoDTO;

@RestController
@RequestMapping
public class TurnosControlador {

	@Autowired
	private TurnoService turnosService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<TurnoDTO>> getAllTurnos() {
		List<TurnoDTO> turnos = turnosService.getAllTurnos();
		if (turnos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(turnos);
	}

	@CrossOrigin
	@PostMapping
	public ResponseEntity<TurnoDTO> createTurno(@RequestBody TurnoDTO turnoDTO) {
		TurnoDTO savedTurnoDTO = turnosService.saveTurno(turnoDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedTurnoDTO);
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<TurnoDTO> updateTurno(@PathVariable Long id, @RequestBody TurnoDTO updatedTurnoDTO) {
		TurnoDTO updatedTurno = turnosService.updateTurno(id, updatedTurnoDTO);
		if (updatedTurno == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(updatedTurno);
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
