package IU.Swing;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class JMenuBarCalculator extends JMenuBar {

	public static final String MENU_ONE_OPTION = "Ver   ";
	public static final String MENU_TWO_OPTION = "Edicion   ";
	public static final String MENU_THREE_OPTION = "Ayuda   ";

	public static final String MENU_ONE_OPTION_ONE = "Estandar";
	public static final String MENU_ONE_OPTION_TWO = "Cientifica ";
	public static final String MENU_ONE_OPTION_THREE = "Programador";
	public static final String MENU_ONE_OPTION_FOUR = "Estadisticas";
	public static final String MENU_ONE_OPTION_FIVE = "Historial";
	public static final String MENU_ONE_OPTION_SIX = "Numero de digitos en grupo ";
	public static final String MENU_ONE_OPTION_SEVEN = "Basicas";
	public static final String MENU_ONE_OPTION_EIGTH = "Conversion de unidades";
	public static final String MENU_ONE_OPTION_NINE = "Calculo de fechas ";
	public static final String MENU_ONE_OPTION_TEN = "Hojas de calculo ";

	public static final String MENU_TWO_OPTION_ONE = "Copiar";
	public static final String MENU_TWO_OPTION_TWO = "Pegar";
	public static final String MENU_TWO_OPTION_THREE = "Historial";

	public static final String MENU_THREE_OPTION_ONE = "Ver la ayuda     F1";
	public static final String MENU_THREE_OPTION_TWO = "Acerca de la calculadora";

	public static final String MENU_ONE_OPTION_TEN_ONE = "Hipoteca";
	public static final String MENU_ONE_OPTION_TEN_TWO = "Alquiler de vehiculos";
	public static final String MENU_ONE_OPTION_TEN_THREE = "Consumo de combustibles (mpg)";
	public static final String MENU_ONE_OPTION_TEN_FOUR = "Alquiler de vehiculos";

	private JMenu jMenuPrincipalOne;
	private JMenu jMenuPrincipalTwo;
	private JMenu jMenuPrincipalThree;

	private JMenuItem jMenuItemOneOne;
	private JMenuItem jMenuItemOneTwo;
	private JMenuItem jMenuItemOneThree;
	private JMenuItem jMenuItemOneFour;
	private JMenuItem jMenuItemOneFive;
	private JMenuItem jMenuItemOneSix;
	private JMenuItem jMenuItemOneSeven;
	private JMenuItem jMenuItemOneEigth;
	private JMenuItem jMenuItemOneNine;
	private JMenu jMenuItemOneTen;

	private JMenuItem jMenuItemTwoOne;
	private JMenuItem jMenuItemTwoTwo;
	private JMenu jMenuItemTwoThree;

	private JMenuItem jMenuItemThreeOne;
	private JMenuItem jMenuThreeTwo;

	private JMenuItem jMenuItemOneTenOne;
	private JMenuItem jMenuItemOneTenTwo;

	public JMenuBarCalculator() {
		super();
		this.jMenuPrincipalOne = new JMenu(MENU_ONE_OPTION);
		this.jMenuPrincipalTwo = new JMenu(MENU_TWO_OPTION);
		this.jMenuPrincipalThree = new JMenu(MENU_THREE_OPTION);
		// -------------------------------------------------------
		this.jMenuItemOneOne = new JMenuItem(MENU_ONE_OPTION_ONE);
		this.jMenuItemOneTwo = new JMenuItem(MENU_ONE_OPTION_TWO);
		this.jMenuItemOneThree = new JMenuItem(MENU_ONE_OPTION_THREE);
		this.jMenuItemOneFour = new JMenuItem(MENU_ONE_OPTION_FOUR);
		this.jMenuItemOneFive = new JMenuItem(MENU_ONE_OPTION_FIVE);
		this.jMenuItemOneSix = new JMenuItem(MENU_ONE_OPTION_SIX);
		this.jMenuItemOneSeven = new JMenuItem(MENU_ONE_OPTION_SEVEN);
		this.jMenuItemOneEigth = new JMenuItem(MENU_ONE_OPTION_EIGTH);
		this.jMenuItemOneNine = new JMenuItem(MENU_ONE_OPTION_NINE);
		this.jMenuItemOneTen = new JMenu(MENU_ONE_OPTION_TEN);
		// -------------------------------------------------------------
		this.jMenuItemTwoOne = new JMenuItem(MENU_TWO_OPTION_ONE);
		this.jMenuItemTwoTwo = new JMenuItem(MENU_TWO_OPTION_TWO);
		this.jMenuItemTwoThree = new JMenu(MENU_TWO_OPTION_THREE);
		// -----------------------------------------------------------
		this.jMenuItemThreeOne = new JMenuItem(MENU_THREE_OPTION_ONE);
		this.jMenuThreeTwo = new JMenuItem(MENU_THREE_OPTION_TWO);
		// -----------------------------------------------------------
		this.jMenuItemOneTenOne = new JMenuItem(MENU_ONE_OPTION_TEN_ONE);
		this.jMenuItemOneTenTwo = new JMenuItem(MENU_ONE_OPTION_TEN_TWO);
		init();
		initOptionOne();
		initOptionTwo();
		initOptionThree();
		setShortcut();
	}

	private void init() {
		this.add(jMenuPrincipalOne);
		this.add(jMenuPrincipalTwo);
		this.add(jMenuPrincipalThree);
	}

	/**
	 * crear panel 1
	 */
	private void initOptionOne() {
		this.jMenuPrincipalOne.add(jMenuItemOneOne);
		this.jMenuPrincipalOne.add(jMenuItemOneTwo);
		this.jMenuPrincipalOne.add(jMenuItemOneThree);
		this.jMenuPrincipalOne.add(jMenuItemOneFour);
		this.jMenuPrincipalOne.addSeparator();
		this.jMenuPrincipalOne.add(jMenuItemOneFive);
		this.jMenuPrincipalOne.add(jMenuItemOneSix);
		this.jMenuPrincipalOne.addSeparator();
		this.jMenuPrincipalOne.add(jMenuItemOneSeven);
		this.jMenuPrincipalOne.add(jMenuItemOneEigth);
		this.jMenuPrincipalOne.add(jMenuItemOneNine);
		this.jMenuPrincipalOne.add(jMenuItemOneTen);
		this.jMenuItemOneTen.add(jMenuItemOneTenOne);
		this.jMenuItemOneTen.add(jMenuItemOneTenTwo);
	}

	/**
	 * Crear panel 2
	 */
	private void initOptionTwo() {
		this.jMenuPrincipalTwo.add(jMenuItemTwoOne);
		this.jMenuPrincipalTwo.add(jMenuItemTwoTwo);
		this.jMenuPrincipalTwo.add(jMenuItemTwoThree);
	}
	
	/**
	 * Crear panel 3
	 */

	private void initOptionThree() {
		this.jMenuPrincipalThree.add(jMenuItemThreeOne);
		this.jMenuPrincipalThree.add(jMenuThreeTwo);
	}
	
	/**
	 * Asignar atajos
	 */
	
	public void setShortcut() {
		jMenuItemOneOne.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				InputEvent.ALT_DOWN_MASK));
		jMenuItemOneTwo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				InputEvent.ALT_DOWN_MASK));
		jMenuItemOneThree.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3,
				InputEvent.ALT_DOWN_MASK));
		jMenuItemOneFour.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
				InputEvent.ALT_DOWN_MASK));
		jMenuItemOneFive.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,
				InputEvent.CTRL_DOWN_MASK));
		jMenuItemOneSix.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
				InputEvent.CTRL_DOWN_MASK));
		jMenuItemTwoOne.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
				InputEvent.CTRL_DOWN_MASK));
		jMenuItemTwoTwo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
				InputEvent.CTRL_DOWN_MASK));
		/*
		 * jMenuItemVerCoversionU.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.
		 * VK_U, InputEvent.CTRL_DOWN_MASK));
		 * jMenuItemVerCalculoFecha.setAccelerator
		 * (KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		 * jMenuItemAyudaOne.setAccelerator(KeyStroke.getKeyStroke("F1"));
		 * jMenuItemEdicionSubEditar
		 * .setAccelerator(KeyStroke.getKeyStroke("F2"));
		 * jMenuItemEdicionSubCancelarEdicion
		 * .setAccelerator(KeyStroke.getKeyStroke("Esc"));
		 * jMenuItemEdicionSubBorrar
		 * .setAccelerator(KeyStroke.getKeyStroke("F2"));
		 */
	}
}
