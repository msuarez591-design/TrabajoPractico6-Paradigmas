import java.util.ArrayList; // CORRECCIÓN: Importamos ArrayList para las colecciones

/**
 * Administra el torneo, las colecciones de jugadores y las partidas.
 *
 * @author Tu Nombre
 * @version 1.0
 */
public class Torneo {
    // Atributos modificados a Colecciones según consigna
    private ArrayList<Partida> listaPartidas;
    private ArrayList<Jugador> listaJugadores;

    // Constructores
    public Torneo() {
        this.listaPartidas = new ArrayList<>();
        this.listaJugadores = new ArrayList<>();
    }

    // Metodos
    public void crearPartida(String competencia, String pais1, String nombre1, int partidas1, String pais2, String nombre2, int partidas2) {
        // Tu lógica de crear la partida
        Partida nuevaPartida = new Partida(competencia, pais1, nombre1, partidas1, pais2, nombre2, partidas2);
        
        // Guardamos la partida en la colección con el metdo add de ArrayList
        this.listaPartidas.add(nuevaPartida);
        
        // Guardamos a los jugadores creados en la partida en nuestra colección de jugadores
        this.listaJugadores.add(nuevaPartida.obtenerJugador1());
        this.listaJugadores.add(nuevaPartida.obtenerJugador2());
        
        System.out.println("Partida creada y guardada en el historial.");
    }
    
    public void listarJugadores() {
        System.out.println("--- JUGADORES DEL TORNEO ---");
        // bucle para imprimir los jugadores
        // se busca en la colección de jugadores y se imprime su nombre y país de origen
        for (Jugador j : listaJugadores) {
            System.out.println("- " + j.getNombre() + " (País: " + j.getPaisDeOrigen() + ")");
        }
    }
    
    public void buscarJugadorPorNombre(String nombre) {
        //bucle para buscar el jugador por nombre en la colección de jugadores
        for (Jugador j : listaJugadores) {
            if (j.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("¡Jugador encontrado!");
                j.getEstadistica();
                return;
            }
        }
        System.out.println("Jugador no encontrado.");
    }
}