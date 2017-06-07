package UI;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Commands;
import controller.ConstantsDistance;

import javax.swing.JMenu;

public class JMenuBarDistance extends JMenuBar{
	/**
	 * configuraciones o seting( Colores, Idioma, )
	 * help, about
	 * File--- almacenar .... leer (percistencia)
	 * clear
	 * 
	 */
	
	
	public JMenuBarDistance() {
		super();
		init();
	}

	private void init() {
		JMenu jMenu = new JMenu(Commands.COMMAND_FILE.getTitle());
		this.add(jMenu);
		jMenu.add(new JMenuItem(Commands.COMMAND_FILE_SAVE.getTitle()));
		jMenu.add(new JMenuItem(Commands.COMMAND_FILE_LOAD.getTitle()));
		jMenu.addSeparator();
		jMenu.add(new JMenuItem(Commands.COMMAND_FILE_EXIT.getTitle()));
		
	}
	
	
	
}
