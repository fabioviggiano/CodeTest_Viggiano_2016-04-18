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

				if (players[0].getPoint().toString().equals("forty") && players[1].getPoint().toString().equals("thirty"))
				{
					matchView.vantaggio(players[0]);
				}

				if (players[1].getPoint().toString().equals("forty") && players[0].getPoint().toString().equals("thirty"))
				{
					matchView.vantaggio(players[1]);
				}

				if (players[0].getPoint().toString().equals("forty") && players[1].getPoint().toString().equals("forty"))
				{
					matchView.deuce();
				}
			} while (players[0].getPoint().toString().equals("forty") || players[1].getPoint().toString().equals("forty"));

			System.out.println("Uscito dal while");
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
