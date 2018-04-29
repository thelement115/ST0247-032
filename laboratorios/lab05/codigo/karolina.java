import java.util.Scanner;
import java.util.ArrayList;
/**
 * Write a description of class karolina here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class karolina
{
    private static void info(int[][] mapa, ArrayList inicio, ArrayList desechos){
        Scanner sc = new Scanner(System.in);
        System.out.println("Posición inicial de Kamila:");
        int filaIni = sc.nextInt();
        int colIni = sc.nextInt();
        inicio.add(filaIni);
        inicio.add(colIni);
        System.out.println("¿Cuántos desechos hay? (Tienen que haber 2 o más)");
        int numDesechos = sc.nextInt();
        System.out.println("Introduce las coordenadas de los desechos");
        while(numDesechos > 0){
            int filaDes = sc.nextInt();
            int colDes = sc.nextInt();
            ArrayList<Integer> coordenada = new ArrayList<Integer>();
            coordenada.add(filaDes);
            coordenada.add(colDes);
            desechos.add(coordenada);
            numDesechos--;
        }
    }
    
    private static int moviMapa(int[][] mapa, ArrayList inicio, ArrayList desechos){
        int costo = 0;
        int iniX = (int)inicio.get(0);
        int iniY = (int)inicio.get(1);
        for(int i = 0; i < desechos.size()-1; ++i){
            ArrayList desecho = (ArrayList)desechos.get(i);
            int x = (int)desecho.get(0);
            int y = (int)desecho.get(1);
            costo += Math.abs(iniX - x) + Math.abs(iniY - y);
            iniX = x;
            iniY = y;
            if(i == desechos.size()-2){
                x = (int)inicio.get(0);
                y = (int)inicio.get(1);
                costo += Math.abs(iniX - x) + Math.abs(iniY - y);
            }
        }
        return costo;
    }
    
    public static void main(String str[]){
        int costo = 0;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos mapas deseas que limpie Karolina?");
        int numMapas = sc.nextInt();
        while(numMapas > 0){
            System.out.println("Introduce medidas del mapa:");
            int largo = sc.nextInt();
            int ancho = sc.nextInt();
            int[][] mapa = new int[largo][ancho];
            ArrayList<ArrayList> desechos = new ArrayList<>();
            ArrayList<Integer> inicio = new ArrayList<>();
            info(mapa,inicio,desechos);
            costo += moviMapa(mapa, inicio, desechos);
            numMapas--;
        }
        System.out.println("El camino mas corto es: "+costo);
    }
}
