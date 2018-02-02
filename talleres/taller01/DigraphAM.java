import java.util.ArrayList;
import java.util.Stack;

/**
 * Implementacion de un grafo dirigido usando matrices de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo,Eduard Damiam, Gonzalo Garcia
 */
public class DigraphAM extends Digraph {
    int [][] grafo = new int [size][size];  
    
	public DigraphAM(int size) {
		super(size);
	}

	public void addArc(int source, int destination, int weight) {
		grafo[source][destination] = weight;
	}

	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> get = new ArrayList<>();
		for (int i =0; i < grafo.length;i++){
		   if (grafo[vertex][i] != 0){
		      get.add(i);
		      }
		  }
		return get;  
	}

	public int getWeight(int source, int destination) {
	     return grafo[source][destination];
	}

}
