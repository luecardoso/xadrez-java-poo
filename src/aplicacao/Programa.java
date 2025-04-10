package aplicacao;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Tabuleio de Xadrez");

		PartidaDeXadrez partida = new PartidaDeXadrez();
		ImprimeTabuleiro.imprimirTabuleiro(partida.getPecas());
	}

}
