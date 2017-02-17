package br.com.testerd.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_lista")
public class ListaCombo implements Serializable {

	private static final long serialVersionUID = -5401026582571258637L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "ds_nome", length = 50)
	private String nome;
	
	@Column(name = "ds_descricao", length = 100)
	private String descricao;
	
	@Column(name="in_status")
	private Boolean status;
	
	@Column(name="in_nativo")
	private Boolean nativo;
		
	@Column(name = "ds_login", length = 50)
	private String login;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Date dhCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_atualizacao")
	private Date dhAtualizacao;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="listaCombo")
	private List<ItemListaCombo> itens;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Boolean getNativo() {
		return nativo;
	}

	public void setNativo(Boolean nativo) {
		this.nativo = nativo;
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
	
	@PreUpdate
	public void preUpdate() {
		this.dhAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		this.dhAtualizacao = new Date();
		this.dhCriacao = new Date();
	}

	public List<ItemListaCombo> getItens() {
		return itens;
	}

	public void setItens(List<ItemListaCombo> itens) {
		this.itens = itens;
	}
	
	public String toString(){
		String texto = "";
		texto = this.getId() + " - " + this.getDescricao() + "\n";
		texto += "Filhos: ( ";
		for (ItemListaCombo item : this.getItens()){
			texto += "	" + item.toString() + "\n";
		}
		texto += ") ";
		return texto;
	}

}
