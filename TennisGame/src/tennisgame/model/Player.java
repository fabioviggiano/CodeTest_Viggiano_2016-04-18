package tennisgame.model;

public class Player {
	
	private String name;
	private Point point;
	
	public Player()
	{
		point = new Point();
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
	
	public String getPoint()
	{
		return point.getName();
	}
}
