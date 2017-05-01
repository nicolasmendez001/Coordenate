package Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JWindow;

public class Splash extends JWindow {
	
	public static final String ICON_APP = "/Doc/icon.PNG";	

	private JProgressBar current;
	private JPanel panel;
	private JLabel jLabel;
	int num = 0;
	
	public Splash() {
		super();
		ImageIcon icon = new ImageIcon(getClass().getResource(ICON_APP));
		jLabel = new JLabel(icon);
		jLabel.setLayout(new BorderLayout());
		panel = (JPanel) getContentPane();
		this.setSize(icon.getIconWidth(), icon.getIconHeight());
		this.setLocationRelativeTo(null);
		panel.setLayout(new FlowLayout());
		current = new JProgressBar(0, 100);
		current.setValue(0);
		current.setStringPainted(true);
		jLabel.add(current, BorderLayout.SOUTH);
		panel.add(jLabel);
		setContentPane(panel);
		this.pack();
		this.setVisible(true);
		iterate();
	}
	
	/**
	 * genera la barra de progreso
	 */

	public void iterate() {
		while (num < 100) {
			current.setValue(num);
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) { }
			num ++;
		}
		this.setVisible(false);
	}
  }