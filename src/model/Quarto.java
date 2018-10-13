package model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Quarto extends DefaultEntity<Quarto> implements Serializable{

	private String numeroQuarto;
	private String descricaoQuarto;
	private String tipoQuarto;
	private boolean ocupado;
	
	public Quarto() {
		
	}
	
	public Quarto(String numeroQuarto, String descricaoQuarto, String tipoQuarto, boolean ocupado) {
		this.setNumeroQuarto(numeroQuarto);
		this.setDescricaoQuarto(descricaoQuarto);
		this.setTipoQuarto(tipoQuarto);
		this.setOcupado(ocupado);
	}
	public String getNumeroQuarto() {
		return numeroQuarto;
	}
	public void setNumeroQuarto(String numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	public String getDescricaoQuarto() {
		return descricaoQuarto;
	}
	public void setDescricaoQuarto(String descricaoQuarto) {
		this.descricaoQuarto = descricaoQuarto;
	}
	public String getTipoQuarto() {
		return tipoQuarto;
	}
	public void setTipoQuarto(String tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
}
