package br.com.testerd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.testerd.model.ReceitaDespesa;
import br.com.testerd.repository.ReceitaDespesaRepository;

@Service
public class ReceitaDespesaServiceImpl implements ReceitaDespesaService {

	private ReceitaDespesaRepository receitaDespesaRepository;

	@Autowired
	public void setReceitaDespesaRepository(ReceitaDespesaRepository receitaDespesaRepository) {
		this.receitaDespesaRepository = receitaDespesaRepository;
	}

	@Override
	public List<ReceitaDespesa> listar() {
		return receitaDespesaRepository.findAll();
	}

	@Override
	public ReceitaDespesa getById(Integer id) {
		return receitaDespesaRepository.findOne(id);
	}

	@Override
	public ReceitaDespesa salvar(ReceitaDespesa receitaDespesa) {
		return receitaDespesaRepository.save(receitaDespesa);
	}
	
	@Override
	public ReceitaDespesa alterar(ReceitaDespesa receitaDespesa) {
		return receitaDespesaRepository.save(receitaDespesa);
	}

}
