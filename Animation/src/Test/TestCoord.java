package Test;

import Mundo.Coord;

public class TestCoord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Coord coord = new Coord(10, 10);
		System.out.println("X: " + coord.getX() + "   " + "Y: " + coord.getY());
		coord.move(Math.toRadians(5), 10);
		System.out.println("X: " + coord.getX() + "   " + "Y: " + coord.getY());
	}

}
