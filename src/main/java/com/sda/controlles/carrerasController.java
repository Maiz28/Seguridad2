package com.sda.controlles;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;

import com.sda.dto.carrerasDto;
import com.sda.persistencia.entity.carreras;
import com.sda.service.carrerasService;

import jakarta.validation.Valid;

public class carrerasController {
	
	@RestController
	@RequestMapping("/carreras")
	public class CarrerasController {

	    @Autowired
	    private carrerasService carrerasService;

	    @GetMapping
	    public ResponseEntity<Page<carreras>> findAll(Pageable pageable) {
	        Page<carreras> carrerasPage = carrerasService.findAll(pageable);
	        if (carrerasPage.hasContent()) {
	            return ResponseEntity.ok(carrerasPage);
	        }
	        return ResponseEntity.notFound().build();
	    }

	    @GetMapping("/{carreraId}")
	    public ResponseEntity<carreras> findOneById(@PathVariable Integer carreraId) {
	        Optional<carreras> carrera = carrerasService.findOneById(carreraId);
	        if (carrera.isPresent()) {
	            return ResponseEntity.ok(carrera.get());
	        }
	        return ResponseEntity.notFound().build();
	    }

	    @PostMapping
	    public ResponseEntity<carreras> createOne(@RequestBody @Valid carrerasDto carrerasDto) {
	        carreras carrera = carrerasService.createOne(carrerasDto);
	        return ResponseEntity.status(HttpStatus.CREATED).body(carrera);
	    }

	    @PutMapping("/{carreraId}")
	    public ResponseEntity<carreras> updateOneById(@RequestBody @Valid carrerasDto carrerasDto,
	            @PathVariable Integer carreraId) {
	        carreras carrera = carrerasService.updateOneById(carrerasDto, carreraId);
	        return ResponseEntity.ok(carrera);
	    }

	    @PutMapping("/{carreraId}/disable")
	    public ResponseEntity<carreras> disableOneById(@PathVariable Integer carreraId) {
	        carreras carrera = carrerasService.disableOneById(carreraId);
	        return ResponseEntity.ok(carrera);
	    }
	}


}
