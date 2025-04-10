package aplicacao;

import java.util.InputMismatchException;
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
		
		while(true) {
			try {
				ImprimeTabuleiro.limparTela();
				ImprimeTabuleiro.imprimirTabuleiro(partida.getPecas());
				
				System.out.println();
				System.out.print("Origem: ");
				PosicaoDoXadrez origem = ImprimeTabuleiro.lerPosicaoDoXadrez(sc);
				
				System.out.println();
				System.out.print("Destino: ");
				PosicaoDoXadrez destino = ImprimeTabuleiro.lerPosicaoDoXadrez(sc);
				
				PecaDeXadrez pecaCapturada = partida.excutarMovimento(origem, destino);

				if (origem.equals("exit")) {
					break;
				}
			} catch (XadrezException | InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
	}

}
