package xadrez;

import tabuleiro.Posicao;
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
		tabuleiro.adicionarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
		tabuleiro.adicionarPeca(new Rei(tabuleiro, Cor.BRANCO), new Posicao(7, 4));
		
		tabuleiro.adicionarPeca(new Torre(tabuleiro, Cor.PRETO), new Posicao(0, 3));
		tabuleiro.adicionarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(7,3));
	}
}
