package Controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Exceptions.IdNotFoundException;
import Exceptions.InvalidBirthDate;
import Mundo.Gender;
import Mundo.GroupPeople;
import Mundo.Person;
import Mundo.PersonFile;
import UI.GUI.JFameDeletePerson;
import UI.GUI.JFramePrincipal;
import UI.GUI.JFramePrintList;
import UI.GUI.JFrameUpdatePerson;
import UI.GUI.JMenuBarPeople;

public class UIControl implements ActionListener {

	public static final String INFO = "BASE DE DATOS DE PERSONAS \n VERSION 2.0 \n AUTHORS: \n Angel Nicolas Mendez \n Daniel Lopez \n Fabian Ramos";
	public static final String FILE = "C:/Users/Mendez/Desktop/Programacion/Programacion II/ProjectPeople/src/Doc/lista.txt";
	private JFramePrincipal framePrincipal;
	private GroupPeople groupPeople;
	private PersonFile file;
	private ControlInsert intser;
	private JFramePrintList print;
	private JFameDeletePerson jframeDeletePerson;
	private JFrameUpdatePerson jFrameUpdatePerson;
	private Person person;
	private Gender gender;

	public UIControl() throws InvalidBirthDate {
		super();
		groupPeople = new GroupPeople();
		intser = new ControlInsert(groupPeople);
		print = new JFramePrintList(groupPeople);
		this.framePrincipal = new JFramePrincipal();
		jFrameUpdatePerson = new JFrameUpdatePerson();
		this.jframeDeletePerson = new JFameDeletePerson();
		file = new PersonFile(FILE);
		init();
	}

	/**
	 * inicializar
	 * 
	 * @throws InvalidBirthDate
	 */
	private void init() throws InvalidBirthDate {
		setActions();
		file.initGroupPeople();
		intser.controlAddPerson1(file.getUsersList());
		file.clear();
	}

	/**
	 * inicializa las acciones
	 */
	public void setActions() {
		framePrincipal.getAddPerson().addActionListener(this);
		framePrincipal.getEditPerson().addActionListener(this);
		framePrincipal.getPrintList().addActionListener(this);
		framePrincipal.getDeletePerson().addActionListener(this);
		framePrincipal.getClose().addActionListener(this);
		framePrincipal.getMenuBarPeople().getAbout().addActionListener(this);
		JFramePrincipal.getMenuBarPeople().getAdd().addActionListener(this);
		JFramePrincipal.getMenuBarPeople().getDelete().addActionListener(this);
		JFramePrincipal.getMenuBarPeople().getSearch().addActionListener(this);
		JFramePrincipal.getMenuBarPeople().getPrint().addActionListener(this);
		JFramePrincipal.getMenuBarPeople().getEdit().addActionListener(this);
		JFramePrincipal.getMenuBarPeople().getSpanish().addActionListener(this);
		JFramePrincipal.getMenuBarPeople().getEnglish().addActionListener(this);
		jframeDeletePerson.getJButtonEliminarPersona().addActionListener(this);
		jFrameUpdatePerson.getJButtonConsultarId().addActionListener(this);
		jFrameUpdatePerson.getJButtonUpdate().addActionListener(this);

	}

	/**
	 * valida las acciones
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == framePrincipal.getMenuBarPeople().getAbout()) {
			JOptionPane.showMessageDialog(null, INFO);
		}
		if (e.getSource() == framePrincipal.getAddPerson()
				|| e.getSource() == JFramePrincipal.getMenuBarPeople().getAdd()) {
			try {
				intser = new ControlInsert(groupPeople);
				intser.add();
			} catch (InvalidBirthDate e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == framePrincipal.getEditPerson()
				|| e.getSource() == JFramePrincipal.getMenuBarPeople()
						.getEdit()) {
			jFrameUpdatePerson.init();
			// JOptionPane.showMessageDialog(null, "Funcion en reparacion");
		}
		if (e.getSource() == framePrincipal.getPrintList()
				|| e.getSource() == JFramePrincipal.getMenuBarPeople()
						.getPrint()) {
			print = new JFramePrintList(groupPeople);
			print.jMostrar();
		}
		if (e.getSource() == framePrincipal.getDeletePerson()
				|| e.getSource() == JFramePrincipal.getMenuBarPeople()
						.getDelete()) {
			jframeDeletePerson.init();
		}
		if (e.getSource() == jframeDeletePerson.getJButtonEliminarPersona()) {
			try {
				ValidateDelete();
			} catch (IdNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jFrameUpdatePerson.getJButtonConsultarId()) {
			try {
				ValidateUpdate();
			} catch (IdNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == jFrameUpdatePerson.getJButtonUpdate()) {
			try {
				InsertInformationUpdate();
			} catch (InvalidBirthDate e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource() == framePrincipal.getClose()) {
			file.salvar(groupPeople);
			framePrincipal.setVisible(false);
		}
		if (e.getSource() == JFramePrincipal.getMenuBarPeople().getSpanish()) {

		}
		if (e.getSource() == JFramePrincipal.getMenuBarPeople().getEnglish()) {

		}
	}

	/**
	 * Valida si el campo del id esta vacio si no lo esta va al metodo eliminar
	 */
	public void ValidateDelete() throws IdNotFoundException {
		if (jframeDeletePerson.getJTextFieldId().getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite  id", "Error!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Delete();
		}
	}

