package com.sda.controlles;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import com.sda.dto.MarcasDto;
import com.sda.persistencia.entity.Marcas;
import com.sda.service.MarcasService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/marcas")
public class MarcasCotrollers {
	@Autowired
	private MarcasService marcasService; 
	
	@GetMapping
	public ResponseEntity<Page<Marcas>> findAll (Pageable pagebale){
		Page<Marcas> marcaPage= marcasService.findAll(pagebale);
		if(marcaPage.hasContent()) {
			return ResponseEntity.ok(marcaPage); 
		}
		return ResponseEntity.notFound().build(); 
	}
	
	@GetMapping("/:marcaId")
	public ResponseEntity<Marcas> findOneById(
			@PathVariable Integer marcaId){
		Optional<Marcas> marca=marcasService.findOneById(marcaId);
				if(marca.isPresent()) {
					return ResponseEntity.ok(marca.get());
				}
		return ResponseEntity.notFound().build(); 
	}
	
	@PostMapping
	public ResponseEntity<Marcas> createOne(@RequestBody @Valid MarcasDto marcasDto){
		Marcas marcas= marcasService.createOne (marcasDto); 
		return ResponseEntity.status(HttpStatus.CREATED).body(marcas); 
		
	}
	
	@PutMapping("/{masrcaId}")
	public ResponseEntity<Marcas> udateOneById(@RequestBody @Valid MarcasDto marcasDto, 
			@PathVariable Integer marcaId){
		Marcas marcas=marcasService.updateOneById(marcasDto, marcaId);
		return ResponseEntity.ok(marcas); 
	}
	
	@PutMapping("/{masrcaId}/disable")
	public ResponseEntity<Marcas> disbleOneByI(@PathVariable Integer marcaId){
		Marcas marcas =marcasService.disableOneById(marcaId); 
		return ResponseEntity.ok(marcas); 
		
	}
}
