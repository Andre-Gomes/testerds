package br.com.testerd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.testerd.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}
