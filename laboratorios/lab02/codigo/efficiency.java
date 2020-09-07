
/**
 * laboratory 2.
 * 
 * @author (Maria José Gutiérrez, Paulina Ocampo) 
 * @version (a version number or a date)
 */
public class efficiency
{ 
    public static void main(String[] args) {
        testIS();
        testMS();
    }

    public static void insertionSort (int[] array){
        int s,temp,j;
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

    public static int [] randomArray(int n) {
        int [] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.round(Math.random());
        }
        return arr;
    }

    public static void testIS() {
        int [] testNums = {10, 50, 1000, 5000,10000,15000,20000,25000,30000,35000,40000,45000,50000,5500,
                60000,65000,70000,75000,80000,85000};
       
        for (int i = 0; i < testNums.length; i++) {
            long ti = System.currentTimeMillis();
            insertionSort(randomArray(testNums[i]));
            long tf = System.currentTimeMillis();
            System.out.println(" The time of the Insertion sort code for length "+i+ " is: " + (tf - ti) + " miliseconds");

        }
    }

    /* 
     * Merge sort code was taken from internet
     * https://www.baeldung.com/java-merge-sort
     * 
     */
     public static void mergeSort(int[] a, int n) {
       if (n < 2) {
           return;
       }
       int mid = n / 2;
       int[] l = new int[mid];
       int[] r = new int[n - mid];

       for (int i = 0; i < mid; i++) {
           l[i] = a[i];
       }
       for (int i = mid; i < n; i++) {
           r[i - mid] = a[i];
       }
       mergeSort(l, mid);
       mergeSort(r, n - mid);
       
       merge(a, l, r, mid, n - mid);
   }
   public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }
   public static void testMS() {
        int [] testNums = {10, 50, 1000, 5000,10000,15000,20000,25000,30000,35000,40000,45000,50000,5500,
                60000,65000,70000,75000,80000,85000,90000};
        
        for (int i = 0; i <=testNums.length; i++) {
            long ti = System.currentTimeMillis();
            mergeSort(randomArray(testNums[i+1]),testNums.length);
            long tf = System.currentTimeMillis();
            System.out.println(" The time of the Merge sort code for length " +i+ " is: " + (tf - ti) + " miliseconds");
        }
    }
}

