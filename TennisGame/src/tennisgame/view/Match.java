package tennisgame.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Match {
	
	public void start()
	{
		System.out.println("Partenza");
	}
	
	public void end()
	{
		System.out.println("Partenza");
	}
	
	public void setNumberSet()
	{
		System.out.println("Quanti set vuoi giocare? (Valore minimo 1 - Valore massimo 5");
	}
	
	public void error(String error)
	{
		System.out.println(error);
	}
}
