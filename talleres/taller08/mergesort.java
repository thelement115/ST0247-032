import java.util.ArrayList;

/**
 * Eduard Damiam Londoño, Gonzalo Garcia
 * @version (a version number or a date)
 */
public class mergesort
{
   public static int [] b; 
    
   public static void mergeSor(int [] a){
     mergeSor(a,0,a.length-1);
     for(int i =0; i<b.length;i++){
        System.out.println(b[i]);
        }
    }
    
   public static void mergeSor(int[] a, int l, int r){
    if (l < r){
         int m = (r+l)/2;
         mergeSor(a, l, m);
         mergeSor(a, m+1, r); 
         pegar(a, l, m, r);
    }
    }
   
   private static void pegar(int[]a,int l,int m,int r){
       int [] temp = new int [r-l];
       int i = l;
       int j = m+1;
       int k = 0;
       while(i<=m && j<=r){
         if (a[i]>a[j]){
             temp[k] = a[j];
             k++;
             j++;
            }else{
         temp[k] = a[i];   
         i++;   
         k++;
        }
        }
       b = temp;
    }
}

