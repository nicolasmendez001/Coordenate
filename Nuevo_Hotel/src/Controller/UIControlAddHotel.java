package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import UI.JFrameAddHotel;

public class UIControlAddHotel implements ActionListener {

	private JFrameAddHotel frameAddHotel;

	public UIControlAddHotel(){
		super();
		this.frameAddHotel = new JFrameAddHotel();
		init();
	}

	/**
	 * inicializar
	 * 
	 */
	private void init() {
		setActions();
	}

	/**
	 * inicializa las acciones
	 */
	public void setActions() {
		frameAddHotel.getJTextFieldName().addActionListener(this);
		frameAddHotel.getJTextFieldLargeName().addActionListener(this);
		frameAddHotel.getJTextFieldAdress().addActionListener(this);
		frameAddHotel.getJTextFieldTelephone().addActionListener(this);
		frameAddHotel.getJTextFieldUrl().addActionListener(this);
		frameAddHotel.getJTextFieldEmail().addActionListener(this);
	}

	/**
	 * valida las acciones
	 */

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == frameAddHotel.getJTextFieldName()) {
			JOptionPane.showMessageDialog(null, frameAddHotel.getJTextFieldName());
		}
		if (e.getSource() == frameAddHotel.getJTextFieldLargeName()) {
			JOptionPane.showMessageDialog(null, frameAddHotel.getJTextFieldLargeName());
		}
		if (e.getSource() == frameAddHotel.getJTextFieldAdress()) {
			JOptionPane.showMessageDialog(null, frameAddHotel.getJTextFieldAdress());
		}
		if (e.getSource() == frameAddHotel.getJTextFieldTelephone()) {
			JOptionPane.showMessageDialog(null, frameAddHotel.getJTextFieldTelephone());
		}
		if (e.getSource() == frameAddHotel.getJTextFieldUrl()) {
			JOptionPane.showMessageDialog(null, frameAddHotel.getJTextFieldUrl());
		}
		if (e.getSource() == frameAddHotel.getJTextFieldEmail()) {
			JOptionPane.showMessageDialog(null, frameAddHotel.getJTextFieldEmail());
		}
	}
}
