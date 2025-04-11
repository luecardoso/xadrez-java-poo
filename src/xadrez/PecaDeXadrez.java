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
	
	public int getContagemMovimentos() {
		return contagemMovimentos;
	}

	protected boolean existePecaInimiga(Posicao pos) {
		PecaDeXadrez p = (PecaDeXadrez) getTabuleiro().peca(pos);
		return p != null && p.getCor() != cor;
	}
	
	public PosicaoDoXadrez getPosicaoDoXadrez() {
		return PosicaoDoXadrez.fromPosicao(posicao);
	}
	
	public void aumentarContagemMovimentos() {
		contagemMovimentos++;
	}
	
	public void diminuirContagemMovimentos() {
		contagemMovimentos--;
	}
}
