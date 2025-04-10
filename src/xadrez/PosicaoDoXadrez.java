package xadrez;

import tabuleiro.Posicao;

public class PosicaoDoXadrez {
	
	private char coluna;
	private int linha;
	
	public PosicaoDoXadrez(char coluna, int linha) {
		if (coluna < 'a' || coluna > 'h' || linha < 1 || linha > 8) {
			throw new IllegalArgumentException("Posição inválida. Use letras de 'a' a 'h' e números de 1 a 8.");
		}
		this.coluna = coluna;
		this.linha = linha;
	}

	public char getColuna() {
		return coluna;
	}
	
	public int getLinha() {
		return linha;
	}
	
	protected Posicao toPosicao() {
		return new Posicao(8 - linha, coluna - 'a');
	}
	
	protected static PosicaoDoXadrez fromPosicao(Posicao pos) {
		return new PosicaoDoXadrez((char) ('a' + pos.getColuna()), 8 - pos.getLinha());
	}
	
	@Override
	public String toString() {
		return "" + coluna + linha;
	}
}
