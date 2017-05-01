package UI.GUI;

import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class JMenuBarPeople extends JMenuBar {
	
	private JMenu people;
	private JMenu settings;
	private JMenu help;
	
	private JMenuItem add;
	private JMenuItem delete;
	private JMenuItem print;
	private JMenuItem search;
	private JMenuItem edit;
	
	private JMenu idiom;
	private JMenuItem spanish;
	private JMenuItem english;
	
	private JMenuItem helpOption;
	private JMenuItem about;
	
	public JMenuBarPeople(){
		super();
		this.people = new JMenu("Personas");
		this.settings = new JMenu("Opciones");
		this.help = new JMenu("Ayuda");
		this.add = new JMenuItem("Adicionar");
		this.delete = new JMenuItem("Eliminar");
		this.print = new JMenuItem("Listar");
		this.search = new JMenuItem("Buscar persona");
		this.edit = new JMenuItem("Editar persona");
		this.idiom =  new JMenu("Idioma");
		this.spanish = new JMenuItem("Español");
		this.english = new JMenuItem("Ingles");
		this.helpOption = new JMenuItem("Ayuda");
		this.about = new JMenuItem("Acerca de");
		init();
	}
	
	/**
	 * Inicializar los componntes
	 */
	public void init(){
		peopleOption();
		frameOption();
		helpOption();
		shortcut();
		this.add(people);
		this.add(settings);
		this.add(help);
	}
	
	/**
	 * Añadir las opciones del menuS
	 */
	public void peopleOption() {
		this.people.add(this.add);
		this.people.add(this.delete);
		this.people.add(this.edit);
		this.people.add(this.search);
		this.people.add(this.print);
	}
	
	public void frameOption(){
		this.idiom.add(this.spanish);
		this.idiom.add(this.english);
		this.settings.add(this.idiom);
	}
	
	public void helpOption(){
		this.help.add(this.helpOption);
		this.help.add(about);
	}
	
	public void shortcut(){
		this.add.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.CTRL_MASK));
		this.delete.setAccelerator(KeyStroke.getKeyStroke('D', ActionEvent.CTRL_MASK));
		this.edit.setAccelerator(KeyStroke.getKeyStroke('E', ActionEvent.CTRL_MASK));
		this.search.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.CTRL_MASK));
		this.print.setAccelerator(KeyStroke.getKeyStroke('P', ActionEvent.CTRL_MASK));
		this.spanish.setAccelerator(KeyStroke.getKeyStroke('S', ActionEvent.ALT_MASK));
		this.english.setAccelerator(KeyStroke.getKeyStroke('E', ActionEvent.ALT_MASK));
		this.helpOption.setAccelerator(KeyStroke.getKeyStroke('H', ActionEvent.SHIFT_MASK));
		this.about.setAccelerator(KeyStroke.getKeyStroke('A', ActionEvent.SHIFT_MASK));
	}

	public JMenu getPeople() {
		return people;
	}

	public JMenu getSettings() {
		return settings;
	}

	public JMenu getHelp() {
		return help;
	}

	public JMenuItem getAdd() {
		return add;
	}

	public JMenuItem getDelete() {
		return delete;
	}

	public JMenuItem getPrint() {
		return print;
	}

	public JMenuItem getSearch() {
		return search;
	}

	public JMenuItem getEdit() {
		return edit;
	}

	public JMenu getIdiom() {
		return idiom;
	}

	public JMenuItem getSpanish() {
		return spanish;
	}

	public JMenuItem getEnglish() {
		return english;
	}

	public JMenuItem getHelpOption() {
		return helpOption;
	}

	public JMenuItem getAbout() {
		return about;
	}
	
}
