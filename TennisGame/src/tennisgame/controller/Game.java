package tennisgame.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tennisgame.model.*;
import tennisgame.view.*;

public class Game {

	public static Match matchView;
	private static Player players[] = new Player[2];

	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// TODO

	// 1. HashCode - Equals 

	// 2. Implementare enum punti

	// 3. Conteggio punti

	// 4. Metodo per la creazione di un sistema di assegnazione punti

	// 5. Evolvere da console a frontend

	public static void main(String[] args) {

		// Variabili

		int numberSet = 0;
		int setsInMatch = 0;

		Set set[] = null;

		// Inizio del match (Nella sua parte di vista)

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
			players[i].setName("a");
			name = null;
		}

		set = new Set[setsInMatch];

		for (int i=0; i<setsInMatch; i++)
		{
			System.out.println("Set numero: " + i);
			do
			{
				int x = (Math.random()<0.5) ? 0 : 1;
				if (x==0)
				{
					players[0].point();
				}
				else
				{
					players[1].point();
				}
				
//				System.out.println("Giocatore 0: " + players[0].getPoint().toString());
//				
//				System.out.println("Giocatore 1: " + players[1].getPoint().toString());
				
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

				// Controllo in caso d parità
				if (players[0].getPoint().toString().equals("forty") && players[1].getPoint().toString().equals("forty"))
				{
					matchView.deuce();

					int p = (Math.random()<0.5) ? 0 : 1;
					if (p==0)
					{
						players[0].vantaggio();
						
						if (players[0].getVantaggio() - players[1].getVantaggio() == 2)
						{
							players[0].setWin(i);
							System.out.println("Sulla parità ha vinto: " + players[0].getName());
						}
						else if (players[1].getVantaggio() - players[0].getVantaggio() == 2)
						{
							players[1].setWin(i);
							System.out.println("Sulla parità ha vinto: " + players[1].getName());
						}
						else if (players[0].getVantaggio() == 1 && players[1].getVantaggio() == 1)
						{
							players[0].resetVantaggio();
							players[1].resetVantaggio();
							System.out.println("Reset della parità");
						}
					}
					else
					{
						players[1].point();
					}
					
					
				}
			} while (!(players[0].getPoint().toString().equals("forty")) || !(players[1].getPoint().toString().equals("forty")));
			
			// Aggiunta condizione vittoria sul vantaggio e parità procrastinata
			
			if (players[0].getPoint().toString().equals("forty"))
			{
				players[0].setWin(i);
				System.out.println("Set vinto da:  " + players[0].getName());
				players[0].resetPoint();
			}
			
			if (players[1].getPoint().toString().equals("forty"))
			{
				players[1].setWin(i);
				System.out.println("Set vinto da:  " + players[1].getName());
				players[1].resetPoint();
			}
		}

		matchView.end();
	}

	public static int insertNumberSet()
	{
		int n = 1;

		//		do {
		//			try {
		//				n = Integer.parseInt(br.readLine());
		//				if (n<0 || n>5) {
		//					matchView.error("Valore non corretto");
		//				}
		//			}
		//			catch (Exception e)
		//			{
		//				matchView.error(e);
		//			}
		//		}	while  (n<0 || n>5);

		return n;
	}

	public static String insertPlayerName() {

		String name = null;

		//		try {
		//			name = br.readLine();
		//		} catch (IOException e) {
		//			matchView.error(e);
		//		}
		name="prova";

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


}
