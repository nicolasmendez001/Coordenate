package Mundo;

public enum Gender {
	MALE("Masculino"), FEMALE("Femenino"), OTHER("Otro");
        private String gender;
        
        private Gender(String gender){
            this.gender = gender;
        }
        
           public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public  static String [] getGenderString(){
        String [] option = new String[Gender.values().length];
        int i = 0;
        for (Gender gender: Gender.values()){
            option[i++] = gender.name();
        }
        return option;
    }
}

