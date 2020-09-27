import java.util.*;
/**
 * Author Mauricio Toro, María José Gutiérrez, Paulina Ocampo
 */


public class DataStructure {
    public int size;
    public ArrayList<Triplet<Data, Data, Double>> adjGraph = new ArrayList<>();

    public DataStructure (HashMap<Long, Data> colection, ArrayList<Triplet<Long, Long, Double>> direction){
        this.size = size();
        for(Triplet<Long, Long, Double> t : direction) {
            Triplet<Data, Data, Double> tr = new Triplet(colection.get(t.x), colection.get(t.y),t.z);
            adjGraph.add(tr);
        }
    }
    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public  ArrayList<Long> getSuccessors(Long vertexID){
        ArrayList<Long> suc = new ArrayList<>();
        for(int i= 0; i<adjGraph.size(); i++){
            Triplet<Data, Data, Double> n = adjGraph.get(i);
            if(vertexID == adjGraph.get(i).x.ID){
                suc.add(n.x.ID);
            }
        }
        return suc;
    }
    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */ 
    public Double getWeight(Long sourceID, Long destinationID){
        for(int i=0; i < adjGraph.size(); i++){
            if((sourceID == adjGraph.get(i).x.ID) && (destinationID == adjGraph.get(i).y.ID)){
                return adjGraph.get(i).z;
            }
        }
        return -1.0;
    }
    /**
     * Metodo que tiene la intencion de retornar el tamaño del grafo
     * @return tamaño del grafo
     */
    public int size() {
        return this.size;
    }
}