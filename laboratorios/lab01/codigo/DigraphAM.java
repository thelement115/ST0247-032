/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
  

import java.util.ArrayList;
/**
 * Esta clase es una implementación de un digrafo usando matrices de adyacencia
 * 
 * @author Mauricio Toro, Eduard Damiam, Gonzalo Garcia
 * @version 1
 */
public class DigraphAM extends Graph
{
    int [][] grafo = new int [size][size];
   
   public DigraphAM(int size){
         super(size);
   }
   
    @Override
   public int getWeight(int source, int destination){
      return grafo[source][destination];
    }
   
    @Override
   public void addArc(int source, int destination, int weight){
      grafo [source][destination] = weight;
   }
  
    @Override
   public ArrayList<Integer> getSuccessors(int vertex)
   {
      ArrayList<Integer> get= new ArrayList<>();
      for(int i =0; i < grafo.length;++i){
         if (grafo[vertex][i] != 0){
             get.add(i);
            }
        }
        return get;
   }
}
