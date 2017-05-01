package Mundo;

import java.util.ArrayList;

public class Cities {
	
	public ArrayList<String> listCities = new ArrayList<String>();
	private FileText fileOriginal;
	
	/**
	 * 
	 * @param originalFile Direccion del archivo
	 */
	
	public Cities(String file){
		this.fileOriginal = new FileText(file, OpenForm.READ);
	}
	
	/**
	 * Grabar en una lista el archivo
	 */
	
	public void cargarLenguaje(){
		fileOriginal.open();
		String temp = fileOriginal.read();
		while (temp != null){
				listCities.add(temp);
				temp = fileOriginal.read();
		}
		fileOriginal.close();
	}
		
	public void print() {
		for (int i = 0; i < listCities.size(); i++) {
			System.out.println(listCities.get(i) + " : " + (i+1));
		}
	}

}
