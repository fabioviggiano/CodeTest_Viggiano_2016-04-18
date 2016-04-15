package tennisgame.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import tennisgame.model.*;
import tennisgame.view.*;

public class Game {

	public static Match matchView;	// Vista del Match
	private static Player players[] = new Player[2]; // Due giocatori
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Variabile per la lettura di input

	public static void main(String[] args) {

		// Variabili

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
			if (i==0)
			{
				players[i].setName("a");
			}
			else
			{
				players[i].setName("b");
			}
			name = null;
		}

		set = new Set[setsInMatch];

		for (int i=0; i<setsInMatch; i++)
		{
			System.out.println("Set # " + (i+1));
			int j = i;
			boolean exit = false;
			do
			{
				j=i;
				int x = (Math.random()<0.5) ? 0 : 1;
				// Assegnazione punto
				if (x==0)
				{
					// Verifico se non è il punto  vittoria del set
					if (players[0].getPoint().toString().equals("forty") && !players[1].getPoint().toString().equals("forty"))
					{
						// True allora assegno la vittoria
						players[0].setWin(i);
						exit = true;
					}
					else
					{
						// False assegno il punto
						players[0].point();
						System.out.println("Punto per " + players[0].getName() +". ");
					}
				}
				else
				{
					if (players[1].getPoint().toString().equals("forty") && !players[0].getPoint().toString().equals("forty"))
					{
						players[1].setWin(i);
						exit = true;
					
					}
					else
					{
						players[1].point();
						System.out.println("Punto per " + players[1].getName() +". ");
					}
				}

//				System.out.println(players[0].getName() + " "+ players[0].getPoint().toString() + " vs " + players[1].getName() + ": "+ players[1].getPoint().toString());
				
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
					if (players[0].getPoint().toString().equals("forty") && players[1].getPoint().toString().equals("forty"))
					{
						matchView.deuce();

						int p = (Math.random()<0.5) ? 0 : 1;

						if (p==0)
						{
							players[0].vantaggio();
						}
						else
						{
							players[1].vantaggio();
						}

						if (players[0].getVantaggio() - players[1].getVantaggio() == 2)
						{
							players[0].setWin(i);
							exit = true;
		
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
				}
			
			} while (exit==false);

			if (players[0].getWin(i) == true)
			{
				System.out.println("Set vinto da player 0");
			}
			else
			{
				System.out.println("Set vinto da player 1");
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
