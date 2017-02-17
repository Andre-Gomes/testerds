package br.com.testerd.service;

import java.util.List;

import br.com.testerd.model.ReceitaDespesa;

public interface ReceitaDespesaService {
	
	List<ReceitaDespesa> listar();

	ReceitaDespesa getById(Integer id);

	ReceitaDespesa salvar(ReceitaDespesa receitaDespesa);
	
	ReceitaDespesa alterar(ReceitaDespesa receitaDespesa);
}
