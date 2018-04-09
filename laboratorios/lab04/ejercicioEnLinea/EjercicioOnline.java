import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class EjercicioOnline {

    static ArrayList <Entrada> entradas = new ArrayList<>();

    public static void main(String [] args){
        try{
            leer();
            horasExtra();
        }catch (IOException e){
            System.out.println("no se pudo leer");
        }
    }

    private static void leer () throws IOException{
        String[] temp;
        String[] linea1;
        int[] linea2;
        int[] linea3;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String a = input.readLine();
        while (!a.equals("0 0 0")) {
            linea1 = a.split(" ");
            a = input.readLine();
            temp = a.split(" ");
            linea2 = new int[temp.length];
            linea3 = new int[temp.length];
            for(int i =0; i< temp.length; ++i){
                linea2[i]= Integer.parseInt(temp[i]);
            }
            a = input.readLine();
            temp= a.split(" ");
            for (int i =0; i< temp.length;++i){
                linea3[i]=Integer.parseInt(temp[i]);
            }
            Entrada b = new Entrada(Integer.parseInt(linea1[0]),Integer.parseInt(linea1[1]),Integer.parseInt(linea1[2]),linea2,linea2);
            entradas.add(b);
            a = input.readLine();
        }
    }

    private static void horasExtra(){
        for (Entrada e: entradas){
            System.out.println(e.HoraExtra());
        }
    }
}
