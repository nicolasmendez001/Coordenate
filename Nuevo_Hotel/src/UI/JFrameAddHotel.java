package UI;

import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Place;

public class JFrameAddHotel extends JFrame{

	public final String LENGUAJE_DEFAULT = "Espa√±ol";
	public static final String TITTLE = "Insertar Hotel";
	public static final String TITTLE_JPANEL = "Nuevo_Hotel";
	public static final String JLABEl_NAME = "Nombre";
	public static final String JLABEl_NAMELARGE = "Nombre Largo";
	public static final String JLABEl_ADRESS = "Direccion";
	public static final String JLABEl_LUGAR = "lugar";
	public static final String JLABEl_TELEPHONE = "Telefono";
	public static final String JLABEl_URL = "Url";
	public static final String JLABEl_EMAIL = "Email";
	
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	
	public static final int WIDTH = 400;
	public static final int HEIGHT = 420;

	private JPanel JPanelNewHotel;
	private JLabel JLabelName;
	private JLabel JLabelNewHotel;
	private JLabel JLabelLargeName;
	private JLabel JLabelAdress;
	private JLabel JLabelLugar;
	private JLabel JLabelTelephone;
	private JLabel JLabelUrl;
	private JLabel JLabelEmail;
	
	private JTextField JTextFieldName;
	private JTextField JTextFieldLargeName;
	private JTextField JTextFieldAdress;
	private JTextField JTextFieldLugar;
	private JTextField JTextFieldTelephone;
	private JTextField JTextFieldUrl;
	private JTextField JTextFieldEmail;
	private JButton JButtonAdd;
	
	public JFrameAddHotel() {
		super();
		this.JLabelNewHotel = new JLabel("hola");
		this.JPanelNewHotel= new JPanel();
		this.JLabelName = new JLabel(TITTLE);
		this.JLabelName = new JLabel(JLABEl_NAME);
		this.JLabelLargeName = new JLabel(JLABEl_NAMELARGE);
		this.JLabelTelephone = new JLabel(JLABEl_TELEPHONE);
		this.JLabelAdress = new JLabel(JLABEl_ADRESS);
		this.JLabelUrl = new JLabel(JLABEl_URL);
		this.JLabelEmail = new JLabel(JLABEl_EMAIL);
		this.JTextFieldName = new JTextField();
		this.JTextFieldLargeName = new JTextField();
		this.JTextFieldAdress = new JTextField();
		this.JTextFieldEmail = new JTextField();
		this.JTextFieldTelephone = new JTextField();
		this.JTextFieldUrl = new JTextField();
		
		this.JButtonAdd = new JButton("add");
		
		init();
	}

	/**
	 * Inicializar el frame
	 */
	private void init() {
		this.setTitle(TITTLE);
		this.setSize(WIDTH, HEIGHT);
		this.setLayout(null);
		this.setBackground(Color.red);
		orderComponents();
		this.setVisible(true);
	}

	/**
	 * AÒadir los componentes
	 */
	public void orderComponents() {
		this.JLabelNewHotel.setBounds(115, 10, 100, 40);
		this.add(this.JLabelNewHotel);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.JPanelNewHotel.setBounds(60, 70, 220, 230);
		this.JPanelNewHotel.setBackground(Color.yellow);
		this.JPanelNewHotel.setBorder(BorderFactory.createLineBorder(Color.black));
		this.JPanelNewHotel.setLayout(new GridLayout(7, 2, 5, 5));
		this.JPanelNewHotel.add(this.JLabelName);
		this.JPanelNewHotel.add(this.JTextFieldName);
		this.JPanelNewHotel.add(this.JLabelLargeName);
		this.JPanelNewHotel.add(this.JTextFieldLargeName);
		this.JPanelNewHotel.add(this.JLabelAdress);
		this.JPanelNewHotel.add(this.JTextFieldAdress);
		this.JPanelNewHotel.add(this.JLabelTelephone);
		this.JPanelNewHotel.add(this.JTextFieldTelephone);
		this.JPanelNewHotel.add(this.JLabelUrl);
		this.JPanelNewHotel.add(this.JTextFieldUrl);
		this.JPanelNewHotel.add(this.JLabelEmail);
		this.JPanelNewHotel.add(this.JTextFieldEmail);
		this.add(this.JPanelNewHotel);
		this.JButtonAdd.setBounds(110, 330, 100, 30);
		this.add(this.JButtonAdd);
	}

	public JTextField getJTextFieldName() {
		return JTextFieldName;
	}

	public void setJTextFieldName(JTextField jTextFieldName) {
		JTextFieldName = jTextFieldName;
	}

	public JTextField getJTextFieldLargeName() {
		return JTextFieldLargeName;
	}

	public void setJTextFieldLargeName(JTextField jTextFieldLargeName) {
		JTextFieldLargeName = jTextFieldLargeName;
	}

	public JTextField getJTextFieldAdress() {
		return JTextFieldAdress;
	}

	public void setJTextFieldAdress(JTextField jTextFieldAdress) {
		JTextFieldAdress = jTextFieldAdress;
	}

	public JTextField getJTextFieldLugar() {
		return JTextFieldLugar;
	}

	public void setJTextFieldLugar(JTextField jTextFieldLugar) {
		JTextFieldLugar = jTextFieldLugar;
	}

	public JTextField getJTextFieldTelephone() {
		return JTextFieldTelephone;
	}

	public void setJTextFieldTelephone(JTextField jTextFieldTelephone) {
		JTextFieldTelephone = jTextFieldTelephone;
	}

	public JTextField getJTextFieldUrl() {
		return JTextFieldUrl;
	}

	public void setJTextFieldUrl(JTextField jTextFieldUrl) {
		JTextFieldUrl = jTextFieldUrl;
	}

	public JTextField getJTextFieldEmail() {
		return JTextFieldEmail;
	}

	public void setJTextFieldEmail(JTextField jTextFieldEmail) {
		JTextFieldEmail = jTextFieldEmail;
	}
   
    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
 
    }

}
