Space invaders es un juego del genero shooter vertical, que consiste de una nave (Jugador) que debe eliminar a los
Omicronianos (Seres provenientes del planeta Omicron Persei 8), antes que estos aterricen y colonizen nuestro 
planeta.

Segun informes de la nasa, en conjunto con la agencia planet express, sabemos que los Omicronianos nos enviaron
sus 5 naves de asalto mas perezosas, por considerarnos una raza inferior a ellos en todos los aspectos posibles.
	1) Crab: Unidad de ataque basica.
	2) Squid: Compuesta por lo peor de lo peor de Omicron Persei 8, la nave de asalto kamikaze tiene
	   como unico objetivo estrellarse contra los defensores terrestres.
	3) Octopus: Unidad de ataque armada. Al perder el 80% de su escudo, suelta sus armas.
	4) UFO: Nave de ataque por antonomasia de Omicron Persei 8, salvo por un detalle... Sus pilotos
	   estan completamente ebrios ya que no esperaban una guerra el dia de hoy, provocando que la nave vaya en cualquier
	   direccion.
	5) Shapeshifter: Nave de ataque kamikaze, la cual busca al objetivo. Al perder el 50% de la integridad de su escudo,
	   sus tripulantes abandonan la nave, dejandola en modo de vuelo erratico. 

Por orden del Presidente Nixon, el comandante Zapp Branigan estara al mando de la defensa, aunque minutos
antes de la llegada de los invasores, este se retiro debido a una mancha de mostaza en su traje de terciopelo
nuevo, dejando a sus tropas en el campo de batalla, vagando erraticamente.
	1) Nave Errante: Obstaculo para los enemigos.
	2) Asteroide: Obstaculo para ambos.
	3) Nimbus: Raramente aparece, y no hace nada, solo molesta en plena batalla

La defensa del planeta quedo en manos de una sola nave, la temeraria nave de planet expess, y su "reputada" 
tripulacion, La piloto Turanga Leela, quien no percibe bien la profunididad, el oficial de abordo Philip J. Fry,
repartidor de pizzas del a�o 2000 y la unidad dobladora Bender B. Rodriguez, quien espera poder saquear las
naves derribadas (Ya sean Terricolas u Omicronianas). Poniendote en el rol del capitan de la nave, deberas defender
tu planeta de la peresoza invasion Omicroniana, utilizando todo tipo de artilugios creados por el profesor Hubbert
Farnsworth (Y vendidos ilegalmente a los Omicronianos por Bender)
	1) Santa Claus: Santa Claus aborda la nave de planet Express, disparando como condenado a todo lo que produzca sombra, y se haya portado mal este a�o.
	2) Lente de amplificacion: Disparas a las dos naves adyacentes al objetivo actual.
	3) Hipnosapo: Un hipsnosapo salvaje aparece en el campo de batalla haciendo lo que mejor sabe hacer... hipnotisar
	4) Aurora Boreal: Aparece una aurora boreal en esta parte de Springfield, en esta epoca del a�o, eliminando al próximo enemigo que toque a la nave
	5) Robot 1-X: La unidad 1-X se encargara de reparar la nave con una eficiencia nunca antes vista (Buuuu... -Bender-)
	6) Aparato catastrofico: Lanzas una bomba capaz de destruir la realidad misma. (Supongo que podre desprenderme de alguno de estos y seguir siendo igual de temible -Profesor Farnsworth-)


Consideracines generales:
	1) El diagrama UML esta dividido en 4 modelos. Main que contiene el diagrama principal, 
FabricaDisparos que contiene la generacion de disparos (Y su relacion con los elementos de Main), 
FabricaPowerUp que contiene la creacion de PowerUps y su relacion con los elementos de Main, y por ultimo, 
Threads, que contiene la informacion referente a los threads que controlan el juego.

	2) Los obstaculos se conservan a medida que se pasa de nivel. Referente a ellos, el daño no esta 
bien balanceado... damn maths.

	3) Pausa y reinicio no implementados.
