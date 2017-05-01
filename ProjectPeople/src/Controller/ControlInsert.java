/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exceptions.InvalidBirthDate;
import Mundo.FileText;
import Mundo.Gender;
import Mundo.GroupPeople;
import Mundo.Person;
import Mundo.PersonFile;
import UI.GUI.JFrameInsertPerson;
import UI.GUI.JFramePrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ControlInsert implements ActionListener {

    JFrameInsertPerson jframeInsertPerson;
    GroupPeople groupPeople;
    Gender gender;
    JFramePrincipal framePrincipal;
    
    
    public ControlInsert(GroupPeople groupPeople) throws InvalidBirthDate {
    	this.groupPeople = groupPeople;       
       
    }
    
    /**
     * Añade el frame de los datos
     */
    public void add(){
    	 jframeInsertPerson = new JFrameInsertPerson(); 
    	jframeInsertPerson.init();
         CreateActions();
	}

   /**
    * Obtiene el genero a partir del comboBox
    */
   
    public Gender comboEmotion() {
        switch (jframeInsertPerson.getJComboBoxGender().getSelectedIndex()) {
            case 0:
                gender = Gender.FEMALE;
                break;
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.OTHER;
                break;
        }
        return gender;
    }

    /**
     * Añadir persona
     * @throws InvalidBirthDate
     */
    public void controlAddPerson() throws InvalidBirthDate {
        Person person = new Person();
        person.setId(Integer.parseInt(jframeInsertPerson.getJTextFieldId().getText()));
        person.setFirstName(jframeInsertPerson.getJTextFieldFirstName().getText());
        person.setLastName(jframeInsertPerson.getJTextFieldLastName().getText());
        person.setGender(comboEmotion());
        person.setBirthDate(jframeInsertPerson.formatDate());
        person.setValue(Float.parseFloat(jframeInsertPerson.getJTextFieldSalary().getText()));
        person.setPhone(jframeInsertPerson.getJTextFieldphone().getText());
        groupPeople.add(person);
        messageInsert();
    }
    
    /**
     * Añade las personas contenidas enla base de datos
     * @param person lista de personas
     * @throws InvalidBirthDate
     */
    public void controlAddPerson1(ArrayList<Person> person) throws InvalidBirthDate {
        for (int i = 0; i < person.size(); i++) {
        	 groupPeople.add(person.get(i));
		}
        person.clear();
    }
    
    /**
     * realiza retroalimentacion y pregunta al usuario si desea crear un nuevo usuario
     */
    public void messageInsert() {
        JOptionPane.showMessageDialog(null, "el Usuario fue creado exitosamente");
        Object[] options = {"yes", "no"};
        int dialogButton = JOptionPane.showOptionDialog(null, "Â¿desea crear otro usuario?", "Insertar", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.DEFAULT_OPTION, null, options, options[1]);
        if (dialogButton == 0) {
            Clean();
        } else if (dialogButton == 1) {
            jframeInsertPerson.dispose();
        }
    }

    /**
     * limpia los campos si el usuario selecciona la opcion de ingresar otro usuario
     */
    public void Clean() {
        jframeInsertPerson.getJTextFieldId().setText("");
        jframeInsertPerson.getJTextFieldFirstName().setText("");
        jframeInsertPerson.getJTextFieldLastName().setText("");
        jframeInsertPerson.getJTextFieldSalary().setText("");
        jframeInsertPerson.getJTextFieldphone().setText("");
    }
    /**
     * valida los campos que no vayan a estar vacios
     * @throws InvalidBirthDate
     */

    public void ValidateFormInsert() throws InvalidBirthDate {
        if (jframeInsertPerson.getJTextFieldId().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite  id", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jframeInsertPerson.getJTextFieldFirstName().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite NOMBRE", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jframeInsertPerson.getJTextFieldLastName().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite apellido", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jframeInsertPerson.getJTextFieldSalary().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite salario", "Error!", JOptionPane.ERROR_MESSAGE);
        } else if (jframeInsertPerson.getJTextFieldphone().getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite numero de celular", "Error!", JOptionPane.ERROR_MESSAGE);
        } else {
            controlAddPerson();
        }
    }

    /**
     * Crea a las acciones
     */
    public void CreateActions() {
        jframeInsertPerson.getJButtonInsertPerson().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == jframeInsertPerson.getJButtonInsertPerson()) {
            try {
                ValidateFormInsert();
            } catch (InvalidBirthDate ex) {
            }
        }
    }
}
