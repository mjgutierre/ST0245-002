
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Reader{

    String[][] data;
    int longitud = ReadData();
    Reader(){
        this.data = new String[ReadData()][];
    }
    @Override
    public String toString() {
        return data.toString() + ')';
    }
    public String[][] getData() {
        return data;
    }
    public void setData(String[][] data) {
        this.data = data;
    }
    public int ReadData(){
        int data = 0;
        Path dataFile = Paths.get("1_test_balanced_15000.csv");
        try {
            BufferedReader content = Files.newBufferedReader(dataFile);
            String line = content.readLine();
            while ((line = content.readLine()) != null){
                data++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return data;
    }
    public void ReaderOfData(){
        Path reader = Paths.get("1_test_balanced_15000.csv");
        try {
            BufferedReader br = Files.newBufferedReader(reader);
            String line;
            line = br.readLine();
            line = br.readLine();
            for(int i = 0;i < data.length;i++){
                data[i] = line.split(";");
                line = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}