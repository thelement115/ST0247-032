import java.util.ArrayList;

/**
 *
 * @author Eduard Damiam, Gonzalo Garcia
 */
public class VecinoMasCercano {

    public static void main(String[] args) {
         Digraph g = new Digraph (4);
         g.addArc(0,1,7);
         g.addArc(1,0,2);
         g.addArc(0,3,6);
         g.addArc(3,0,10);
         g.addArc(3,1,4);
         g.addArc(1,3,3);
         g.addArc(3,2,8);
         g.addArc(2,3,12);
         g.addArc(2,1,6);
         g.addArc(1,2,7);
         g.addArc(2,0,9);
         g.addArc(0,2,15);
         System.out.println(VMC(g));
         
         Monedas.cambio();
    }

    public static int VMC (Digraph g){ // metodo para obtener el camino mas corto
        boolean [] visitados = new boolean [g.size];
        int cont = 1;
        int camino = 0;
        camino = VMCAux(visitados,camino,cont,0,g);
        return camino;
    }

    private static int VMCAux (boolean [] visitados, int camino,int cont, int v,Digraph g){
        if (cont == g.size){
            camino = camino + g.getWeight(v,0);
            return camino;
        }
        ArrayList sucesores = g.getSuccessors(v);      
        int m = 0;
        int b = 0;
        for (int i =0; i < sucesores.size(); ++i){
            if (visitados[(int)sucesores.get(i)]){ 
                continue;
            }
            int a = g.getWeight(v,(int)sucesores.get(i));
            if (m == 0){
                m = a;
                b = (int)sucesores.get(i);
            }
            else if (m > a){
                m = a;
                b = (int)sucesores.get(i);
            }
        }       
        camino = camino + m;
        visitados[v] = true;
        cont ++;
         return VMCAux(visitados,camino, cont, b , g);
    }
}
