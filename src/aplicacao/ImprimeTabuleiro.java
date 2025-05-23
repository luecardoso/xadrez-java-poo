package aplicacao;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xadrez.Cor;
import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDoXadrez;

public class ImprimeTabuleiro {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	public static void limparTela() {
		 System.out.print("\033[H\033[2J");
		 System.out.flush();
//		try {
//	        String operatingSystem = System.getProperty("os.name"); // verifica o SO
//
//	        if(operatingSystem.contains("Windows")){
//	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//	        } else {
//	            new ProcessBuilder("clear").inheritIO().start().waitFor();
//	        }
//	    } catch(Exception e) {
//	        System.out.println(e);
//	    }
	}

	public static void imprimirTabuleiro(PecaDeXadrez[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	public static void imprimirTabuleiro(PecaDeXadrez[][] pecas, boolean[][] possiveisMovimentos) {
		for (int i = 0; i < pecas.length; i++) {
			System.out.print((8 - i) + " ");
			for (int j = 0; j < pecas.length; j++) {
				imprimirPeca(pecas[i][j], possiveisMovimentos[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	private static void imprimirPeca(PecaDeXadrez peca, boolean fundo) {
		if (fundo) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		} else {
			System.out.print(ANSI_RESET);
		}
		
		if (peca == null) {
			System.out.print("-" + ANSI_RESET);
		} else {
			if (peca.getCor() == Cor.BRANCO) {
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + peca + ANSI_RESET);
            }
		}
		System.out.print(" ");
	}
	
	public static PosicaoDoXadrez lerPosicaoDoXadrez(Scanner posicao) {
		try {
			String s = posicao.nextLine();
			char coluna = s.charAt(0);
			int linha = Integer.parseInt(s.substring(1));
			return new PosicaoDoXadrez(coluna, linha);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Erro ao ler a posição. Valores válidos são de a1 até h8.");
		}
	}
	
	public static void imprimirPartida(PartidaDeXadrez partida, List<PecaDeXadrez> pecasCapturadas) {
		imprimirTabuleiro(partida.getPecas());
		System.out.println();
		imprimirPecasCapturadas(pecasCapturadas);
		System.out.println();
		System.out.println("Turno: " + partida.getTurno());
		if (!partida.isCheckMate()) {
			System.out.println("Aguardando jogador: " + partida.getJogadorAtual());
			if (partida.isCheck()) {
				System.out.println("CHECK!");
			}
		} else {
			System.out.println("CHECKMATE!");
			System.out.println("Vencedor: " + partida.getJogadorAtual());
		}
		
		

	}
	
	public static void imprimirPecasCapturadas(List<PecaDeXadrez> pecasCapturadas) {
		List<PecaDeXadrez> 	pecasBrancas = pecasCapturadas.stream()
				.filter(x -> x.getCor() == Cor.BRANCO)
				.toList();
		List<PecaDeXadrez> 	pecasPretas = pecasCapturadas.stream()
				.filter(x -> x.getCor() == Cor.PRETO)
				.toList();
		
		System.out.println("Peças capturadas: ");
		System.out.print("Brancas: ");
		System.out.print(Arrays.toString(pecasBrancas.toArray()));
		System.out.print(ANSI_WHITE);
		System.out.println(ANSI_RESET);
		System.out.print("Pretas: ");
		System.out.print(Arrays.toString(pecasPretas.toArray()));
		System.out.print(ANSI_YELLOW);
		System.out.println(ANSI_RESET);
	}
}
