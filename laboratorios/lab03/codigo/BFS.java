import java.util.*;
/**
 * Write a description of class BFS here.
 *
 * Edward Damiam & Gonzalo Garcia
 */
public class BFS
{
    public static void main(String[] args) {
        DigraphAL g1 = new DigraphAL (6);
        g1.addArc(0,1,1);
        g1.addArc(0,2,1);
        g1.addArc(1,3,1);
        g1.addArc(1,4,1);
        g1.addArc(2,5,1);
        
        DigraphAM g2 = new DigraphAM (6);
        g2.addArc(0,1,1);
        g2.addArc(0,2,1);
        g2.addArc(1,3,1);
        g2.addArc(1,4,1);
        g2.addArc(2,5,1);
        
        System.out.println(bfs(g1));
        System.out.println(bfs(g2));
    }
    
    private static ArrayList bfs(Digraph g){
        ArrayList<Integer> camino = new ArrayList<>();
        boolean[] visitado = new boolean[g.size()];
        return AuxBFS(g,0,camino,visitado);
    }
    
    private static ArrayList AuxBFS(Digraph g, int v, ArrayList camino, boolean[] visitado){
        if(visitado[v] == false){
            camino.add(v);
            visitado[v] = true;
        }
        ArrayList<Integer> vecinos = g.getSuccessors(v);
        for(int i = 0; i < vecinos.size(); i++){
            camino.add(vecinos.get(i));
            visitado[vecinos.get(i)] = true;
        }
        for(int i = 0; i < vecinos.size(); i++){
            ArrayList<Integer> losVecis = g.getSuccessors(vecinos.get(i));
            if(losVecis.size() > 0){
                AuxBFS(g,vecinos.get(i),camino,visitado);
            }
        }
        return camino;
    }
}