	/**
	 * se pregunta si el id existe en la lista si existe lo elimina si no existe
	 * muestra un mensaje de error
	 */
	public void Delete() throws IdNotFoundException {
		boolean falg = this.groupPeople.searchid(Integer
				.parseInt(this.jframeDeletePerson.getJTextFieldId().getText()));
		if (falg == false) {
			JOptionPane.showMessageDialog(null, "el Id no existe", "Error!",
					JOptionPane.ERROR_MESSAGE);
			jframeDeletePerson.getJTextFieldId().setText("");
		} else {
			this.groupPeople.remove(Integer.parseInt(this.jframeDeletePerson
					.getJTextFieldId().getText()));
			JOptionPane.showMessageDialog(null,
					"Usuario Eliminado Correctamente");
			jframeDeletePerson.getJTextFieldId().setText("");
		}
	}

	/**
	 * valida si e campo del id esta vacio si no lo esta llama al metodo update
	 */
	public void ValidateUpdate() throws IdNotFoundException {
		if (jFrameUpdatePerson.getJframeDeletePerson().getJTextFieldId()
				.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Digite  id", "Error!",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Update();
		}
	}

	/**
	 * pregunta si el id existe, si existe carga los campo a actualizar
	 */
	public void Update() throws IdNotFoundException {
		boolean falg = this.groupPeople.searchid(Integer
				.parseInt(this.jFrameUpdatePerson.getJframeDeletePerson()
						.getJTextFieldId().getText()));
		if (falg == false) {
			JOptionPane.showMessageDialog(null, "El Id no existe", "Error!",
					JOptionPane.ERROR_MESSAGE);
			jFrameUpdatePerson.getJframeDeletePerson().getJTextFieldId()
					.setText("");
		} else {
			int id = Integer.parseInt(this.jFrameUpdatePerson
					.getJframeDeletePerson().getJTextFieldId().getText());
			LoadTextFileUpdate(id);
		}
	}

	/**
	 * Cargar la informacion de los campos
	 * 
	 * @param id
	 *            del usuario
	 * @throws IdNotFoundException
	 */
	public void LoadTextFileUpdate(int id) throws IdNotFoundException {
		this.person = groupPeople.searchPerson(id);
		this.jFrameUpdatePerson.getJFrameInsertPerson().getJTextFieldId()
				.setText(String.valueOf(person.getId()));
		this.jFrameUpdatePerson.getJFrameInsertPerson().getJTextFieldId()
				.setEnabled(false);
		this.jFrameUpdatePerson.getJFrameInsertPerson()
				.getJTextFieldFirstName().setText(person.getFirstName());
		this.jFrameUpdatePerson.getJFrameInsertPerson().getJTextFieldLastName()
				.setText(person.getLastName());
		this.jFrameUpdatePerson.getJFrameInsertPerson().getJTextFieldSalary()
				.setText(String.valueOf(person.getValue()));
		this.jFrameUpdatePerson.getJFrameInsertPerson().getJTextFieldphone()
				.setText(person.getPhone());
		this.jFrameUpdatePerson.ShowPanel(true);
		this.groupPeople.remove(id);
	}

	/**
	 * Insertar la informacion del usuario
	 * 
	 * @throws InvalidBirthDate
	 */
	public void InsertInformationUpdate() throws InvalidBirthDate {
		Person person = new Person();
		person.setId(Integer.parseInt(this.jFrameUpdatePerson
				.getJFrameInsertPerson().getJTextFieldId().getText()));
		person.setFirstName(this.jFrameUpdatePerson.getJFrameInsertPerson()
				.getJTextFieldFirstName().getText());
		person.setLastName(this.jFrameUpdatePerson.getJFrameInsertPerson()
				.getJTextFieldLastName().getText());
		person.setGender(comboGender());
		person.setBirthDate(this.jFrameUpdatePerson.getJFrameInsertPerson()
				.formatDate());
		person.setValue(Float.parseFloat(this.jFrameUpdatePerson
				.getJFrameInsertPerson().getJTextFieldSalary().getText()));
		person.setPhone(this.jFrameUpdatePerson.getJFrameInsertPerson()
				.getJTextFieldphone().getText());
		groupPeople.add(person);
	}

	/**
	 * Obtener Genero del usuario
	 * 
	 * @return
	 */
	public Gender comboGender() {
		switch (this.jFrameUpdatePerson.getJFrameInsertPerson()
				.getJComboBoxGender().getSelectedIndex()) {
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
}
