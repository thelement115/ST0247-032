import java.util.ArrayList;
import java.util.LinkedList;

public class Digraph {
    public int size;
    public LinkedList<LinkedList<Pair<Integer, Integer>>> grafo;

    public Digraph(int size) {
        this.size =size;
        grafo = new LinkedList<>();
        for (int i =0; i<size;i++){
            grafo.add(new LinkedList<Pair<Integer,Integer>>());
        }
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
