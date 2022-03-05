import java.io.BufferedReader;
import java.io.FileReader;

public class Lectura {
    public String lector(String path){
        String texto="";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(path));
            String temp = "";
            String bflinea;
            while ((bflinea = bf.readLine()) != null){
                temp = texto + bflinea;
            }
            texto = temp;
        } catch (Exception e){
            System.out.println("[ERROR]. El archivo no fue encontrado");
        }
        return texto;
    }
}
