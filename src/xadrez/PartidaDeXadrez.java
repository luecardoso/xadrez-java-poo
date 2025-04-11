package xadrez;

import java.util.ArrayList;
import java.util.List;

import tabuleiro.Peca;
import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import tabuleiro.exeption.TabuleiroException;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {

	private Tabuleiro tabuleiro;
	private int turno;
	private Cor jogadorAtual;
	
	private List<Peca> pecasEmJogo =  new ArrayList<>();
	private List<Peca> pecasCapturadas = new ArrayList<>();

	public PartidaDeXadrez() {
		tabuleiro = new Tabuleiro(8, 8);
		turno = 1;
		jogadorAtual = Cor.BRANCO;
		inicializarPartida();
	}

	public int getTurno() {
		return turno;
	}

	public Cor getJogadorAtual() {
		return jogadorAtual;
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
		colocarNovaPeca('e', 1, new Rei(tabuleiro, Cor.BRANCO));
		colocarNovaPeca('a', 1, new Torre(tabuleiro, Cor.BRANCO));
	}

	private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca) {
		tabuleiro.adicionarPeca(peca, new PosicaoDoXadrez(coluna, linha).toPosicao());
		pecasEmJogo.add(peca);
	}

	public PecaDeXadrez excutarMovimento(PosicaoDoXadrez origem, PosicaoDoXadrez destino) {
		Posicao origemPos = origem.toPosicao();
		Posicao destinoPos = destino.toPosicao();
		validarPosicaoDeOrigem(origemPos);
		validarPosicaoDeDestino(origemPos, destinoPos);
		
		Peca pecaCapturada = moverPeca(origemPos, destinoPos);
		proximoTurno();
		return (PecaDeXadrez) pecaCapturada;
	}

	private Peca moverPeca(Posicao origemPos, Posicao destinoPos) {
		Peca peca = tabuleiro.removerPeca(origemPos);
		Peca pecaCapturada = tabuleiro.removerPeca(destinoPos);
		tabuleiro.adicionarPeca(peca, destinoPos);
		
		if (pecaCapturada != null) {
			pecasEmJogo.remove(pecaCapturada);
			pecasCapturadas.add(pecaCapturada);
		}
		
		return pecaCapturada;
	}

	private void validarPosicaoDeOrigem(Posicao pos) {
		if (!tabuleiro.temPeca(pos)) {
			throw new TabuleiroException("Não existe peça na posição de origem.");
		}
		
		if (jogadorAtual != ((PecaDeXadrez) tabuleiro.peca(pos)).getCor()) {
			throw new TabuleiroException("A peça de origem não é sua.");
		}
		
		if (!tabuleiro.peca(pos).existeMovimentosPossiveis()) {
			throw new TabuleiroException("Não existe movimentos possíveis para a peça de origem.");
		}
	}
	
	private void validarPosicaoDeDestino(Posicao origemPos, Posicao destinoPos) {
		if (!tabuleiro.peca(origemPos).movimentoPossivel(destinoPos)) {
			throw new TabuleiroException("Movimento inválido.");
		}
	}
	
	public boolean[][] possiveisMovimentos(PosicaoDoXadrez origem) {
		Posicao origemPos = origem.toPosicao();
		validarPosicaoDeOrigem(origemPos);
		
		return tabuleiro.peca(origemPos).movimentosPossiveis();
	}
	
	public void proximoTurno() {
		turno++;
		jogadorAtual = (jogadorAtual == Cor.BRANCO) ? Cor.PRETO : Cor.BRANCO;
	}
	
	
	
	
	
}
