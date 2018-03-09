import java.util.ArrayList;

/**
 *
 * @author eduar
 */
public class Monedas {
    
    public static void cambio() {
        int [] denominacion = {500,300,200,50};
        ArrayList cambio =cambioGreedy(900,denominacion);
        for (int i =0; i<cambio.size();++i){
            System.out.println (cambio.get(i));
        }
    }
    
    
    public static ArrayList cambioGreedy (int n, int [] denominaciones){
        ArrayList <Integer> cambio = new ArrayList <>();
        if (n < denominaciones[denominaciones.length-1]){
            return null;
        } 
        for (int i = 0 ; i< denominaciones.length; ++i){
           if (n >= denominaciones[i]){
               n-= denominaciones[i];
               cambio.add(denominaciones[i]);
               i = 0;
           }    
        }   
        return cambio;
    }    
}
