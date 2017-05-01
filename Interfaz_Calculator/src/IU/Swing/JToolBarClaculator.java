package IU.Swing;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class JToolBarClaculator extends JToolBar {

	private JToolBar jToolBar;

	public JToolBarClaculator() {
		super();
		this.jToolBar = new JToolBar("Prueba");
		init();
	}

	private void init() {
		this.add(jToolBar);
	}

}
