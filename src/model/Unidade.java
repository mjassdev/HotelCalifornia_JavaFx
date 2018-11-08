package model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Unidade extends DefaultEntity<Unidade> implements Serializable{

	private static final long serialVersionUID = -5487186793319507405L;

	private String nome;
	
	public Unidade() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String toString() {
		return this.getNome();
	}
}
