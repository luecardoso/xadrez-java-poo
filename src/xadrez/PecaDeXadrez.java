package xadrez;

import tabuleiro.Peca;
import tabuleiro.Tabuleiro;

public class PecaDeXadrez extends Peca {

	private Cor cor;
	private int contagemMovimentos;

	public PecaDeXadrez(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro);
		this.cor = cor;
		this.contagemMovimentos = 0;
	}

	public Cor getCor() {
		return cor;
	}

	public int getContagemMovimentos() {
		return contagemMovimentos;
	}

	public void incrementarContagemMovimentos() {
		contagemMovimentos++;
	}

	public void decrementarContagemMovimentos() {
		contagemMovimentos--;
	}

}
