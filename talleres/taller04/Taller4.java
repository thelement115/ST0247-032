import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller4 {
    /**
     * lo que hicimos en clase
     */
    public static void main(String[] args){
        DigraphAL g = new DigraphAL(4);
        g.addArc(0,1,1);
         g.addArc(1,3,1);
           g.addArc(0,2,1);
            g.addArc(3,0,1);
            
        System.out.println(dfsRetornador(g,0));
    }
           
    public static ArrayList<Integer> dfsRetornador(Digraph g, int v){
          boolean[] vi = new boolean[g.size()];
          ArrayList<Integer> respuesta = new ArrayList<Integer>();
          dfsRetornador(g, v, respuesta, vi);
          return respuesta;
    }
    
    private static void dfsRetornador(Digraph g, int v,ArrayList<Integer> l, boolean[] vi){
          vi[v] = true; //lista de nodos visitados
           l.add(v);
          ArrayList<Integer> sucesores = g.getSuccessors(v);
          if (sucesores != null)
            for(Integer sucesor: sucesores){
              if (vi[sucesor] != false) // vi[sucesor] != false
                 dfsRetornador(g,sucesor, l, vi); 
             }
            
          return;
    }   
    
    public static ArrayList<Integer> bfsRetornador(Digraph g, int v){
        boolean[] vi = new boolean[g.size()];
        ArrayList<Integer> respuesta = new ArrayList<Integer>();
        bfsRetornador(g, v, respuesta, vi);
        return respuesta;
    }
    
    public static void bfsRetornador(Digraph g,int v,ArrayList<Integer> l,boolean[] vi){
        vi[v] = true;
        l.add(v);
        ArrayList<Integer> sucesores = g.getSuccessors(v);
        if(sucesores != null){
            for(Integer sucesor : sucesores){
                if(vi[sucesor] != false){
                    
                }
            }
        }
    }
    
    
    
    
    
    
    /*********************************************************
     * 
     */
    
    
    
    public static int recorrido(Digraph g) {
        return 0;
    }

    // recomendacion
    private static int recorrido(Digraph g, int v, int[] unvisited) {
        return 0;
    }

    // recomendacion
    private static int[] removeAt(int k, int a[]) {
        // complete...
    }

    public static int costoMinimo(Digraph g, int inicio, int fin) {
        // complete...
    }

    // recomendacion
    private static void dfs(Digraph g, int v, int[] costo) {
        // complete...
    }

}