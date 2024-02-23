package com.sda.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.sda.dto.ModelosDto;
import com.sda.exception.ObjectNotFoundException;
import com.sda.persistencia.entity.Marcas;
import com.sda.persistencia.entity.Modelos;
import com.sda.persistencia.entity.Modelos.ModelosEstatus;
import com.sda.persistencia.repository.ModelosRepository;
import com.sda.service.ModeloService;


@Service
public class ModelosServiceImpl implements ModeloService{
	
	@Autowired
	private ModelosRepository modelosRepository;

	@Override
	public Page<Modelos> findAll(org.springframework.data.domain.Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Modelos> findOneById(Integer modelosId) {
		return modelosRepository.findById(modelosId); 
	}

	@Override
	public Modelos createOne(ModelosDto modelosDto) {
		Modelos modelos= new Modelos(); 
		modelos.setDescripcion(modelosDto.getDescripcion());
		modelos.setPrecio(modelosDto.getPrecio());
		modelos.setEstatus(ModelosEstatus.HABILITADO);
		
		Marcas marca = new Marcas(); 
		marca.setId(modelosDto.getMarca_id());
		modelos.setMarcas(marca);
		
		return modelosRepository.save(modelos);
	}

	@Override
	public Modelos updateOneById(ModelosDto modelosDto, Integer modelosId) {
		Modelos modelos= modelosRepository.findById(modelosId).orElseThrow(()-> new ObjectNotFoundException("No existe el modelo"));
		modelos.setDescripcion(modelosDto.getDescripcion());
		modelos.setPrecio(modelosDto.getPrecio());
		
		Marcas marca = new Marcas(); 
		marca.setId(modelosDto.getMarca_id());
		modelos.setMarcas(marca);
		
		return modelosRepository.save(modelos);
	}

	@Override
	public Modelos disableOneById(Integer modelosId) {
		Modelos modelos= modelosRepository.findById(modelosId).orElseThrow(()-> new ObjectNotFoundException("No existe el modelo"));
		modelos.setEstatus(ModelosEstatus.DESHABILITADO);
		return modelosRepository.save(modelos); 
	}

	

}
