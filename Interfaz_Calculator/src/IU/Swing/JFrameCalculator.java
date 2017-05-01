package IU.Swing;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameCalculator extends JFrame {

	public static final String TITTLE_APP = "CALCULATOR";
	public static final String ICON_APP = "/Doc/icon.PNG";
	public static final int WIDTH_APP = 620;
	public static final int HEIGTH_APP = 480;

	private JMenuBarCalculator jMenuBarCalculator;
	private JToolBarClaculator jToolBarCalculator;
	private JPanelCalculator jPanelCalculator;

	public JFrameCalculator() {
		super();
		this.jMenuBarCalculator = new JMenuBarCalculator();
		this.jToolBarCalculator = new JToolBarClaculator();
		this.jPanelCalculator = new JPanelCalculator();
		init();
	}

	/**
	 * añadir los componentes del Frame
	 */
	private void init(){
		this.setTitle(TITTLE_APP);
		setIconImage(new ImageIcon(getClass().getResource(ICON_APP)).getImage());
		this.add(jToolBarCalculator);
		this.setSize(WIDTH_APP, HEIGTH_APP);
		this.setJMenuBar(jMenuBarCalculator);
		this.add(jPanelCalculator);
		this.setVisible(true);
		this.setResizable(false);
	}
}
