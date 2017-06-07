package test;

import controller.DistanceListener;

public class TestDistanceListener {

	public static void main(String[] args) {
		DistanceListener distanceListener = DistanceListener.getInstance();
		DistanceListener distanceListener1 = DistanceListener.getInstance();
		System.out.println(distanceListener);
		System.out.println(distanceListener1);
	}
	
}
