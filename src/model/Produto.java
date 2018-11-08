package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto extends DefaultEntity<Produto> implements Serializable{

	private static final long serialVersionUID = 1020950800821773964L;
	
	private String item;
	private String descricao;
	private String genero;
	
	@ManyToOne
	@JoinColumn(name="idUnidadeMedida")
	private Unidade unidadeMedida;
	
	@Column(columnDefinition="Date")
	private LocalDate dataCaddastro;

	public Produto() {
		
	}
	
	public Produto(String item, String descricao, String genero, Unidade unidadeMedida, LocalDate dataCadastro) {
		super();
		this.item = item;
		this.descricao = descricao;
		this.genero = genero;
		this.unidadeMedida = unidadeMedida;
		this.dataCaddastro = dataCadastro;
	}
	
	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}

	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public LocalDate getDataCaddastro() {
		return dataCaddastro;
	}

	public void setDataCaddastro(LocalDate dataCaddastro) {
		this.dataCaddastro = dataCaddastro;
	}

	public Unidade getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(Unidade unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}
}