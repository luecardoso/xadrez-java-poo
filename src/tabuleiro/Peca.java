package tabuleiro;

public class Peca {
	protected Posicao posicao;
	protected Tabuleiro tabuleiro;
	
	public Peca(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		this.posicao = null;
	}

	protected Tabuleiro	getTabuleiro() {
        return tabuleiro;
    }
	
}
