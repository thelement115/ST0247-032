/**
 * Eduard Damiam y Gonzalo Garcia
 */
public class Taller5 {

    public static void main(String[] args){
        Digraph g = new Digraph(10);
        g.addArc(0,1,1);
        g.addArc(0,2,1);
        g.addArc(0,5,1);
        g.addArc(1,6,1);
        g.addArc(1,7,1);
        g.addArc(1,0,1);
        g.addArc(2,3,1);
        g.addArc(2,8,1);
        g.addArc(2,0,1);
        g.addArc(3,4,1);
        g.addArc(3,7,1);
        g.addArc(3,2,1);
        g.addArc(4,5,1);
        g.addArc(4,6,1);
        g.addArc(4,3,1);
        g.addArc(5,9,1);
        g.addArc(5,0,1);
        g.addArc(5,4,1);
        g.addArc(6,1,1);
        g.addArc(6,4,1);
        g.addArc(6,8,1);
        g.addArc(7,1,1);
        g.addArc(7,3,1);
        g.addArc(7,9,1);
        g.addArc(8,2,1);
        g.addArc(8,6,1);
        g.addArc(8,9,1);
        g.addArc(9,7,1);
        g.addArc(9,8,1);
        g.addArc(9,5,1);
        System.out.println(colorear(3,g));
        System.out.println(colorear(1,g));
        System.out.println(colorear(2,g));
        System.out.println(colorear(4,g));
    }

    public static boolean colorear(int m, Digraph g){
         int[] colors = new int[g.size]; // se crea el arreglo donde se guardan los colores
         return colorearAux(g, 0, colors,m); //  se llama al auxiliar
    }

    public  static  boolean colorearAux(Digraph g, int v,int[] colors, int m){
        if (v == g.size){ // si ya se recorrio todo el grafo se retorna true
            return true;
        }
        for (int i =1; i <= m; i++){ // se hace un ciclo para probar colores
            if(valido(g,v,colors,i)){ // si el color que se le dara el vertice es valido
                colors[v] = i; // el vertice v tendra el color i
                if (colorearAux(g,v+1,colors,m)){ // se intenta con v+1
                     return true; // si funciona se retorna true
                }
                else{
                    colors[v] = 0; // si no funciona se intenta con otro color
                }
            }
        }
        return false; // si nada funciona se retorna false
    }

    public  static boolean valido(Digraph g, int v, int [] colors, int z){
        for (int i = 0; i <g.size; ++i){ // se recorre el grafo
            if (g.getWeight(v,i) == 1 && colors[i] == z){ // si el vertice v y el vertice i estan conectados y ademas tienen el mismo color
                return false; // se retorna falso
            }
        }
        return  true; // si no se retorna true
    }
}
