package controller;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public enum Commands {
/*
 * public static final Color APP_ICON_WIDTH = 30;
 */
	COMMAND_CALCULATE_DISTANCE("COMMAD_CALCULATE_DISTANCE", "Calcular distancia",
			"Calcula la distancia entre dos distacnias ", "questionbook32.png"),
	COMMAND_FILE("COMMAND_FILE", "ARCHIVO",
			"Persistencia de la aplicacion","paperplus32.png"),
	COMMAND_FILE_SAVE("COMMAND_FILE_SAVE", "Grabar..",
			"Grabar las coordenadas","boxdownload32.png"),
	COMMAND_FILE_LOAD("COMMAND_FILE_LOAD", "Salvar..",
			"Salvar las coordenadas","boxupload32.png"),
	COMMAND_FILE_EXIT("COMMAND_FILE_EXIT", "Salir..",
			"Salir  de la aplicacion","stop32.png");
	
	private String command;
	private String title;
	private String hint;
	private String filename;
	private ImageIcon imageIcon;
	
	private Commands(String command, String title, String hint ,String filename) {
		this.command =command;
		this.title = title;
		this.hint = hint;
		this.filename = filename;
		this.imageIcon = imageIcon;
	}
	
	public String getCommand() {
		return command;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHind() {
		return hint;
	}

	public void setHind(String hind) {
		this.hint = hind;
	}

	public void setCommand(String command) {
		this.command = command;
	}
	
	public ImageIcon getImageIcon() {
		ImageIcon imageIcon = new ImageIcon("src/Archive/" + ConstantsDistance.APP_ICON_STYLE+"/"+filename);
		Image image = imageIcon.getImage();
		imageIcon = new ImageIcon(image.getScaledInstance(ConstantsDistance.APP_ICON_WIDTH, ConstantsDistance.APP_ICON_HEIGHT, java.awt.Image.SCALE_REPLICATE));
		//System.out.println(imageIcon+"");
		return imageIcon;		
		}
	
}
