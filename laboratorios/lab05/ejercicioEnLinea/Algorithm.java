public class Algorithm {

    public static boolean DFSColorFC(DigraphAM a){
        String[] visited = new String[a.size];
        int start = a.getFirst();
        return DFSColorFCAux(a, start, visited, "red");
    }

    private static boolean DFSColorFCAux(DigraphAM a, int start , String[] v, String color){
        if(v[start] == null){
            for(Integer i : a.getSuccessors(start)){ 
                if(color.equals("red")){
                    v[start] = "blue"; 
                    if(!DFSColorFCAux(a, i, v, "blue")){
                        return false;
                    }
                }else{   
                    v[start] = "red";
                    if(!DFSColorFCAux(a, i, v, "red")){
                        return false;
                    }                    
                }
            }
        }else{
            if(v[start].equals(color)){
                return false;
            }else{ 
                if(color.equals("red")){
                    v[start] = "blue";
                    return true;
                }else{
                    v[start] = "red";
                    return true;
                }
            }            
        }      
        return true;
    }
}
