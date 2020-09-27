import java.util.LinkedList;

/**
 * Write a description of class data here.
 * @author María José Gutiérrez, Paulina Ocampo
 * Version 1.0
 */
public class Keyboard {

    public static String brokenKb(String b) {
        LinkedList<String> list = new LinkedList<>();
        boolean Final = true;
        int k = 0;
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '[') {
                if (Final) {
                    list.addLast(b.substring(k,i));
                } else {
                    list.addFirst(b.substring(k,i));
                }

                k = i + 1;
                Final = false;
            }
            if (b.charAt(i) == ']') {
                if (Final) {
                    list.addLast(b.substring(k,i));
                } else {
                    list.addFirst(b.substring(k,i));
                }

                k = i + 1;
                Final = true;
            }
        }
        if (Final) {
            list.addLast(b.substring(k));
        } else {
            list.addFirst(b.substring(k));
        }
         String result= "";
        for (String a: list) {
            result+= a;
        }
          return result;
    }
    public static void main (String[] args) {
       
        String [] test = {"This_is_a_[Beiju]_text","[[]][][]Happy_Birthday_to_Tsinghua_University",
        "asd[fgh[jkl","asd[fgh[jkl[","[[a[[d[f[[g[g[h[h[dgd[fgsfa[f","asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg"};

        for (int i = 0; i < test.length; i++) {
            System.out.println("For the string: " + test[i] +
                "\nThe result is: "+ brokenKb(test[i]));
        }
    }
}

