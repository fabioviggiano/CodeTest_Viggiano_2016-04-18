package tennisgame.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tennisgame.model.*;
import tennisgame.view.*;

// Tennis Game

// Implement a simple tennis game

// Rules:

// - Scores from zero to three points are described as “love”, “fifteen”, “thirty”, and “forty” respectively.
// - If at least three points have been scored by each side and a player has one more point than his opponent, the score of the game is “advantage” for the player in the lead.
// - If at least three points have been scored by each player, and the scores are equal, the score is “deuce”.
// - A game is won by the first player to have won at least four points in total and at least two points more than the opponent.

public class Game {

	public static Match matchView;	// Vista del Match
	private static Player players[] = new Player[2]; // Due giocatori
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Variabile per la lettura di input

	public static void main(String[] args) {

		// Variabili

		int setsInMatch = 0;
		Set set[] = null;
		int casualNumber;

		// Inizio del match 

		matchView  = new Match();

		do
		{
			// L' oggetto matchView interviene quando è necessario dialogare visualmente con l' utente
			matchView.setNumberSet(); 
			// Il controller insertNumeberSet ritornerà al game il numero di set da giocare
			setsInMatch = insertNumberSet();
		} while (setsInMatch == 0);

		for (int i=0; i<players.length; i++)
		{
			players[i] = new Player();
			String name = null;
			matchView.setNamePlayerView();
			name = insertPlayerName();
			players[i].setName(name);
		}

		set = new Set[setsInMatch];

		for (int i=0; i<setsInMatch; i++)
		{
			matchView.numberSet(i);
			boolean exitFromSet = false;
			do
			{
				casualNumber = randomPointAssigner();
				// Assegnazione punto
				if (casualNumber==0)
				{
					// Verifico se non è il punto  vittoria del set ossia
					// A game is won by the first player to have won at least four points in total and at least two points more than the opponent.
					
					if (players[0].getPoint().toString().equals("forty") && !players[1].getPoint().toString().equals("forty") && !players[1].getPoint().toString().equals("forty"))
					{
						// True allora assegno la vittoria
						players[0].setWin(i);
						exitFromSet = true;
					}
					else
					{
						// False assegno il punto
						players[0].point();
						matchView.showPointPlayer(players[0]);
					}
				}
				else
				{
					// Per diversificare l' utilizzo di classi, metodi ecc si è deciso in questo caso di effettuare il confronto sul valore "ordinale dell' enum"
					if (players[1].getPoint().toString().equals("forty") && !(players[0].getOrdinalPoint()==3) && !(players[0].getOrdinalPoint()==2))
					{
						players[1].setWin(i);
						exitFromSet = true;
					}
					else
					{
						players[1].point();
						matchView.showPointPlayer(players[1]);
					}
				}

				matchView.aggiornamentoRisultato(players[0],players[1]);

				if (players[0].getWin(i) == false || players[1].getWin(i) == false) // Non c'è un vincitore ancora, controlliamo il caso di paregigo
				{
					// Controllo del vantaggio nel caso spetti al giocatore 0
					if (players[0].getPoint().toString().equals("forty") && players[1].getPoint().toString().equals("thirty"))
					{
						matchView.vantaggio(players[0]);
					}

					// Controllo del vantaggio nel caso spetti al giocatore 1
					if (players[1].getPoint().toString().equals("forty") && players[0].getPoint().toString().equals("thirty"))
					{
						matchView.vantaggio(players[1]);
					}

					// Controllo in caso d parità e vantaggi
					while (players[0].getPoint().toString().equals("forty") && players[1].getPoint().toString().equals("forty") && (exitFromSet==false))
					{
						matchView.deuce();

								// Assegnazione punteggio sul vantaggio
						
								casualNumber = randomPointAssigner();

								if (casualNumber==0)
								{
									players[0].vantaggio();
								}
								else
								{
									players[1].vantaggio();
								}

						// Controlo vantaggi
								
								
						// Caso vittoria del player 0 
						if (players[0].getVantaggio() - players[1].getVantaggio() == 2)
						{
							players[0].setWin(i);
							exitFromSet = true;
							matchView.deuceWinner(players[0]);
						}
						// Caso vittoria del player 1
						else if (players[1].getVantaggio() - players[0].getVantaggio() == 2)
						{
							players[1].setWin(i);
							exitFromSet = true;
							matchView.deuceWinner(players[1]);
						}
						// Caso di riazzarmento del vantaggio
						else if (players[0].getVantaggio() == 1 && players[1].getVantaggio() == 1)
						{
							// Reset della parità quando la differenza si riazzera
							players[0].resetVantaggio();
							players[1].resetVantaggio();
						}	
					} 
				}
			} while (exitFromSet==false);

			if (players[0].getWin(i) == true)
			{
				matchView.winSet(players[0]);
			}
			else
			{
				matchView.winSet(players[1]);
			}
		}
		matchView.end();
	}

	public static int insertNumberSet()
	{
		int n = 1;

		do {
			try {
				n = Integer.parseInt(br.readLine());
				if (n<0 || n>5) {
					matchView.error("Valore non corretto");
				}
			}
			catch (Exception e)
			{
				matchView.error(e);
			}
		}	while  (n<0 || n>5);

		return n;
	}

	public static String insertPlayerName() {
		String name = null;

		try {
			name = br.readLine();
		} catch (IOException e) {
			matchView.error(e);
		}

		return name;
	}

	public static String insertPlayerSurname() {
		try {
			br.readLine();
		} catch (IOException e) {
			matchView.error(e);
		}

		return br.toString();
	}

	public static int randomPointAssigner()
	{
		return (Math.random()<0.5) ? 0 : 1;
	}
}
