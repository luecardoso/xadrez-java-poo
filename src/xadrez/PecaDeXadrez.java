package xadrez;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;

public abstract class PecaDeXadrez extends Peca {

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

	protected boolean existePecaInimiga(Posicao pos) {
		PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(pos);
		return p != null && p.getCor() != cor;
	}

}
