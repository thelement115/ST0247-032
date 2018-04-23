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
    public ArrayList <Vertice> conjuntoSolucion (ArrayList <Vertice> clientes, Graph g, Vertice deposito ){
        ArrayList <ArrayList> Soluciones = new ArrayList<>(); // crea un array para guardar las soluciones
        ArrayList <Vertice> visitados = new ArrayList<>(); // arraylist para manejar los visitados
        ArrayList <Vertice> solucion = new ArrayList<>();
        double [] totales = new double [5]; // guarda el peso total de los caminos
        totales[0] = solucion(visitados,g,clientes,solucion,deposito,1); // primera solucion
        Soluciones.add(solucion); // añade solucion
        visitados.clear();
        ArrayList <Vertice> solucion2 = new ArrayList <>();
        totales[1] = solucion(visitados,g,clientes,solucion2,deposito,2);
        Soluciones.add(solucion2);
        visitados.clear();
        ArrayList <Vertice> solucion3 = new ArrayList<>();
        totales[2] = solucion(visitados,g,clientes,solucion3,deposito,3);
        Soluciones.add(solucion3);
        visitados.clear();
        ArrayList <Vertice> solucion4 = new ArrayList<>();
        totales[3] = solucion(visitados,g,clientes,solucion4,deposito,4);
        Soluciones.add(solucion4);
        visitados.clear();
        ArrayList <Vertice> solucion5 = new ArrayList<>();
        totales[4] = solucion(visitados,g,clientes,solucion4,deposito,4);
        Soluciones.add(solucion5);
        double x = totales[0];
        int mejor = 0;
        for (int i =1; i< totales.length; i++){
            if (totales[i] < x){
                mejor = i;
            }
        }
//        System.out.println(mejor);
        return Soluciones.get(mejor);
    }

    /**
     *
     * @param visitados
     * @param g
     * @param clientes
     * @param solucion1
     * @param inicial
     * @param prueba
     * @return una solucion
     */
    public double solucion (ArrayList <Vertice> visitados, Graph g, ArrayList <Vertice> clientes, ArrayList <Vertice> solucion1,Vertice inicial,int prueba){
         double total =0;
         double [] temporales = {Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE,Double.MAX_VALUE,};
         Vertice n = inicial;
         Vertice temp = null;
         int i =1;
         double min = Double.MAX_VALUE;
         while(true){
             if(i == clientes.size()){ // si se recorrio todo el grafo se detiene
                 break;
             }
             if(i == clientes.size()/2 && prueba > 1){ // si se llego a la mitad y no es la primera solucion se va por otro camino
                 if(prueba ==2){
                     for (Vertice s : clientes) { // se recorren los vertices
                         if (!visitados.contains(s)) { // si no se ha visitado ese vertice
                             double a = g.getWeight(n.nombre, s.nombre); // se obtiene el peso entre los dos vertces
                             if (a < temporales[0]) { // si el peso actual es menor al mas menor
                                 temporales[1] = temporales[0]; // cambia el segundo por el primero
                                 temporales[0] = a; // y hace que a sea el mas menor
                             }
                             else if( a < temporales[1] && a > temporales[0]){ // si a es mayor que el segundo mas menor pero mayot que el mas menor
                                 min = a; // el min es igual a 'a'
                                 temporales[1] = a; // el segundo mas menor es igual a 'a'
                                 temp = s; // temp es igual al vertice actual
                             }
                         }
                     }
                 }
                 else if(prueba ==3) {
                     for (Vertice s : clientes) { // se recorren los vertices
                         if (!visitados.contains(s)) { // si no se ha visitado ese vertice
                             double a = g.getWeight(n.nombre, s.nombre); // se obtiene el peso entre los dos vertces
                             if (a < temporales[0]) { // si el peso actual es menor al mas menor
                                 temporales[1] = temporales[0]; // cambia el segundo por el primero
                                 temporales[0] = a; // y hace que a sea el mas menor
                             } else if (a < temporales[1] && a > temporales[0]) { // si a es mayor que el segundo mas menor pero mayot que el mas menor
                                 temporales[2] = temporales[1];
                                 temporales[1] = a;
                             } else if(a < temporales[2] && a>temporales[1]  ){
                                 min = a;
                                 temporales[2] =a;
                                 temp = s;
                             }
                         }
                     }
                 }
                 else if(prueba ==4) {
                     for (Vertice s : clientes) { // se recorren los vertices
                         if (!visitados.contains(s)) { // si no se ha visitado ese vertice
                             double a = g.getWeight(n.nombre, s.nombre); // se obtiene el peso entre los dos vertces
                             if (a < temporales[0]) { // si el peso actual es menor al mas menor
                                 temporales[1] = temporales[0]; // cambia el segundo por el primero
                                 temporales[0] = a; // y hace que a sea el mas menor
                             } else if (a < temporales[1] && a > temporales[0]) { // si a es mayor que el segundo mas menor pero mayot que el mas menor
                                 temporales[2] = temporales[1];
                                 temporales[1] = a;
                             } else if(a < temporales[2] && a>temporales[1]  ){
                                 temporales[3] = temporales [2];
                                 temporales[2] = a;
                             }else if(a < temporales [3] && a>temporales[2]){
                                 temporales[4] = temporales [3];
                                 temporales[3] = a;
                             }else if(a < temporales [4] && a> temporales[3]){
                                 min = a;
                                 temporales[4] = a;
                                 temp = s;
                             }
                         }
                     }
                 }
                 else if(prueba ==5) {
                     for (Vertice s : clientes) { // se recorren los vertices
                         if (!visitados.contains(s)) { // si no se ha visitado ese vertice
                             double a = g.getWeight(n.nombre, s.nombre); // se obtiene el peso entre los dos vertces
                             if (a < temporales[0]) { // si el peso actual es menor al mas menor
                                 temporales[1] = temporales[0]; // cambia el segundo por el primero
                                 temporales[0] = a; // y hace que a sea el mas menor
                             } else if (a < temporales[1] && a > temporales[0]) { // si a es mayor que el segundo mas menor pero mayot que el mas menor
                                 temporales[2] = temporales[1];
                                 temporales[1] = a;
                             } else if(a < temporales[2] && a>temporales[1]  ){
                                 temporales[3] = temporales [2];
                                 temporales[2] = a;
                             }else if(a < temporales[3] && a>temporales[2]){
                                 temporales[4] = temporales [3];
                                 temporales[3] = a;
                             }else if(a < temporales[4] && a> temporales[3]){
                                 temporales[5] = temporales[4];
                                 temporales[4] = a;
                             }else if(a < temporales[5] && a> temporales[4] ){
                                 min = a;
                                 temporales[5] = a;
                                 temp = s;
                             }
                         }
                     }
                 }
                 }else {
                 for (Vertice s : clientes) { // si es la primera solucion, o no es la mitad se recorren los vertices
                     if (!visitados.contains(s) && s != n) { // si no se ha visitado el vertice
                         double a = g.getWeight(n.nombre, s.nombre); // se obtiene el peso entre los dos vertices
                         if (a < min) { // si el peso actual es menor al minimo
                             min = a;  // el minimo se hace igual a a
                             temp = s; // temp es igual al vertices actual
                         }
                     }
                 }
             }
             total = total+min;
             visitados.add(n);
             solucion1.add(n);
             n = temp;
             min = Double.MAX_VALUE;
             ++i;
         }
         solucion1.add(inicial);
         total = total + g.getWeight(n.nombre,inicial.nombre);
         return total;
    }
}

