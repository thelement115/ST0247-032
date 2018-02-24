import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Gonzalo Garcia & Edward Damiam
 */
public class Punto1 {
    
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
    
}
