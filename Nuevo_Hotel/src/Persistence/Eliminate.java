package Persistence;

import java.util.ArrayList;
import java.util.StringTokenizer;

import Model.Place;

public class Eliminate {

	public static final String SEPARATOR = ",";
	private FileText fileOriginal;
	private FileText newFile;
	private FilePlace filePlace;
	private ArrayList <String> abrevi = new ArrayList<String>();

	public Eliminate(String originalFile, String newFile) {
		this.fileOriginal = new FileText(originalFile, OpenForm.APPEND);
		this.newFile = new FileText(newFile, OpenForm.WRITE);
		this.filePlace = new FilePlace(newFile);
	}

	public void copy() {
		fileOriginal.setOpenForm(OpenForm.READ);
		fileOriginal.open();
		newFile.open();
		String temp = "";
		temp = fileOriginal.read();
		while (temp != null) {
			if (temp != null) {
				System.out.println(temp);
				StringTokenizer st = new StringTokenizer(temp, SEPARATOR);
				String cod1 = st.nextToken();
				String muni = st.nextToken();
				String cod2 = st.nextToken();
				String dep = st.nextToken();
				newFile.write(cod1 + "," + muni+","+ cod2 + "," + dep);
				temp = fileOriginal.read();
			}
		}
		newFile.close();
		fileOriginal.close();
	}
	
	public String getCodeM(String codel) {
		String codeF = "";
		for (int i = 2; i < codel.length(); i++) {
			codeF += codel.charAt(i);
		}
		return codeF;
	}
	
	public String getCodeD(String codel) {
		String codeF = "";
		for (int i = 0; i < 2; i++) {
			codeF += codel.charAt(i);
		}
		return codeF;
	}
	
	public void textToBinary() {
		Place place;
		fileOriginal.setOpenForm(OpenForm.READ);
		fileOriginal.open();
		filePlace.open("rw");
		String temp = "";
		temp = fileOriginal.read();
		int count = 0;
		while (temp != null) {
			if (temp != null) {
				System.out.println(temp);
				StringTokenizer st = new StringTokenizer(temp, SEPARATOR);
				String cod1 = st.nextToken();
				String muni = st.nextToken();
				place = new Place(Integer.parseInt(cod1), (byte) 3, muni, generateAbre(muni), null);
				filePlace.save(place, count);
				count++;
				temp = fileOriginal.read();
			}
		}
		fileOriginal.close();
	}
	
	public String generateAbre(String municipio) {
		String abreviFinal = "";
		for (int i = 0; i < 3; i++) {
			abreviFinal += municipio.charAt(i);
		}
		if (abrevi.contains(abreviFinal)) {
			abreviFinal = "";
			for (int i = 0; i < 2; i++) {
				abreviFinal += municipio.charAt(i);
			}
			abreviFinal += municipio.charAt(3);
		}
		
		return abreviFinal;
	}

//	public void copyFinal(String file) {
//		copy();
//		FileText text = new FileText(file, OpenForm.WRITE);
//		newFile.setOpenForm(OpenForm.READ);
//		newFile.open();
//		text.open();
//		String temp = "";
//		temp = newFile.read();
//		while (temp != null) {
//			if (temp != null) {
//				System.out.println(temp);
//				StringTokenizer st = new StringTokenizer(temp, SEPARATOR);
//				String cod1 = st.nextToken();
//				String muni = st.nextToken();
//				String cod2 = st.nextToken();
//				String dep = st.nextToken();
//
//				text.write(cod1 + "," + remove1(muni) + "," + cod2 + ","
//						+ remove1(dep) + ",");
//				temp = newFile.read();
//			}
//		}
//		text.close();
//		newFile.close();
//	}
//

	public void finaFile() {
		fileOriginal.setOpenForm(OpenForm.READ);
		fileOriginal.open();
		newFile.open();
		String temp = "";
		temp = fileOriginal.read();
		String flag = "";
		while (temp != null) {
			if (temp != null) {
				System.out.println(temp);
				StringTokenizer st = new StringTokenizer(temp, SEPARATOR);
				String code = st.nextToken();
				String muni = st.nextToken();
				String codeD = st.nextToken();
				String depa = st.nextToken();
				newFile.write(getCodeM(code) + "," + muni + "," +"3" + "," +generateAbre(muni)+","
				+codeD + "," + depa + "," +"2" + "," +generateAbre(depa));
				temp = fileOriginal.read();
			}
		}
		newFile.close();
		fileOriginal.close();
	}
	
	public void save1() {
		fileOriginal.setOpenForm(OpenForm.READ);
		fileOriginal.open();
		newFile.open();
		String temp = "";
		temp = fileOriginal.read();
		ArrayList <String> flag = new ArrayList<String>();
		while (temp != null) {
			if (temp != null) {
				System.out.println(temp);
				StringTokenizer st = new StringTokenizer(temp, SEPARATOR);
				int codeM = Integer.parseInt(st.nextToken());
				String muni = st.nextToken();
				int levelM = Integer.parseInt(st.nextToken());
				String abreM = st.nextToken();
				
				int codeD = Integer.parseInt(st.nextToken());
				String dpto = st.nextToken();
				int levelD = Integer.parseInt(st.nextToken());
				String abreD = st.nextToken();
				
				if (!flag.contains(abreD)) {
					newFile.write(codeD + ","+ levelD +","+ dpto + "," + abreD +","+ "57");
					newFile.write(codeM + ","+ levelM +","+ muni + "," + abreM +","+ codeD);
					flag.add(abreD);
				}else {
					newFile.write(codeM + ","+ levelM +","+ muni + "," + abreM +","+ codeD);
				}
				temp = fileOriginal.read();
			}
		}
		newFile.close();
		fileOriginal.close();
	}
	
	public static void main(String[] args) {
		Eliminate eliminate = new Eliminate(
				"C:/Users/Mendez/Desktop/Programacion/Programacion II/Hotel-Nuevo/src/Doc/municipios.txt",
				"C:/Users/Mendez/Desktop/Programacion/Programacion II/Hotel-Nuevo/src/Doc/lista.txt");
		//eliminate.copy();
		eliminate.finaFile();
		//eliminate.save1();
		//eliminate.textToBinary();
		//eliminate.copyFinal("C:/Users/Mendez/Desktop/Programacion/Programacion II/Hotel-Nuevo/src/Doc/finalMunicipios.txt");
	}
}
