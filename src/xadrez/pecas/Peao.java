package xadrez.pecas;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.Cor;
import xadrez.PecaDeXadrez;

public class Peao extends PecaDeXadrez {

	public Peao(Tabuleiro tabuleiro, Cor cor) {
		super(tabuleiro, cor);
	}
	
	@Override
	public String toString() {
		return "P";
	}

	@Override
	public boolean[][] movimentosPossiveis() {
		boolean[][] mat = new boolean[getTabuleiro().getLinhas()][getTabuleiro().getColunas()];
		Posicao p = new Posicao(0, 0);

		if (getCor() == Cor.BRANCO) {
			// Acima
			p.setValores(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().temPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			// Acima duas casas
			p.setValores(posicao.getLinha() - 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() - 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().temPeca(p) && getTabuleiro().existePosicao(p2)
					&& !getTabuleiro().temPeca(p2) && getContagemMovimentos() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			// Diagonal esquerda
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() - 1);
			if (getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			// Diagonal direita
			p.setValores(posicao.getLinha() - 1, posicao.getColuna() + 1);
			if (getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

		} else {
			// Abaixo
			p.setValores(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().temPeca(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			// Abaixo duas casas
			p.setValores(posicao.getLinha() + 2, posicao.getColuna());
			Posicao p2 = new Posicao(posicao.getLinha() + 1, posicao.getColuna());
			if (getTabuleiro().existePosicao(p) && !getTabuleiro().temPeca(p) && getTabuleiro().existePosicao(p2)
					&& !getTabuleiro().temPeca(p2) && getContagemMovimentos() == 0) {
				mat[p.getLinha()][p.getColuna()] = true;
			}

			// Diagonal esquerda
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() - 1);
			if (getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
			// Diagonal direita
			p.setValores(posicao.getLinha() + 1, posicao.getColuna() + 1);
			if (getTabuleiro().existePosicao(p) && existePecaInimiga(p)) {
				mat[p.getLinha()][p.getColuna()] = true;
			}
		}
		return mat;
	}

}
