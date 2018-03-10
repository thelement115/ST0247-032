import  java.util.ArrayList;

public class Ciclos {

   public static void main(String [] args){
       DigraphAL g = new DigraphAL(3);
       g.addArc(0,1,2);
       g.addArc(1,2,2);
       System.out.print(ciclos(g));
   }

   public static boolean ciclos (DigraphAL g){
       boolean [] recorridos = new boolean[g.size];
       return ciclosAux(0,g,recorridos,-1);
   }

   public  static  boolean ciclosAux(int v, DigraphAL g, boolean[] recorridos, int p){
       ArrayList sucesores = g.getSuccessors(v);
       if (sucesores.isEmpty()){
           return false;
       }
       if(comprobar(v,p,sucesores)){
           return true;
       }
       recorridos[v] = true;
       for (int i = 0; i< sucesores.size();++i){
           if(recorridos[(int)sucesores.get(i)]){
               continue;
           }
           else if(ciclosAux((int)sucesores.get(i),g,recorridos,v)){
               return true;
           }
       }
       return false;
   }
   
   public static boolean comprobar(int h,int p,ArrayList sucesores){
      for (int i =0; i< sucesores.size();++i) {
          if (p == (int)sucesores.get(i)){
              return true;
          }
      }
      return false;
   }
}
