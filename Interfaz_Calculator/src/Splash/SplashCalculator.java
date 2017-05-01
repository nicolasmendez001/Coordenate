package Splash;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.WindowConstants;

public class SplashCalculator extends JFrame{

    Hilo hilo;
    private JLabel jLabel1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JProgressBar progreso;

    public SplashCalculator(){
        //Método por defecto
        initComponents();
        iniciarSplash();
        //Creamos un objeto HiloProgreso al cual
        //le pasamos por parámetro la barra de progreso
        hilo = new Hilo(progreso);
        //Iniciamos el Hilo
        hilo.start();
        //Le damos tamaño y posición a nuestro Frame
        this.setLocation(200, 200);
        this.setSize(472, 249);
        //Liberamos recursos
        hilo = null;
    }

    public void iniciarSplash() {
        this.getjProgressBar1().setBorderPainted(true);
        this.getjProgressBar1().setForeground(new Color(50, 50, 153, 100));
        this.getjProgressBar1().setStringPainted(true);
    }

    private void initComponents(){

        jPanel1 = new JPanel();
        progreso = new JProgressBar();
        jPanel2 = new JPanel();
        jLabel1 = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(progreso, BorderLayout.CENTER);

        getContentPane().add(jPanel1, BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());

       jLabel1.setIcon(new ImageIcon(getClass().getResource("/Doc/icon.png"))); 
        jPanel2.add(jLabel1, BorderLayout.CENTER);

        getContentPane().add(jPanel2, BorderLayout.CENTER);

        pack();
    }

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable(){

            public void run(){
                new SplashCalculator().setVisible(true);
            }
        });
    }
  
    public JProgressBar getjProgressBar1(){
        return progreso;
    }

}