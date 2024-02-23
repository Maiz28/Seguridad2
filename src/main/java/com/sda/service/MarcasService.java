package com.sda.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sda.dto.MarcasDto;
import com.sda.persistencia.entity.Marcas;

public interface MarcasService {
	
	Page<Marcas> findAll (Pageable pageable); 
	
	Optional<Marcas> findOneById(Integer marcasId); 
	Marcas createOne(MarcasDto marcasrDto); 
	Marcas updateOneById(MarcasDto marcasDto, Integer marcaId);
	Marcas disableOneById(Integer marcaId); 

}
