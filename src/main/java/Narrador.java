/**
 * Representa un narrador que comenta los sucesos del partido
 */



public class Narrador {
    /**
     * Narra pase exitoso
     *
     * @param emisor
     * @param receptor
     */
    public void narrarPase(Jugador emisor, Jugador receptor) {
        System.out.println(emisor.nombre + " pasa el balón hacia " + receptor.nombre);
    }

    /**
     *
     * Narra pérdida de posesión
     *
     * @param recuperador
     * @param perdedor
     */
    public void narrarRobo(Jugador recuperador, Jugador perdedor) {
        System.out.println( recuperador.nombre + " le quita la pelota  a " + perdedor.nombre);
    }

    /**
     * Narra gol
     *
     * @param e
     * @param j
     */
    public void narrarGol(Equipo e, Jugador j) {
        System.out.println("Gol del " + e.nombre + "Marca " + j.nombre + " " + j.apellido  );
    }

    /**
     * Narra regate exitoso
     *
     * @param atacante
     * @param defensor
     */
    public void narrarRegate(Jugador atacante, Jugador defensor) {
        System.out.println(atacante.nombre + " realiza una maniobra individual y supera la marca de " + defensor.nombre);
    }
    public void narrarResultadoFinal(Equipo e1, Equipo e2) {
        System.out.println("El resultado final del partido ha sido");
        System.out.println(e1.nombre + ": " + e1.goles);
        System.out.println(e2.nombre + ": " + e2.goles);

    }
}