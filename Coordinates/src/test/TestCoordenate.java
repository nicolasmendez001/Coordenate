package test;

import model.Coordenate;

public class TestCoordenate {
	
	public static void main(String[] args) {
		Coordenate coordenate = new Coordenate(10.0, 20.0);
		System.out.println("caso 1  " +  (coordenate.getDistance(
				new Coordenate(20.0, 30.0))
		== Math.sqrt(200) ? "ok" : "ERROR"));
		
		System.out.println("caso 2  " +  (coordenate.getDistance(
				new Coordenate(0.0, 10.0))
		== Math.sqrt(200) ? "ok" : "ERROR"));
		
		
	}
}
