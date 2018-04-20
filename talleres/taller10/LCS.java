
/**
 * Write a description of class LCS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LCS
{
    private static class Camino{
        public char character;
        public int i;
        public int j;
        
        public Camino (char c, int i , int j){
            character = c;
            this.i = i;
            this.j = j;
        }
    }
    
    public static int lcs (String a, String b){
        int tabla [][] = new int [a.length()][b.length()];
        for(int i =0; i < a.length(); ++i){
            tabla[i][0] = 0;
        }
        for(int i =0; i < b.length(); ++i){
            tabla[0][i] = 0;
        }

        for (int i = 1; i < a.length(); ++i){
            for(int j =1; j< b.length(); ++j){
                if (a.charAt(i-1) == b.charAt(j-1)){
                   tabla[i][j] = tabla[i-1][j-1]+1;
                }
                else{
                  tabla[i][j] = Math.max(tabla[i-1][j],tabla[i][j-1]);
                }
                    }
            }
        return tabla[a.length()-1][b.length()-1];    
        }
        
    public static String lcsVolver(String a, String b){
        Camino camino[][] = new Camino[a.length()][b.length()];
        for(int i =0; i < a.length(); ++i){
            camino[i][0] = null;
        }
        for(int i =0; i < b.length(); ++i){
            camino[0][i] = null;
        }
        lcsVolverAux(a,b,camino);
        Camino x = camino[a.length()-1][b.length()-1];
        int i = x.i;
        int j = x.j;
        String z = x.character + "";
        while(true){
           if (camino[i][j] == null){
              break;
            }
           x = camino[i][j];
           z = z+ x.character;
           i = x.i;
           j = x.j;
        }
        return z;
    }
    
    private static void lcsVolverAux (String a, String b, Camino[][] camino){
        int tabla [][] = new int [a.length()][b.length()];
        for(int i =0; i < a.length(); ++i){
            tabla[i][0] = 0;
        }
        for(int i =0; i < b.length(); ++i){
            tabla[0][i] = 0;
        }

        for (int i = 1; i < a.length(); ++i){
            for(int j =1; j< b.length(); ++j){
                if (a.charAt(i-1) == b.charAt(j-1)){
                   tabla[i][j] = tabla[i-1][j-1]+1;
                   Camino x = new Camino(a.charAt(i-1),i-1,j-1);
                }
                else{
                  if (tabla[i-1][j] > tabla[i][j-1]){
                   tabla [i][j] = tabla[i-1][j];
                   Camino x = new Camino(b.charAt(i-1),i-1,j);
                   camino[i][j] = x;
                    }else{
                        tabla[i][j] = tabla[i][j-1];
                        Camino x = new Camino(b.charAt(i-1),i,j-1);
                        camino[i][j] = x;
                    }
                }
                    }
            }
    }
    }
