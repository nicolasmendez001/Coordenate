package Mundo;

import Exceptions.ErrorBirthDate;
import Exceptions.IdNotFoundException;
import Exceptions.NameNotFoundException;


public class GroupPeople {
	private Person[] peopleList;
	
	//*******Constructores****************************************
	public GroupPeople(){
		this.peopleList = new Person[0];
	}
	public GroupPeople(GroupPeople newPeopleList){
		this.peopleList = newPeopleList.getPeopleList();
	}
	//***********************************************************
	public Person[] getPeopleList(){
		return peopleList;
	}

	/**
	 * Asignar la lista de personas
	 * @param peopleList
	 */
	public void setPeopleList(Person[] peopleList) {
		this.peopleList = peopleList;
	}

	/**
	 * Añadir usuario a la lista de personas
	 * @param newPerson
	 */
	public void add(Person newPerson){
		Person []auxGroupPeople = new Person[this.peopleList.length+1];
		for(int i = 0; i < peopleList.length;i++){
			auxGroupPeople[i] = this.peopleList[i];
		}
		auxGroupPeople[auxGroupPeople.length-1]= newPerson;
		this.peopleList = auxGroupPeople;
		System.out.println("Group" + peopleList[0].getFirstName());
	}

    public int searchPosRemove(int id) throws IdNotFoundException {
        for (int pos = 0; pos < peopleList.length; pos++) {
            if (peopleList[pos].getId() != 0 && peopleList[pos].getId() == id) {
                return pos;
            }
        }
        throw new IdNotFoundException();
    }
       public void remove(int id) throws IdNotFoundException {
        boolean isNull = false;
        int pos = searchPosRemove(id);
        for (int posRemove = pos; posRemove < peopleList.length && !isNull; posRemove++) {
            if (peopleList[posRemove] != null) {
                if (posRemove + 1 != peopleList.length) {
                    peopleList[posRemove] = peopleList[posRemove + 1];
                } else {
                    isNull = true;
                    peopleList[posRemove] = null;
                }
            }
        }
        Person[] peopleListAux = new Person[peopleList.length - 1];
        for (int j = 0; j < peopleListAux.length; j++) {
            peopleListAux[j] = peopleList[j];
        }
        peopleList = peopleListAux;
    }
	public boolean search(String name){
		boolean isthere = false;
		for(int i = 0; i < peopleList.length;i++){
			//System.out.println(peopleList[i].getFirstName());
			if(peopleList[i].getFirstName().equals(name)){
				isthere = true;
				return isthere;				
			}else{
				isthere=false;
			}			
		}
		return isthere;
	}

    public GroupPeople find(Gender gender) {
        byte numberPeople = 0;
        for (int i = 0; i < peopleList.length; i++) {
            if (peopleList[i].getGender().equals(gender)) {
                numberPeople++;
            }
        }
        GroupPeople foundGroupPeople = new GroupPeople();
        Person[] foundPeople = new Person[numberPeople];
        for (int i = 0; i < peopleList.length; i++) {
            if (peopleList[i].getGender().equals(gender)) {
                for (int j = 0; j < numberPeople; j++) {
                    if (i < foundPeople.length) {
                        if (foundPeople[i] == null) {
                            foundPeople[j] = peopleList[i];
                            j = numberPeople;
                        }
                    }
                }
            }
        }
        foundGroupPeople.setPeopleList(foundPeople);
        return foundGroupPeople;
    }
    
    public Person searchPerson(int id)throws IdNotFoundException{
        for(int i=0;i<peopleList.length;i++){
            if(peopleList[i].getId()==id){
                return peopleList[i];
            }else{
                throw new IdNotFoundException();
            }
        }
        return null;
    }
    
    public boolean searchid(int Id) {
        boolean isthere = false;
        for (int i = 0; i < peopleList.length; i++) {
            if (peopleList[i].getId() == Id) {
                isthere = true;
                return isthere;
            } else {
                isthere = false;
            }
        }
        return isthere;
    }
}
