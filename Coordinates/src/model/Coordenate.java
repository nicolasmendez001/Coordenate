package model;

public class Coordenate {
	private double valueX;
	private double valueY;

	public Coordenate(double valueX, double valueY) {
		this.valueX = valueX;
		this.valueY = valueY;
		
	}

	public double getValueX() {
		return valueX;
	}

	public void setValueX(double valueX) {
		this.valueX = valueX;
	}

	public double getValueY() {
		return valueY;
	}

	public void setValueY(double valueY) {
		this.valueY = valueY;
	}
	/**
	 * calcula la distacia de la coordenada a una coordenada que llega
	 * por parametro
	 * @param coordenate
	 * @return Distancia entre las coordenadas
	 */
	public double getDistance(Coordenate coordenate) {
		return Math.sqrt(Math.pow(this.valueX-coordenate.getValueX(), 2) +
				Math.pow(this.valueY-coordenate.getValueY(), 2));
	}

}
