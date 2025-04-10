package xadrez;

import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {
	
	private Tabuleiro tabuleiro;
	
	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		inicializarPartida();
	}
	
	public PecaDeXadrez[][] getPecas() {
		PecaDeXadrez[][] pecas = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];

		for (int i = 0; i < tabuleiro.getLinhas(); i++) {
			for (int j = 0; j < tabuleiro.getColunas(); j++) {
				pecas[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
			}
		}

		return pecas;
	}
	
	private void inicializarPartida() {
		colocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.PRETO));	
	    colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
	    colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.PRETO));
	    colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
	}
	
	private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.adicionarPeca(peca, new PosicaoDoXadrez(coluna, linha).toPosicao());
	}
}
