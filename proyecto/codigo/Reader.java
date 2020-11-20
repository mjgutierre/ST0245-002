
import java.util.*;
import java.io.*;

public class Reader{	
	public static ArrayList<String[]> main(String s) {
		return read(s);
	}

	private static ArrayList<String[]> read(String direction) {
		ArrayList<String[]> data1= new ArrayList<>();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(direction));
			String aux = ""; String line;
			while ((line = reader.readLine()) != null) {
				aux=line;
				String[] string= new String[78];
				int cl=aux.indexOf(';');
				int i=0;
				while(cl!=-1) {
					string[i]=aux.substring(0, cl);
					aux=aux.substring(cl+1);
					cl=aux.indexOf(';');
					i++;
				}
				string[i]=aux;
				data1.add(string);
			}
		} catch (IOException e) {
			System.err.println("No se encuentra archivo");
		}
		return data1;
	}

	public static void main(String args[]) {
		ArrayList<String[]> arr = main("D:\\SEMESTRE2\\Algoritmos\\0_train_balanced_15000.csv");
		//("D:\\SEMESTRE2\\Algoritmos\\2_train_balanced_75000.csv");
		//("D:\\SEMESTRE2\Algoritmos\\0_train_balanced_15000.csv");
	}
}
