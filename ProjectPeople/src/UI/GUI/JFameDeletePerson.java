/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GUI;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author EQUIPO-PC
 */
public class JFameDeletePerson extends JFrame {

	public static final String TITTLE = "Rliminar";
	public static final String TITTLEJPANEL = "elimnar usuario";
	public static final String JLABELID = "Id";
	public static final String JBUTTONELIMINAR = "Eliminar";

	public static final int WIDTH = 360;
	public static final int HEIGHT = 230;

	private JPanel JPanelDeleteUser;
	private JLabel JLabelNewPerson;
	private JLabel JLabelId;
	private JTextField JTextFieldId;
	private JButton JButtonEliminarPersona;

	public JFameDeletePerson() {
		this.JPanelDeleteUser = new JPanel();
		this.JLabelNewPerson = new JLabel(TITTLEJPANEL);
		this.JLabelId = new JLabel(JLABELID);
		this.JTextFieldId = new JTextField();
		this.JButtonEliminarPersona = new JButton(JBUTTONELIMINAR);
	}

	public void init() {
		this.setTitle(TITTLE);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		this.setBackground(Color.red);
		orderComponents();
		this.setVisible(true);
	}

	public void orderComponents() {
		this.JLabelNewPerson.setBounds(130, 10, 100, 40);
		this.add(this.JLabelNewPerson);
		this.setResizable(false);
		this.JPanelDeleteUser.setBounds(60, 70, 260, 30);
		this.JPanelDeleteUser.setBackground(Color.yellow);
		this.JPanelDeleteUser.setBorder(BorderFactory
				.createLineBorder(Color.black));
		this.JPanelDeleteUser.setLayout(new GridLayout(1, 2, 5, 5));
		this.JPanelDeleteUser.add(this.JLabelId);
		this.JPanelDeleteUser.add(this.JTextFieldId);
		this.setLocationRelativeTo(null);
		this.JButtonEliminarPersona.setBounds(125, 120, 100, 30);
		this.add(this.JButtonEliminarPersona);
		this.add(this.JPanelDeleteUser);
	}

	public JTextField getJTextFieldId() {
		return JTextFieldId;
	}

	public JPanel getJPanelDeleteUser() {
		return JPanelDeleteUser;
	}

	public JButton getJButtonEliminarPersona() {
		return JButtonEliminarPersona;
	}

}
