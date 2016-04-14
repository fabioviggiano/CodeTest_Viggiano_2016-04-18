package tennisgame.controller;

import tennisgame.view.*;

public class Game {
	
	public static Match matchView;
	
	public static void main(String[] args) {
		
			int numberSet = 0;
		
		    matchView  = new Match();
		    matchView.setNumberSet();
		     
		    numberSet = insertNumberSet();
		    
			Set set = new Set(matchView);
		
	}
	
	public static int insertNumberSet()
	{
		int n = 0;
	
		do {
			n = Integer.parseInt(System.console().readLine());
			if (n<0 || n>5) {
				matchView.error("Valore non corretto");
			}
		}	while  (n<0 || n>5);
	    
	    return n;
	}
		
}
