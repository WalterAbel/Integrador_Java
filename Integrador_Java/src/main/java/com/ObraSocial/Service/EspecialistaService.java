package com.ObraSocial.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ObraSocial.Entity.Medicos;
import com.ObraSocial.Repository.MedicosRepositorio;

@Service
public class EspecialistaService {

	@Autowired
	private MedicosRepositorio medicoRepository;

	@Transactional(readOnly = true)
	public List<Medicos> getAllMedicos() {
		return (List<Medicos>) medicoRepository.findAll();
	}

}
