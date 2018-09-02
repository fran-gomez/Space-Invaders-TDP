package juego;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import utilidades.Constantes;

public class Splash extends JFrame {

	protected Tablero t;
	
	public Splash() {
		super();
		t = new Tablero(2);
		this.setLayout(new FlowLayout());
		this.add(t);
		
		this.setTitle("Space Invaders");
		this.setSize(2000, 2000);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	private class BotonIniciar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
