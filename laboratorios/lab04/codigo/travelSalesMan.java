import graph.*;
import java.util.ArrayList;
public class travelSalesMan
{
       public static ArrayList VMC (Digraph g){ // metodo para obtener el camino mas corto
        boolean [] visitados = new boolean [g.size];
        int cont = 1;
        ArrayList <Integer> camino = new ArrayList <>();
        camino = VMCAux(visitados,camino,cont,0,g);
        return camino;
    }

    private static ArrayList VMCAux (boolean [] visitados, ArrayList camino,int cont, int v,Digraph g) {
        if (cont == g.size) {    
            camino.add(v);
            camino.add(0);
            return camino;
        }
        ArrayList sucesores = g.getSuccessors(v);
        int m = 0;
        int b = 0;
        for (int i = 0; i < sucesores.size(); ++i) {
            if (visitados[(int) sucesores.get(i)]) {
                continue;
            }
            int a = g.getWeight(v, (int) sucesores.get(i));
            if (m == 0) {
                m = a;
                b = (int) sucesores.get(i);
            } else if (m > a) {
                m = a;
                b = (int) sucesores.get(i);
            }
        }
        camino.add(v);
        visitados[v] = true;
        cont++;
        return VMCAux(visitados, camino, cont, b, g);
    }
}
