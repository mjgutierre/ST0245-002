 
/**
*
* torresDeHannoi 
* 
*/

public class taller3_Punto1 {
        /**
	*
	* El método torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* 
	*/	
	
	public static void torresDeHannoi(int n) {

		torresDeHannoiAux(n, 1, 2, 3);
 	}

	/**
	*
	* El método torresDeHannoi es un auxiliar del proceso 
	* @param n numero de discos
	* @param origen la torre número uno donde se posicionan todos los discos inicialmente
	* @param destino la torre donde deben posicionarse todos los discos terminado el proceso
	* @param intermedio torre auxiliar para que el cambio de torres se haga efectivo
	* 
	*/	
	
        private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
	    if(n==1){
		    System.out.println("Disk 1 from "+
		    origen + " to "+ destino);
            }else{
		   torresDeHannoiAux(n-1,origen,destino,intermedio);
		   	    System.out.println("Disk "+ n + " from "+
		              origen + " to "+ destino);
		   torresDeHannoiAux(n-1,intermedio,origen,destino);
		  }
	 }
}