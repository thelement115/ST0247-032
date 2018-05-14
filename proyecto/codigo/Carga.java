public class Carga extends Vertice {

    public Double vel;
    public Double carga;
    public int tipo;

    public Carga (Double x, Double y, String nombre,int tipo){
       super(x, y, nombre);
       this.tipo= tipo;
    }

}
