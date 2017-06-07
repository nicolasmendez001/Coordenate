package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import controller.ConstantsDistance;
import controller.DistanceListener;

public class JFrameDistance extends JFrame{

	private JMenuBarDistance jMenuBarDistance;
	private JToolBarDistance jToolBarDistance;
	private JPanelStatusBarDistance jpanelStatusBar;
	private JPanelWorkAreaDistance jPanelWorkArea;
	private JPopupMenuDistance jPopupMenuDistance;
	
	public JFrameDistance() {
		super(ConstantsDistance.APP_NAME+ "__" + ConstantsDistance.APP_VERSION);
		this.jMenuBarDistance   =   new JMenuBarDistance();
		this.jToolBarDistance   =   JToolBarDistance.getInstance();
		this.jpanelStatusBar    =   JPanelStatusBarDistance.getInstance();
		this.jPanelWorkArea     =   new JPanelWorkAreaDistance();
		this.jPopupMenuDistance =   new JPopupMenuDistance();
		init();
	}

	public void init() {
		//this.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		this.setSize(500, 500);
		
		this.setLayout(new BorderLayout());
		this.add(jpanelStatusBar, BorderLayout.SOUTH);
		this.add(jPanelWorkArea, BorderLayout.CENTER);
		this.add(jToolBarDistance, BorderLayout.NORTH);
		this.setJMenuBar(jMenuBarDistance);
		//this.add(jPopupMenuDistance);
		//*-------------------------------------------------------
		DistanceListener.getInstance().setJPanelWorkAreaDistance(jPanelWorkArea);
		//*-------------------------------------------------------
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.jPanelWorkArea.setjPanelDistance(jToolBarDistance.getPaint());
	}
	
	public JPanelStatusBarDistance getJPanelStatusBar(){
		return jpanelStatusBar;
	}
	
	public JToolBarDistance getJToolBarDistance() {
		return jToolBarDistance;
	}
}
