/**
 *Punto 2.1
 * @author Maria Paulina Ocampo Duque,Maria Jose Gutierrez Estrada
 * @version 25/10/2020
 */

import java.util.ArrayList;
public class Punto2
{
    public class Node {
        public Node left;
        public Node right;
        public int data;
        public Node (int data) {
            this.data=data;
        }
    }
    public Node root;
    public void buildingTree (int [] preOrder) {
        root=new Node(preOrder[0]);
        for(int i = 1; i < preOrder.length; i++) {
            insert(root, preOrder[i]);
        }
    }
    public Node insert(Node node, int data){
        if(node == null){
            return new Node(data);
        }else if(data < node.data){
            node.left = insert(node.left, data);
        }else if(data > node.data){
            node.right = insert(node.right, data);
        }
        return node;
    }
    public void preOrder(Node node) {
        if(node != null) {                 //c1
            System.out.println(node.data); //c2
            preOrder(node.left);           //c3*(n/2)
            preOrder(node.right);           //c4*(n/2)
        }
     }
    public void posOrder(Node node) {
        if(node != null) {                 //c1
            posOrder(node.left);           //c2*(n/2)
            posOrder(node.right);          //c3*(n/2)
            System.out.println(node.data); //c4
        }
    }
    public void exercise21 (int [] input) {
        buildingTree(input);
        System.out.println("PosOrder");
        posOrder(root);
        System.out.println();
    }
    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        Punto2 testing = new Punto2();
        testing.exercise21(test);
    }
}
