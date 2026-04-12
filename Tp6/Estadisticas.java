
/**
 * Representa las estadísticas de un jugador.
 * Almacena puntaje total y partidas jugadas.
 *
 * @author C. Guadalupe Bravo y Martin E. Suárez
 * @version 1.0
 */
public class Estadisticas {

    //Atributos
    private int puntaje;
    private int partidas;

    //Constructores
    Estadisticas() {
        this.puntaje = 0;
        this.partidas = 0;
    }

    Estadisticas(int puntaje, int partidas) {
        this.puntaje = puntaje;
        this.partidas = partidas;
    }

    //Set y get
    public int getPuntaje() {
        return this.puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPartidas() {
        return this.partidas;
    }

    public void setPartidas(int partidas) {
        this.partidas = partidas;
    }

    //Metodos
    /**
     * Suma puntos al puntaje total.
     *
     * @param nuevoPunto puntos a agregar
     */
    public void sumarPuntos(int nuevoPunto) {
        this.puntaje += nuevoPunto;
    }

    /**
     * Suma una partida al total.
     *
     * @param nuevaPartida cantidad a agregar
     */
    public void sumarPartidas(int nuevaPartida) {
        this.partidas += nuevaPartida;
    }
}
