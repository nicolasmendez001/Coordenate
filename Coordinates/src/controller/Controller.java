package controller;

import UI.JFrameDistance;
import model.Coordenate;

public class Controller {

	private Coordenate coordenateOne;
	private Coordenate coordenateTwo;
	private DistanceListener distanceListener;
	private JFrameDistance frameDistance;
	
	public Controller() {
		Coordenate coordenateOne = new Coordenate(0.0, 0.0);
		Coordenate coordenateTwo = new Coordenate(0.0,0.0);
		System.out.println("creo bien");
		frameDistance= new JFrameDistance();
		DistanceListener distanceListener = DistanceListener.getInstance();
		distanceListener.setCoordenates(coordenateOne, coordenateTwo);
		distanceListener.setController(this);
		}
	
	public void setCoordenatesStatusBar(String string) {
		frameDistance.getJPanelStatusBar().setMessage(string);
	}
	
}
