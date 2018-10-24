package naves;

public abstract class RecibidorDano {
	protected NaveAliada jugador;

	public RecibidorDano(NaveAliada na) {
		this.jugador = na;
	}

	public abstract void recibirDano(NaveEnemiga obj);
}
