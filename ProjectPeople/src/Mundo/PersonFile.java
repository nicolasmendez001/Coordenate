
package Mundo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.StringTokenizer;
import Controller.ControlInsert;
import Exceptions.InvalidBirthDate;

public class PersonFile{
	
	public static final String SEPARATOR = ",";	
	private FileText fileOriginal;
	private ArrayList<Person> usersList = new ArrayList<Person>();
	private ControlInsert control;
    
	public PersonFile(String originalFile) throws InvalidBirthDate {
		 this.fileOriginal = new FileText(originalFile, OpenForm.APPEND);
	}
	
	/**
	 * Añadir los usuarios contenidos en la base de datos
	 * @throws InvalidBirthDate
	 */
	 public void initGroupPeople() throws InvalidBirthDate{
		 fileOriginal.setOpenForm(OpenForm.READ);
	        fileOriginal.open();
			String temp = "";
			temp = fileOriginal.read();
			System.out.println(temp + "-----123");
			while (temp != null){
				if (temp != null){
					StringTokenizer st = new StringTokenizer(temp, SEPARATOR);
					int id = Integer.parseInt(st.nextToken());
						String name = st.nextToken();
						String lastName = st.nextToken();
						String gender = st.nextToken();
						String birthDate = st.nextToken();
						float value = Float.parseFloat(st.nextToken());
						String Phone = st.nextToken();
						LocalDate date = getDate(birthDate);
						Gender gender2 = getGender(gender);
						System.out.println(id);
						System.out.println("name: " +name);
						System.out.println("LastName: " +lastName);
						System.out.println("Gender: " + gender2);
						System.out.println("fecha" + date);
						System.out.println("valor: " + value);
						System.out.println("Cel: " + Phone);
				        usersList.add(new Person(id, name, lastName, gender2, date, value, Phone, null));
				        System.out.println(temp);
						temp = fileOriginal.read();
					}
			}

			fileOriginal.close();
	    }
	 
	 /**
	  * Limpiar base de datos
	  */
	 public void clear() {
		 fileOriginal.setOpenForm(OpenForm.WRITE);
		 fileOriginal.open();
			fileOriginal.write("");
			fileOriginal.close();
	}
    
	 /**
	  * Obtener la lista de usuarios a partir de la base de datos
	  * @return
	  */
	public ArrayList<Person> getUsersList() {
		return usersList;
	}

	/**
	 * Pasar edad a localDate
	 * @param strDate
	 * @return
	 */
	public LocalDate getDate(String strDate){
		StringTokenizer st = new StringTokenizer(strDate, "-");
		int year = Integer.parseInt(st.nextToken());
		int month = Integer.parseInt(st.nextToken());
		int day = Integer.parseInt(st.nextToken());
			return LocalDate.of(year,month,day);
	}
	
	/**
	 * Obtener el genero de los usuarios
	 * @param gender
	 * @return
	 */
	public Gender getGender(String gender){
		Gender is = null;
		if (gender.equalsIgnoreCase("MASCULINO")) {
			is = Gender.MALE;
		}else if (gender.equalsIgnoreCase("FEMENINO")) {
			is = Gender.FEMALE;
		}
		return is;
	}
		
	/**
	 * Guardar usuarios en la base de datos
	 * @param groupPeople
	 */
    public void salvar(GroupPeople groupPeople){
		fileOriginal.setOpenForm(OpenForm.WRITE);
		Person [] people = groupPeople.getPeopleList();
		fileOriginal.open();
		for (int i = 0; i < people.length; i++) {
		fileOriginal.write(String.valueOf(people[i].getId()) + "," 
				+ people[i].getFirstName() + "," 
				+ people[i].getLastName() + "," 
				+ people[i].getGender().getGender() + ","
				+ people[i].getBirthDate().toString() +","
				+ String.valueOf(people[i].getValue()) + ","
				+ String.valueOf(people[i].getPhone()));
		}
		fileOriginal.close();
	}
}
