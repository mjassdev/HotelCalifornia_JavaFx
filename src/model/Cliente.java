package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity

public class Cliente extends DefaultEntity<Cliente> implements Serializable{

	private static final long serialVersionUID = -4977468047936686376L;

	private String nome;
	
	@Column(unique=true)
	private String cpf;
	
	private String endereco;
	private String email;
	
	@Column(columnDefinition="Date")
	private LocalDate dataAniversario;
	
	public Cliente(){
		
	}
	
	public Cliente(String nome, String cpf, String endereco, String email, LocalDate dataAniversario) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.email = email;
		this.dataAniversario = dataAniversario;
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	public LocalDate getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(LocalDate dataAniversario) {
		this.dataAniversario = dataAniversario;
	}
	
	
}
