package tennisgame.controller;

import tennisgame.view.Match;

public class Set extends Game {
	
	public Set() {
		
	}
	
	public Set(Match matchView)
	{
		matchView.start();
	}

}
