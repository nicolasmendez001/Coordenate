package test;

import model.Coordenate;
import controller.DistanceListener;
import UI.JFrameDistance;

public class TestJFrameDistance {

	public static void main(String[] args) {
		//model
		Coordenate coordenateOne = new Coordenate(0.0, 0.0);
		Coordenate coordenateTwo = new Coordenate(0.0,0.0);
		//controller....
		DistanceListener distanceListener = DistanceListener.getInstance();
		distanceListener.setCoordenates(coordenateOne, coordenateTwo);
		//vista
		JFrameDistance frameDistance= new JFrameDistance();
		
	}
	
}
