
import java.util.Random;

/**
 * Representa una partida entre dos jugadores. El resultado se genera de forma
 * aleatoria.
 *
 * @author C. Guadalupe Bravo y Martin E. Suárez
 * @version 1.0
 */
public class Partida {

    // Atributos
    private String resultado;
    private int puntaje1;
    private int puntaje2;
    private String nombreCompetencia;
    private Jugador jugador1;
    private Jugador jugador2;

    // Constructores
    public Partida() {
        this.resultado = "";
        this.nombreCompetencia = "";
        this.jugador1 = null;
        this.jugador2 = null;
    }

    /**
     * Genera un puntaje aleatorio (0 o 1).
     *
     * @return valor entero aleatorio
     */
    public Partida(String competencia, String pais1, String nombre1, String pais2, String nombre2) {
        this.nombreCompetencia = competencia;
        this.puntaje1 = ramdonpunto();
        this.puntaje2 = ramdonpunto();

        if (this.puntaje1 > this.puntaje2) {
            this.resultado = "ganador jugador 1";
        }
        if (this.puntaje2 > this.puntaje1) {
            this.resultado = "ganador jugador 2";
        }
        if (this.puntaje2 == this.puntaje1) {
            this.resultado = "Empate";
        }
        //Jugador 1
        try {
            this.jugador1 = new Jugador(pais1, nombre1, this.puntaje1, 1); 
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear jugador 1: " + e.getMessage());
            this.jugador1 = new Jugador("Argentina", "Jugador 1", this.puntaje1, 1); 
            System.out.println("Jugador 1 creado con datos por defecto: Pais: Argentina, Nombre: Jugador 1");
        }
        //Jugador 2
        try {
            this.jugador2 = new Jugador(pais2, nombre2, this.puntaje2, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear jugador 2: " + e.getMessage());
            this.jugador2 = new Jugador("Argentina", "Jugador 2", this.puntaje2, 1);
            System.out.println("Jugador 2 creado con datos por defecto: Pais: Argentina, Nombre: Jugador 2");
        }

    }

    // Metodos
    // Set y get
    public String getResultado() {
        return this.resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getNombreCompetencia() {
        return this.nombreCompetencia;
    }

    public void setNombreCompetencia(String nombreCompetencia) {
        this.nombreCompetencia = nombreCompetencia;
    }

    public void setPuntajes() {
        this.puntaje1 = ramdonpunto();
        this.puntaje2 = ramdonpunto();
    }

    public int getPuntaje1() {
        return this.puntaje1;
    }

    public int getPuntaje2() {
        return this.puntaje2;
    }

    public void getJugadores() {
        System.out.println("----------DATOS JUGADORES---------");
        System.out.println("Jugador 1: ");
        System.out.println("Nombre: " + this.jugador1.getNombre() + " Pais de origen: " + this.jugador1.getPaisDeOrigen() + " DNI: " + this.jugador1.getDNI());
        this.jugador1.getEstadistica();

        System.out.println("Jugador 2: ");
        System.out.println("Nombre: " + this.jugador2.getNombre() + " Pais de origen: " + this.jugador2.getPaisDeOrigen() + " DNI: " + this.jugador2.getDNI());
        this.jugador2.getEstadistica();
    }

    public void getJugador1() {
        System.out.println("Jugador 1: ");
        System.out.println("Nombre: " + this.jugador1.getNombre() + " Pais de origen: " + this.jugador1.getPaisDeOrigen() + " DNI: " + this.jugador1.getDNI());
        this.jugador1.getEstadistica();
    }

    public void getJugador2() {
        System.out.println("Jugador 2: ");
        System.out.println("Nombre: " + this.jugador2.getNombre() + " Pais de origen: " + this.jugador2.getPaisDeOrigen() + " DNI: " + this.jugador2.getDNI());
        this.jugador2.getEstadistica();
    }

    public void setJugadores(String pais1, String nombre1, int puntaje1, int partidas1, String pais2, String nombre2, int puntaje2, int partidas2) {
        this.jugador1 = new Jugador(pais1, nombre1, puntaje1, partidas1);
        this.jugador2 = new Jugador(pais2, nombre2, puntaje2, partidas2);
    }

    /**
     * Genera un puntaje aleatorio (0 o 1).
     *
     * @return valor entero aleatorio
     */
    private int ramdonpunto() {
        Random rand = new Random();
        return rand.nextInt(2);
    }

    /**
     * Obtiene el jugador 1 de la partida.
     *
     * @return jugador 1
     */
    public Jugador obtenerJugador1() {
        return this.jugador1;
    }

    /**
     * Obtiene el jugador 2 de la partida.
     *
     * @return jugador 2
     */
    public Jugador obtenerJugador2() {
        return this.jugador2;
    }
}
