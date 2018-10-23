package power_ups;

import java.util.Random;

import juego.Agregable;

public class FabricaAleatoria extends FabricaPowerUp {

	protected Random rn;
	
	public FabricaAleatoria(Agregable mapa) {
		super(mapa);
		rn = new Random();
	}

	@Override
	public void crearPowerUp(int x, int y) {

		PowerUp creado;
		int valor = rn.nextInt(4);
		
		switch (valor) {
		  case 0:
			  creado = new Robot1X(x, y, 10, 12);
			  break;
		  case 1:
			  creado = new AparatoCatastrofico(x, y, 10, 12);
			  break;
		  case 2:
			  creado = new LaserDeProtones(x, y, 10, 12);
			  break;
		  case 3:
			  creado = new LenteDeAmplificacion(x, y, 10, 12);
			  break;
		  default:
			  creado = null;
		}
		
		if(creado != null) {
		mapa.addToObjects(creado);
		}
	}

	
}
