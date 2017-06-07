package test;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import UI.JPanelCoordenate;
import UI.JPanelDistance;
import model.Coordenate;

public class TestCoordenateGUI {

	public static void main(String[] args) {
		Coordenate coordenateOne = new Coordenate(10.0, 20.0);
		Coordenate coordenateTwo = new Coordenate(30.0,50.0);
		JFrame jFrame = new JFrame("Test GUI Coordenate");
		jFrame.setSize(new Dimension(300, 300));
		JPanelDistance jPanelDistance = new JPanelDistance();
		jFrame.add(jPanelDistance);
		
		jPanelDistance.set(coordenateOne, coordenateTwo);
		
		Coordenate coordenateOutOne = jPanelDistance.getCoordenateOne(); 
		Coordenate coordenateOutTwo = jPanelDistance.getCoordenateTwo();
		double distance = jPanelDistance.get();
		System.out.println("Distancia es igual a"  + distance);
		jFrame.setVisible(true);
		jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
	}
	
}
