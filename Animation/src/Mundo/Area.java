package Mundo;

public class Area extends Coord{
	
	private double width;
	private double heigth;

	public Area(double x, double y, double width, double heigth){
		super(x, y);
		this.width  = width;
		this.heigth = heigth;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeigth() {
		return heigth;
	}

	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}
}
