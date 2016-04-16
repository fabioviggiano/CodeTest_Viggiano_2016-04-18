package tennisgame.view;

import tennisgame.model.Player;

public class Score extends Match {

	public void deuce() {
		System.out.println("** Siamo in parità (Deuce)! 40-40");
	}
	
	public void vantaggio(Player p) {
		System.out.println("++ Vantaggio per " + p.getName());
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
		System.out.println("Sulla parità ha vinto: " + player.getName());
	}

	
}
