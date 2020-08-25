/**
 * CodingBat1 Recursion1  
 * 
 * @author Maria Paulina Ocampo,Maria Jose Gutierrez
 */
public class CodingBat1
{public int bunnyEars(int bunnies) {           
  if(bunnies==0)                    
    return bunnies;                                
    return 2+bunnyEars(bunnies-1);  
}
public int fibonacci(int n) {                            
  if(n<=1)                                  
    return n;
    return fibonacci(n-1) + fibonacci(n-2); 
}
public int bunnyEars2(int bunnies) {
  if(bunnies==0)
    return bunnies;
  if (bunnies%2==1)
  return 2+bunnyEars2(bunnies-1);
  return 3+bunnyEars2(bunnies-1) ;
}
public String allStar(String str) {
  if(str.length() <=1)
  return str;
  return str.charAt(0) + "*" + allStar(str.substring(1));
}
public int triangle(int rows){
   if(rows <=1)
   return rows;
   return rows+triangle(rows-1);
}
}
