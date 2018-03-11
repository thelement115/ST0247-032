import java.util.ArrayList;

public class CaminoMasCorto {

    public static void main (String args[]){
        DigraphAL g = new DigraphAL(7);
        g.addArc(0,1,50);
        g.addArc(0,2,50);
        g.addArc(0,6,30);
        g.addArc(0,5,150);
        g.addArc(1,0,50);
        g.addArc(1,6,40);
        g.addArc(1,2,50);
        g.addArc(2,1,50);
        g.addArc(2,0,50);
        g.addArc(2,3,30);
        g.addArc(3,2,30);
        g.addArc(3,4,20);
        g.addArc(3,5,20);
        g.addArc(4,5,10);
        g.addArc(4,3,20);
        g.addArc(5,0,150);
        g.addArc(5,6,100);
        g.addArc(5,3,20);
        g.addArc(6,0,30);
        g.addArc(6,1,40);

        ArrayList camino = CMC(g,0,5);
        if (camino.isEmpty()){
            System.out.print(":c");
        }
        else {
            for (int i = 0; i < camino.size();++i) {
               System.out.println(camino.get(i));
            }
        }

    }

    public static ArrayList CMC (DigraphAL g, int inicio,int Final){
        boolean[] recorridos = new boolean[g.size];
        if (inicio == Final){
            return null;
        }
        ArrayList <Integer> camino = new ArrayList <>();
        ArrayList <Integer> temp = new ArrayList<>();
        int[] tot = {Integer.MAX_VALUE};
        camino = CMCAux(g,recorridos,inicio,Final,camino,tot,temp,0);
        return camino;
    }

    public static ArrayList CMCAux (DigraphAL g, boolean[] recorridos, int v, int f,ArrayList camino,int[] tot,ArrayList temp,int
                                     tempo){
        if (v == f){
           if (tempo < tot[0]){
               tot[0] = tempo;
               camino = (ArrayList)temp.clone();
               return camino;
           }
        }
        else if (tempo > tot[0]){
            return camino;
        }
        ArrayList sucesores = g.getSuccessors(v);
        if(!sucesores.isEmpty()){
            recorridos[v] = true;
            for(int i =0; i<sucesores.size();++i) {
                if(recorridos[(int)sucesores.get(i)]){
                    continue;
                }
                temp.add(sucesores.get(i));
                camino = CMCAux(g, recorridos, (int)sucesores.get(i), f, camino, tot, temp, tempo + g.getWeight(v, (int) sucesores.get(i)));
                Integer a = (int)sucesores.get(i);
                temp.remove(a);
            }
            recorridos[v] = false;
        }
     return camino;
    }

}

