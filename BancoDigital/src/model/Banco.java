package model;

public class Banco {
	private String nome;
	private int numero;
	private Conta[] contas;
	private int posicaoLivre = 0;

	public Banco(String nome, int numero) {
		this.nome = nome;
		this.numero = numero;
		this.contas = new ContaCorrente[10];
	}

	public void adiciona(ContaCorrente c) {
		try {
			contas[this.posicaoLivre] = c;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Erro! O limite de contas por banco já foi atingido.");
		}
		this.posicaoLivre += 1;
	}

	public void mostrarContas() {
		for (Conta c : this.contas) {
			if (c != null) {
				System.out.println(c);
			}
		}
	}

	public boolean contem(Conta conta) {
		for (Conta c : this.contas) {
			if (conta == c) {
				return true;
			}
		}
		return false;
	}

	public String getNome() {
		return nome;
	}

	public int getNumero() {
		return numero;
	}

	public Conta[] getContas() {
		return contas;
	}

}