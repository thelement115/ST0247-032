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
    public ArrayList <Vertice> conjuntoSolucion (ArrayList <Vertice> clientes, Graph g, Vertice deposito,Double Tmax,Double vel){
        ArrayList <Vertice> visitados = new ArrayList<>(); // arraylist para manejar los visitados
        ArrayList <Vertice> solucion = new ArrayList<>();
        double [] totales = new double [5]; // guarda el peso total de los caminos
        totales[0] = solucion(visitados,g,clientes,solucion,deposito,Tmax,vel); // primera solucion
        System.out.println(totales[0]);
        return solucion;
    }

    /**
     *
     * @param v = visitados
     * @param g
     * @param c = clientes
     * @param so = solucion
     * @param in = vertice inicial
     * @param Tmax
     * @param vel
     * @return una solucion
     */
    public double solucion (ArrayList <Vertice> v, Graph g, ArrayList <Vertice> c, ArrayList <Vertice> so,Vertice in,Double Tmax,Double vel){
         double total =0;
         double time =0;
         Vertice n = in;
         Vertice temp = null;
         int i =1;
         double min = Double.MAX_VALUE;
         while(true){
             if(i == c.size()){ // si se recorrio todo el grafo se detiene
                 break;
             }
             else {
                 for (Vertice s : c) { // si es la primera solucion, o no es la mitad se recorren los vertices
                     if (!v.contains(s) && s != n) { // si no se ha visitado el vertice
                         double a = g.getWeight(n.nombre, s.nombre); // se obtiene el peso entre los dos vertices
                         if (a < min) { // si el peso actual es menor al minimo
                             min = a;  // el minimo se hace igual a a
                             temp = s; // temp es igual al vertices actual
                         }
                     }
                 }
                 time = time+g.getWeight(n.nombre,temp.nombre)/vel;
             }
             if((time+(min/vel))>= Tmax ||(time+(g.getWeight(temp.nombre,"depot")/vel))>= Tmax) {
                 total = total +time+ (g.getWeight(n.nombre,"depot")/vel);
                 time = g.getWeight("depot",temp.nombre)/vel;
             }
             v.add(n);
             so.add(n);
             n = temp;
             min = Double.MAX_VALUE;
             ++i;
         }
         so.add(in);
         total = total + g.getWeight(n.nombre,in.nombre)/vel;
         return total;
    }
}

