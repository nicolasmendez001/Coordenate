package UI;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Coordenate;

public class JPanelCoordenate extends JPanel{
	
	private static final String NAME_VALUE_X = "Valor de x";
	private static final String NAME_VALUE_Y = "Valor de y";
	private JTextField jTextFieldValueX;
	private JTextField jTextFieldValueY;
		
	public JPanelCoordenate(String name) {
		super();
		this.jTextFieldValueX = new JTextField();
		this.jTextFieldValueY = new JTextField();
		this.setBorder(BorderFactory.createTitledBorder(name));
		init();
	}
	
	public void init() {
		this.add(new JLabel(NAME_VALUE_X));
		this.add(this.jTextFieldValueX);
		this.add(new JLabel(NAME_VALUE_Y));
		this.add(this.jTextFieldValueY);
	}
	
	public void set(Coordenate coordenate) {
		if(coordenate != null){
			this.jTextFieldValueX.setText(coordenate.getValueX()+"");
			this.jTextFieldValueY.setText(coordenate.getValueY()+"");
		}
		
	}
	
	public double getJTextFieldX(){
		return Double.parseDouble(this.jTextFieldValueX.getText());
	}
	
	public double getJTextFieldY(){
		return Double.parseDouble(this.jTextFieldValueY.getText());
	}
	
	public Coordenate get() {
		return new Coordenate(Double.parseDouble(this.jTextFieldValueX.getText()) ,
				Double.parseDouble(this.jTextFieldValueY.getText()) );
	}
}
