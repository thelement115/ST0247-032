
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
public class Nreinas {

    static Scanner input = new Scanner (System.in);
    
    public static void main(String[] args) {
        System.out.println("inserte el numero de reinas");
        int a = input.nextInt();
        System.out.println(nreinas(a));
    }

    
    
    public static boolean sePuede(int[] tablero) { // el codigo para comprobar el tablero es del profesor mauricio toro
        int n = tablero.length; // se saca tamaño del tablero
        for (int i = 0; i < n; ++i) { // se hace un ciclo desde 0 hasta el tamaño del tablero
            for (int j = 0; j < n; ++j) //// se hace un ciclo desde 0 hasta el tamaño del tablero
                if (i != j) { 
                    if (tablero[i] == tablero[j]){ // se mira que 2 reinas iguales no esten en distintas posiciones
                        return false;
                    }
                    if ((i - j == Math.abs(tablero[i] - tablero[j]))){ // se mira que dos reinas no esten en diagonal
                        return false;
                    }
                }
        }
        return true;
    }

    public static int nreinas(int n) {
        return nreinasAux(new int[n], 0);  
    }

    public static int nreinasAux(int[] tablero, int x) {
        int n = tablero.length; 
        if (x >= n) // verifica que todas las reinas esten puestas
            if (sePuede(tablero)){ // verifica que el tablero sea valido
                return 1; // si es valido retorna 1 
            }
            else {
                return 0; // si no es valido retorna cero
            } 
        int soluciones = 0;     
        for (int i = 0; i < n; ++i) { // for para ir poniendo las reinas  
            tablero[x] = i; // coloca la reina en la fila i columna x 
            soluciones = soluciones + nreinasAux(tablero, x + 1); // se le suma 1 o cero al numero de soluciones de manera recursiva 
        }
        return soluciones; // se retorna el numero de soluciones
    }
}
