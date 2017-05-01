package IU.Swing;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class JPanelCalculator extends JPanel {

	private JPanel[] jPanel;
	private JButton[] button;
	private JButton[] buttonTwo;

	public JPanelCalculator() {
		super();
		this.setLayout(null);
		this.jPanel = new JPanel[6];

		for (int i = 0; i < this.jPanel.length; i++) {
			this.jPanel[i] = new JPanel();
		}
		this.button = new JButton[18];
		for (int i = 0; i < button.length; i++) {
			this.button[i] = new JButton();
		}
		this.buttonTwo = new JButton[28];
		for (int i = 0; i < buttonTwo.length; i++) {
			this.buttonTwo[i] = new JButton();
		}
		init();
	}

	private void init() {
		setPanelOne();
		setPanelTwo();
		setPanelThree();
		setPanelFour();
		setPanelFive();
		setPanelSix();
		for (int i = 0; i < jPanel.length; i++) {
			this.add(jPanel[i]);
		}
		this.setVisible(true);
	}

	private void setPanelOne() {
		this.jPanel[0].setLayout(new FlowLayout());
		this.jPanel[0].setBounds(10, 10, 590, 60);
		this.jPanel[0].setBorder(BorderFactory.createLineBorder(Color.black));
		this.jPanel[0].setBorder(BorderFactory.createTitledBorder("0"));
	}

	private void setPanelTwo() {
		this.jPanel[1].setLayout(new GridLayout(2, 8, 15, 5));
		this.jPanel[1].setBounds(10, 80, 590, 70);
		this.jPanel[1].setBorder(BorderFactory.createLineBorder(Color.black));
		for (int i = 0; i < 16; i++) {
			this.jPanel[1].add(new JLabel("  0000"));
		}
	}

	private void setPanelThree() {
		this.jPanel[2].setLayout(new FlowLayout());
		this.jPanel[2].setBounds(10, 160, 90, 120);
		this.jPanel[2].setBorder(BorderFactory.createLineBorder(Color.black));
		this.jPanel[2].add(new JRadioButton("Hex"));
		this.jPanel[2].add(new JRadioButton("Dec"));
		this.jPanel[2].add(new JRadioButton("Oct"));
		this.jPanel[2].add(new JRadioButton("Bin"));

	}

	private void setPanelFour() {
		this.jPanel[3].setLayout(new FlowLayout());
		this.jPanel[3].setBounds(10, 290, 90, 120);
		this.jPanel[3].setBorder(BorderFactory.createLineBorder(Color.black));
		this.jPanel[3].add(new JRadioButton("Qword"));
		this.jPanel[3].add(new JRadioButton("Dword"));
		this.jPanel[3].add(new JRadioButton("Word"));
		this.jPanel[3].add(new JRadioButton("Byte "));
	}

	private void setPanelFive() {
		String[] nameButton = { " ", "Mod", "A", "(", ")", "B", "Rol", "RoR",
				"C", "Or", "Xor", "D", "Lsh", "Rsh", "E", "Not", "And", "F" };
		this.jPanel[4].setLayout(new FlowLayout());
		this.jPanel[4].setBounds(110, 156, 150, 250);
		this.jPanel[4].setBorder(BorderFactory.createLineBorder(Color.black));
		this.jPanel[4].setLayout(new GridLayout(6, 3));
		for (int i = 0; i < button.length; i++) {
			this.jPanel[4].add(button[i] = new JButton(nameButton[i]));
			this.button[i].setMargin(new Insets(0, 0, 0, 0));
		}
		this.button[0].setEnabled(false);
		for (int i = 2; i < nameButton.length; i += 3) {
			this.button[i].setEnabled(false);
		}
	}

	private void setPanelSix() {
		String[] nameButton = { "MC", "MR", "MS", "M+", "M-", "←", "CE", "C",
				"+-", "√", "7", "8", "9", "/", "%", "4", "5", "6", "*", "1/x",
				"1", "2", "3", "-", "=", "0", ",", "+" };
		this.jPanel[5].setLayout(new FlowLayout());
		this.jPanel[5].setBounds(270, 156, 330, 250);
		this.jPanel[5].setBorder(BorderFactory.createLineBorder(Color.black));
		this.jPanel[5].setLayout(new GridLayout(6, 5));
		for (int i = 0; i < buttonTwo.length; i++) {
			this.jPanel[5].add(buttonTwo[i] = new JButton(nameButton[i]));
		}
		for (int i = 0; i < 5; i++) {
			this.buttonTwo[i].setEnabled(false);
		}
		for (int i = 9; i < 19; i += 5) {
			this.buttonTwo[i].setEnabled(false);
		}
		this.buttonTwo[26].setEnabled(false);
	}

}
