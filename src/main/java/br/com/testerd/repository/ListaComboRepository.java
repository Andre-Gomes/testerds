package br.com.testerd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testerd.model.ListaCombo;

public interface ListaComboRepository extends JpaRepository<ListaCombo, Integer> {

}
