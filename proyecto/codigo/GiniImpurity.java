
/**
 * Write a description of class h here.
 * 
 * @author (your namatrixe) 
 * @version (a version numatrixber or a date)
 */

public class GiniImpurity {
    public GiniImpurity(){
    }
    String[][] equalValue;
    String[][] differentValue;
    public static float gini(String[][]matrix){
        float success = 0;
        for (int row = 0; row <matrix.length; row++){
            if (matrix[row][matrix[0].length-1].equals("1"))
                success++;
        }
        float failure =matrix.length - success;
        float averageSuccess = success/matrix.length;
        float averageFailure = failure/matrix.length;
        float impurity = 1 - (averageSuccess*averageSuccess + averageFailure*averageFailure);
        return impurity;
    }
    public float calculateWeightedGini(String[][] leftmatrix, String[][] rightmatrix){
        float leftGini = gini(leftmatrix);
        float rightGini = gini(rightmatrix);
        float weigthedGini = (leftGini*leftmatrix.length +
                rightGini*rightmatrix.length) /  (leftmatrix.length + rightmatrix.length);
        return weigthedGini;
    }
    public float weightedImpurity(String[][]matrix, int posVariable, String value){
        int equalValueStudents = 0;
        for (int row = 0; row <matrix.length; row++)
            if (matrix[row][posVariable].equalsIgnoreCase(value))
                equalValueStudents++;
        int differentValueStudents =matrix.length - equalValueStudents;
        equalValue = new String[equalValueStudents][matrix[0].length];
        differentValue = new String[differentValueStudents][matrix[0].length];
        int row = 0;
        int rowN1 = 0;
        int rowN2 = 0;
        while(row<matrix.length)
        {
            if(matrix[row][posVariable].equalsIgnoreCase(value))
            {
                equalValue[rowN1]=matrix[row];
                row++;rowN1++;
            }else
            {
                differentValue[rowN2]=matrix[row];
                row++;rowN2++;
            }
        }
        float weightedImatrixpurity = calculateWeightedGini(equalValue,differentValue);
        return weightedImatrixpurity;
    }
}