package model;

public class ContaCorrente extends Conta implements Tributavel {

	public ContaCorrente() {
	}

	public String getTipo() {
		return "Conta Corrente";
	}

	@Override
	public double getValorImposto() {
		return this.getSaldo() * 0.1;
	}
}