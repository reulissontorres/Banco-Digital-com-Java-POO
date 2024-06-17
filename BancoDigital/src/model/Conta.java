package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe responsável por moldar as Contas do Banco
 * @author Reulisson Torres
 */
public abstract class Conta implements Comparable<Conta> {
	private static int totalDeContas;

	private String titular;
	private int numero;
	private String agencia;
	private double saldo;
	private int identificador;
	private String dataAbertura;

	public Conta() {
		// Número total de contas
		Conta.totalDeContas += 1;
		this.identificador = Conta.totalDeContas;

		// Data de criação da conta
		Date data = new Date();
		SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");
		this.dataAbertura = fd.format(data);
	}

	/**
	 * Método que incrementa o valor do saldo
	 * @param valor
	 * @return
	 */
	public void deposita(double valor) {
		if (valor < 0.0) {
			throw new IllegalArgumentException("Não é possível depositar valor negativo.");
		} else if (valor < 0.05) {
			throw new IllegalArgumentException("O depósito deve ser no mínimo R$0,05");
		} else {
			this.saldo += valor;
		}
	}

	public void saca(double valor) throws SaldoInsuficienteException {
		if (valor < 0) {
			throw new IllegalArgumentException("Não é possível sacar valores negativos.");
		} else if (valor > this.saldo) {
			throw new SaldoInsuficienteException(valor);
		} else {
			this.saldo -= valor;
		}
	}

	public int compareTo(Conta outra) {
		return this.titular.compareTo(outra.titular);
	}

	public double getRendimento() {
		return this.saldo * 0.1;
	}

	public static int getTotaldeContas() {
		return Conta.totalDeContas;
	}

	public int getIdentificador() {
		return this.identificador;
	}

	public double getSaldo() {
		return this.saldo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getDataAbertura() {
		return this.dataAbertura;
	}

	public void setDataAbertura(String data) {
		this.dataAbertura = data;
	}

	public abstract String getTipo();

	public void transfere(double valor, Conta conta) {
		this.saca(valor);
		conta.deposita(valor);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}

		if (!(object instanceof Conta)) {
			return false;
		}

		Conta outraConta = (Conta) object;

		return (this.numero == outraConta.numero &&
				this.agencia.equals(outraConta.agencia));
	}

	@Override
	public String toString() {
		return "Titular: " + titular.toUpperCase() +
				"\nNumero: " + numero +
				"\nAgencia: " + agencia +
				"\nSaldo: " + saldo +
				"\nData de abertura: " + this.dataAbertura +
				"\nRendimento: " + this.getRendimento() +
				"\nTipo: " + this.getTipo();
	}

}