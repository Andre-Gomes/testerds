package br.com.testerd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testerd.model.ItemListaCombo;

public interface ItemListaComboRepository extends JpaRepository<ItemListaCombo, Integer> {
}
