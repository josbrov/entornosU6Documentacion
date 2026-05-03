import net.datafaker.Faker;
import java.util.Random;

/**
 *Clase que representa un equipo de jugadores
 */

public class Equipo {
    public String nombre;
    public Jugador[] jugadores;
    public int goles;
    /**
     * Constructor para crear equipos, genera 11 jugadores y un equipo con nombres aleatorios
     *
     */

    public Equipo(){
        //objetos faker y random
       Faker f=new Faker();
       Random r=new Random();
       //  NOMBRE EQUIPO random
      this.nombre=f.pokemon().name().concat(" F.C.");

      //INICIALIZAR ARRAY DE JUGADORES Y GOLES
        this.jugadores=new Jugador[11];
        this.goles=0;
        //nombres y apellidos  random de jugadores
        for(int i=0;i<jugadores.length;i++) {

            String nombreJugador = f.name().firstName();
            String apellidoJugador = f.name().lastName();

            //stats de los jugadores y guardarlos en la array con stats aleatorios

            this.jugadores[i]=new Jugador(i+1,nombreJugador,apellidoJugador,r.nextInt(101),r.nextInt(101),r.nextInt(101),r.nextInt(101),r.nextInt(101));
        }

    }
}
