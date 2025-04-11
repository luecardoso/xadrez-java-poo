package tabuleiro;

public abstract class Peca {
	protected Posicao posicao;
	protected Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.posicao = null;
	}

	protected Tabuleiro	getTabuleiro() {
        return tabuleiro;
    }
	
	public abstract boolean[][] movimentosPossiveis();
	
	public boolean movimentoPossivel(Posicao pos) {
		return movimentosPossiveis()[pos.getLinha()][pos.getColuna()];
	}
	
	public boolean existeMovimentosPossiveis() {
		boolean[][] mat = movimentosPossiveis();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}
}
