public class Nreinas {

    public static int[] nreinas (int n){
        int [] soluciones = new int[n];
        nreinasAux(0,0,soluciones,n);
        return  soluciones;
    }

    public static int nreinasAux(int Fila,int Col,int[] soluciones, int n){
        for (int i =Fila; i<=soluciones.length-1; i++){
            if(Col==n){
                return 1;
            }
            else if (comprobacion(i,Col,soluciones)){
                int a = nreinasAux(0,Col+1,soluciones,n);
                if (a == 0){
                    soluciones[Col] = 0;
                    continue;
                }else {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static  boolean comprobacion (int Fila, int Col,int[] soluciones){
       soluciones[Col] = Fila;
       for (int i= 0; i<Col; ++i){
           if (soluciones[i] == soluciones [Col]){
               soluciones[Col] =0;
               return false;
           }
           else if (soluciones[i]+i == soluciones[Col]+Col || soluciones[i]-i == soluciones[Col]-Col){
               soluciones[Col] = 0;
               return false;
           }
       }
       return true;
    }
}
