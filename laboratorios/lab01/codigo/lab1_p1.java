
/**
 * This class contents the solution of point 1.1
 * 
 * @author Maria José Gutiérrez & Paulina Ocampo 
 * @version 1.0
 */
public class lab1_p1{ 
    public static int lcsUser(String c1, String c2){
        return lcs(c1,c2,c1.length(),c2.length());
    }

    private static int lcs(String c1, String c2, int m, int n) {
        if  (m==0 || n==0){
            return 0;
        }
        if(c1.charAt(m-1)==c2.charAt(n-1)){
            return 1 + lcs(c1,c2,(m-1),(n-1));
        } else {
            return Math.max(lcs(c1,c2,m,(n-1)), lcs(c1,c2,(m-1),n));
        }
    }

    public static void main (String [] args){
        String [] testString1= {"g","gt","gTr","gtra","gtras","gtrase","gtraSeo","gtraseOp",
                "gtraseopl","gtraSEopli","graSEeoplin","gtraseopliaw","gtraseopliawg",
                "gTrasEOpliAwGd","gTrasEoPliawgDf","gTRAseopLiawgdfe","gtraseopliAWGdfep",
                "gtraseopliawgdFEPB","GtraseopliawgdfepbV","GTRAseopliawgdfePBVH"};

        String []testString2 = {"s","st","Stp","stPa","Stpag","stpAgE","stagexo","stpagexp",
                "sTpageXpr","stpagexpRN","stpaGexprNi","stpagexprnIT","stpagexPRNItw",
                "stpAgexprnITwf","sTpAgExprNitwle","stpagEXprnitWFld","stpagexPrNiTwflde",
                "StPaGexprnitwflDeQ","StpagexprnitwfldeqB","STPAgexprnitwfldEQBS"};
                
        int [] testNums1= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int [] testNums2= {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        for (int i = 0; i<20; i++){
                long ti = System.currentTimeMillis();
                lcs (testString1[i],testString2[i],testNums1[i],testNums2[i]);
                long tf = System.currentTimeMillis();
                System.out.println(tf - ti);
            }
        }
    }


