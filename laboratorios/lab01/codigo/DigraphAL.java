/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Mauricio Toro, Eduard Damiam, Gonzalo Garcia 
 * @version 1
 */
public class DigraphAL extends Graph
{
   public LinkedList<LinkedList<Pair<Integer,Integer>>> grafo;
   
   public DigraphAL(int size){
     super(size);
     grafo = new LinkedList<>();
     for (int i =0; i<size;++i){
         grafo.add(new LinkedList<Pair<Integer,Integer>>());   
     }
   }
   
   @Override
   public void addArc(int source, int destination, int weight){
     LinkedList arco = grafo.get(source);
     arco.add(new Pair(destination,weight));
   }
   
   @Override
   public int getWeight(int source, int destination){
      LinkedList weight=grafo.get(source);
      for(int i =0; i< weight.size();++i){
          Pair a = (Pair)weight.get(i);
          if((int)(a.first)== destination){
              return (int)a.second;
          }
      }
      return 0;
   }
  
   @Override
   public ArrayList<Integer> getSuccessors(int vertice){
    ArrayList<Integer> successor = new ArrayList<>();
    int a = grafo.get(vertice).size();
    for (int i =0; i<a; ++i){
        successor.add(grafo.get(vertice).get(i).first);
    }
    return successor;
   }
}
