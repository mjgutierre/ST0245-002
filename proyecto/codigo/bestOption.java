import java.util.ArrayList;
import java.util.LinkedList;



public class bestOption {
	public static double[] bestQ(ArrayList<String[]> arr,int first, int last,LinkedList<Integer[]> done) {
		double[] bestOne= {0,0,100};
		for(int i= first;i<last;i++) {
			double[] aux=bestQuestion(arr, i, 0, 100);
			
			if(bestOne[2]>aux[1] && compare(i,aux[0],done)) {
				bestOne[0]=i;
				bestOne[1]=aux[0];
				bestOne[2]=aux[1];
			}
		}
		Integer[] s={(int) bestOne[0],(int) bestOne[1]};
		done.add(s);
		return bestOne;
	}
	
	private static boolean compare(int a,double aux, LinkedList<Integer[]> done) {
		for(Integer[] n:done) {
			if(n[0]==a && n[1]==aux)
			return false;
		}
		return true;
	}

	public static double[] bestQuestion(ArrayList<String[]> array, int varbl, int fit, int last) {
		int bestOne = fit;

		for (int i = 1; i < last - fit; i++) {
			double f = getGini(array, varbl, fit+i);
			double l = getGini(array, varbl, bestOne);

			bestOne = f < l ? fit + i : bestOne;
		}
		
		double[] rgt= {bestOne, getGini(array, varbl, bestOne)};
		return rgt;
	}

	public static double getGini(ArrayList<String[]> array, int varbl, int diff) {
		float es = 0, nd0 = 0, nlf = 0, nlf2 = 0;

		for (int i = 1; i < array.size(); i++) {
			String another = array.get(i)[varbl-1];
			String aux = Float.parseFloat(another) >= diff ? "1" : "0";
			String aux2 = array.get(i)[array.get(i).length - 1];
			if (aux.equals("1")) {

				if (aux.equals(aux2))
					es++;
				else
					nd0++;
			} else {
				if (aux.equals(aux2))
					nlf++;
				else
					nlf2++;
			}
		}
		Gini g = new Gini();
		return g.weightedGini(es, nd0, nlf, nlf2);
	}
}