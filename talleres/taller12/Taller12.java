
/**
 * Write a description of class Taller12 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Taller12
{
    private static int[] permutar(int[] tabla){
        int[] intocables = new int[tabla.length];
        int[] soluc = new int[tabla.length];
        return auxPermut(tabla,soluc, intocables);
    }
    
    private static int[] auxPermut(int[] tabla, int[] soluc, int[] intocables){
        while(true){
            int minimo = Integer.MAX_VALUE;
            int filIntocable = 0;
            for(int n = 0; n < tabla.length; ++n){
                for(int fil = 0; fil < tabla.length; ++fil){
                    int posicion = tabla[fil];
                    for(int m = 0; m < tabla.length; ++m){
                        if(intocables[fil] == 1){
                            continue;
                        }
                        if(tabla[fil] < tabla.length-1){
                            tabla[fil] = tabla[fil]+1;
                        }
                        
                        int colis = colisiones(tabla);
                        if(colis == 0){
                            return tabla;
                        }else if(colis < minimo){
                            minimo = colis;
                            filIntocable = fil;
                            copy(soluc,tabla);
                        }
                    }
                    
                    if(intocables[fil] != 1){
                        tabla[fil] = posicion;
                    }
                }
                intocables[filIntocable] = 1;
                copy(tabla,soluc);
            }
            return soluc;
        }
    }
    
    private static int colisiones(int[] tabla){
        int colis = 0;
        for(int r1 = 0; r1 <= tabla.length-1 ; ++r1){
            int k = 0;
            for(int r2 = 0; r2 <= tabla.length-1; ++r2){
                k = Math.abs(r1-r2);
                if(tabla[r1] == tabla[r2] && (r1 != r2)){
                    colis++;
                }else if( (tabla[r1]+k == tabla[r2] || (tabla[r1]-k == tabla[r2])) && r1 != r2){
                    colis++;
                }
            }
        }
        return colis/2;
    }
    
    private static void copy(int[] a1, int[]a2){
        for(int i = 0;i < a2.length; ++i){
            a1[i] = a2[i];
        }
    }
    
    public static void main(String str[]){
        int[] tabla = {0,0,0,0};
        int[] soluc = permutar(tabla);
        for(int i = 0; i < soluc.length; ++i){
            System.out.print("["+soluc[i]+"]");
        }
    }
}
