import java.util.ArrayList;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Write a description of class punto4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class punto5
{
    public static ArrayList costo (DigraphAL g,int inicio,int Final){
        ArrayList <Integer> camino = new ArrayList <>();
        if (inicio == Final){
            camino.add(inicio);
            return camino; 
        }
        if (g.getArco(inicio).size() == 0){
            camino.add(-1);
            return camino;
        }
        boolean vi[] = new boolean [g.size()];
        Integer costo = Integer.MAX_VALUE;
        costoAux(g,inicio,Final,vi,camino,costo,-1);
        return camino;
    }

    public static void costoAux(Digraph g, int inicio, int Final, boolean[] vi, ArrayList camino,Integer costo,int sum){
        vi[inicio] = true; 
        camino.add(inicio);     
        ArrayList<Integer> sucesores = g.getSuccessors(inicio);
        if (sucesores != null){
            for (int i=0; i < sucesores.size(); ++i){
               if (vi[i] != true){ 
               int  a = sucesores.get(i);
               if (a == Final){
                 sum = sum+g.getWeight(inicio,a);
                 if (sum < costo){
                     costo = sum; 
                     continue;
                    }
                }
               if (sum > costo){
                   continue;
                }
               costoAux(g,a,Final,vi,camino,costo,sum+g.getWeight(inicio,a)); 
            }
        }
        }
        return;
    }
}
