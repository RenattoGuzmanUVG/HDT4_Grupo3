
/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 * Clase: Factory
 * Proposito: Superclase abstracta que sera utilizada para instanciar sus subclases siguiendo patron Singleton
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public abstract class Factory {

    /**
     * @return int con la cantidad de elementos en
     */
    abstract int count();

    /**
     * @return booleano que representa si el stack se encuentra vacio o tiene uno o mas elementos
     */
    abstract boolean isEmpty();

}
