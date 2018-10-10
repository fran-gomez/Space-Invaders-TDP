package juego;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import utilidades.Constantes;

public class Juego {

	private static Tablero t;
	private static JFrame ventana;
	
	public static void main(String[] args) {

		ventana = new JFrame();
		
		ventana.setLayout(new FlowLayout());
		ventana.add(armarPanelNiveles());

		ventana.setTitle("Space Invaders");
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ventana.pack();
		ventana.setVisible(true);
	}
	
	
	private static JPanel armarPanelNiveles() {
		JPanel panel = new JPanel();
		JButton botonNivel;
		
		panel.setLayout(new GridLayout(10, 10));
		panel.setPreferredSize(new Dimension(Constantes.MAP_WIDTH + 50, Constantes.MAP_HEIGHT));
		
		for (int i = 1; i <= 10; i++)
			for (int j = 1; j <= 10; j++) {
				int lvl = i*j;
				if (lvl != 100)
					botonNivel = new JButton("LvL " + lvl);
				else
					botonNivel = new JButton("CHAOS");
				
				botonNivel.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                    t = new Tablero(lvl);
	                    ventana.remove(panel);
	                    ventana.add(t);
	                }
	            });
				
				panel.add(botonNivel);
			}
		
		
		return panel;
	}
}
