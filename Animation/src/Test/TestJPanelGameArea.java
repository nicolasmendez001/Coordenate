package Test;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.FigureGUI;
import GUI.JPanelGameArea;
import Mundo.Area;
import Mundo.Figure;

public class TestJPanelGameArea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame jFrame = new JFrame("Test Game Area");
		jFrame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		
		Figure figure = new Figure(100, Math.toRadians(90), 50.0, 100.0, 100.0);
		
		figure.setArea(new Area(20.0, 20.0, 800, 600));
		
		JPanelGameArea jPanelGameArea = new JPanelGameArea(new FigureGUI(figure));
		jFrame.add(jPanelGameArea);
		jPanelGameArea.init();
		jFrame.setVisible(true);
	}

}
