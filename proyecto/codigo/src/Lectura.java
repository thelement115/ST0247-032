import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import graph.*;

/**
 * clase para hacer la lectura del archivo
 */
public class Lectura {
    private BufferedReader input;
    private Integer n ;
    private Integer m;
    private Integer u;
    private Integer breaks;
    private Double r;
    private Double speed;
    private Double Tmax;
    private Double Smax;
    private Double stCustomer;
    private Double Q;

    public Integer getN() {
        return n;
    }

    public Integer getM() {
        return m;
    }

    public Integer getU() {
        return u;
    }

    public Integer getBreaks() {
        return breaks;
    }

    public Double getR() {
        return r;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getTmax() {
        return Tmax;
    }

    public Double getSmax() {
        return Smax;
    }

    public Double getStCustomer() {
        return stCustomer;
    }

    public Double getQ() {
        return Q;
    }

    /**
     *
     * @param archivo
     * @param clientes
     * @param cargas
     * @return Graph
     * @throws IOException
     * metodo que recibe el nombre del archivo y uns arreglo de vertices y regresa un grafo hecho con los datos del archivo
     */

    public Graph leer (String archivo, ArrayList <Vertice> clientes, ArrayList <Vertice> cargas) throws IOException{
        input = new BufferedReader(new FileReader(archivo)); // creacion del buffered
        String entrada; // string para manejar las entradas
        Graph grafo = new Graph(); // se crea el grafo
        leerPrimeraParte(input); // lee todo antes de las coordenadas
        while (true){
            entrada = input.readLine();
            if (entrada.equals("Coordinates")){
                leerCoordenadas(input,clientes,cargas); // lee las coordenadas
                break;
            }
        }
        insertarCoordenadas(clientes,grafo, cargas);
        return grafo;
    }

    /**
     *
     * @param input
     * metodo que lee la primera parte y asigna los valores de los atributos
     */

    public void leerPrimeraParte(BufferedReader input){
        String entrada;
        String [] strings;
        try{
            for (int i =1; i<= 10; ++i){
                entrada = input.readLine();
                strings = entrada.split(" ");
                if (i == 1){
                    n = Integer.parseInt(strings[3]);
                }
                else if (i == 2){
                    m = Integer.parseInt(strings[3]);
                }
                else if (i == 3){
                    u = Integer.parseInt(strings[3]);
                }
                else if (i ==4){
                    breaks = Integer.parseInt(strings[3]);
                }
                else if (i == 5){
                    r = Double.parseDouble(strings[3]);
                }
                else if (i == 6){
                    speed = Double.parseDouble(strings[3]);
                }
                else if (i == 7){
                    Tmax = Double.parseDouble(strings[3]);
                }
                else if (i == 8){
                    Smax = Double.parseDouble(strings[3]);
                }
                else if (i == 9){
                    stCustomer = Double.parseDouble(strings[3]);
                }
                else if (i == 10){
                    Q = Double.parseDouble(strings[3]);
                }
            }
        }catch (IOException e){
            System.exit(1);
        }
    }

    /**
     *
     * @param input
     * @param clientes
     * @pàram
     * metodo que lee las coordenadas
     */
    public void leerCoordenadas(BufferedReader input,ArrayList <Vertice> clientes, ArrayList <Vertice> cargas) {
        String entrada; // string para manejar la entrada
        String[] strings; // arreglo para manejar cada palabra
        try {
            while (!(entrada = input.readLine()).equals("l")){ // se miran todas las coordenadas
                if (!entrada.equals("")){ // si la linea esta vacia no se hace nada
                    continue;
                }else {
                    strings = entrada.split(" "); //
                    if (strings[2].charAt(0) == 'c' || strings[2].charAt(0) == 'd'){
                        Vertice n = new Vertice(Double.parseDouble(strings[2]),Double.parseDouble(strings[3]),strings[2]);
                        clientes.add(n);
                    }else {
                        Vertice n = new Vertice(Double.parseDouble(strings[2]),Double.parseDouble(strings[3]),strings[2]);
                        cargas.add(n);
                    }
                }
            }

        }catch (IOException e){
            System.exit(1);
        }
    }

    /**
     *
     * @param clientes
     * @param grafo
     * @param cargas
     * metodo que crea el grafo con las cargas y los clientes
     */

    public void insertarCoordenadas(ArrayList <Vertice> clientes, Graph grafo, ArrayList <Vertice> cargas){
        for (Vertice s: clientes
             ) {
            for (Vertice r:clientes
                 ) {
                grafo.addArc(s.nombre,r.nombre,s.x,s.y,r.x,r.y);
            }
            for (Vertice r:cargas){
                grafo.addArc(s.nombre,r.nombre,s.x,s.y,r.x,r.y);
            }
        }
        for (Vertice s: cargas
             ) {
            for (Vertice r: clientes){
                grafo.addArc(s.nombre,r.nombre,s.x,s.y,r.x,r.y);
            }
        }
    }

}
