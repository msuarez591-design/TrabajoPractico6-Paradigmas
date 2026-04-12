import java.util.ArrayList;

/**
 * Administra el torneo, las colecciones de jugadores y las partidas.
 *
 * @author Tu Nombre
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
    public void crearPartida(String competencia, String pais1, String nombre1, int partidas1, String pais2, String nombre2, int partidas2) {
        Partida nuevaPartida = new Partida(competencia, pais1, nombre1, partidas1, pais2, nombre2, partidas2);
        
        // Guardamos la partida
        this.listaPartidas.add(nuevaPartida);
        
        // Verificamos si los jugadores ya existen antes de guardarlos
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
    
    public void listarJugadores() {
        System.out.println("\n--- JUGADORES DEL TORNEO ---");
        for (Jugador j : listaJugadores) {
            System.out.println("- " + j.getNombre() + " (País: " + j.getPaisDeOrigen() + ")");
        }
    }
    
    public void buscarJugadorPorNombre(String nombre) {
        for (Jugador j : listaJugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("\n¡Jugador encontrado: " + j.getNombre() + "!");
                j.getEstadistica();
                return;
            }
        }
        System.out.println("\nJugador '" + nombre + "' no encontrado.");
    }

    // Nombres en minúscula siguiendo las buenas prácticas
    public void mostrarHistorial() {
        System.out.println("\n--- HISTORIAL DE PARTIDAS ---");
        for (Partida p : listaPartidas) {
            System.out.println("Competencia: " + p.getNombreCompetencia() + " | Resultado: " + p.getResultado());
        }
    }

    public void mostrarRanking() {
        System.out.println("\n--- RANKING DE JUGADORES ---");
        for (Jugador j : listaJugadores) {
            // Ahora usamos el nuevo método que nos devuelve el número exacto
            System.out.println(j.getNombre() + " - Puntaje total: " + j.getPuntajeActual());
        }
    }
}