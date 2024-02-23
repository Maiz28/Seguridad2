package com.sda.service;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sda.dto.ModelosDto;
import com.sda.persistencia.entity.Modelos;

public interface ModeloService {
	Page<Modelos> findAll (Pageable pageable); 
	
	Optional<Modelos> findOneById(Integer modelosId); 
	Modelos createOne(ModelosDto modelosDto); 
	Modelos updateOneById(ModelosDto modelosDto, Integer modelosId);
	Modelos disableOneById(Integer modelosId); 

}





