package io.github.joaopugliesi.projetomv.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import io.github.joaopugliesi.projetomv.models.entity.ClientePf;

public class ContaPfDto {

	@NotBlank
	@NotEmpty
	private String banco;

	@NotBlank
	@NotEmpty
	private String contaCorrente;

	@NotBlank
	@NotEmpty
	private String agencia;

	@NotBlank
	@NotEmpty
	private String numConta;

	private ClientePf clientePf;

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

	public ClientePf getClientePf() {
		return clientePf;
	}

	public void setClientePf(ClientePf clientePf) {
		this.clientePf = clientePf;
	}

}
