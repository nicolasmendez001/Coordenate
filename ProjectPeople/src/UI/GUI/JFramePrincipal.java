package UI.GUI;

import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import Vista.Splash;

public class JFramePrincipal extends JFrame {

	public static final String ICON_APP = "/Doc/icon.PNG";
	public static final String ICON_ADD_PERSON = "/Doc/AddPerson.PNG";
	public static final String ICON_PRINT = "/Doc/PrintList.PNG";
	public static final String ICON_EDIT_PERSON = "/Doc/editPerson.PNG";
	public static final String ICON_CLOSE = "/Doc/close.PNG";
	public static final String ICON_DELETE_PERSON = "/Doc/deletePerson.PNG";

	private JButton addPerson;
	private JButton printList;
	private JButton editPerson;
	private JButton close;
	private JButton deletePerson;
	private static JMenuBarPeople menuBarPeople;

	public JFramePrincipal() {
		super("POYECT PEOPLE");
		new Splash();
		setMenuBarPeople(new JMenuBarPeople());
		addPerson = new JButton();
		printList = new JButton();
		editPerson = new JButton();
		deletePerson = new JButton();
		close = new JButton();
		this.setLayout(new FlowLayout());
		init();

	}

	private void init() {
		this.setSize(300, 500);
		setIconImage(new ImageIcon(getClass().getResource(ICON_APP)).getImage());
		this.setLocationRelativeTo(null);
		this.setJMenuBar(getMenuBarPeople());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addButtons();
		this.setVisible(true);
		this.setResizable(false);
	}

	public void addButtons() {
		buttonAddperson();
		buttonEditPerson();
		buttonDeletePerson();
		buttonPrintList();
		buttonClose();
	}

	public void buttonAddperson() {
		ImageIcon icon = new ImageIcon(getClass().getResource(ICON_ADD_PERSON));
		addPerson.setIcon(icon);
		addPerson.setToolTipText("Añadir persona");
		addPerson.setMargin(new Insets(0, 0, 0, 0));
		addPerson.setSize(100, 100);
		this.add(addPerson);
	}

	public void buttonPrintList() {
		ImageIcon icon = new ImageIcon(getClass().getResource(ICON_PRINT));
		printList.setIcon(icon);
		printList.setToolTipText("Imprimir lista");
		printList.setMargin(new Insets(0, 0, 0, 0));
		printList.setSize(100, 100);
		this.add(printList);
	}

	public void buttonEditPerson() {
		ImageIcon icon = new ImageIcon(getClass().getResource(ICON_EDIT_PERSON));
		editPerson.setIcon(icon);
		editPerson.setToolTipText("Editar persona");
		editPerson.setMargin(new Insets(0, 0, 0, 0));
		editPerson.setSize(100, 100);
		this.add(editPerson);
	}

	public void buttonClose() {
		ImageIcon icon = new ImageIcon(getClass().getResource(ICON_CLOSE));
		close.setIcon(icon);
		close.setToolTipText("Cerrar");
		close.setMargin(new Insets(0, 0, 0, 0));
		close.setSize(100, 100);
		this.add(close);
	}

	public void buttonDeletePerson() {
		ImageIcon icon = new ImageIcon(getClass().getResource(
				ICON_DELETE_PERSON));
		deletePerson.setIcon(icon);
		deletePerson.setToolTipText("Eliminar persona");
		deletePerson.setMargin(new Insets(0, 0, 0, 0));
		deletePerson.setSize(100, 100);
		this.add(deletePerson);
	}

	/**
	 * Obtener accion del boton añadir persona
	 * 
	 * @return
	 */
	public JButton getAddPerson() {
		return addPerson;
	}

	/**
	 * Obtener la accion de mostrar usuarios
	 * 
	 * @return
	 */
	public JButton getPrintList() {
		return printList;
	}

	/**
	 * Obtener accion de editar ususario
	 * 
	 * @return
	 */
	public JButton getEditPerson() {
		return editPerson;
	}

	/**
	 * Obtener accion de cerrar aplicacion
	 * 
	 * @return
	 */
	public JButton getClose() {
		return close;
	}

	/**
	 * Obtener accion de editar usuario
	 */
	public JButton getDeletePerson() {
		return deletePerson;
	}

	/**
	 * Obtener accion del menu
	 * 
	 * @return
	 */
	public static JMenuBarPeople getMenuBarPeople() {
		return menuBarPeople;
	}

	public void setMenuBarPeople(JMenuBarPeople menuBarPeople) {
		this.menuBarPeople = menuBarPeople;
	}
}
