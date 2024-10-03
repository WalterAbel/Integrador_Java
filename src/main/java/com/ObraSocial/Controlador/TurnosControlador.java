package com.ObraSocial.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ObraSocial.Repositorio.TurnosRepositorio;
import com.ObraSocial.Modelo.*;
@RestController
@RequestMapping
public class TurnosControlador {
	
	@Autowired
	private TurnosRepositorio turnorepository;
	
	
	@CrossOrigin
	@GetMapping
	public List<Turnos> getAllTurnos() {
		return turnorepository.findAll();
	}
	
	@CrossOrigin
	@PostMapping("/turnos")
	public ResponseEntity<Turnos> crateTurnos(@RequestBody Turnos turno){
		Turnos savedTurno = turnorepository.save(turno);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedTurno);
	}
	

}
