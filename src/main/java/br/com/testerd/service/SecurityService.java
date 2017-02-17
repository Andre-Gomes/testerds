package br.com.testerd.service;

public interface SecurityService {
	
	String recuperarNomeUsuarioLogado();

	void autologin(String username, String senha);
	
}
