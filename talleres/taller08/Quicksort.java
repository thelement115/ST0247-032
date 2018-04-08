
/**
 * Write a description of class Quicksort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Quicksort
{
    public static void quicksort(int[] a){
        int[] def = new int[a.length];
        int[] sub2 = new int[1];
        auxQuick(def,a,sub2,0,a.length-1);
    }
    
    private static void auxQuick(int[] def, int[]sub1, int[] sub2, int piv, int comp){
        if(piv < comp){
            if(sub1[piv] >= sub1[comp]){
                int temp = piv;
                int cont = sub1[piv];
                
                piv = comp;
                sub1[piv] = sub1[comp];
                
                comp = temp + 1;
                sub1[comp] = cont;
                
                auxQuick(def,sub1,sub2,piv,comp);
            }else{
                comp--;
                
                auxQuick(def,sub1,sub2,piv,comp);
            }
        }else if(piv > comp){
            if(sub1[piv] <= sub1[comp]){
                int temp = piv;
                int cont = sub1[piv];
                piv = comp;
                sub1[piv] = sub1[comp];
                comp = temp - 1;
                sub1[comp] = cont;
                auxQuick(def,sub1,sub2,piv,comp);
            }else{
                comp++;
                auxQuick(def,sub1,sub2,piv,comp);
            }   
        }else if(piv == comp){
            //System.out.println(sub1[piv]);
            def[piv] = sub1[piv];
            if(piv != 0 ){//&& piv != sub1.length-1){
                System.out.println("DEF: pos"+piv+" = "+def[piv]);
                int[] nSub1 = new int[piv];
                int[] nSub2 = new int[(sub1.length-1) - piv];
                subgrupo(sub1,nSub1,0,0,piv);
                subgrupo(sub1,nSub2,piv+1,0,sub1.length);
                comp--;
                auxQuick(def,nSub1,nSub2,piv,comp);
            }
        }
        for(int i = 0; i < def.length; i++){
            System.out.print(def[i]);
        }
        System.out.println();
    }
    
    private static void subgrupo(int[] grupo, int[] subG, int punt1, int punt2, int fin){
        if(punt1 == fin){
            return;
            /*
            for(int i = 0; i < subG.length; i++){
                System.out.print(subG[i]);
            }
            System.out.println();*/
        }else if(punt1 < fin){
            subG[punt2] = grupo[punt1];
            punt1++;
            punt2++;
            subgrupo(grupo,subG,punt1,punt2,fin);
        }
    }
    
    public static void prueba(){
        int[] a = {0,1,2,3,4,5};
        int[] b = new int[2];
        int[] c = new int[3];
        subgrupo(a,b,0,0,2);
        subgrupo(a,c,3,0,6);
    }
}
