package Splash;

import javax.swing.JProgressBar;

public class Hilo extends Thread {

	public static final int NUMBER_LOAD = 100;
	public static final int SPEED_LOAD = 20;
	JProgressBar progreso;

	public Hilo(JProgressBar progreso1) {
		super();
		this.progreso = progreso1;
	}

	public void run() {
		for (int i = 1; i <= NUMBER_LOAD; i++) {
			progreso.setValue(i);
			pausa(20);
		}
	}

	public void pausa(int mlSeg) {
		try {
			Thread.sleep(mlSeg);
		} catch (Exception e) {

		}
	}
}
