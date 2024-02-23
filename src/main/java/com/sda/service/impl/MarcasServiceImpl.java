package com.sda.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sda.dto.MarcasDto;
import com.sda.exception.ObjectNotFoundException;
import com.sda.persistencia.entity.Marcas;
import com.sda.persistencia.entity.Marcas.MarcaEstatus;
import com.sda.persistencia.repository.MarcasRepository;
import com.sda.service.MarcasService;

@Service
public class MarcasServiceImpl implements MarcasService {
	
	@Autowired 
	private MarcasRepository marcasRepository;

	@Override
	public Page<Marcas> findAll(org.springframework.data.domain.Pageable pageable) {
		return marcasRepository.findAll(pageable);
	}

	@Override
	public Optional<Marcas> findOneById(Integer marcasId) {
		// TODO Auto-generated method stub
		return marcasRepository.findById(marcasId); 
	}

	@Override
	public Marcas createOne(MarcasDto marcasrDto) {
		Marcas marcas= new Marcas(); 
		marcas.setNombre(marcasrDto.getNombre());
		marcas.setEstatus(MarcaEstatus.HABILITADA);
		return marcasRepository.save(marcas);
	}

	@Override
	public Marcas updateOneById(MarcasDto marcasDto, Integer marcaId) {
		Marcas marcas= marcasRepository.findById(marcaId).orElseThrow(()-> new ObjectNotFoundException("No existe la marca"));
		marcas.setNombre(marcasDto.getNombre());
		marcas.setEstatus(MarcaEstatus.HABILITADA);
		return marcasRepository.save(marcas);
	}

	@Override
	public Marcas disableOneById(Integer marcaId) {
		Marcas marcas= marcasRepository.findById(marcaId).orElseThrow(()-> new ObjectNotFoundException("No existe la marca"));
		marcas.setEstatus(MarcaEstatus.DESABILITADA);
		return marcasRepository.save(marcas);
	}

	

}
