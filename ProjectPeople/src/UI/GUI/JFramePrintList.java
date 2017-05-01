package UI.GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Mundo.GroupPeople;
import Mundo.Person;

public class JFramePrintList extends JFrame {

	public DefaultTableModel defaultTable;
	public JTable jTable;
	public JScrollPane jScrollPane;
	private GroupPeople groupPeople;

	public JFramePrintList(GroupPeople groupPeople) {
		super("Print");
		this.groupPeople = groupPeople;
		this.setSize(1000, 500);
		this.defaultTable = new DefaultTableModel();
		this.jTable = new JTable();
		this.setLocationRelativeTo(null);
		init();
		initPanel();
		this.setResizable(false);

	}

	/**
	 * Inicializar la tabla de informacion
	 */
	private void init() {
		this.defaultTable.addColumn("id");
		this.defaultTable.addColumn("nombre");
		this.defaultTable.addColumn("Apellido");
		this.defaultTable.addColumn("Genero");
		this.defaultTable.addColumn("Fecha de nacimiento");
		this.defaultTable.addColumn("Salario");
		this.defaultTable.addColumn("Telefono");
		jTable.setModel(defaultTable);
		jScrollPane = new JScrollPane(jTable);
	}

	private void initPanel() {
		this.add(jScrollPane, BorderLayout.CENTER);
	}

	/**
	 * Mostrar la tabla de informacion
	 */
	public void jMostrar() {
		this.setVisible(true);
		Person[] people = groupPeople.getPeopleList();
		String[] fill = new String[defaultTable.getColumnCount()];
		for (int i = 0; i < people.length; i++) {
			fill[0] = String.valueOf(people[i].getId());
			fill[1] = people[i].getFirstName();
			fill[2] = people[i].getLastName();
			fill[3] = people[i].getGender().getGender();
			fill[4] = people[i].getBirthDate().toString();
			fill[5] = String.valueOf(people[i].getValue());
			fill[6] = String.valueOf(people[i].getPhone());
			defaultTable.addRow(fill);
		}

	}

}
