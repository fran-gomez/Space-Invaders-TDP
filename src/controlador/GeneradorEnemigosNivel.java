package controlador;

import java.util.HashMap;

import Inteligencias.InteligenciaAleatoria;
import Inteligencias.InteligenciaDefecto;
import Inteligencias.InteligenciaKamikaze;
import juego.Mapa;
import naves.Crab;
import naves.NaveEnemiga;
import naves.Octopus;
import naves.ShapeShifter;
import naves.Squid;
import naves.UFO;

public class GeneradorEnemigosNivel extends GeneradorEnemigos {

	public GeneradorEnemigosNivel(Mapa map) {
		super(map);

		if (map == null)
			System.out.println("Fuck it");
		
		int lvl = map.dificultad();
		// x , y , vida, durabilidad, alcance , daño, velocidad, inteligencia , fabrica
		this.muchos = new Crab(0, 0, lvl, InteligenciaDefecto.getInstance(), map);
		this.algunos1 = new UFO(0, 0, lvl, InteligenciaDefecto.getInstance(), map);

		this.algunos2 = new ShapeShifter(0, 0, lvl, InteligenciaAleatoria.getInstance(), map);

		this.algunos3 = new Squid(0, 0, lvl, InteligenciaKamikaze.getInstance(map.obtenerJugador()), map);

		this.pocos = new Octopus(0, 0, lvl, InteligenciaDefecto.getInstance(), map);

		// muchos -> Crab
		// algunos1 -> UFO minimo1
		// algunos2 -> ShapeShifter minimo1
		// algunos3 -> Squid minimo1
		// pocos -> Octopus

		mapeoCantMinima = new HashMap<NaveEnemiga, Integer>();
		mapeoCantMinima.put(muchos, 1);
		mapeoCantMinima.put(algunos1, 1);
		mapeoCantMinima.put(algunos2, 1);
		mapeoCantMinima.put(algunos3, 2);
		mapeoCantMinima.put(pocos, 1);
	}

}
