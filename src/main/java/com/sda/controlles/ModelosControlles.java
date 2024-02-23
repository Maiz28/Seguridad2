package com.sda.controlles;

import org.springframework.data.domain.Pageable;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sda.dto.ModelosDto;
import com.sda.persistencia.entity.Modelos;
import com.sda.service.ModeloService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/modelo")

public class ModelosControlles {
	@Autowired
	private ModeloService modelosServices;

	@GetMapping
	public ResponseEntity<Page<Modelos>> findAll(Pageable pagebale) {
		Page<Modelos> modelosPage = modelosServices.findAll(pagebale);
		if (modelosPage.hasContent()) {
			return ResponseEntity.ok(modelosPage);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/:marcaId")
	public ResponseEntity<Modelos> findOneById(@PathVariable Integer modeloId) {
		Optional<Modelos> modelo = modelosServices.findOneById(modeloId);
		if (modelo.isPresent()) {
			return ResponseEntity.ok(modelo.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Modelos> createOne(@RequestBody @Valid ModelosDto modelosDto){
		Modelos modelos= modelosServices.createOne (modelosDto); 
		return ResponseEntity.status(HttpStatus.CREATED).body(modelos); 
		
	}
	
	@PutMapping("/{modeloId}")
	public ResponseEntity<Modelos> udateOneById(@RequestBody @Valid ModelosDto modelosDto, 
			@PathVariable Integer modeloId){
		Modelos modelos=modelosServices.updateOneById(modelosDto, modeloId);
		return ResponseEntity.ok(modelos); 
	}
	
	@PutMapping("/{modeloId}/disable")
	public ResponseEntity<Modelos> disbleOneById(@PathVariable Integer modeloId){
		Modelos modelos =modelosServices.disableOneById(modeloId); 
		return ResponseEntity.ok(modelos); 
		
	}

}
