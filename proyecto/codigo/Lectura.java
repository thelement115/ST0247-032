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
    private Double r;
    private Double speed;
    private Double Tmax;
    private Double stCustomer;
    private Double Q;
    private Vertice deposito;

    public Integer getN() {
        return n;
    }

    public Integer getM() {
        return m;
    }

    public Integer getU() {
        return u;
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

    public Double getStCustomer() {
        return stCustomer;
    }

    public Double getQ() {
        return Q;
    }

    public Vertice getDeposito() {
        return deposito;
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

    public Graph leer (String archivo, ArrayList <Vertice> clientes, ArrayList <Carga> cargas) throws IOException{
        input = new BufferedReader(new FileReader(archivo)); // creacion del buffered //c
        String entrada; // string para manejar las entradas //c
        Graph grafo = new Graph(); // se crea el grafo //c
        leerPrimeraParte(input); // lee todo antes de las coordenadas
        while (true){
            entrada = input.readLine(); //c
            if (entrada.equals("Coordinates")){ //c
                leerCoordenadas(input,clientes,cargas); // lee las coordenadas //l
                break;
            }
        }
        añadirEnergia(input,clientes,grafo,cargas); //x
        insertarCoordenadas(clientes,grafo, cargas); // n^2+(n*x)
        return grafo;
    }

    private void añadirEnergia(BufferedReader input,ArrayList <Vertice> clientes,Graph g,ArrayList <Carga> cargas){
        String entrada; //c
        String[] strings; //c
        ArrayList<Double> tempCarga = new ArrayList<>(); //c
        ArrayList<Double> cantidCarga= new ArrayList<>(); //c
        try{
            while (!(entrada=input.readLine()).equals("g")){  //g
                if (entrada.equals("")|| entrada.equals("l")){
                    continue;
                }
                else{
                    strings = entrada.split( " ");
                    double tiempo = Double.parseDouble(strings[3]);
                    tempCarga.add(tiempo);
                }
            }
            while ((entrada = input.readLine())!= null){ //l
                if (entrada.equals("") || entrada.equals("g")){ // si la linea esta vacia no se hace nada
                    continue;
                }else {
                    strings = entrada.split(" "); //Separa la linea por palabras
                    double carga = Double.parseDouble(strings[3]);
                    cantidCarga.add(carga);
                }
            }
            for(Carga estacion : cargas){ //x
                if(estacion.tipo == 0){ //c
                    estacion.vel = (tempCarga.get(0)); //c
                    estacion.carga = cantidCarga.get(0); //c
                }else if(estacion.tipo == 1){ //c
                    estacion.vel = tempCarga.get(1); //c
                    estacion.carga = cantidCarga.get(1); //c
                }else if(estacion.tipo == 2){ //c
                    estacion.vel= tempCarga.get(2); //c
                    estacion.carga = cantidCarga.get(2); //c
                }
            }

        }catch (Exception e){
            System.exit(1);
        }
    }

    /**
     *
     * @param input
     * metodo que lee la primera parte y asigna los valores de los atributos
     */

    private void leerPrimeraParte(BufferedReader input){
        String entrada; //c
        String [] strings; //c
        try{ //c
            for (int i =1; i<= 10; ++i){  //c
                entrada = input.readLine();
                strings = entrada.split(" ");
                if (i == 1){
                    n = Integer.parseInt(strings[2]);
                }
                else if (i == 2){
                    m = Integer.parseInt(strings[2]);
                }
                else if (i == 3){
                    u = Integer.parseInt(strings[2]);
                }
                else if (i == 5){
                    r = Double.parseDouble(strings[2]);
                }
                else if (i == 6){
                    speed = Double.parseDouble(strings[2]);
                }
                else if (i == 7){
                    Tmax = Double.parseDouble(strings[2]);
                }
                else if (i == 9){
                    stCustomer = Double.parseDouble(strings[2]);
                }
                else if (i == 10){
                    Q = Double.parseDouble(strings[2]);
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
    private void leerCoordenadas(BufferedReader input,ArrayList <Vertice> clientes, ArrayList <Carga> cargas) {
        String entrada; // string para manejar la entrada //c
        String[] strings; // arreglo para manejar cada palabra  //c
        try {
            while (!(entrada = input.readLine()).equals("l")){ // se miran todas las coordenadas // l
                if (entrada.equals("")){ // si la linea esta vacia no se hace nada //c
                    continue;
                }else {
                    strings = entrada.split(" "); // //c
                    if (strings[1].charAt(0) == 'c' ){ //c
                        Vertice n = new Vertice(Double.parseDouble(strings[2]),Double.parseDouble(strings[3]),strings[1]); //c
                        clientes.add(n); //c
                    }else if(strings[1].charAt(0)== 'd'){ //c
                        deposito = new Vertice(Double.parseDouble(strings[2]),Double.parseDouble(strings[3]),strings[1]); //c
                    }
                    else {
                        Carga n = new Carga(Double.parseDouble(strings[2]),Double.parseDouble(strings[3]),strings[1],Integer.parseInt(strings[5])); //c
                        cargas.add(n); //c
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

    private void insertarCoordenadas(ArrayList <Vertice> clientes, Graph grafo, ArrayList <Carga> cargas) { // n^2+(n*x)
        for (Vertice s : clientes //n
                ) {
            for (Vertice r : clientes //n
                    ) {
                if(r != s) { //c
                    grafo.addArc(s.nombre, r.nombre, s.x, s.y, r.x, r.y); //c
                }
            }
            for (Vertice r : cargas) { //x
                grafo.addArc(s.nombre, r.nombre, s.x, s.y, r.x, r.y); //c
                grafo.addArc(r.nombre, s.nombre, r.x, r.y, s.x, s.y); //c
                grafo.addArc(s.nombre, deposito.nombre, s.x, s.y, deposito.x, deposito.y); //c
                grafo.addArc(deposito.nombre, s.nombre, deposito.x, deposito.y, s.x, s.y); //c
            }
            grafo.addArc(s.nombre, deposito.nombre, s.x, s.y, deposito.x, deposito.y); //c
            grafo.addArc(deposito.nombre, s.nombre, deposito.x, deposito.y, s.x, s.y); //c
        }
    }

}
