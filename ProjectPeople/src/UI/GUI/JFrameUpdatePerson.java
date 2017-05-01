/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.GUI;

import static UI.GUI.JFrameInsertPerson.HEIGHT;
import static UI.GUI.JFrameInsertPerson.TITTLE;
import static UI.GUI.JFrameInsertPerson.WIDTH;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author EQUIPO-PC
 */
public class JFrameUpdatePerson extends JFrame {

    public static final String TITTLE = "actualizar";
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

    private JFrameInsertPerson JFrameInsertPerson;
    private JFameDeletePerson jframeDeletePerson;
    private JButton JButtonConsultarId;
    private JButton JButtonUpdate;
    private JLabel jsharePerson;
    private JLabel JLabelUpdatePerson;
    private JPanel JPanelUpdate;

    public JFrameUpdatePerson() {
        super();
        this.JFrameInsertPerson = new JFrameInsertPerson();
        this.jframeDeletePerson = new JFameDeletePerson();
        this.JButtonConsultarId = new JButton("Consultar");
        this.JButtonUpdate = new JButton("Actualizar");
        this.jsharePerson = new JLabel("Buscar Persona");
        this.JLabelUpdatePerson = new JLabel("Actualizar Persona");
        this.JPanelUpdate = new JPanel();
    }

    public void init() {
        this.setTitle(TITTLE);
        this.setSize(WIDTH, HEIGHT);
        this.setLayout(null);
        this.setBackground(Color.red);
        orderComponents();
        this.setVisible(true);
    }

    public void orderComponents() {
        this.jsharePerson.setBounds(130, 15, 100, 40);
        this.add(this.jsharePerson);
        this.jframeDeletePerson.orderComponents();
        this.jframeDeletePerson.getJPanelDeleteUser().setBounds(60, 70, 220, 35);
        this.add(this.jframeDeletePerson.getJPanelDeleteUser());
        this.JButtonConsultarId.setBounds(125, 120, 100, 30);
         this.setLocationRelativeTo(null);
        this.add(this.JButtonConsultarId);
        InsertJPanelUpdatePractics();
    }

    public void InsertPanelUpdate() {
        this.JLabelUpdatePerson.setBounds(120, 160, 150, 40);
        this.add(this.JLabelUpdatePerson);
        this.JFrameInsertPerson.orderComponents();
        this.JFrameInsertPerson.getJPanelNewUser().setBounds(60, 210, 220, 230);
        this.add(this.JFrameInsertPerson.getJPanelNewUser());
        this.JButtonUpdate.setBounds(125, 470, 100, 30);
        this.add(this.JButtonUpdate);
    }

    public void InsertJPanelUpdatePractics() {
        this.JPanelUpdate.setBounds(0, 170, 400, 350);
        this.JPanelUpdate.setLayout(null);
        this.JLabelUpdatePerson.setBounds(120, 10, 150, 40);
        this.JPanelUpdate.add(JLabelUpdatePerson);
        this.JFrameInsertPerson.orderComponents();
        this.JFrameInsertPerson.getJPanelNewUser().setBounds(60, 50, 220, 230);
        this.JPanelUpdate.add(this.JFrameInsertPerson.getJPanelNewUser());
        this.JButtonUpdate.setBounds(120, 310, 100, 30);
        this.JPanelUpdate.add(this.JButtonUpdate);
        this.JPanelUpdate.setVisible(false);
        this.add(this.JPanelUpdate);
    }

    public void ShowPanel(Boolean falg) {
        this.JPanelUpdate.setVisible(falg);
    }

    public JPanel getJPanelUpdate() {
        return JPanelUpdate;
    }

    public JButton getJButtonConsultarId() {
        return JButtonConsultarId;
    }

    public JButton getJButtonUpdate() {
        return JButtonUpdate;
    }

    public JFrameInsertPerson getJFrameInsertPerson() {
        return JFrameInsertPerson;
    }

    public JFameDeletePerson getJframeDeletePerson() {
        return jframeDeletePerson;
    }

}
