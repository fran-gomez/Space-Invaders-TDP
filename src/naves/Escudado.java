package naves;

public class Escudado extends RecibidorDano {

	public Escudado(NaveAliada na) {
		super(na);
	}

	@Override
	public void recibirDano(NaveEnemiga na) {
		na.eliminar();
		jugador.setForeground(null);
		jugador.setOpaque(false);
		jugador.setRecibidorDano(new NoEscudado(jugador));
	}
}
