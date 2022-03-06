import java.util.Scanner;

/**Universidad del Valle de Guatemala
 * Facultad de Ingenieria
 * Departamento de Ciencia de la Computacion.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operacion.
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public class Main {

    /**
     * Método utilizado para mostrar la informacion e interactuar con el usuario.
     * @param args Parámetro requerido
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Lectura l = new Lectura();
        CalcIInPostFix c = new CalcIInPostFix();

        int seleccion;
        String expresion;
        int resultado = 0;

        expresion = l.lector("datos");
        Factory f = null;
        System.out.println("""
                ██╗███╗░░██╗███████╗██╗██╗░░██╗  ████████╗░█████╗░
                ██║████╗░██║██╔════╝██║╚██╗██╔╝  ╚══██╔══╝██╔══██╗
                ██║██╔██╗██║█████╗░░██║░╚███╔╝░  ░░░██║░░░██║░░██║
                ██║██║╚████║██╔══╝░░██║░██╔██╗░  ░░░██║░░░██║░░██║
                ██║██║░╚███║██║░░░░░██║██╔╝╚██╗  ░░░██║░░░╚█████╔╝
                ╚═╝╚═╝░░╚══╝╚═╝░░░░░╚═╝╚═╝░░╚═╝  ░░░╚═╝░░░░╚════╝░
                                              
                ██████╗░░█████╗░░██████╗████████╗███████╗██╗██╗░░██╗
                ██╔══██╗██╔══██╗██╔════╝╚══██╔══╝██╔════╝██║╚██╗██╔╝
                ██████╔╝██║░░██║╚█████╗░░░░██║░░░█████╗░░██║░╚███╔╝░
                ██╔═══╝░██║░░██║░╚═══██╗░░░██║░░░██╔══╝░░██║░██╔██╗░
                ██║░░░░░╚█████╔╝██████╔╝░░░██║░░░██║░░░░░██║██╔╝╚██╗
                ╚═╝░░░░░░╚════╝░╚═════╝░░░░╚═╝░░░╚═╝░░░░░╚═╝╚═╝░░╚═╝
                
                █▀▀ ▄▀█ █░░ █▀▀ █░█ █░░ ▄▀█ ▀█▀ █▀█ █▀█
                █▄▄ █▀█ █▄▄ █▄▄ █▄█ █▄▄ █▀█ ░█░ █▄█ █▀▄
                """);
        System.out.println("La calculadora mas inteligente que sus creadores");
        System.out.println("<<Mi programa es mas inteligente que yo, y yo lo hice>> - Diego,2022");
        System.out.println("De acuerdo, démosle una solución a sus problemas...");
        System.out.println("""
                
                Seleccione un tipo de stack a implementar:
                [1]. ArrayList.
                [2]. Vector.
                [3]. Lista.""");
        seleccion = s.nextInt();
        s.nextLine();
        if (seleccion == 3){
            System.out.println("""
                
                Ya que seleccionó el tipo de stack 'Lista', seleccione un tipo de implementación:
                [4]. Lista simplemente encadenada
                [5]. Lista doblemente encadenada.""");
            seleccion = s.nextInt();
            s.nextLine();
        }

        System.out.println("""
                Perfecto, ahora procederemos a calcular la expresión que se encuentra en su archivo...
                
                Presione una tecla para continuar!""");
        s.nextLine();

        switch (seleccion){
            case 1:
                f = new StackArrayList();
                resultado= c.EvaluatePostFixStack(expresion, (Stack) f);
                break;
            case 2:
                f = new StackVector();
                resultado = c.EvaluatePostFixStack(expresion, (Stack) f);
                break;
            case 4:
                f = new StackUsingLinkedList();
                resultado = c.EvaluatePostFixStack(expresion, (Stack) f);
                break;
            case 5:
                f = new StackUsingDoubleLinkedList();
                resultado = c.EvaluatePostFixStack(expresion, (Stack) f);
                break;
        }

        System.out.println("Archivo escaneado!");
        System.out.println("El resultado de evaluar la expresion '" + expresion + "' es: "  + resultado);
        System.out.println("Solicitud finalizada con éxito. Finalizando programa...");
    }
}
