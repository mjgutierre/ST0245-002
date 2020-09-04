/**
 * @author Mauricio Toro, Andres Paez, Maria José Gutiérrez, Paulina Ocampo
 * @version 1.0
 */
public class taller6_arraylist{
    private int size;
    private static final int capacity = 10;
    private int array[];

    public taller6_arraylist() {
        array = new int[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }
    
    public int get(int i) {
        if (i < size && i > 0) {
            return array[i];
        }else {
            throw new IndexOutOfBoundsException("Index : " + i);
        }
    }

     /*
     * Su complejidad al ser lineal, no permite que este método sea usado con millones de abejas
     * ya que la hace menos eficiente al ser el peor de los casos
     */
    public void add(int e) {
        if (size == array.length) {   // O(1)
            int[] temp = new int[array.length*2]; // O(1)
            for (int i = 0; i < array.length; i++) { // O(n)
                temp[i] = array[i]; // O(n)
            }
            array = temp;   // O(1)
        }
        array[size] = e; // O(1)
        size++; 
    }
    
    /*
     * Su complejidad al ser lineal, no permite que este método sea usado con millones de abejas
     * ya que la hace menos eficiente al ser el peor de los casos
     */
    public void add1(int index, int e) {
        if (size == array.length) { // O(1)
            int [] nuevo = new int [array.length*2]; // O(1)
            for (int i = 0; i < array.length; i++) {  // O(n)
                nuevo[i] = array[i]; // O(n)
            }
            array = nuevo;  // O(1)
        }                                         
        int [] nuevo;
        nuevo = array;
        for (int i = index+1; i < array.length; i++) {  // O(n)
            nuevo[i] = array[i-1];
        }
        array = nuevo; // O(1)
        array[size] = e;   // O(1)
        size++;
    }

    public void del(int index){
        int [] nuevo;
        nuevo=array;
        for (int i = index; i < array.length-1; i++) {
            nuevo[i] = array[i+1];
        }
        array = nuevo;
        size--;
    }
  
}

