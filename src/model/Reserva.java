package model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reserva extends DefaultEntity<Reserva> implements Serializable{

	private static final long serialVersionUID = -6210097564831085196L;
	
	@OneToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente;
	private LocalDate dataPrevisaoEntrada;
	private LocalDate dataPrevisaoSaida;
	private Integer acompanhantes;
	private Quarto quarto;
	
	public Reserva() {
		
	}
	
	public Reserva(Cliente cliente, LocalDate dataPrevisaoEntrada, LocalDate dataPrevisaoSaida, Integer acompanhantes, Quarto quarto) {
		super();
		this.cliente = cliente;
		this.dataPrevisaoEntrada = dataPrevisaoEntrada;
		this.dataPrevisaoSaida = dataPrevisaoSaida;
		this.acompanhantes = acompanhantes;
		this.quarto = quarto;
	}
	


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataPrevisaoEntrada() {
		return dataPrevisaoEntrada;
	}

	public void setDataPrevisaoEntrada(LocalDate dataPrevisaoEntrada) {
		this.dataPrevisaoEntrada = dataPrevisaoEntrada;
	}

	public LocalDate getDataPrevisaoSaida() {
		return dataPrevisaoSaida;
	}

	public void setDataPrevisaoSaida(LocalDate dataPrevisaoSaida) {
		this.dataPrevisaoSaida = dataPrevisaoSaida;
	}

	public Integer getAcompanhantes() {
		return acompanhantes;
	}

	public void setAcompanhantes(Integer acompanhantes) {
		this.acompanhantes = acompanhantes;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

}
