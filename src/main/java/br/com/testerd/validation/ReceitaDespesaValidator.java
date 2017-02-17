package br.com.testerd.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.testerd.model.ReceitaDespesa;

@Component
public class ReceitaDespesaValidator implements Validator {

	@Override
	public boolean supports(Class<?> aClass) {
		return ReceitaDespesa.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "evento", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoEvento", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "creditoDebito", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoria", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subCategoria", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "status", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "valor", "NotEmpty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dtLancamento", "NotEmpty");
	}
}