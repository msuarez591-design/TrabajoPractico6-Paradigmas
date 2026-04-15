
import java.util.Random;

/**
 * Representa un jugador dentro del torneo. Contiene datos personales y
 * estadísticas.
 *
 * @author C. Guadalupe Bravo y Martin E. Suárez
 * @version 1.0
 */
public class Jugador {

    // Atributos
    private String paisDeOrigen;
    private String nombre;
    private int dni;
    private Estadisticas estad;

    // Constructores
    public Jugador() {
        this.paisDeOrigen = "";
        this.nombre = "";
        this.dni = generaDNI();
        this.estad = new Estadisticas();
    }

    // @throws IllegalArgumentException el dato del pais de origen y el nombre del jugador no puede ser nulo
    public Jugador(String pais, String nombre, int puntaje, int partidas) {
        if (pais == null || pais.trim().isEmpty()) {
            throw new IllegalArgumentException("El pais de origen no puede ser nulo.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo.");
        }
        this.paisDeOrigen = pais;
        this.nombre = nombre;
        this.dni = generaDNI();
        try {
            this.estad = new Estadisticas(puntaje, partidas);
        } catch (IllegalArgumentException e) {
            // Si hay error por números negativos, mostramos advertencia y asignamos (0,0)
            System.out.println("Advertencia al crear jugador " + nombre + ": " + e.getMessage());
            System.out.println("Se le asignarán 0 puntos y 0 partidas por defecto.");
            this.estad = new Estadisticas(0, 0);
        }
    }

    // Metodos Set y get
    public String getPaisDeOrigen() {
        return this.paisDeOrigen;
    }

    public void setPaisDeOrigen(String paisDeOrigen) {
        this.paisDeOrigen = paisDeOrigen;
    }

    /**
     * Obtiene el nombre del jugador.
     *
     * @return nombre del jugador
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void getEstadistica() {
        System.out.println("----------DATOS DEL JUGADOR---------\n");
        System.out.println("Puntaje: " + this.estad.getPuntaje() + " Partidas: " + this.estad.getPartidas());
    }

    /**
     * Obtiene el puntaje actual del jugador.
     *
     * @return puntaje acumulado
     */
    public int getPuntajeActual() {
        return this.estad.getPuntaje();
    }

    public void setEstadistica(int puntaje, int partidas) {
        this.estad.setPuntaje(puntaje);
        this.estad.setPartidas(partidas);
    }

    /**
     * Suma estadísticas al jugador.
     *
     * @param puntaje puntos a sumar
     * @param partidas partidas a sumar
     */
    public void SumarEstadistica(int puntaje, int partidas) {
        this.estad.sumarPuntos(puntaje);
        this.estad.sumarPartidas(partidas);
    }

    private int generaDNI() {
        Random rand = new Random();
        return 10000000 + rand.nextInt(90000000);
    }

    public int getDNI() {
        return this.dni;
    }
}
