package tennisgame.view;

import tennisgame.model.Player;

public class Score extends Match {

	public void deuce() {
		System.out.println("** Siamo in deuce! 40-40");
	}

	public void vantaggio(Player p) {
		System.out.println("++ Vantaggio per " + p.getName() + "| +1");
	}

	public void showPointPlayer(Player p) {
		System.out.println("-- Punto per " + p.getName() + ". ");
	}

	public void winSet(Player player) {
		System.out.println("Set vinto da " + player.getName() + ". ");
	}

	public void aggiornamentoRisultato(Player player, Player player2) {
		System.out.println("| " + player.getName() + ": " + player.getPoint().toString() + "| vs |" + player2.getName()
				+ ": " + player2.getPoint().toString() + " |");
	}

	public void deuceWinner(Player player) {
		System.out.println("Sul deuce ha vinto: " + player.getName());
	}

	public void showWinnerSets(Player player1, Player player2, int setsInMatch) {
		System.out.print("-- Sets --");
		for (int i = 0; i < setsInMatch; i++) {
			System.out.print(" " + (i + 1) + "");
		}
		System.out.println("");

		System.out.print(player1.getName());

		System.out.print("   ");

		for (int i = 0; i < setsInMatch; i++) {
			if (player1.getWin(i) == true) {
				System.out.print("+");
			} else {
				System.out.print("-");
			}
		}

		System.out.println("");

		System.out.print(player2.getName());

		System.out.print("   ");

		for (int i = 0; i < setsInMatch; i++) {
			if (player2.getWin(i) == true) {
				System.out.print("+");
			} else {
				System.out.print("-");
			}
		}

		System.out.println("");
	}
}
