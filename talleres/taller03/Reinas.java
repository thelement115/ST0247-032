/**
 * clase para solucionar el problema de las n-reinas
 * Eduard Damiam Londoño, Gonzalo Garcia
 */
public class Reinas
{
   public static int nReinas(int n ) {
     int [] tablero = new int [n];
     Nreinas(0,0,tablero);
     for (int i=0; i< tablero.length;++i){
        System.out.println(tablero[i]);
        }
     return 1;
    }
   
   public static int Nreinas(int Fila, int Col, int [] tablero){
     for (int i =Fila; i<= tablero.length-1;++i){
        if (Col == 8){
           return 1;
        }
        else if (comprobacion(i,Col,tablero)){
           int a = Nreinas(0,Col+1,tablero);
           if (a ==0){
             tablero[Col] =0;  
             continue;
            }
           else {
             return 1;
            }            
        }
        }
     return 0;
    }
    
   public static boolean comprobacion (int Fila,int Col, int [] tablero){
     tablero[Col] = Fila;
       for (int i =0; i< Col; ++i){
        if (tablero[i] == tablero[Col]){
           tablero[Col] = 0; 
           return false;
        }
        else if (tablero[i]+i==tablero[Col]+Col || tablero[i]-i==tablero[Col]-Col){
           tablero[Col] =0; 
           return false;
        }
        }
     return true;   
    }
}

