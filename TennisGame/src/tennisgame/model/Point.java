package tennisgame.model;

public class Point {

	public enum Name {
		love, 
		fifteen, 
		thirty, 
		forty
	};

	public int i = 0;
	public Name name = null;

	public Point() {
		i=0;
		name = name.love;
	}

	public Name increasePoint() {

		i = i+15;

		switch (i) {
		
			case 15:  name = name.fifteen;
			break;
			
			case 30:  name = name.thirty;
			break;
			
			case 45:  name = name.forty;;
			break;
			
		    default: name = null;
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
}

