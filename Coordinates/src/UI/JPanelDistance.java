package UI;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantsDistance;
import model.Coordenate;

public class JPanelDistance extends JPanel {
	private JPanelCoordenate jPanelCoordenate;
	private JPanelCoordenate jPanelCoordenateTwo;
	private JLabel jLabelDistance;

	public JPanelDistance() {
		jPanelCoordenate = new JPanelCoordenate(ConstantsDistance.APP_NAME_COORDENATE_ONE);
		jPanelCoordenateTwo = new JPanelCoordenate(ConstantsDistance.APP_NAME_COORDENATE_TWO);
		jLabelDistance = new JLabel();
		
		init();
	}

	private void init() {
		this.add(this.jPanelCoordenate);
		this.add(this.jPanelCoordenateTwo);
		this.add(this.jLabelDistance);
		this.jLabelDistance.setBorder(BorderFactory.createTitledBorder(ConstantsDistance.APP_NAME_COORDENATE_DISRANCE));

	}

	public void set(Coordenate coordenateOne, Coordenate coordenateTwo) {
		this.jPanelCoordenate.set(coordenateOne);
		this.jPanelCoordenateTwo.set(coordenateTwo);
		if(jPanelCoordenate.get() != null && jPanelCoordenateTwo.get() != null){
			this.jLabelDistance.setText("" + (jPanelCoordenate.get().getDistance(jPanelCoordenateTwo.get())));
		}
			
		
		
		
	}

	
	
	public void set() {
		this.jLabelDistance.setText(""+jPanelCoordenate.get().getDistance(jPanelCoordenateTwo.get()));
	}

	public double get() {
		return Double.parseDouble(jLabelDistance.getText());
	}

	public Coordenate getCoordenateOne() {
		return jPanelCoordenate.get();
	}

	public Coordenate getCoordenateTwo() {
		return jPanelCoordenateTwo.get();
	}
	
	public JPanelCoordenate getjPanelCoordenateOne() {
		return jPanelCoordenate;
	}
	
	public JPanelCoordenate getjPanelCoordenateTwo() {
		return jPanelCoordenateTwo;
	}
	
	protected void showLine(Graphics graphics) {
		graphics.setColor(ConstantsDistance.APP_COLOR_LINE);
		
		graphics.drawLine((int)jPanelCoordenate.getJTextFieldX(), (int)jPanelCoordenate.getJTextFieldY(),
				(int)jPanelCoordenateTwo.getJTextFieldX(), (int)jPanelCoordenateTwo.getJTextFieldY());
		Font fuente=new Font("Monospaced", Font.BOLD, 20);
        graphics.setFont(fuente);
        graphics.drawString(ConstantsDistance.APP_NAME_COORDENATE_DISRANCE + jLabelDistance.getText(), (int)jPanelCoordenate.getJTextFieldX(), (int)jPanelCoordenate.getJTextFieldY());
        
	}

}
