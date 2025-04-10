package aplicacao;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.PartidaDeXadrez;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Tabuleio de Xadrez");
		Posicao pos = new Posicao(8, 8);
		System.out.println(pos);
		
		Tabuleiro tab = new Tabuleiro(8, 8);
		PartidaDeXadrez partida = new PartidaDeXadrez();
		ImprimeTabuleiro.imprimirTabuleiro(partida.getPecas());
	}

}
