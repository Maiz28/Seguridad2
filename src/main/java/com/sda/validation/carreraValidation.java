package com.sda.validation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sda.dto.carrerasDto;
import com.sda.persistencia.entity.carreras.TipoCarrea;

@Component
public class carreraValidation implements Validator {

	private Date fechaActual = new Date(System.currentTimeMillis());
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public boolean supports(Class<?> clazz) {
		return carrerasDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		carrerasDto carrera = (carrerasDto) target;
		if (carrera.getNombre() == null || carrera.getNombre().isEmpty()) {
			errors.rejectValue("nombre", null, "no debe estar vacío.");
		}
		if (carrera.getNombre().length() < 2 || carrera.getNombre().length() > 55) {
			errors.rejectValue("nombre", null, " debe tener entre 2 y 55 caracteres.");
		}
		if (carrera.getCompetencias() == null || carrera.getCompetencias().isEmpty()) {
			errors.rejectValue("competencias", null, "no debe estar vacío.");
		}
		if (carrera.getCompetencias().length() < 5 || carrera.getCompetencias().length() > 80) {
			errors.rejectValue("competencias", null, " debe tener entre 5 y 80 caracteres.");
		}
		String tipoCarrera = carrera.getTipoCarrera().toString();
		boolean tipoValido = false;
		for (TipoCarrea enumValue : TipoCarrea.values()) {
			if (enumValue.toString().equals(tipoCarrera)) {
				tipoValido = true;
		        break;
			}
		}
		if (!tipoValido) {
		    errors.rejectValue("tipoCarrera", null,
		            "debe tener alguno de los siguientes tipos ESCOLARIZADA, SEMIESCOLARIZADA");
		}
		Date fechaParseada;
		try {
			fechaParseada = date.parse(carrera.getFechaRegistro());
			if (fechaActual.before(fechaParseada)) {
				errors.rejectValue("fechaRegistro", null, "fecha debe ser la actual o anterior.");
			}
		} catch (ParseException e) {
		}

	}

}
