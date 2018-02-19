import java.util.*;
/**
 * Write a description of class punto2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class punto2
{
    public  static DigraphAL crear(DigraphAL grafo, int inicio, int fin){
        grafo.addArc(inicio,fin,0);
        grafo.addArc(fin,inicio,0);
        return grafo;
    }
   
    public static int[] pintar(DigraphAL grafo, int vertices){ //O(m*j*a)
        int[] pintados = new int[vertices]; //c1
        ArrayList<Integer> vecinos; //Aqui se almacenarán todos los vertices que se relacionan con cada uno //c2
        
        for(int i = 0; i < pintados.length; i++){ //m
            if(pintados[i] == 0){ //el grafo no está pintado? //c3
                pintados[i] = 1; //pintar grafo //c4
            }
            vecinos = grafo.getSuccessors(i); // a
            
            if(pintados[i] == 1){ //el grafo es de color 1? //c6
                for(int j = 0; j < vecinos.size(); j++){ //recorrer vecinos //j
                    int vec = vecinos.get(j); //vecino visitado //c7
                    if(pintados[vec] == 0){ // el vecino está pintado? //c8
                        pintados[vec] = 2; //pintar vecino //c9
                    }
                }
            }else{
                for(int j = 0; j < vecinos.size(); j++){ // j
                    int vec = vecinos.get(j); //c10
                    if(pintados[vec] == 0){ //c11
                        pintados[vec] = 1; //c12
                    }
                }
            }
        }
        
        return pintados; //c13
    }
    
    public static boolean revisar(DigraphAL grafo, int[] pintados){ //O(l*j*a)
        ArrayList<Integer> vecinos; //c1
        boolean resp = true; //c2
        for(int i = 0; i < pintados.length; i++){ //l
            vecinos = grafo.getSuccessors(i); // a
            
            for(int j = 0; j < vecinos.size(); j++){ // j
                int vec = vecinos.get(j);//vecino visitado (numero del vertice vecino) //c4
                if(pintados[vec] == pintados[i]){ //c5
                    resp = false; //c6
                }
            }
        }
        return resp; //c7
    }
    
    public static void main(String[] ags){
        int v; //vertivces
        int a; //aristas
        Scanner sc = new Scanner(System.in);
        v = sc.nextInt();
        
        if(v != 0){
            a = sc.nextInt();
            DigraphAL grafo = new DigraphAL(v);
            while( (v!=0) && (a>0) ){
                int inicio = sc.nextInt();
                int fin = sc.nextInt();
                grafo = crear(grafo,inicio,fin);
                a--;
            }
            
            int[] pintados = pintar(grafo,v); // colores de los vertices. Color "1" y color "2"
            
            if(revisar(grafo,pintados)){
                System.out.println("El grafo es BICOLOREABLE");
            }else{
                System.out.println("El grafo NO es BICOLOREABLE");
            }
        }
    }
}