package com.sda.service;



import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sda.dto.carrerasDto;
import com.sda.persistencia.entity.carreras;

public interface carrerasService {
	
Page<carreras> findAll (Pageable pageable); 
	
	Optional<carreras> findOneById(Integer carreraId); 
	carreras createOne(carrerasDto carreraDto); 
	carreras updateOneById( carrerasDto carreraDto, Integer carreraId);

	carreras disableOneById(Integer carreraId);


}
