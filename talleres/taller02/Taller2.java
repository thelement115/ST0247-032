import java.util.ArrayList;

/**
 * Taller #2
 * 
 * @author Edward Damiam Londoño Garcia & Gonzalo Garcia Hernandez
 */
public class Taller2 {
    private static void combinations(String pre, String pos,ArrayList <String> list) {
        if (pos.equals("")){
            list.add(pre);
            System.out.println(pre);
          }
        else { 
           combinations(pre,pos.substring(1),list);
           combinations(pre+pos.substring(0,1),pos.substring(1),list);
          }
    }
    
    public static ArrayList<String> combinar (String s){
        ArrayList <String> combinaciones = new ArrayList<>(); 
        for (int i =0; i< s.length(); ++i){
            String R1= s.substring(i,i+1);
            String R2= s.substring(0, i) + s.substring(i+1);
            combinaciones = combinarAux(R1,R2,combinaciones);
        }
        return combinaciones;
    } 

    public static ArrayList<String> combinarAux(String R1,String R2,ArrayList <String> combinaciones){
        if (R2.equals("")){
            combinaciones.add(R1);
            return combinaciones;
        }else {
            for (int i =0; i <R2.length();++i){
                combinarAux(R1+R2.substring(i,i+1),R2.substring(0,i)+R2.substring(i+1),combinaciones);  
            }
            return combinaciones;
        }
    }
    
    public static boolean esValido(int[] tablero){
        for(int i = 0; i < tablero.length-1; i++){
            int k = 1; // Constante de suma o resta
            for(int j = i+1 ; j < tablero.length; j++){
                if(tablero[i] == tablero[j]){
                    return false;
                }else if(j == i+1){
                    if( (tablero[j] == tablero[i]+1) || (tablero[j] == tablero[i]-1)){
                        return false;
                    }
                }else if( (tablero[j] == tablero[i]+k) || (tablero[j] == tablero[i]-k)){
                    return false;
                }
                k++;
            }
        }
        return true;
    }
    
        public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i)
            System.out.print(i + " ");
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j)
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            System.out.println();
        }
        System.out.println();
    }
}
