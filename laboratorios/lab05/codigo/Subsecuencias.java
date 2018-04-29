
/**
 * Write a description of class Subsecuencias here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Subsecuencias
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
}
