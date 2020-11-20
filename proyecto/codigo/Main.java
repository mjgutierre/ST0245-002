import java.util.*;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class Main {
    public static void main(String args[]) {
        float falsepositive = 0,falsenegative=0,truepositive=0,truenegative=0;
        long startTime=System.currentTimeMillis();

        LinkedList<Integer[]> done=new LinkedList<>();
        ArrayList<String[]> array = Reader.main("4_train_balanced_135000.csv");
        //(0_test_balanced_5000.csv")
        //("0_train_balanced_15000.csv")
        //("1_test_balanced_15000.csv")
        //("1_train_balanced_45000.csv")
        //("2_test_balanced_25000.csv")
        //("2_train_balanced_75000.csv")
        //("3_test_balanced_35000.csv")
        //("3_train_balanced_105000.csv")
        //("4_test_balanced_45000.csv")
        //("4_train_balanced_135000.csv")
        double[] temp = bestOption.bestQ(array, 66, 73, done);
        Node root=new Node(array,temp);

        splitTree(root,done);
        int i=0;
        
        long endTime = System.currentTimeMillis();
        long totalExecTime = endTime - startTime;
        System.gc();
        System.out.println("Total execution time: " + totalExecTime + " miliseconds");
        
        System.gc();
        System.out.println("Total memory usage: " + (double) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024)/1024 + " MB");
        
        String[][] results = new String[array.size()][2];
       
        double exit = 0;
        double nonexit = 0;
        double total = 0;
        
        /*for(int j = 1; i<array.size(); i++){
            results[j][0] = array.get(j).get(array.get(0).size());
            String aux2 = array.get(i)[array.get(i).length - 1];
            if(Integer.parseInt(aux2) == 1){
                exit+=1;
                results[j][1] = "1";
            }else{
                nonexit+=1;
                results[j][1] = "0";
            }

            if(results[j][0].equals(results[j][1])){
                if(results[j][0].equals("1")){
                    truepositive+=1;
                }else{
                    falsenegative+=1;
                }
            }else{
                if(results[j][0].equals("0")){
                    falsepositive+=1;
                }else{
                    truenegative+=1;
                }
            }
        }
        */

        
        total = truepositive+truenegative+falsepositive+falsenegative;
        
        System.out.println("Accuracy: "+( (truepositive+truenegative) / (total))*100);
        System.out.println("Recall: "+(truepositive/(truepositive+falsenegative))*100);
        System.out.println("Precision: "+(truepositive/(truepositive+falsepositive))*100+"%");
    }

    public static void splitTree(Node nodo, LinkedList<Integer[]> done) {
        if(nodo.question[2]==0 || nodo.question[2]==100)return;
        ArrayList<String[]> right = new ArrayList<>();
        ArrayList<String[]> left = new ArrayList<>();
        for (int i=1;i<nodo.data.size();i++) {
            String[] person=nodo.data.get(i);
            if (Float.parseFloat(person[(int) nodo.question[0]]) >= nodo.question[1])
                right.add(person);
            else
                left.add(person);
        }
        nodo.rightOne=new Node(right, bestOption.bestQ(right,66, 73, done) );
        nodo.leftOne=new Node(left,bestOption.bestQ(left,66, 73, done) );
        splitTree(nodo.rightOne, done);
        splitTree(nodo.leftOne, done);
    }

}