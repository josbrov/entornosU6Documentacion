import java.util.Random;

/**
 * Clase que representra un partido durante tres minutos
 */
public class Partido {
    public static void main(String [] args){
        /**
         * @throws InterruptedException si la ejecución se detiene
         */

        try {
        //se crean los elementos del partido
            Equipo e1 = new Equipo();
            Equipo e2 = new Equipo();
            Narrador narrador = new Narrador();
            Random r = new Random();

            //Ver quien empieza
            Equipo inicial = r.nextBoolean() ? e1 : e2;//esto se llama operador ternario es como un if else simplificado repasar este concepto
            Pelota pelota = new Pelota(inicial);

            System.out.println("PARTIDO: " + e1.nombre + " vs " + e2.nombre);
            System.out.println("Saca de centro: " + inicial.nombre);
            System.out.println("---------------------------------------");

           //determinar duracion
            long tiempoInicio = System.currentTimeMillis();
            long duracion = 3 * 60 * 1000; // 180.000 milisegundos

            while (System.currentTimeMillis() - tiempoInicio < duracion) {

                // Identificamos quién ataca y quién defiende en este turno
                Equipo atacando = pelota.tienePosesion;
                Equipo defendiendo = (atacando == e1) ? e2 : e1;//otro operador ternario

                Jugador atacante = atacando.jugadores[pelota.indicePosesion];
                // El rival es el espejo (10 - indice)
                Jugador defensor = defendiendo.jugadores[10 - pelota.indicePosesion];

               //acciones random
                int accion = r.nextInt(3); // 0: Pase, 1: Regate, 2: Tiro

                if (accion == 0 && pelota.indicePosesion < 10) {
                    // LÓGICA PASE
                    if (atacante.pasarPelota(atacante, defensor)) {
                        Jugador receptor = atacando.jugadores[pelota.indicePosesion + 1];
                        narrador.narrarPase(atacante, receptor);
                        pelota.indicePosesion++;
                    } else {
                        narrador.narrarRobo(defensor, atacante);
                        pelota.cambioPosesion(defendiendo, 0);
                    }

                } else if (accion == 1 && pelota.indicePosesion < 10) {
                    // LÓGICA REGATE
                    if (atacante.factorSuerte(atacante.regate) > defensor.factorSuerte(defensor.defensa)) {
                        narrador.narrarRegate(atacante, defensor);

                        // INTERCAMBIO DE POSICIONES
                        Jugador compañero = atacando.jugadores[pelota.indicePosesion + 1];
                        atacando.jugadores[pelota.indicePosesion + 1] = atacante;
                        atacando.jugadores[pelota.indicePosesion] = compañero;

                        pelota.indicePosesion++;
                    } else {
                        narrador.narrarRobo(defensor, atacante);
                        pelota.cambioPosesion(defendiendo, 0);
                    }

                } else if (pelota.indicePosesion >= 7) {
                    // LÓGICA TIRO
                    // Aplicamos reducción del 10% por distancia
                    double factorDistancia = 1 - (10 - pelota.indicePosesion) * 0.10;
                    int tiroAjustado = (int) (atacante.tiro * factorDistancia);

                    // El rival en el tiro siempre es el portero (índice 0)
                    Jugador porteroRival = defendiendo.jugadores[0];

                    if (atacante.factorSuerte(tiroAjustado) > porteroRival.factorSuerte(porteroRival.portero)) {
                        narrador.narrarGol(atacando, atacante);
                        atacando.goles++;
                        // Sacar de centro tras gol
                        pelota.tienePosesion = defendiendo;
                        pelota.indicePosesion = 5;
                    } else {
                        System.out.println(porteroRival.nombre + " detiene el disparo de " + atacante.nombre);
                        pelota.cambioPosesion(defendiendo, 0);
                    }
                }

                //Pausa de los comentarios
                Thread.sleep(2000);
            }

            // marcador final
            narrador.narrarResultadoFinal(e1, e2);

        } catch (InterruptedException e) {
            System.out.println("El partido se ha suspendido.");
        }
    }
}
