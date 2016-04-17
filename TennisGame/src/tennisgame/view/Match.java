package tennisgame.view;
import tennisgame.model.Player;

public class Match {
	// Classe Match - Individuata per le viste da fornire all' utente

	// I metodi cercano di descrivere il loro obiettivo in fase di lancio

	// Al suo interno sono contenute al momento output a termiale per indicare
	// l' attivita' in corso

	// Inizio del match
	public void start() {
		System.out.println("----- Inizio del match ----");
	}

	// Fine del match
	public void end() {
		System.out.println("----- Fine del match ----");
	}

	// Visualizza messaggio di eventuale errore intercettato come stringa

	public void error(String error) {
		System.out.println(error);
	}

	public void error(Exception e) {
		System.err.println("Intercettata eccezione: " + e.getMessage());
	}

	public void numberSet(int i) {
		System.out.println("  -- Set numero: " + i + " --");
	}

	public void resetVantaggio() {
		System.out.println("Vantaggio da deuce azzerato.");
	}
}