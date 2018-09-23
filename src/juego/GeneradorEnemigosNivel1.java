package juego;

import java.util.HashMap;

import Inteligencias.InteligenciaAleatoria;
import Inteligencias.InteligenciaDefecto;
import Inteligencias.InteligenciaKamikaze;
import disparos.FabricaDisparoEnemigo;
import naves.Crab;
import naves.NaveEnemiga;
import naves.Octopus;
import naves.ShapeShifter;
import naves.Squid;
import naves.UFO;

public class GeneradorEnemigosNivel1 extends GeneradorEnemigos {

	public GeneradorEnemigosNivel1(Mapa map) {
		super(map);

		// x , y , vida, durabilidad, alcance , daño, velocidad, inteligencia , fabrica
		this.muchos = new Crab(0, 0, 100, 10, 10, 20, 10, InteligenciaDefecto.getInstance(), new FabricaDisparoEnemigo(map));
		this.algunos1 = new UFO(0, 0, 100, 10, 10, 20, 10, InteligenciaDefecto.getInstance(), new FabricaDisparoEnemigo(map));

		this.algunos2 = new ShapeShifter(0, 0, 100, 10, 10, 20, 10, InteligenciaAleatoria.getInstance(),
				new FabricaDisparoEnemigo(map));

		this.algunos3 = new Squid(0, 0, 100, 10, 10, 20, 10, InteligenciaKamikaze.getInstance(map.obtenerJugador()),
				new FabricaDisparoEnemigo(map));

		this.pocos = new Octopus(0, 0, 100, 10, 10, 20, 10, InteligenciaDefecto.getInstance(), new FabricaDisparoEnemigo(map));

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
