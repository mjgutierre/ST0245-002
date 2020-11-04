import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 */
public class DigraphAL extends Diagraph {
    LinkedList<Pair<Integer, Integer>>  arregloDeListas[];
    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAL(int size) {
        super(size);
        arregloDeListas = new LinkedList[size];
    }
    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        if(arregloDeListas[source] == null){
            arregloDeListas[source] = new LinkedList<Pair<Integer, Integer>>();            
        }
        arregloDeListas[source].add(new Pair(destination, weight));
    }
    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex){            
        LinkedList< Pair<Integer, Integer> > destinos = arregloDeListas[vertex];
        ArrayList<Integer> sucesores = new ArrayList<>();
        if(destinos.isEmpty())return sucesores; 
        for(int i = 0; i < destinos.size(); i++){
            sucesores.add(destinos.get(i).first);
        }
        return sucesores;
    }
    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     *
     * @param source desde donde inicia el arco
     * @param destination donde termina el arco
     * @return un entero con dicho peso
     */
    public int getWeight(int source, int destination) {
        //ArrayList<LinkedList< Pair<Integer, Integer> >> arregloDeListas;
        LinkedList< Pair<Integer, Integer> > destinos = arregloDeListas[source];
        for (int i = 0; i < destinos.size(); i++)
            if (destinos.get(i).first == destination)
                return destinos.get(i).second;
        return -1;
    }
}