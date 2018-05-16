import graph.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private static Integer n ;
    private static Integer m;
    private static Integer u;
    private static Double r;
    private static Double speed;
    private static Double Tmax;
    private static Double stCustomer;
    private static Double Q;
    private static Vertice deposito;

    public static void main(String [] args){
            Graph g;
            ArrayList <Vertice> clientes = new ArrayList<>();
            ArrayList <Carga> cargas = new ArrayList<>();
            ArrayList <Vertice> solucion = new ArrayList<>();
            Lectura input = new Lectura();
            try {
                g = input.leer("tc2c320s24cf0.txt", clientes, cargas);
                n = input.getN();
                m = input.getM();
                u = input.getU();
                r = input.getR();
                speed= input.getSpeed();
                Tmax = input.getTmax();
                stCustomer = input.getStCustomer();
                Q = input.getQ();
                deposito= input.getDeposito();
                //dibujar draw = new dibujar(clientes,cargas,deposito);
                Camino mejor = new Camino();
                double [] totales = new double[2];
                ArrayList <Double> tiemposCarga = new ArrayList<>();
                solucion =mejor.mejorSolucion(clientes,g,deposito,Tmax,speed,stCustomer,Q,r,cargas,totales,tiemposCarga);
                int j =0;
                int k =1;
            for(int i =0; i<solucion.size(); ++i){
                if(solucion.get(i).nombre.equals("depot")){
                    System.out.println();
                    System.out.println("ruta " + k);
                    k++;
                    continue;
                }
                System.out.print(solucion.get(i).nombre+ " ");
                if(solucion.get(i).nombre.charAt(0) == 'c'){
                    System.out.print(stCustomer+ " ");
                }
                else {
                    System.out.print(tiemposCarga.get(j) +  " ");
                    j++;
                }
            }
            if(totales[0] < totales[1]){
                System.out.println("tiempo total : " + totales[0]);
            }else{
                System.out.println("tiempo total : " + totales[1]);
            }

            } catch(IOException e){
                System.out.println (e);
            }
    }

}
