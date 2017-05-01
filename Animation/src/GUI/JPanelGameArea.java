package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;

import Mundo.Figure;

public class JPanelGameArea extends JPanel implements Runnable{
	
	private FigureGUI figureGUI;

	public JPanelGameArea(FigureGUI figureGUI){
		super();
		this.figureGUI = figureGUI;
	}
	
	public void init(){
		new Thread(this).start();
		figureGUI.startMove();
	}
	
	@Override
	public void paint(Graphics graphics){
		graphics.clearRect(0, 0, 1350, 800);
		
		this.figureGUI.show(graphics);
	}

	public void run() {
		while (true) {
			repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
			}
		}
	}
	
	

}
