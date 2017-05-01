package GUI;

import java.awt.Graphics;

import Mundo.Figure;

public class FigureGUI extends Figure{

	public FigureGUI(Figure figure){
		super(figure.getSize(), figure.getDirection(), figure.getSpeed(), figure.getX(), figure.getY());
	}
	
	public void startMove(){
		this.setMoving(true);
		new Thread(this).start();
	}
	
	public void show(Graphics graphics) {
		graphics.fillOval((int)this.getX(),(int) this.getY(), this.getSize(), this.getSize());
	}

}
