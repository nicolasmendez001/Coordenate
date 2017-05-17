package Test;

import javax.swing.JOptionPane;

import UI.JFrameAddHotel;

public class TextJFrameAddHotel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrameAddHotel addHotel = new JFrameAddHotel();
		JOptionPane.showMessageDialog(null, addHotel.validateEmail("mnikolas001@hotmail.com"));
	}

}
