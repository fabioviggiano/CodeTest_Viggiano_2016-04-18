package tennisgame.model;

public class Point {

	public enum Name {
		love, fifteen, thirty, forty
	};

	public int i = 0;
	private int vantaggio = 0;
	public Name name = null;

	@SuppressWarnings("static-access")
	public Point() {
		i = 0;
		vantaggio = 0;
		name = name.love;
	}

	@SuppressWarnings("static-access")
	public Name increasePoint() {

		i = i + 15;

		switch (i) {

		case 15:
			name = name.fifteen;
			break;

		case 30:
			name = name.thirty;
			break;

		case 45:
			name = name.forty;
			;
			break;

		default:
			name = null;
			break;
		}

		return name;
	}

	public int getI() {
		return i;
	}

	public String getName() {
		return name.toString();
	}

	public int getVantaggio() {
		return vantaggio;
	}

	public int getOrdinalPoint() {
		return name.ordinal();
	}

	public void increaseVantaggio() {
		vantaggio++;
	}

	public void resetVantaggio() {
		vantaggio = 0;
	}

	public void resetPoint() {
		i = 0;
		name = name.love;
		vantaggio = 0;
	}
}
