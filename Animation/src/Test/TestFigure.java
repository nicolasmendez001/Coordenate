package Test;

import javax.swing.JOptionPane;

import Mundo.Figure;

public class TestFigure {

	/**
	 * Prueba Figure
	 */
	public static void main(String[] args) {
		Figure figure = new Figure(10, Math.toRadians(45), 10.0, 100.0, 100.0);
		System.out.println("X: " + figure.getX() + "   " + "Y: " + figure.getY());
		figure.setMoving(true);
		new Thread(figure).start();
		for (int i = 0; i < 100; i++) {
		System.out.println( "X: " + figure.getX() + "   " + "Y: " + figure.getY());
		}
	}

}
