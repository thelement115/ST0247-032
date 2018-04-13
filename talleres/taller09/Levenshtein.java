/**
 * Eduard Damiam Londoño, Gonzalo Garcia
 */
public class Levenshtein
{   
    public static int levenshtein (String a, String b){
       int [][] solucion = new int[a.length()][b.length()];
       for (int i =0; i< a.length();++i){
          solucion [i][0] = i;
        }
       for(int i =0; i<b.length();++i){
         solucion [0][i] = i;
        } 
       for(int i =1; i < a.length();++i){
          for(int j =1; j< b.length();++j){
             if (a.charAt(i-1)==b.charAt(j-1)){
                solucion[i][j] = solucion[i-1][j-1];
                }else{
                 solucion[i][j] = Math.min(Math.min(solucion[i-1][j]+1,solucion[i][j-1]+1),solucion[i-1][j-1]+1);                                             
                }
            }
        }        
       return solucion[a.length()-1][b.length()-1];
    }
}
