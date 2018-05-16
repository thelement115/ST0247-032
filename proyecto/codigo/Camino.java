import java.util.ArrayList;

import graph.*;

public class Camino {

    /**
     *
     * @param clientes
     * @param g
     * @param deposito
     * @return conjutos de soluciones
     */
    public ArrayList <Vertice> mejorSolucion(ArrayList<Vertice> clientes, Graph g, Vertice deposito, Double Tmax, Double vel, Double customer, Double carga, Double gasto, ArrayList<Carga> cargas,double [] totales,ArrayList <Double> tiemposCarga){
        ArrayList <Vertice> visitados = new ArrayList<>(); // arraylist para manejar los visitados
        ArrayList <Vertice> solucion0 = new ArrayList<>();
        totales[0] = solucion(visitados,g,clientes,solucion0,deposito,Tmax,vel,customer,carga,gasto,cargas,tiemposCarga); // primera solucion //n^2+(n*x)
        ArrayList <Vertice> solucion1 = new ArrayList<>(); //c
        ArrayList <Double> tiemposCarga2 = new ArrayList<>();
        visitados.clear(); //c
        totales[1] = solucion2(visitados,g,clientes,solucion1,deposito,Tmax,vel,customer,carga,gasto,cargas,tiemposCarga2); //n^2+(n*x)
        if(totales[0] < totales[1]){ //c
//            System.out.println("totales 0" +totales1[0]);
            return solucion0;
        }else {
//            System.out.println("totales 1 "+ totales1[1]);
            tiemposCarga = tiemposCarga2;
            return solucion1;
        }
    }

    /**
     *
     * @param v = visitados
     * @param g = grafo
     * @param c = clientes
     * @param so = solucion
     * @param in = vertice inicial
     * @param cu = tiempo por cliente
     * @param ca = carga
     * @param Tmax
     * @param vel
     * @return una solucion
     */
    public double solucion (ArrayList <Vertice> v, Graph g, ArrayList <Vertice> c, ArrayList <Vertice> so,Vertice in,Double Tmax,Double vel, Double cu,Double ca,Double ga,ArrayList <Carga> car,ArrayList<Double> tiemposCarga){ //n^2+(n*x)
        double total =0; //c
        double time =0; //c
        double cargaMax = ca; //c
        Vertice n = in; //c
        Vertice temp = null; //c
        int i =1; //c
        double min = Double.MAX_VALUE; //c
        while(i != c.size()){ // n
            for (Vertice s : c) { // si es la primera solucion, o no es la mitad se recorren los vertices //n
                if (!v.contains(s) && s != n) { // si no se ha visitado el vertice //c
                    double a = g.getWeight(n.nombre, s.nombre); // se obtiene el peso entre los dos vertices //c
                    if (a < min) { // si el peso actual es menor al minimo // c
                        min = a;  // el minimo se hace igual a a //c
                        temp = s; // temp es igual al vertices actual//c
                    }
                }
            }

            if((time+g.getWeight(n.nombre,temp.nombre)/vel+cu>=Tmax) ||(time+(g.getWeight(temp.nombre,"depot")/vel))>= Tmax) { //c
                total = total +time+ (g.getWeight(n.nombre,"depot")/vel); //c
                so.add(in);
                time = g.getWeight("depot",temp.nombre)/vel; //c
                ca = cargaMax; //c
            }
            if(ca-(min*ga) <= (cargaMax*40)/100){ //c
                Carga mejor = null; //c
                double tiempomejor = Double.MAX_VALUE; //c
                for(Carga s: car){ //x
                    if(mejor == null){ //c
                        mejor = s; //c
                        tiempomejor = (g.getWeight(s.nombre,n.nombre)/vel)+s.vel; //c
                    }else{
                        double tiempo = g.getWeight(s.nombre,n.nombre)/vel; //c
                        if(tiempo+s.vel < tiempomejor ){ //c
                            tiempomejor = tiempo+s.vel; //c
                            mejor = s; //c
                        }
                    }
                }
                if (time+tiempomejor >=Tmax){ //c
                    total = total +time+ (g.getWeight(n.nombre,"depot")/vel); //c
                    time = g.getWeight("depot",temp.nombre)/vel; //c
                    ca = cargaMax; //c
                }else{
                    time = time+tiempomejor; //c
                    so.add(mejor); //c
                    tiemposCarga.add(mejor.vel);
                    ca = cargaMax;
                }
            }
            time = time+g.getWeight(n.nombre,temp.nombre)/vel+cu; //c
            ca-= min*ga; //c
            v.add(n); //c
            so.add(n); //c
            n = temp; //c
            min = Double.MAX_VALUE; //c
            ++i; //c
        }
        so.add(in); //c
        total = total + cu + g.getWeight(n.nombre,in.nombre)/vel; //c
        return total; //c
    }

