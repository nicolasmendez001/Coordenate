package Mundo;

public class Figure extends Coord implements Runnable{
	
	private int size;
	private double direction;
	private double speed;
	private boolean moving;
	private Area area;

	public Figure(int size, double direction, double speed, double x, double y) {
		super(x, y);
		this.size = size;
		this.direction = direction;
		this.speed = speed;
		this.moving = false;
	}

	public Area getArea() {
		return area;
	}



	public void setArea(Area area) {
		this.area = area;
	}



	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public double getDirection() {
		return direction;
	}

	public void setDirection(double direction) {
		this.direction = direction;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
	public void run() {
		while (moving) {
			try {
				Thread.sleep((long)(1/speed) * 1000);
				this.move(this.direction, 1);
				//if (!this.isInArea(area)){
					//this.setDirection(this.direction + Math.toRadians(180));
					//this.move(this.direction, 2);
				//}
					
			} catch (InterruptedException e) {
			}
		}
	}
	
}
