package br.com.testerd.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.com.testerd.model.Usuario;
import br.com.testerd.service.UsuarioService;

@Component
public class UsuarioValidator implements Validator {
	@Autowired
	private UsuarioService usuarioService;

	@Override
	public boolean supports(Class<?> aClass) {
		return Usuario.class.equals(aClass);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Usuario usuario = (Usuario) o;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if (usuario.getUsername().length() < 5 || usuario.getUsername().length() > 50) {
			errors.rejectValue("login", "Size.userForm.username");
		}
		if (usuarioService.findByUsername(usuario.getUsername()) != null) {
			errors.rejectValue("username", "Duplicate.userForm.username");
		}

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
		if (usuario.getPassword().length() < 5 || usuario.getPassword().length() > 50) {
			errors.rejectValue("password", "Size.userForm.password");
		}

		if (!usuario.getPassword().equals(usuario.getPassword())) {
			errors.rejectValue("confirmaPassword", "Diff.userForm.passwordConfirm");
		}
	}
}