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
            solucion =mejor.mejorSolucion(clientes,g,deposito,Tmax,speed,stCustomer,Q,r,cargas);
//            for(int i =0; i<solucion.size(); ++i){
//                System.out.println(solucion.get(i).nombre);
//            }
        } catch(IOException e){
            System.out.println (e);
        }
    }

}
