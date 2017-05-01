package Mundo;

import Exceptions.ErrorBirthDate;
import Exceptions.InvalidBirthDate;
import java.awt.Image;
import java.time.LocalDate;

public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate birthDate;
    private float value;
    private String phone;
    private Image photo;

    public Person(){}
    public Person(int id, String firstName, String lastName, Gender gender, LocalDate birthDate, float value, String phone, Image photo){
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.value = value;
        this.phone = phone;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) throws InvalidBirthDate {
        if (birthDate.getYear() > LocalDate.now().getYear()) {
            throw new InvalidBirthDate();
        } else {
            this.birthDate = birthDate;
        }
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    /**
     *
     * @return la edad en a�os de la persona
     */
    public byte getAge() throws ErrorBirthDate {
        short age = 0;
        if ((short) birthDate.getYear() > (short) LocalDate.now().getYear()) {
            throw new ErrorBirthDate();
        }
        age = (short) (LocalDate.now().getYear() - birthDate.getYear());
        if ((short) LocalDate.now().getMonthValue() < (short) birthDate.getMonthValue()) {
            age--;
        } else if ((short) LocalDate.now().getMonthValue() == (short) birthDate.getMonthValue()) {
            if ((short) LocalDate.now().getDayOfMonth() < (short) birthDate.getDayOfMonth()) {
                age--;
            }
        }
        return (byte) age;
    }

    /**
     *
     * @param name
     * @return si la palabra de entrada esta o no en el nombre o el apellido
     */
    public boolean isthis(String name) {

        if (this.firstName.compareToIgnoreCase(name) == 0 || this.lastName.compareToIgnoreCase(name) == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static String[] toStringInfo() {
        String[] option = new String[9];
        for (int i = 0; i < option.length; i++) {
            switch (i) {
                case 0:
                    option[0] = "ID";
                    break;
                case 1:
                    option[1] = "Nombre";
                    break;
                case 2:
                    option[2] = "Apellido";
                    break;
                case 3:
                    option[3] = "Genero";
                    break;
                case 4:
                    option[4] = "Fecha de Nacimiento";
                    break;
                case 5:
                    option[5] = "Valor";
                    break;
                case 6:
                    option[6] = "Telefono";
                    break;
                case 7:
                    option[7] = "Foto";
                    break;
                case 8:
                    option[8] = "Salir";
            }
        }
        return option;
    }
     public String toString(){
        String formatLine = "%1$-7s %2$-10s %3$-12s %4$-12s %5$-20s %6$-20s %7$-14s %8$-4s";
        String line = String.format(formatLine,this.id, this.firstName, this.lastName,this.gender,this.birthDate,this.value,
                this.phone,this.photo);
        return line;
    }
}
