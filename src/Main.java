import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Lectura l = new Lectura();
        CalcIInPostFix c = new CalcIInPostFix();

        int seleccion;
        String expresion;
        int resultado;

        expresion = l.lector("datos");

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
                StackArrayList a = new StackArrayList();
                break;
            case 2:
                StackVector v = new StackVector();
                break;
            case 4:
                SingleStackList singlel = new SingleStackList();
                break;
            case 5:
                DoubleStackList doublel = new DoubleStackList();
                break;
        }

        resultado = c.EvaluateInFix(expresion);
        resultado = c.EvaluatePostFix(expresion);

        System.out.println("Archivo escaneado!");
        System.out.println("El resultado de evaluar la expresion '" + expresion + "' es: ");
        System.out.println("Solicitud finalizada con éxito. Finalizando programa...");

    }
}
