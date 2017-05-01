/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GUI;

import Mundo.Gender;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.freixas.jcalendar.JCalendarCombo;

/**
 * 
 * @author EQUIPO-PC
 */
public class JFrameInsertPerson extends JFrame {

	public final String LENGUAJE_DEFAULT = "EspaÃ±ol";
	public static final String TITTLE = "Insertar";
	public static final String TITTLEJPANEL = "Nuevo_Usuario";
	public static final String JLABELID = "Id";
	public static final String JLABELFIRSTNAME = "Nombre";
	public static final String JLABELLASTNAME = "Apellido";
	public static final String JLABELGENDER = "genero";
	public static final String JLABELDATE = "Fecha";
	public static final String JLABELSALARY = "Salario";
	public static final String JLABELPHONE = "Celular";
	public static final String JBUTTONGUARDAR = "Guardar";

	public static final int WIDTH = 400;
	public static final int HEIGHT = 420;

	private JPanel JPanelNewUser;
	private JLabel JLabelNewPerson;
	private JLabel JLabelId;
	private JLabel JLabelLastName;
	private JLabel JLabelFirstName;
	private JLabel JLabelGender;
	private JLabel JLabelDate;
	private JLabel JLabelSalary;
	private JLabel JLabelPhone;
	private JTextField JTextFieldId;
	private JTextField JTextFieldLastName;
	private JTextField JTextFieldFirstName;
	private JTextField JTextFieldSalary;
	private JTextField JTextFieldphone;
	private JButton JButtonInsertPerson;
	private JComboBox JComboBoxGender;
	private JCalendarCombo jcalendar;
	private Gender gender;

	public JFrameInsertPerson() {

		this.JPanelNewUser = new JPanel();
		this.JLabelNewPerson = new JLabel(TITTLEJPANEL);
		this.JLabelId = new JLabel(JLABELID);
		this.JLabelLastName = new JLabel(JLABELFIRSTNAME);
		this.JLabelFirstName = new JLabel(JLABELLASTNAME);
		this.JLabelGender = new JLabel(JLABELGENDER);
		this.jcalendar = new JCalendarCombo();
		this.JLabelDate = new JLabel(JLABELDATE);
		this.JLabelSalary = new JLabel(JLABELSALARY);
		this.JLabelPhone = new JLabel(JLABELPHONE);
		this.JTextFieldId = new JTextField();
		this.JTextFieldLastName = new JTextField();
		this.JTextFieldFirstName = new JTextField();
		this.JTextFieldSalary = new JTextField();
		this.JTextFieldphone = new JTextField();
		this.JButtonInsertPerson = new JButton(JBUTTONGUARDAR);
		this.JComboBoxGender = new JComboBox();
	}

	/**
	 * Inicializar el frame
	 */
	public void init() {
		this.setTitle(TITTLE);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		this.setBackground(Color.red);
		orderComponents();
		this.setVisible(true);
	}

	/**
	 * Añadir los componentes
	 */
	public void orderComponents() {
		this.JLabelNewPerson.setBounds(115, 10, 100, 40);
		this.add(this.JLabelNewPerson);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.JPanelNewUser.setBounds(60, 70, 220, 230);
		this.JPanelNewUser.setBackground(Color.yellow);
		this.JPanelNewUser.setBorder(BorderFactory
				.createLineBorder(Color.black));
		this.JPanelNewUser.setLayout(new GridLayout(7, 2, 5, 5));
		this.JPanelNewUser.add(this.JLabelId);
		this.JPanelNewUser.add(this.JTextFieldId);
		this.JPanelNewUser.add(this.JLabelLastName);
		this.JPanelNewUser.add(this.JTextFieldFirstName);
		this.JPanelNewUser.add(this.JLabelFirstName);
		this.JPanelNewUser.add(this.JTextFieldLastName);
		this.JPanelNewUser.add(this.JLabelGender);
		this.JPanelNewUser.add(this.JComboBoxGender);
		this.JPanelNewUser.add(this.JLabelDate);
		this.JPanelNewUser.add(this.jcalendar);
		this.JPanelNewUser.add(this.JLabelSalary);
		this.JPanelNewUser.add(this.JTextFieldSalary);
		this.JPanelNewUser.add(this.JLabelPhone);
		this.JPanelNewUser.add(this.JTextFieldphone);
		this.add(this.JPanelNewUser);
		this.JButtonInsertPerson.setBounds(110, 330, 100, 30);
		this.add(this.JButtonInsertPerson);
		this.JComboBoxGender.addItem(gender.FEMALE);
		this.JComboBoxGender.addItem(gender.MALE);
	}

	/**
	 * Obtener el id del usuario
	 * 
	 * @return
	 */
	public JTextField getJTextFieldId() {
		return JTextFieldId;
	}

	/**
	 * Obtener el apellido del usuario
	 * 
	 * @return
	 */
	public JTextField getJTextFieldLastName() {
		return JTextFieldLastName;
	}

	/**
	 * Obtener el nombre
	 * 
	 * @return
	 */

	public JTextField getJTextFieldFirstName() {
		return JTextFieldFirstName;
	}

	/**
	 * Obtener el salario del usuario
	 * 
	 * @return
	 */
	public JTextField getJTextFieldSalary() {
		return JTextFieldSalary;
	}

	/**
	 * Obtener el telefono del usuario
	 * 
	 * @return
	 */
	public JTextField getJTextFieldphone() {
		return JTextFieldphone;
	}

	/**
	 * Obtener la accion de añadir
	 * 
	 * @return
	 */
	public JButton getJButtonInsertPerson() {
		return JButtonInsertPerson;
	}

	/**
	 * Obtener el genero de la persona
	 * 
	 * @return
	 */
	public JComboBox getJComboBoxGender() {
		return JComboBoxGender;
	}

	public LocalDate formatDate() {
		return this.jcalendar.getDate().toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public void setJTextFieldId(JTextField JTextFieldId) {
		this.JTextFieldId = JTextFieldId;
	}

	public void setJTextFieldLastName(JTextField JTextFieldLastName) {
		this.JTextFieldLastName = JTextFieldLastName;
	}

	public void setJTextFieldFirstName(JTextField JTextFieldFirstName) {
		this.JTextFieldFirstName = JTextFieldFirstName;
	}

	public void setJTextFieldSalary(JTextField JTextFieldSalary) {
		this.JTextFieldSalary = JTextFieldSalary;
	}

	public void setJTextFieldphone(JTextField JTextFieldphone) {
		this.JTextFieldphone = JTextFieldphone;
	}

	public JPanel getJPanelNewUser() {
		return JPanelNewUser;
	}

}