    /**
     *
     * @param v = visitados
     * @param g = grafo
     * @param c = clientes
     * @param so = solucion
     * @param in = vertice inicial
     * @param cu = tiempo por cliente
     * @param ca = carga
     * @param Tmax
     * @param vel
     * @return una solucion
     */
    public double solucion2 (ArrayList <Vertice> v, Graph g, ArrayList <Vertice> c, ArrayList <Vertice> so,Vertice in,Double Tmax,Double vel, Double cu,Double ca,Double ga,ArrayList <Carga> car,ArrayList<Double> tiemposCarga){
        double total =0;
        double time =0;
        double cargaMax = ca;
        Vertice n = in;
        Vertice temp = null;
        int i =1;
        double min = Double.MAX_VALUE;
        while(i != c.size()){
            for (Vertice s : c) { // si es la primera solucion, o no es la mitad se recorren los vertices
                if (!v.contains(s) && s != n) { // si no se ha visitado el vertice
                    double a = g.getWeight(n.nombre, s.nombre); // se obtiene el peso entre los dos vertices
                    if (a < min) { // si el peso actual es menor al minimo
                        min = a;  // el minimo se hace igual a a
                        temp = s; // temp es igual al vertices actual
                    }
                }
            }

            if((time+g.getWeight(n.nombre,temp.nombre)/vel+cu>= Tmax) || (time+(g.getWeight(temp.nombre,"depot")/vel))>= Tmax) {
                total = total +time+ (g.getWeight(n.nombre,"depot")/vel);
                time = 0;
                v.add(n);
                so.add(n);
                min = Double.MAX_VALUE;
                n = in;
                ca = cargaMax;
                continue;
            }
            if(ca-(min*ga) <= (cargaMax*40)/100 && !n.nombre.equals("depot")){
                Carga mejor = null;
                double tiempomejor = Double.MAX_VALUE;
                for(Carga s: car){
                    if(mejor == null){
                        mejor = s;
                        tiempomejor = (g.getWeight(s.nombre,n.nombre)/vel)+s.vel;
                    }else{
                        double tiempo = g.getWeight(s.nombre,n.nombre)/vel;
                        if(tiempo+s.vel < tiempomejor ){
                            tiempomejor = tiempo+s.vel;
                            mejor = s;
                        }
                    }
                }
                if (time+tiempomejor >=Tmax){
                    total = total +time+ (g.getWeight(n.nombre,"depot")/vel);
                    time = g.getWeight("depot",temp.nombre)/vel;
                    ca = cargaMax;
                }else{
                    time = time+tiempomejor;
                    tiemposCarga.add(mejor.vel);
                    ca = cargaMax;
                    so.add(mejor);
                }
            }
            time = time+g.getWeight(n.nombre,temp.nombre)/vel+cu;
            ca-= min*ga;
            v.add(n);
            so.add(n);
            n = temp;
            min = Double.MAX_VALUE;
            ++i;
        }
        so.add(in);
        total = total + cu + g.getWeight(n.nombre,in.nombre)/vel;
        return total;
    }
}
