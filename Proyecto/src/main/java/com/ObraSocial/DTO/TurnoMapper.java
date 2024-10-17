package com.ObraSocial.DTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.ObraSocial.Entity.Turnos;

@Mapper
public interface TurnoMapper {
	TurnoMapper INSTANCE = Mappers.getMapper(TurnoMapper.class);
	
	@Mapping(source = "medico.id", target = "medicoId")
	TurnoDTO turnoToTurnoDTO(Turnos turno);
	
	@Mapping(source = "medicoId", target ="medico.id")
	Turnos turnoDTOToTurno(TurnoDTO turnoDTO);
}
