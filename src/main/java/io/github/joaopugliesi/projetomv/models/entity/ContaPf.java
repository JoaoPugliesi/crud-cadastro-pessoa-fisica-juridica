package io.github.joaopugliesi.projetomv.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CONTA_PF")
public class ContaPf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_conta;

	@Column(nullable = false, length = 20)
	private String banco;

	@Column(nullable = false, unique = true, length = 12)
	private String contaCorrente;

	@Column(nullable = false, length = 8)
	private String agencia;

	@Column(nullable = false, unique = true, length = 15)
	private String numConta;

	@Column(nullable = false)
	private LocalDateTime dataRegistro;

	@ManyToOne
	@JoinColumn(name = "id")
	private ClientePf clientePf;

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Integer getId_conta() {
		return id_conta;
	}

	public void setId_conta(Integer id_conta) {
		this.id_conta = id_conta;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ClientePf getClientePf() {
		return clientePf;
	}

	public void setClientePf(ClientePf clientePf) {
		this.clientePf = clientePf;
	}

}
