package com.ObraSocial.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ObraSocial.Entity.Medicos;
import com.ObraSocial.Service.EspecialistaService;

@RestController
@RequestMapping
public class EspecialistasControlador {

	@Autowired
	private EspecialistaService especialistaService;

	@CrossOrigin
	@GetMapping("/especialistas")
	public ResponseEntity<List<Medicos>> getAllMedicos() {
		List<Medicos> medicos = this.especialistaService.getAllMedicos();
		if (medicos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(medicos);
	}
}
