import java.util.ArrayList;
import java.util.Scanner;

public class Online {

    public static void main (String args []){
        DigraphAL g = leer();
        if (g == null){
            System.out.println("no se puede con los datos proporcionados");
        }

        ArrayList respuesta = CMC(g,1,g.size);
        if (respuesta.isEmpty() || respuesta == null) {
            System.out.print("-1");
        }
        else {
            for(int i=0; i< respuesta.size(); ++i){
                System.out.println(respuesta.get(i)+ " ");
            }
        }
    }

    public static DigraphAL leer(){
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String [] in = a.split(" ");
        if(Integer.parseInt(in[0])<2 || Integer.parseInt(in[0])>105){
            return null;
        }
        if(Integer.parseInt(in[1])< 0 ||Integer.parseInt(in[1])> 105 ){
            return null;
        }
        DigraphAL g = new DigraphAL(Integer.parseInt(in[0]));
        String []inp;
        for(int i = 0;i< Integer.parseInt(in[1]);++i){
            a=input.nextLine();
            inp = a.split(" ");
            if (Integer.parseInt(inp[0])< 1 || Integer.parseInt(inp[0])> g.size ){
                System.out.println("dato incorrecto");
                i--;
                continue;
            }else if(Integer.parseInt(inp[1])< 1 || Integer.parseInt(inp[1])> g.size ){
                System.out.println("dato incorrecto");
                i--;
                continue;
            }else if(Integer.parseInt(inp[2])< 1 || Integer.parseInt(inp[2])> 106){
                System.out.println("dato incorrecto");
                i--;
                continue;
            }
            g.addArc(Integer.parseInt(inp[0]),Integer.parseInt(inp[1]),Integer.parseInt(inp[2]));
        }
        return g;
    }

    public static ArrayList CMC (DigraphAL g, int inicio, int Final){
        boolean[] recorridos = new boolean[g.size];
        if (inicio == Final){
            return null;
        }
        ArrayList <Integer> camino = new ArrayList <>();
        ArrayList <Integer> temp = new ArrayList<>();
        int[] tot = {Integer.MAX_VALUE};
        camino = CMCAux(g,recorridos,inicio,Final,camino,tot,temp,0);
        camino.add(0,1);
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
        }try {
            ArrayList sucesores = g.getSuccessors(v);
            if(!sucesores.isEmpty()){
                recorridos[v-1] = true;
                for(int i =0; i<sucesores.size();++i) {
                    if(recorridos[(int)sucesores.get(i)-1]){
                        continue;
                    }
                    temp.add(sucesores.get(i));
                    camino = CMCAux(g, recorridos, (int)sucesores.get(i), f, camino, tot, temp, tempo + g.getWeight(v, (int) sucesores.get(i)));
                    Integer a = (int)sucesores.get(i);
                    temp.remove(a);
                }
                recorridos[v-1] = false;
            }
            return camino;

        }catch (Exception e){
           return camino;
        }
    }

}