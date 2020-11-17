  
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Nodo{
    private String[][] matriz;
    private Nodo left;
    private Nodo right;
    private int row;
    private String value;
    private float gini;
    boolean successLeaf;

    GiniImpurity idg = new  GiniImpurity();
    Reader data = new Reader();
    int length = data.longitud;

    int[] list = new int[]{0, 1, 2, 3, 4, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 32, 33, 34, 37, 38, 39, 40, 41, 43, 45, 46, 47, 48, 49, 50, 52, 53, 56, 57, 58, 59, 61, 62, 63, 64, 74, 75, 76};
    List<Integer> that = Arrays.stream(list).boxed().collect(Collectors.toList());
    TreeSet<Integer> noAllowed = new TreeSet<Integer>();

    public Nodo (String[][] m){
        noAllowed.addAll(that);
        if (m.length <= (length*33)/100){
            matriz = m;
            successLeaf = successOrFailure(m);
        }
        else{
            matriz = m;
            Pair<Integer,String> dato = comparePosition(m);
            row = dato.first;
            value = dato.second;
            gini = idg.weightedImpurity(m, row, value);
            String[][] mI = idg.differentValue;
            String[][] mD = idg.equalValue;
            Nodo left = new Nodo(mI);
            Nodo right = new Nodo(mD);
        }
    }
    public boolean successOrFailure(String[][] m){
        int count = 0;float porcent = 0;
        for(int i = 0; i < m.length; i++){
            if(m[i][m[0].length-1].equals("0")){
                count++;
            }
        }
        porcent = (count * 100)/m.length;
        System.out.println("The success percent of this leaf was " + porcent + " % ");
        if(porcent > 80.0f) return true;
        return false;
    }
    public TreeSet<String> DifferentValues(String[][] m, int posVariable){
        TreeSet<String> answer = new TreeSet<String>();
        for (int fila = 0; fila < m.length; fila++)
            answer.add(m[fila][posVariable]);
        return answer;
    }
    public Pair<Integer,String> comparePosition(String[][] m){
        TreeSet<String> valores = null;
        String Best = "";float worstImpurity = 1;
        int laPosDeLaVariableDondeEstaElMejorValor = -1;
        for (int row = 0; row < m[0].length - 1; row++) {
            valores = DifferentValues(m, row);
            if(noAllowed.contains(row)){
                continue;
            }
            for (String unValor : valores) {
                float weightedImpurityClm;
                if((!unValor.isEmpty())&&(unValor.matches("^[0-9]*$"))){
                    weightedImpurityClm = idg.weightedImpurity(m, row, unValor);  
                }else{
                    weightedImpurityClm = idg.weightedImpurity(m, row, unValor);
                }
                if (weightedImpurityClm < worstImpurity){
                    worstImpurity = weightedImpurityClm;
                    Best = unValor;
                    laPosDeLaVariableDondeEstaElMejorValor = row;
                }
            }
        }
        Pair<Integer,String> answer = new Pair<Integer,String>(laPosDeLaVariableDondeEstaElMejorValor, Best);
        return answer;
    }
}