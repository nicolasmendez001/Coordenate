package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import controller.ConstantsDistance;
import controller.DistanceListener;

public class JPanelWorkAreaDistance extends JPanel{

	private JPanelDistance jPanelDistance;
	
	public JPanelWorkAreaDistance() {
		super();
		init();
	}

	private void init() {
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.addMouseMotionListener(DistanceListener.getInstance());
		this.addMouseListener(DistanceListener.getInstance());
	}
	
	
	public JPanelDistance getjPanelDistance() {
		return jPanelDistance;
	}

	public void setjPanelDistance(JPanelDistance jPanelDistance) {
		this.jPanelDistance = jPanelDistance;
	}

	@Override
	public void  paint(Graphics graphics) {
		super.paint(graphics);// para limpiar la pantalla
		
		graphics.setColor(ConstantsDistance.APP_COLOR_LINE);
		jPanelDistance.showLine(graphics);
		
	}
	
}
