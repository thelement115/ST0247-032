import java.util.*;
/**
 * clase para calcular el camino en un grafo
 * 
 * Eduard Damiam Londoño, Gonzalo Garcia
 */
public class Camino
{
    public static ArrayList camino (DigraphAL grafo,int inicio, int finaL){
        int tamaño = grafo.getSize();
        boolean [] recorridos = new boolean [tamaño];
        ArrayList <Integer> ruta = new ArrayList <>();
        caminoAux(grafo,tamaño,recorridos,ruta,inicio,finaL); 
        return ruta;
    }

    private static int caminoAux(DigraphAL grafo,int tamaño, boolean [] recorridos, ArrayList ruta,int inicio,int finaL){
        LinkedList arco = grafo.getArco(inicio);
        for (int i =0; i<arco.size();++i){
          Pair a = (Pair) arco.get(i);
          int vertice = (int) a.first;
          if (!recorridos[vertice-1]){
             recorridos[vertice-1] = true;
             ruta.add(vertice);
             if (vertice == finaL){
                 return 1;
                }
             int b = caminoAux(grafo,tamaño,recorridos,ruta,vertice,finaL);
             if (b == 1){
                 return 1;
                }
            }            
        }
        Integer a = inicio;
        ruta.remove(inicio);
        return 0;  
    }

}
