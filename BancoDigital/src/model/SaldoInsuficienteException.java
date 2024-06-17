package model;

public class SaldoInsuficienteException extends RuntimeException {

	/**
	 * Lança uma Exception quando o saldo é insuficiente
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException() {
		super("Seu saldo insuficiente.");
	}

	public SaldoInsuficienteException(String message) {
		super(message);
	}

	public SaldoInsuficienteException(double valor) {
		super("Saldo insuficiente para sacar o valor de R$" + valor);
	}
}
