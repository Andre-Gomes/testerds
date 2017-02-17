package br.com.testerd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_lista_item")
public class ItemListaCombo implements Serializable {

	private static final long serialVersionUID = 411432284718315762L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ds_login", length = 50)
	private String login;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Date dhCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_atualizacao")
	private Date dhAtualizacao;

	@Column(name = "ds_nome", length = 50)
	private String nome;

	@Column(name = "ds_descricao", length = 100)
	private String descricao;

	@Column(name = "ds_valor", length = 50)
	private String valor;

	@Column(name = "in_status")
	private Boolean status;

	@Column(name = "nr_posicao")
	private Integer posicao;

	/*
	 * *Obs: considerando que terá uma das duas FKs, ou para a ListaCombo
	 * (quando for Item raiz) ou para o Pai (quando for item filho)
	 */
	@ManyToOne(targetEntity = ListaCombo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_lista")
	private ListaCombo listaCombo;

	/*
	 * *Obs: considerando que terá uma das duas FKs, ou para a ListaCombo
	 * (quando for Item raiz) ou para o Pai (quando for item filho)
	 */
	@ManyToOne(targetEntity = ListaCombo.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_pai")
	private ItemListaCombo pai;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pai")
	private List<ItemListaCombo> filhos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getDhCriacao() {
		return dhCriacao;
	}

	public void setDhCriacao(Date dhCriacao) {
		this.dhCriacao = dhCriacao;
	}

	public Date getDhAtualizacao() {
		return dhAtualizacao;
	}

	public void setDhAtualizacao(Date dhAtualizacao) {
		this.dhAtualizacao = dhAtualizacao;
	}

	public ListaCombo getListaCombo() {
		return listaCombo;
	}

	public void setListaCombo(ListaCombo listaCombo) {
		this.listaCombo = listaCombo;
	}

	@PreUpdate
	public void preUpdate() {
		this.dhAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		this.dhAtualizacao = new Date();
		this.dhCriacao = new Date();
	}

	public ItemListaCombo getPai() {
		return pai;
	}

	public void setPai(ItemListaCombo pai) {
		this.pai = pai;
	}

	public List<ItemListaCombo> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<ItemListaCombo> filhos) {
		this.filhos = filhos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String toString() {
		String texto = "";
		texto = this.getId() + " - " + this.getDescricao() + "\n";
		if (getFilhos() != null) {
			texto += "Filhos: ( ";
			for (ItemListaCombo item : this.getFilhos()) {
				texto += "	" + item.toString() + "\n";
			}
			texto += ") ";
		}
		return texto;
	}

}
