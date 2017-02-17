package br.com.testerd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.testerd.model.ItemListaCombo;
import br.com.testerd.model.ListaCombo;
import br.com.testerd.model.ReceitaDespesa;
import br.com.testerd.repository.ItemListaComboRepository;
import br.com.testerd.repository.ListaComboRepository;
import br.com.testerd.service.ReceitaDespesaService;
import br.com.testerd.service.SecurityService;
import br.com.testerd.util.Constantes;
import br.com.testerd.validation.ReceitaDespesaValidator;

@Controller
public class ReceitaDespesaController {

	private Logger log = Logger.getLogger(ReceitaDespesaController.class);
	
	@Autowired
	private ReceitaDespesaService receitaDespesaService;

	@Autowired
	private ReceitaDespesaValidator receitaDespesaValidator;
	
	@Autowired
	private ListaComboRepository comboRepository;
	
	@Autowired
	private ItemListaComboRepository itemComboRepository;
	
	@Autowired
	private SecurityService securityService;

	@InitBinder
	public void dataBinding(WebDataBinder binder) {
		binder.addValidators(receitaDespesaValidator);
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    dateFormat.setLenient(false);

	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "/receitasDespesas", method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request) {
		model.addAttribute("receitaDespesa", new ReceitaDespesa());
		model.addAttribute("message", "asdfasdf");
		request.getSession().setAttribute("receitasDespesas", receitaDespesaService.listar());
		return "receitasDespesas";
	}

	@RequestMapping(value = "/receitaDespesa/adicionar", method = RequestMethod.POST)
	public String adicionarReceitaDespesa(@ModelAttribute("receitaDespesa") @Valid ReceitaDespesa receitaDespesa, BindingResult result, RedirectAttributes redirectAttrs, HttpServletRequest request) {
		
		if (result.hasErrors()){
			return "receitasDespesas";
		}
		
		receitaDespesa.setLogin(securityService.recuperarNomeUsuarioLogado());
		
		if (receitaDespesa.getId() == null) {
			this.receitaDespesaService.salvar(receitaDespesa);
			redirectAttrs.addAttribute("id", receitaDespesa.getId()).addFlashAttribute("message", "ReceitaDespesa criada com sucesso!");
		} else {
			this.receitaDespesaService.alterar(receitaDespesa);
			redirectAttrs.addAttribute("id", receitaDespesa.getId()).addFlashAttribute("message", "ReceitaDespesa atualizada com sucesso!");
		}
		
		request.getSession().setAttribute("receitasDespesas", receitaDespesaService.listar());

		return "redirect:/receitasDespesas";
	}	
	
}


