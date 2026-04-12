
import java.util.ArrayList;

/**
 * Administra el torneo, incluyendo jugadores y partidas. Permite registrar
 * partidas, consultar jugadores y mostrar estadísticas.
 *
 * @author C. Guadalupe Bravo y Martin E. Suárez
 * @version 1.0
 */
public class Torneo {

    private ArrayList<Partida> listaPartidas;
    private ArrayList<Jugador> listaJugadores;

    // Constructores
    public Torneo() {
        this.listaPartidas = new ArrayList<>();
        this.listaJugadores = new ArrayList<>();
    }

    // Metodos
    /**
     * Crea una nueva partida entre dos jugadores y la registra en el torneo.
     *
     * @param competencia Nombre del torneo
     * @param pais1 País del jugador 1
     * @param nombre1 Nombre del jugador 1
     * @param pais2 País del jugador 2
     * @param nombre2 Nombre del jugador 2
     */
    public void crearPartida(String competencia, String pais1, String nombre1, String pais2, String nombre2) {
        // Quitamos partidas1 y partidas2 de los argumentos de abajo también
        Partida nuevaPartida = new Partida(competencia, pais1, nombre1, 0, pais2, nombre2, 0);

        this.listaPartidas.add(nuevaPartida);

        actualizarOAgregarJugador(nuevaPartida.obtenerJugador1());
        actualizarOAgregarJugador(nuevaPartida.obtenerJugador2());

        System.out.println("Partida registrada: " + nombre1 + " vs " + nombre2);
    }

    private void actualizarOAgregarJugador(Jugador jugadorDeLaPartida) {
        boolean existe = false;

        for (Jugador j : listaJugadores) {
            // Si el nombre ya está en la lista de jugadores...
            if (j.getNombre().equalsIgnoreCase(jugadorDeLaPartida.getNombre())) {
                // Le sumamos los puntos que ganó en esta partida y sumamos 1 partida jugada
                j.SumarEstadistica(jugadorDeLaPartida.getPuntajeActual(), 1);
                existe = true;
                break; // Salimos del bucle porque ya lo encontramos
            }
        }

        // Si después de buscar no lo encontramos, lo agregamos como jugador nuevo
        if (!existe) {
            this.listaJugadores.add(jugadorDeLaPartida);
        }
    }

    /**
     * Lista todos los jugadores registrados en el torneo.
     */
    public void listarJugadores() {
        System.out.println("\n--- JUGADORES DEL TORNEO ---");
        //Itera a lo largo de toda la lista de jugadores mostrando su nombre y pais de origen hasta que llegue al final de la misma
        for (Jugador j : listaJugadores) {
            System.out.println("- " + j.getNombre() + " (País: " + j.getPaisDeOrigen() + ")");
        }
    }

    /**
     * Busca un jugador por su nombre.
     *
     * @param nombre Nombre del jugador a buscar
     */
    public void buscarJugadorPorNombre(String nombre) {
        //Iteramos sobre la lista de jugadores y por cada iteracion evaluamos la condicion utilizando un metodo de la biblioteca de strings para comparar el nombre ingresado como parametro con el nombre del jugador. Todo esto utilizando la "j" como indice de la iteracion
        for (Jugador j : listaJugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\n¡Jugador encontrado: " + j.getNombre() + "!");
                j.getEstadistica();
                return;
            }
        }
        System.out.println("\nJugador '" + nombre + "' no encontrado.");
    }

    /**
     * Muestra el historial de partidas del torneo.
     */
    public void mostrarHistorial() {
        System.out.println("\n--- HISTORIAL DE PARTIDAS ---");
        for (Partida p : listaPartidas) {
            System.out.println("Competencia: " + p.getNombreCompetencia() + " | Resultado: " + p.getResultado());
        }
    }

    /**
     * Muestra el ranking de jugadores según su puntaje.
     */
    public void mostrarRanking() {
        System.out.println("\n--- RANKING DE JUGADORES ---");
        for (Jugador j : listaJugadores) {
            // Ahora usamos el nuevo método que nos devuelve el número exacto
            System.out.println(j.getNombre() + " - Puntaje total: " + j.getPuntajeActual());
        }
    }
}
