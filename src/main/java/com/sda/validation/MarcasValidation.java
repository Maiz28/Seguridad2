package com.sda.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sda.dto.MarcasDto;

@Component
public class MarcasValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return MarcasDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MarcasDto marcasDto = (MarcasDto) target;
		if (marcasDto.getNombre() == null || marcasDto.getNombre().isEmpty()) {
			errors.rejectValue("nombre", null, "debes de escribir algo.");
		} else if (marcasDto.getNombre().length() < 3 || marcasDto.getNombre().length() > 10) {
			errors.rejectValue("nombre", null, "debe tener entre 3 y 10 caracteres.");
		}
	}

}
