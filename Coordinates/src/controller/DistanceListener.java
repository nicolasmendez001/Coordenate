package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import UI.JPanelStatusBarDistance;
import UI.JPanelWorkAreaDistance;
import UI.JToolBarDistance;
import model.Coordenate;

public class DistanceListener  implements ActionListener,MouseMotionListener, MouseListener{

	public static String COMMAND_CALCULATE = "COMMAND_CALCULATE_DISTANCE";
	private static DistanceListener distanceListener;
	private Coordenate coordenateOne;
	private Coordenate coordenateTwo;
	private Controller controller;
	private JPanelWorkAreaDistance jPanelWorkAreaDistance;
	
	private DistanceListener() {
		
	}
	
	public static DistanceListener getInstance(){
		if(distanceListener== null) {
			distanceListener = new DistanceListener();
			return distanceListener;
		}
		return distanceListener;
	}
	
	
	public void setJPanelWorkAreaDistance(JPanelWorkAreaDistance jPanelWorkAreaDistance) {
		this.jPanelWorkAreaDistance = jPanelWorkAreaDistance;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Commands.valueOf(e.getActionCommand())) {
		case COMMAND_FILE_SAVE:
			//salvar las coordenadas--->
			System.out.println("Gaurdar Archivo : " + coordenateOne.getValueX() + ","+coordenateOne.getValueY()
					+"-" + coordenateTwo.getValueX() + ","+coordenateTwo.getValueY());
			break;
		case COMMAND_FILE_LOAD:
			System.out.println("Cargar Archivo");
			break;
		case COMMAND_FILE_EXIT:
			System.out.println("Salir");
			//verificar si hay acciones por terminar	
			// verificar
			//despedida
			System.exit(0);
			break;
		default:
			System.out.println("Comando .... "  + e.getActionCommand() + 
			"En construccion");
		}
		
	}
	
	public void setCoordenates(Coordenate coordenateOne,Coordenate coordenateTwo) {
		this.coordenateOne= coordenateOne;
		this.coordenateTwo =coordenateTwo;
	}

	public Coordenate getCoordenateOne() {
		return coordenateOne;
	}

	public void setCoordenateOne(Coordenate coordenateOne) {
		this.coordenateOne = coordenateOne;
	}

	public Coordenate getCoordenateTwo() {
		return coordenateTwo;
	}

	public void setCoordenateTwo(Coordenate coordenateTwo) {
		this.coordenateTwo = coordenateTwo;
	}

	public void setController( Controller controller){
		this.controller = controller;
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
 		//controller.setCoordenatesStatusBar(e.getPoint().x+","+e.getPoint().y);
		JPanelStatusBarDistance.getInstance().setMessage(e.getPoint().x+","+e.getPoint().y);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getClickCount());
		switch (e.getButton()) {
		case ConstantsDistance.MAUSE_BUTTON_ONE://calcular los valores del JpanelDistance inicial
			JToolBarDistance.getInstance().setCoordenates(new Coordenate(e.getX(), e.getY()), null);
			jPanelWorkAreaDistance.repaint();
			break;
		case ConstantsDistance.MAUSE_BUTTON_TWO://calcular los valores del JpanelDistance final
			JToolBarDistance.getInstance().setCoordenates(null, new Coordenate(e.getX(), e.getY()));
			jPanelWorkAreaDistance.repaint();
			break;	

		default:
			break;
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
//		System.out.println("mouseEntered");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("mouseExited");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//System.out.println("mousePressed");
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
