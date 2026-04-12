public class Main {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SISTEMA DE GESTIÓN DE TORNEO ===");
        Torneo torneo = new Torneo();

        System.out.println("\n[1] CREACIÓN DE PARTIDAS Y JUGADORES (Simulando 3 enfrentamientos)");
        
        // Partida 1: Ana vs Luis
        torneo.crearPartida("Torneo fifa", "Argentina", "Ana", 0, "Chile", "Luis", 0);
        
        // Partida 2: Pedro vs Ana
        torneo.crearPartida("Torneo fifa", "Uruguay", "Pedro", 0, "Argentina", "Ana", 0);
        
        // Partida 3: Luis vs Pedro
        torneo.crearPartida("Torneo fifa", "Chile", "Luis", 0, "Uruguay", "Pedro", 0);

        System.out.println("\n[2] LISTADO DEL TORNEO (Jugadores inscritos)");
        torneo.listarJugadores();

        System.out.println("\n[3] CONSULTA DE JUGADORES");
        System.out.println("Buscando a Ana...");
        torneo.buscarJugadorPorNombre("Ana");

        System.out.println("\n[4] MOSTRAR HISTORIAL DE PARTIDAS");
        torneo.mostrarHistorial();

        System.out.println("\n[5] MOSTRAR RANKING");
        torneo.mostrarRanking();
    }
}