package br.com.testerd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.testerd.model.Usuario;
import br.com.testerd.service.SecurityService;
import br.com.testerd.service.UsuarioService;
import br.com.testerd.validation.UsuarioValidator;

@Controller
public class UsuarioController {
	
	@Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UsuarioValidator usuarioValidator;
    
    @RequestMapping(value = "/registroUsuario", method = RequestMethod.GET)
    public String registrar(Model model) {
        model.addAttribute("userForm", new Usuario());

        return "registroUsuario";
    }

    @RequestMapping(value = "/registroUsuario", method = RequestMethod.POST)
    public String registrar(@ModelAttribute("userForm") Usuario formUsuario, BindingResult bindingResult, Model model) {
    	usuarioValidator.validate(formUsuario, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registroUsuario";
        }

        usuarioService.salvar(formUsuario);

        securityService.autologin(formUsuario.getUsername(), formUsuario.getConfirmaPassword());
        
        return "redirect:/home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Login e senha inválidos.");

        if (logout != null)
            model.addAttribute("message", "Logout realizado com sucesso.");

        return "login";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcome(Model model) {
    	return "redirect:/home";
    }

}
