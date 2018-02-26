
/**
 * esta clase esta hecha para soluciones el problema de las n-reinas
 * 
 * Eduard Damiam Londoño, Gonzalo Garcia
 */
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author eduar
 */
public class Punto2 {

    static Scanner input = new Scanner (System.in);
    
    
    public static void main(String[] args) {
        System.out.println("Inserte casos de prueba y cuadros malos\n"+"Nota: El primer cuadro de cada fila nunca se daña");
        int a = input.nextInt();//número de reinas
        int n = a; //numero de veces de lectura de lineas
        int[] malos = new int[a];
        int fila = 0; //número de la fila actual
        while(n>=0){
            String columnas = input.nextLine();
            for(int i = 0; i < columnas.length(); ++i){
                char col = columnas.charAt(i); //extraccion de columna
                if(col == '*'){
                    malos[fila] = i;
                }
            }
            ++fila;
            --n;
        }
        
        System.out.println(nreinas(a,malos));
    }

    public static int nreinas(int n,int[] malos) {
        return nreinasAux(new int[n], 0,malos);  
    }

    public static int nreinasAux(int[] tablero, int x,int[] malos) {
        int n = tablero.length; 
        if (x >= n) // verifica que todas las reinas esten puestas
            if (sePuede(tablero,malos)){ // verifica que el tablero sea valido
                return 1; // si es valido retorna 1 
            }
            else {
                return 0; // si no es valido retorna cero
            } 
        int soluciones = 0;     
        for (int i = 0; i < n; ++i) { // for para ir poniendo las reinas  
            if(malos[i] == x && x!=0){  
                tablero[x+1] = i;
            }else{
                tablero[x] = i; // coloca la reina en la fila i columna x 
            }
            soluciones = soluciones + nreinasAux(tablero, x + 1,malos); // se le suma 1 o cero al numero de soluciones de manera recursiva 
        }
        return soluciones; // se retorna el numero de soluciones
    }
    
    public static boolean sePuede(int[] tablero,int[] malos) { // el codigo para comprobar el tablero es del profesor mauricio toro
        int n = tablero.length; // se saca tamaño del tablero
        for (int i = 0; i < n; ++i) { // se hace un ciclo desde 0 hasta el tamaño del tablero (posición comparada con la siguiente)
            for (int j = 0; j < n; ++j) //// se hace un ciclo desde 0 hasta el tamaño del tablero (posicion comparada con la anterior)
                if (i != j) { 
                    if (tablero[i] == tablero[j]){ // se mira que 2 reinas iguales no esten en la misma columna
                        return false;
                    }
                    if ((i - j == Math.abs(tablero[i] - tablero[j]))){ // se mira que dos reinas no esten en diagonal
                        return false;
                    }
                }
        }
        return true;
    }
}