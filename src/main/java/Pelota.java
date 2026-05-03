/**
 * Clase que representa la pelota e indica donde se encuentra el juego
 */


public class Pelota {
    //qué equipo está jugando
    public Equipo tienePosesion;

    //qué jugador tiene la pelota
    public int indicePosesion;

    /**
     * Constructor de la pelot
     * @param equipoInicial
     */
    public Pelota(Equipo equipoInicial){
        this.tienePosesion=equipoInicial;
        //saque de centro casilla 5
        this.indicePosesion=5;
    }

    /**
     * Representa el cambio de posesion
     *
     * @param  nuevaPosesion equipo que gana la posesion de la pelota
     * @param nuevoIndice jugador que recupera la posesion para el equipo
     */
    public void cambioPosesion(Equipo nuevaPosesion, int nuevoIndice){
        this.tienePosesion=nuevaPosesion;
        //jugador mas cercano es 10-indicePosesion(10:0,9:1,8:2...)
        this.indicePosesion=10-this.indicePosesion;
    }


}
