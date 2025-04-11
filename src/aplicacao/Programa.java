package aplicacao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDoXadrez;
import xadrez.exception.XadrezException;

public class Programa {

	public static void main(String[] args) {
		System.out.println("Tabuleio de Xadrez");

		PartidaDeXadrez partida = new PartidaDeXadrez();
		Scanner sc = new Scanner(System.in);
		List<PecaDeXadrez> 	pecasCapturadas = new ArrayList<>();
		
		while(true) {
			try {
				ImprimeTabuleiro.limparTela();
				ImprimeTabuleiro.imprimirPartida(partida, pecasCapturadas);
				
				System.out.println();
				System.out.print("Origem: ");
				PosicaoDoXadrez origem = ImprimeTabuleiro.lerPosicaoDoXadrez(sc);
				
				boolean[][] possiveisMovimentos = partida.possiveisMovimentos(origem);
				ImprimeTabuleiro.limparTela();
				ImprimeTabuleiro.imprimirTabuleiro(partida.getPecas(), possiveisMovimentos);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoDoXadrez destino = ImprimeTabuleiro.lerPosicaoDoXadrez(sc);
				
				PecaDeXadrez pecaCapturada = partida.excutarMovimento(origem, destino);
				if (pecaCapturada != null) {
					pecasCapturadas.add(pecaCapturada);
				}
				

			} catch (XadrezException | InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
