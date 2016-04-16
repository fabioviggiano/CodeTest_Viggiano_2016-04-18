package tennisgame.model;

import java.util.Arrays;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(win);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(win, other.win))
			return false;
		return true;
	}
}
