import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Gonzalo Garcia & Edward Damiam
 */
public class Punto2 {
    public static void main(String[] args){
        DigraphAL g = new DigraphAL(4);
        g.addArc(0,1,1);
         g.addArc(1,3,1);
           g.addArc(0,2,1);
            g.addArc(3,0,1);
            
        System.out.println(bfsRetornador(g,0));
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
                if(vi[sucesor] != true){
                    l.add(sucesor);
                    vi[sucesor] = true;
                }
            }
            for(Integer sucesor : sucesores){
                ArrayList<Integer> sucs = g.getSuccessors(sucesor);
                if(sucs != null){
                    for(Integer suc : sucs){
                        if(vi[suc] != true){
                            bfsRetornador(g,suc,l,vi);
                        }
                    }
                }
            }
        }
    }
    
}