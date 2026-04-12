import java.util.Random;

/**
 * Representa una partida entre dos jugadores.
 * Se simulan los enfrentamientos de forma aleatoria asignando 0 o 1 punto.
 *
 * @author Tu Nombre
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

    public Partida(String competencia, String pais1, String nombre1, int partidas1, String pais2, String nombre2, int partidas2) {
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
        
        // CORRECCIÓN: Se agregó 'new' para instanciar los objetos
        this.jugador1 = new Jugador(pais1, nombre1, this.puntaje1, partidas1);
        this.jugador2 = new Jugador(pais2, nombre2, this.puntaje2, partidas2);
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

    private int ramdonpunto() {
        Random rand = new Random();
        return rand.nextInt(2); 
    }  

    // Métodos extra para que Torneo pueda pedirte los jugadores de esta partida y guardarlos
    public Jugador obtenerJugador1() { 
        return this.jugador1; 
    }
    
    public Jugador obtenerJugador2() { 
        return this.jugador2; 
    }
}