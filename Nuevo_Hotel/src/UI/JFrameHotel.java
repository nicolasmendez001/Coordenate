package UI;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class JFrameHotel extends JFrame{
	
	public static final String ICON_APP = "/Doc/icon.PNG"; 

	public JFrameHotel(){
		super("Hotel");
		init();
	}
	
	private void init() {
		this.setSize(300, 500);
		setIconImage(new ImageIcon(getClass().getResource(ICON_APP)).getImage());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

}
