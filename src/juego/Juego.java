package juego;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import utilidades.Constantes;

public class Juego {

	private static Tablero t;
	private static JFrame ventana;

	public Juego() {
		ventana = new JFrame();
		setGUI();
	}

	public void setGUI() {
		armarPanelNiveles(getLastCompletedLevel());

		ventana.setLocation(200, 200);
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
			e.printStackTrace();
		}

		return lvl;
	}

	public void armarPanelNiveles(int lastCompletedLevel) {
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

				if (lvl <= lastCompletedLevel + 1) {
					botonNivel.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							ventana.remove(panel);
							t = new Tablero(lvl, Juego.this);
							ventana.add(t);
							ventana.repaint();
							t.startThreads();
						}
					});
				} else {
					botonNivel.setEnabled(false);
				}

				panel.add(botonNivel);
			}
		}
		ventana.add(panel);
	}

	public void lose() {
		ventana.remove(t);
		t.killThreads();
		
		JPanel panel = new JPanel();
		JLabel labelImagenPerdiste = new JLabel();
		JLabel perdisteLabel = new JLabel("GAME OVER");
		
		labelImagenPerdiste.setIcon(new ImageIcon(getClass().getResource("/resources/lose.gif")));
		labelImagenPerdiste.setHorizontalAlignment(SwingConstants.CENTER);
		labelImagenPerdiste.setVerticalAlignment(FlowLayout.CENTER);
		labelImagenPerdiste.setPreferredSize(new Dimension(Constantes.MAP_WIDTH, 200));
		panel.setPreferredSize(new Dimension(Constantes.MAP_WIDTH, Constantes.MAP_HEIGHT));
		
		perdisteLabel.setPreferredSize(new Dimension(Constantes.MAP_WIDTH, 100));
		perdisteLabel.setForeground(Color.WHITE);
		perdisteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton button = new JButton("Restart");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ventana.remove(panel);
				setGUI();
			}

		});
		
		panel.setLayout(new FlowLayout());
		panel.add(labelImagenPerdiste);
		panel.add(perdisteLabel);
		panel.add(button);
		panel.setBackground(Color.BLACK);

		ventana.add(panel);
		ventana.pack();
		ventana.repaint();
	}

}
