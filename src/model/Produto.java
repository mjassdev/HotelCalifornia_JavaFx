package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Produto extends DefaultEntity<Produto> implements Serializable{

	private static final long serialVersionUID = 1020950800821773964L;
	
	private String item;
//	private String unidade;
	private String descricao;
	private String genero;
	
	@Column(columnDefinition="Date")
	private LocalDate dataCaddastro;

	public Produto() {
		
	}
	
	public Produto(String item, String descricao, String genero, LocalDate dataCadastro) {
		super();
		this.item = item;
//		this.unidade = unidade;
		this.descricao = descricao;
		this.genero = genero;
		this.dataCaddastro = dataCadastro;
	}
	
	public String getItem() {
		return item;
	}


	public void setItem(String item) {
		this.item = item;
	}


//	public String getUnidade() {
//		return unidade;
//	}
//
//
//	public void setUnidade(String unidade) {
//		this.unidade = unidade;
//	}
//

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

}
