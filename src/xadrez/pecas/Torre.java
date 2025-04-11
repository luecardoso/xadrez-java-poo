package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Torre extends PecaDeXadrez {

	public Torre(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}

	@Override
	public String toString() {
		return "T";
	}
	
	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		
		// Acima
		Posicao p = new Posicao(0, 0);
		p.setValores(posicao.getLinha() - 1, posicao.getColuna());
		while (getTabuleiro().existePosicao(p) && !getTabuleiro().temPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() - 1);
		}
		if (getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Esquerda
		p.setValores(posicao.getLinha(), posicao.getColuna() -1);
		while (getTabuleiro().existePosicao(p) && !getTabuleiro().temPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() -1);
		}
		if (getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Direita
		p.setValores(posicao.getLinha(), posicao.getColuna() +1);
		while (getTabuleiro().existePosicao(p) && !getTabuleiro().temPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setColuna(p.getColuna() + 1);
		}
		if (getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		// Abaixo
		p.setValores(posicao.getLinha() + 1, posicao.getColuna());
		while (getTabuleiro().existePosicao(p) && !getTabuleiro().temPeca(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
			p.setLinha(p.getLinha() + 1);
		}
		if (getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
			mat[p.getLinha()][p.getColuna()] = true;
		}
		
		
		return mat;
	}

	
}
