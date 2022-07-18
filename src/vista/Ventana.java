package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import modelo.Vector3;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Ventana {

	private JFrame frame;
	private PanelJuego panel;
	private JTextPane textPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana window = new Ventana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				botonApretado(e);
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textPane = new JTextPane();
		textPane.setEnabled(false);
		textPane.setDisabledTextColor(new Color(0,0,0));
		frame.getContentPane().add(textPane, BorderLayout.NORTH);
		
		panel = new PanelJuego();
		
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	}
	
	protected void botonApretado(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_W) this.panel.mover(0);
		if(e.getKeyCode()==KeyEvent.VK_S) this.panel.mover(1);
		if(e.getKeyCode()==KeyEvent.VK_A) this.panel.mover(1.5);
		if(e.getKeyCode()==KeyEvent.VK_D) this.panel.mover(0.5);
		if(e.getKeyCode()==KeyEvent.VK_CONTROL) this.panel.addY(this.panel.velocidad);
		if(e.getKeyCode()==KeyEvent.VK_SPACE) this.panel.addY(-this.panel.velocidad);
		if(e.getKeyCode()==KeyEvent.VK_R) this.panel.D1+=0.25;
		if(e.getKeyCode()==KeyEvent.VK_F) this.panel.D1-=0.25;
		if(e.getKeyCode()==KeyEvent.VK_I) this.panel.addInclinacion(new Vector3(0.0,0.02,0));
		if(e.getKeyCode()==KeyEvent.VK_J) this.panel.addInclinacion(new Vector3(-0.02,0,0));
		if(e.getKeyCode()==KeyEvent.VK_K) this.panel.addInclinacion(new Vector3(0,-0.02,0));
		if(e.getKeyCode()==KeyEvent.VK_L) this.panel.addInclinacion(new Vector3(0.02,0,0));
		if(e.getKeyCode()==KeyEvent.VK_Z) {
			
			for(int x=0; x<this.panel.escena.size(); x+=2) {
				this.panel.escena.get(x).setPosicion(new Vector3(this.panel.escena.get(x).getPosicion().x, this.panel.escena.get(x).getPosicion().y, this.panel.escena.get(x).getPosicion().z-1));
			}
		}
		this.textPane.setText(panel.toString());
		frame.repaint();
	}

}
