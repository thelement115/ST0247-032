import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Gonzalo Garcia & Edward Damiam
 */
public class Punto4 {
    public static void main(String[] args){
        DigraphAL g = new DigraphAL(4);
        g.addArc(0,1,1);
         g.addArc(1,3,1);
           g.addArc(0,2,1);
            g.addArc(3,0,1);
            
        System.out.println(bfsRetornador(g,0,1));
    }   
    
    public static ArrayList<Integer> bfsRetornador(Digraph g, int inicio,int destino){
        boolean[] vi = new boolean[g.size()];
        ArrayList<Integer> respuesta = new ArrayList<Integer>();
        bfsRetornador(g, inicio, respuesta, vi);

        ArrayList<Integer> camino = new ArrayList<Integer>();
        for(Integer v : respuesta){
            if(v == destino){
                for(int i = 0; i <= destino; i++){
                    camino.add(respuesta.get(i));
                }
                break;
            }
        }
        return camino;
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