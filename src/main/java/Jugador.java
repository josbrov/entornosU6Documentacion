import java.util.*;
import net.datafaker.Faker;

/**
 * Clase que representa un JUgador con sus estadísticas de habilidad
 */

public class Jugador {

    public int dorsal;
    public String nombre;
    public String apellido;
    /**
     * estadísticas de habilidad del jugador
     */
    public int portero;
    public int defensa;
    public int regate;
    public int pase;
    public int tiro;

    /**
     * Constructor que genera un objeto Jugador
     *
     * @param dorsal
     * @param nombre
     * @param apellido
     * @param portero
     * @param defensa
     * @param regate
     * @param pase
     * @param tiro

     */
    public Jugador(int dorsal,String nombre, String apellido,int portero,int defensa, int regate,int pase,int tiro){

        this.nombre=nombre;
        this.apellido=apellido;
        this.portero=portero;
        this.defensa=defensa;
        this.regate=regate;
        this.pase=pase;
        this.tiro=tiro;
    }

    /**
     * Método que aplica una variación aleatoria del 20% a una jugada basandose en las habilidades
     *
     * @param valorSkill valor base de una habilidad del Jugador
     * @return resultado es el final de la jugada aplicada la variación del 20%
     */
    public int factorSuerte(int valorSkill){
        //objeto random
       Random r=new Random();
       //horquilla del porcentaje
       int suerte=r.nextInt(-10,10);
       int valorAjuste=(valorSkill*suerte)/100;
       int valorFinal=valorSkill+valorAjuste;
       return valorFinal;
    }

    /**
     * Método pasar pelota compara pase del atacante y defensa del defensor
     *
     * @param atacante jugador que ataca
     * @param defensor jugador que defiende
     * @return true si el pase es exitoso false si es interceptado
     */
    public boolean pasarPelota(Jugador atacante, Jugador defensor){
        //factor suerte a los parámetros
        int paseFinal= factorSuerte(atacante.pase);
        int defensaFinal= factorSuerte(defensor.defensa);
        //si pasa la pelota

       if (paseFinal>defensaFinal){
           return true;
        //si no pasa la pelota
       }return false;


    }

}
