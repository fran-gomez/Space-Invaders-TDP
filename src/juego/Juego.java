package juego;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import utilidades.Constantes;

public class Juego {

	private static Tablero t;
	private static JFrame ventana;

	public Juego() {
		ventana = new JFrame();
		startGUI();
	}

	public void startGUI() {
		// ventana.add(new JLabel(new ImageIcon("src/resources/mapa_bg.jpg")));
		armarPanelNiveles(getLastCompletedLevel());
		ventana.setLayout(new FlowLayout());

		ventana.setTitle("Space Invaders");
		ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		ventana.pack();
		ventana.setVisible(true);
	}
	
	private int getLastCompletedLevel() {
		int lvl = 0;

		try {
			File file = new File("nivelesCompletados");

			if (file.isFile() || file.createNewFile()) {
				BufferedReader reader = new BufferedReader(new FileReader(file));

				String line = reader.readLine();
				if (line != null && line.length() > 0) {
					lvl = Integer.parseInt(line);
				}

				reader.close();
			}
		} catch (IOException e) {

		}

		return lvl;
	}
	
	

	public void armarPanelNiveles(int lastCompletedLevel) {
		if(t != null) {
			ventana.remove(t);
		}
		JPanel panel = new JPanel();
		JButton botonNivel;

		panel.setLayout(new GridLayout(10, 10));
		panel.setPreferredSize(new Dimension(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT));

		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < 10; j++) {
				int lvl = i * 10 + j - 9;
				if (lvl != 100)
					botonNivel = new JButton("" + lvl);
				else
					botonNivel = new JButton("CHAOS");

				if (lvl <= lastCompletedLevel+1) {
					botonNivel.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ventana.remove(panel);
							t = new Tablero(lvl, Juego.this);
							ventana.add(t);
							ventana.repaint();
							t.startThreads();
						}
					});
				}else {
					botonNivel.setEnabled(false);
				}

				panel.add(botonNivel);
			}
		}
		ventana.add(panel);
	}

}
