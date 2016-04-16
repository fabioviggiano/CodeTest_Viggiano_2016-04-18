package tennisgame.model;

public class Player {
	
	private String name;
	private Point point;
	private boolean[] win;
	
	public Player()
	{
		point = new Point();
		win = new boolean[5];

		for (int i=0; i<win.length; i++)
		{
			win[i] = false;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void point()
	{
		point.increasePoint();
	}

	public void resetPoint()
	{
		point.resetPoint();
	}

	public String getPoint()
	{
		return point.getName();
	}
	
	public int getOrdinalPoint()
	{
		return point.getOrdinalPoint();
	}
	
	public void vantaggio()
	{
		point.increaseVantaggio();
	}
	
	public int getVantaggio()
	{
		return point.getVantaggio();
	}
	
	public void resetVantaggio()
	{
		point.resetVantaggio();
	}
	
	public void setWin(int i)
	{
		win[i] = true;
	}
	
	public boolean getWin(int i)
	{
		return win[i];
	}
}
