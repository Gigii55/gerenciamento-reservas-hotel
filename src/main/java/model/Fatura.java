package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "fatura")
public class Fatura {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 100, name ="valorTotal")
	private double valorTotal;
	
	@Column(nullable = false, length = 100, name ="desconto")
	private double desconto;

	@Column(nullable = false, length = 100, name ="status_pagamento")
	private StatusPagamento statusPagamento;
	
	@Column(nullable = false, length = 100, name ="data_fechamento")
	private Date dataFechamento;
	

	public double getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}


	public double getDesconto() {
		return desconto;
	}


	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}


	public StatusPagamento getStatusPagamento() {
		return statusPagamento;
	}


	public void setStatusPagamento(StatusPagamento statusPagamento) {
		this.statusPagamento = statusPagamento;
	}


	public Date getDataFechamento() {
		return dataFechamento;
	}


	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}


	public long getId() {
		return id;
	}
}
