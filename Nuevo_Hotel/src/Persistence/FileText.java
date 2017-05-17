package Persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

public class FileText {
	File file;
	FileWriter fileWriter;
	FileReader fileReader;
	BufferedWriter bufferedWriter = null;
	BufferedReader bufferedReader = null;
	private OpenForm openForm;
	
	public FileText(String nameFile, OpenForm openForm) {
		this.openForm = openForm;
		file = new File(nameFile);
		this.openForm = openForm;
	}
	
	public void open(){
		try {
			switch (this.openForm){
			case WRITE:
				fileWriter = new FileWriter(file);
				bufferedWriter = new BufferedWriter(fileWriter);
				break;
			case READ:
				fileReader = new FileReader(file);
				bufferedReader = new BufferedReader(fileReader);
				break;
			case APPEND: //escribir sobre el archivo
				fileWriter = new FileWriter(file, true);
				bufferedWriter = new BufferedWriter(fileWriter);
				break;
			default:
				break;
			}
			
		} catch (IOException e) {
			System.out.println("Error al abrir");
		}	
	}
	
	 /**
	  * cierra el archivo dependiendo el modo
	  */
	 public void close(){
		 try {
			 switch (this.openForm){
			 case WRITE: 
			 case APPEND:
				 bufferedWriter.close();
				 fileWriter.close();
				 break;
			 case READ: // Leer el archivo
				 fileReader.close();
				 bufferedReader.close();
				 break;
			 }
		 } catch (IOException e) {
			 System.out.println("Error al cerrar");
		 }
	 }
/**
 * Almacena la cadena ingresada por parametro
 * @param cadena de texto
 */

	public void write(String cad){
		if (this.openForm == OpenForm.WRITE || this.openForm == OpenForm.APPEND){
			try {
				bufferedWriter.write(cad);
				bufferedWriter.newLine();
			} catch (IOException e) {
				 System.out.println("Error al escribir");
			}
		}
 }
	/**
	 * lee una linea del archivo
	 * @return linea del archivo
	 */
	 public String read(){		  
		 String cad= "";	
			try {
				if (this.openForm == OpenForm.READ) {
					cad = bufferedReader.readLine();
				}
				
			} catch (IOException e) {
				 System.out.println("Error al leer");
			}
		return cad;		  		
	}

	public OpenForm getOpenForm() {
		return openForm;
	}

	public void setOpenForm(OpenForm openForm) {
		this.openForm = openForm;
	}
	
	/**
	 * Crear una copia del archivo
	 * @param nameFileDestinaton
	 */
	public void copyFile(String nameFileDestinaton){
		FileText fileDestination = new FileText(nameFileDestinaton, openForm.WRITE);
		this.setOpenForm(openForm.READ);
		fileDestination.open();
		this.open();
		String line = this.read();
		while (line != null) {
			fileDestination.write(line);
			line = this.read();
		}
		this.close();
		fileDestination.close();
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
}
