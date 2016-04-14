package tennisgame.controller;

import tennisgame.model.Player;
import tennisgame.view.Match;

public class Set extends Game {
	
	private Player[] players;
	
	public Set() {
		
	}
	
	public Set(Match matchView)
	{
		matchView.start();
	}
	
	public void setPlayers(Player[] p)
	{
		players = p;
	}
	
	public boolean playSet()
	{
		return false;
	}
}
