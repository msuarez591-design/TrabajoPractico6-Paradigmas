public class Estadisticas{
    //Atributos
    private int puntaje;
    private int partidas;
    //Constructores
    Estadisticas(){
        this.puntaje = 0;
        this.partidas = 0;
    }
    Estadisticas(int puntaje, int partidas){
        this.puntaje = puntaje;
        this.partidas = partidas;
    }
    
    //Set y get
    public int getPuntaje(){
        return this.puntaje;
    } 
    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
    }
    public int getPartidas(){
        return this.partidas;
    }
    public void setPartidas(int partidas){
        this.partidas = partidas;
    }

    //Metodos
    public void sumarPuntos(int nuevoPunto){
        this.puntaje += nuevoPunto;
    }
    public void sumarPartidas(int nuevaPartida){
        this.partidas += nuevaPartida;
    }
}