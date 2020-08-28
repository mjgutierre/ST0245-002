
/**
 * Write a description of class Taller5_1 here.
 * 
 * @autor Maria José  
 * @version (a version number or a date)
 */
public class Taller5_1
{
    public static void insertionSort (int[] array){
        int s, temp,j;
        for (s=1; s<array.length; s++){
            temp= array[s];
            j=s-1;
            while (j>0 && array [j]>temp){
                array [j+1]= array[j];
                j=j-1;

            }
            array[j+1]= temp;
        }
    }

    public static void main (String [] args) {
        int [] testNums= {2,4,1,9,7,8,6,3,5};
        Taller5_1 obj =new Taller5_1 ();
        obj.insertionSort(testNums); 
        for (int i = 0; i<20; i++){
            long ti = System.currentTimeMillis();
            insertionSort(new int [testNums[i]]);
            long tf = System.currentTimeMillis();
            System.out.println(tf - ti);
        }
    }
}

