package tennisgame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Match {
	
	// Classe Match - Individuata per le viste da fornire all' utente
	
	// I metodi cercano di descrivere il loro obiettivo in fase di lancio
	
	// Al suo interno sono contenute al momento output a termiale per indicare
	// l' attivita' in corso
	
	// Inizio del match
	public void start()
	{
		System.out.println("Partenza");
	}

	// Fine del match
	public void end()
	{
		System.out.println("Partenza");
	}
	
	// Visualizza messaggio di inserimento numero set
	public void setNumberSet()
	{
		System.out.println("Quanti set vuoi giocare? (Valore minimo 1 - Valore massimo 5");
	}
	
	// Visualizza messaggio di visualizzazione numero di viste
	public void setNamePlayerView()
	{
		System.out.println("Inserire nome:");
	}
	
	
	// Visualizza messaggio di eventuale errore intercettato come stringa
	// Implementazione futura la creazione nel controller di una classe
	// ereditata dalla classe exception per creare eccezioni utente anzichè
	// l' utilizzo delle stringhe 
	public void error(String error)
	{
		System.out.println(error);
	}

	public void error(Exception e) {
		System.err.println("Intercettata eccezione: " + e.getMessage());
	}
}
