package tabuleiro;

import tabuleiro.exeption.TabuleiroException;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private Peca[][] pecas;

	public Tabuleiro(int linhas, int colunas) {
		if (linhas < 1 || colunas < 1) {
            throw new TabuleiroException("Erro ao criar tabuleiro: deve haver pelo menos 1 linha e 1 coluna.");
        }
		this.linhas = linhas;
		this.colunas = colunas;
		pecas = new Peca[linhas][colunas];
	}

	public int getLinhas() {
		return linhas;
	}

	public int getColunas() {
		return colunas;
	}
	
	public Peca peca(int linha, int coluna) {
		if (!existePosicao(linha, coluna)) {
			throw new TabuleiroException("Posição inválida no tabuleiro.");
		}
		return pecas[linha][coluna];
	}
	
	public Peca peca(Posicao pos) {
		if (!existePosicao(pos)) {
			throw new TabuleiroException("Posição inválida no tabuleiro.");
		}
		return pecas[pos.getLinha()][pos.getColuna()];
	}
	
	public void adicionarPeca(Peca peca, Posicao pos) {
		if (temPeca(pos)) {
			throw new TabuleiroException("Já existe uma peça na posição: " + pos);
		}
		pecas[pos.getLinha()][pos.getColuna()] = peca;
		peca.posicao = pos;
	}
	
	public boolean existePosicao(Posicao pos) {
		return existePosicao(pos.getLinha(), pos.getColuna());
	}
	
	public boolean existePosicao(int linha, int coluna) {
		return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
	}
	
	public boolean temPeca(Posicao pos) {
		if (!existePosicao(pos)) {
			throw new TabuleiroException("Posição inválida no tabuleiro.");
		}
		return peca(pos) != null;
	}
	
	public Peca removerPeca(Posicao pos) {
		if (!existePosicao(pos)) {
			throw new TabuleiroException("Posição inválida no tabuleiro.");
		}
		if (pecas[pos.getLinha()][pos.getColuna()] == null) {
			return null;
		}
		Peca aux = peca(pos);
		aux.posicao = null;
		pecas[pos.getLinha()][pos.getColuna()] = null;
		return aux;
	}
}
