
/**
 * This class contents the solution of point 1.2
 * 
 * @author Maria José Gutiérrez & Paulina Ocampo 
 * @version 1.0
 */
public class lab1_p2
{
    /*Title: <Laboratory1 > Author: <Isabella Quintero, Sofia Vega>
      Date: <23 de octubre 2019>
      Code version: <version 1.0> 
      Availability: <https://github.com/mauriciotoro/ST0245-Eafit/blob/master/laboratorios/lab01/codigo_estudiante/codigo/java/Laboratory1.java>
    */
public static int rectangles (int r) {
        if (r<=2) {
            return r;
        } else 
            return rectangles(r-1)+rectangles (r-2);

    }
}
