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
import com.ObraSocial.Entity.*;
import com.ObraSocial.Service.TurnoService;

@RestController
@RequestMapping
public class TurnosControlador {

	@Autowired
	private TurnoService turnosService;

	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> getAllTurnos() {
		List<Turnos> turnos = this.turnosService.getAllTurnos();
		if (turnos.isEmpty()) {
			return ResponseEntity.ok("No hay turnos registrados");
		}
		return ResponseEntity.ok(turnos);
	}

	@CrossOrigin
	@PostMapping("/turnos")
	public ResponseEntity<Turnos> crateTurnos(@RequestBody Turnos turno) {
		Turnos savedTurno = turnosService.saveTurnos(turno);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedTurno);
	}

	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity<Turnos> updateTurno(@PathVariable Long id, @RequestBody Turnos updatedTurno) {
		Turnos turno = turnosService.updateTurno(id, updatedTurno);
		return ResponseEntity.ok(turno);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Turnos> deleteTurno(@PathVariable Long id) {
	    Turnos deletedTurno = turnosService.deleteTurno(id);
	    return ResponseEntity.ok(deletedTurno);
	}
}
