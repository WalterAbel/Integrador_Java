package com.ObraSocial.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ObraSocial.Entity.Receta;
import com.ObraSocial.Service.RecetaService;

@RestController
@RequestMapping
public class RecetaControlador {

	@Autowired
	private RecetaService recetaService;

	@GetMapping("/{idPaciente}/{idReceta}")
	public ResponseEntity<?> getRecetaByPacienteAndId(@PathVariable Long idPaciente, @PathVariable Long idReceta) {

		Receta receta = recetaService.FindRecetaByID(idPaciente, idReceta);

		if (receta != null) {
			return ResponseEntity.ok(receta);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("No se encontró la receta con ID " + idReceta + " para el paciente con ID " + idPaciente);
		}
	}
}
