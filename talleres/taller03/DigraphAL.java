import java.util.*;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Eduard Damiam, Gonzalo Garcia
 */
public class DigraphAL extends Digraph {
    public LinkedList<LinkedList<Pair<Integer, Integer>>> grafo;
    
	public DigraphAL(int size) {
		super(size);
		grafo = new LinkedList<>();
		for (int i =0; i<size;i++){
		  grafo.add(new LinkedList<Pair<Integer,Integer>>());
		  }
	}
	
	public int getSize(){
	    return size;
	   }
	   
	public LinkedList getArco(int source){
	    LinkedList arco = grafo.get(source);
	    return arco;
	   }
	   
	public void addArc(int source, int destination, int weight) {
	     LinkedList arco = grafo.get(source);
	     arco.add(new Pair(destination,weight));
	   }

	public ArrayList<Integer> getSuccessors(int vertex) {
	   ArrayList<Integer> Successors = new ArrayList<>();
	   int a = grafo.get(vertex).size();
	   for (int i =0;i< a;i++){
	       Successors.add(grafo.get(vertex).get(i).first);
	   }
	   return Successors;
	}

	public int getWeight(int source, int destination) {
	   LinkedList weight= grafo.get(source);
	   for (int i =0; i < weight.size();i++){
	     Pair a = (Pair)weight.get(i);
	     if((int)(a.first)==destination){
	        return (int)a.second;
	       }
	   }
	   return 0;
	}

}
