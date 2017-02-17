package br.com.testerd.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import br.com.testerd.model.enums.StatusReceitaDespesa;

@Entity
@Table(name = "tb_receita_despesa")
public class ReceitaDespesa implements Serializable {

	private static final long serialVersionUID = -2989040681874580726L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_criacao")
	private Date dhCriacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dh_atualizacao")
	private Date dhAtualizacao;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_lancamento")
	private Date dtLancamento;

	@Column(name = "ds_comentario", length = 200)
	private String comentario;

	@Column(name = "ds_login", length = 50)
	private String login;

	@Column(name = "in_status")
	private Integer status;

	@NumberFormat(pattern="R$ ###.###,00")
	@Column(name = "nr_valor")
	private BigDecimal valor;
	
	@Column(name="ds_evento")
	private String evento;
	
	@Column(name="id_evento")
	private Integer codigoEvento;
	
	@ManyToOne
	@JoinColumn(name="id_credito_debito")
	private ItemListaCombo creditoDebito;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private ItemListaCombo categoria;
	
	@ManyToOne
	@JoinColumn(name="id_sub_categoria")
	private ItemListaCombo subCategoria;

	@PreUpdate
	public void preUpdate() {
		this.dhAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		this.dhAtualizacao = new Date();
		this.dhCriacao = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getDtLancamento() {
		return dtLancamento;
	}

	public void setDtLancamento(Date dtLancamento) {
		this.dtLancamento = dtLancamento;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public StatusReceitaDespesa getStatus() {
		if (this.status == null){
			return null;
		}
		return StatusReceitaDespesa.parse(this.status);
	}

	public void setStatus(StatusReceitaDespesa status) {
		if (status != null){
			this.status = status.getValue();
		}
	}

	public String toString() {
		if (getCreditoDebito() == null){
			return "";
		}
		return  "\nId " + id + 
				"\nValor " + valor + 
				"\nStatus " + getStatus() + 
				"\nDh_criacao " + dhCriacao + 
				"\nDh_atualizacao " + dhAtualizacao + "\n" +
				getCreditoDebito().getNome() + ": " +  
				getCreditoDebito().getValor() + " \n" + 
				getCategoria().getNome() + ": " +  
				getCategoria().getValor() +  " \n" + 
				getSubCategoria().getNome() + ": " +  
				getSubCategoria().getValor() ;
	}

	public ItemListaCombo getCreditoDebito() {
		return creditoDebito;
	}

	public void setCreditoDebito(ItemListaCombo creditoDebito) {
		this.creditoDebito = creditoDebito;
	}

	public ItemListaCombo getCategoria() {
		return categoria;
	}

	public void setCategoria(ItemListaCombo categoria) {
		this.categoria = categoria;
	}

	public ItemListaCombo getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(ItemListaCombo subCategoria) {
		this.subCategoria = subCategoria;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public Integer getCodigoEvento() {
		return codigoEvento;
	}

	public void setCodigoEvento(Integer codigoEvento) {
		this.codigoEvento = codigoEvento;
	}

}
