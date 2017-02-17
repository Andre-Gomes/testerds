package br.com.testerd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testerd.model.ReceitaDespesa;

public interface ReceitaDespesaRepository extends JpaRepository<ReceitaDespesa, Integer> {

}
