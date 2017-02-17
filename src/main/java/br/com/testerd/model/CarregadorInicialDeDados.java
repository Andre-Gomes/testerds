package br.com.testerd.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.testerd.model.enums.StatusReceitaDespesa;
import br.com.testerd.repository.ItemListaComboRepository;
import br.com.testerd.repository.ListaComboRepository;
import br.com.testerd.repository.PerfilRepository;
import br.com.testerd.repository.ReceitaDespesaRepository;
import br.com.testerd.service.UsuarioService;

@Component
public class CarregadorInicialDeDados implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private ReceitaDespesaRepository receitaDespesaRepository;

	@Autowired
	private PerfilRepository perfilRepository;

	@Autowired
	private ListaComboRepository listaComboRepository;
	
	@Autowired
	private ItemListaComboRepository itemListaComboRepository;

	@Autowired
	private UsuarioService usuarioService;

	private Logger log = Logger.getLogger(CarregadorInicialDeDados.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		Perfil admin = new Perfil();
		admin.setNome("Admin");
		perfilRepository.save(admin);

		Perfil leitura = new Perfil();
		leitura.setNome("Leitura");
		perfilRepository.save(leitura);

		Usuario usuario = new Usuario();
		usuario.setUsername("admin");
		usuario.setPassword("admin");
		usuarioService.salvar(usuario);

		log.info("Usuário admin/admin cadastrado. Perfis: " + usuario.getPerfis());

		ReceitaDespesa receitaDespesa = new ReceitaDespesa();
		receitaDespesa.setComentario("Comentário");
		receitaDespesa.setDtLancamento(new Date());
		receitaDespesa.setLogin("admin");
		receitaDespesa.setStatus(StatusReceitaDespesa.ATIVO);
		receitaDespesa.setValor(BigDecimal.valueOf(125.00));
		receitaDespesa.setEvento("0001");
		receitaDespesa.setCodigoEvento(1);
		
		ReceitaDespesa receitaDespesa2 = new ReceitaDespesa();
		receitaDespesa2.setComentario("Comentário 2");
		receitaDespesa2.setDtLancamento(new Date());
		receitaDespesa2.setLogin("admin");
		receitaDespesa2.setStatus(StatusReceitaDespesa.ATIVO);
		receitaDespesa2.setValor(BigDecimal.valueOf(1225.50));
		receitaDespesa2.setEvento("0002");
		receitaDespesa2.setCodigoEvento(2);

		ListaCombo listaCombo = carregarCombos();
		
		receitaDespesa.setCreditoDebito(listaCombo.getItens().get(0));
		receitaDespesa.setCategoria(listaCombo.getItens().get(0).getFilhos().get(0));
		receitaDespesa.setSubCategoria(listaCombo.getItens().get(0).getFilhos().get(0).getFilhos().get(0));
		receitaDespesaRepository.save(receitaDespesa);
		
		
		receitaDespesa2.setCreditoDebito(listaCombo.getItens().get(1));
		receitaDespesa2.setCategoria(listaCombo.getItens().get(1).getFilhos().get(0));
		receitaDespesa2.setSubCategoria(listaCombo.getItens().get(1).getFilhos().get(0).getFilhos().get(0));
		receitaDespesaRepository.save(receitaDespesa2);

		log.info("\n\nAdicionando Receita/Despesa " + receitaDespesa);
		log.info("\n\nAdicionando Receita/Despesa " + receitaDespesa2);
	}

	private ListaCombo carregarCombos() {
		ListaCombo listaCombo = new ListaCombo();
		listaCombo.setNome("sist_conta_fluxo_caixa");
		listaCombo.setDescricao("Combo para definir o tipo de Despesas e Receitas");
		listaCombo.setLogin("admin");
		listaCombo.setNativo(true);
		listaCombo.setStatus(false);

		ItemListaCombo creditoNivel1 = new ItemListaCombo();
		creditoNivel1.setNome("Crédito/Débito");
		creditoNivel1.setDescricao("Crédito/Débito");
		creditoNivel1.setValor("Crédito");
		creditoNivel1.setLogin("admin");
		creditoNivel1.setPosicao(1);
		creditoNivel1.setListaCombo(listaCombo);

			ItemListaCombo categoriaPagamentoNivel2 = new ItemListaCombo();
			categoriaPagamentoNivel2.setNome("Categoria");
			categoriaPagamentoNivel2.setDescricao("Categoria");
			categoriaPagamentoNivel2.setValor("Pagamento");
			categoriaPagamentoNivel2.setLogin("admin");
			categoriaPagamentoNivel2.setPosicao(1);
				
				ItemListaCombo subCategoriaVendaNivel3 = new ItemListaCombo();
				subCategoriaVendaNivel3.setNome("Subcategoria");
				subCategoriaVendaNivel3.setDescricao("Subcategoria");
				subCategoriaVendaNivel3.setValor("Venda");
				subCategoriaVendaNivel3.setLogin("admin");
				subCategoriaVendaNivel3.setPosicao(1);
		
			categoriaPagamentoNivel2.setFilhos(Arrays.asList(subCategoriaVendaNivel3)); //ERRO NESSE PONTO!!!!!!!!!!!!!

		creditoNivel1.setFilhos(Arrays.asList(categoriaPagamentoNivel2));

		ItemListaCombo debitoNivel1 = new ItemListaCombo();
		debitoNivel1.setNome("Crédito/Débito");
		debitoNivel1.setDescricao("Crédito/Débito");
		debitoNivel1.setValor("Débito");
		debitoNivel1.setLogin("admin");
		debitoNivel1.setPosicao(2);
		
			ItemListaCombo categoriaReembolsoNivel2 = new ItemListaCombo();
			categoriaReembolsoNivel2.setNome("Categoria");
			categoriaReembolsoNivel2.setDescricao("Categoria");
			categoriaReembolsoNivel2.setValor("Reembolso");
			categoriaReembolsoNivel2.setLogin("admin");
			categoriaReembolsoNivel2.setPosicao(1);
			
				ItemListaCombo subCategoriaCombustivelNivel3 = new ItemListaCombo();
				subCategoriaCombustivelNivel3.setNome("Subcategoria");
				subCategoriaCombustivelNivel3.setDescricao("Subcategoria");
				subCategoriaCombustivelNivel3.setValor("Combustível");
				subCategoriaCombustivelNivel3.setLogin("admin");
				subCategoriaCombustivelNivel3.setPosicao(1);
				
				ItemListaCombo subCategoriaOutrosNivel3 = new ItemListaCombo();
				subCategoriaOutrosNivel3.setNome("Subcategoria");
				subCategoriaOutrosNivel3.setDescricao("Subcategoria");
				subCategoriaOutrosNivel3.setValor("Outros");
				subCategoriaOutrosNivel3.setLogin("admin");
				subCategoriaOutrosNivel3.setPosicao(2);
				
			categoriaReembolsoNivel2.setFilhos(Arrays.asList(subCategoriaCombustivelNivel3, subCategoriaOutrosNivel3));
	
			ItemListaCombo categoriaDespesasNivel2 = new ItemListaCombo();
			categoriaDespesasNivel2.setNome("Categoria");
			categoriaDespesasNivel2.setDescricao("Categoria");
			categoriaDespesasNivel2.setValor("Despesas");
			categoriaDespesasNivel2.setLogin("admin");
			categoriaDespesasNivel2.setPosicao(2);
			
				ItemListaCombo subCategoriaAluguelNivel3 = new ItemListaCombo();
				subCategoriaAluguelNivel3.setNome("Subcategoria");
				subCategoriaAluguelNivel3.setDescricao("Subcategoria");
				subCategoriaAluguelNivel3.setValor("Aluguel");
				subCategoriaAluguelNivel3.setLogin("admin");
				subCategoriaAluguelNivel3.setPosicao(1);
				
				ItemListaCombo subCategoriaFolhaPagamentoNivel3 = new ItemListaCombo();
				subCategoriaFolhaPagamentoNivel3.setNome("Subcategoria");
				subCategoriaFolhaPagamentoNivel3.setDescricao("Subcategoria");
				subCategoriaFolhaPagamentoNivel3.setValor("Folha Pagamento");
				subCategoriaFolhaPagamentoNivel3.setLogin("admin");
				subCategoriaFolhaPagamentoNivel3.setPosicao(2);
			
			categoriaReembolsoNivel2.setFilhos(Arrays.asList(subCategoriaAluguelNivel3, subCategoriaFolhaPagamentoNivel3));
		

		debitoNivel1.setFilhos(Arrays.asList(categoriaReembolsoNivel2, categoriaDespesasNivel2));
			
		listaCombo.setItens(Arrays.asList(creditoNivel1, debitoNivel1));

		listaComboRepository.save(listaCombo);	
		
		log.info("Combo cadastrado:\n" + listaCombo);
		
		return listaCombo;		
	}

}
