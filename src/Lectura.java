import java.io.BufferedReader;
import java.io.FileReader;

/**Universidad del Valle de Guatemala
 * Facultad de Ingenieria
 * Departamento de Ciencia de la Computacion.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operacion.
 * Clase: Lectura
 * Proposito: Leer el archivo ingresado con el nombre datos.txt.
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public class Lectura {
    /**
     * Método empleado para leer archivos.
     * @param path Direccion en la que se encuentra el archivo
     * @return Devuelve una variable string que contiene la informacion del archivo.
     */
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
