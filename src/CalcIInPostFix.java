/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 * Clase: CalIInPostFix
 * Proposito: Realizar traduccion de InFix a PosFix y calculos necesarios con expresion PosFix
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public class CalcIInPostFix {

    /**
     * @param expresion String con la expresion InFix que sera pasada por la calculadora
     * @param f objeto tipo Stack que sera utilizado para realizar el algoritmo de traduccion de InFix a PosFix y calculos con PosFix
     * @return int con resultado de calculos
     */
    public int EvaluatePostFixStack(String expresion, Stack f) {
        expresion = infixToPostfixStack(expresion, f);
        int calculo = 0;
        String tmpTexto = "";
        boolean isNumeric = false;
        int numValido = 0;
        int Operacion = 0;
        int operandoB;
        int operandoA;
        boolean existeError = false;
        String[] expresionSplit = expresion.split(" ");
        for (int i = 0; i < expresionSplit.length; i++) {
            tmpTexto = expresionSplit[i];
            // Se verifica que el numero que viene en el texto es correcto
            try {
                Integer.parseInt(tmpTexto);
                isNumeric = true;
            } catch (NumberFormatException excepcion) {
                isNumeric = false;
            }
            // Al verificar que es correcto se insertara en pila
            if (isNumeric) {
                numValido = Integer.parseInt(tmpTexto);
                f.push(numValido);
            }
            // Se verificara si este es un tipo de operador
            else {
                if (tmpTexto.equals("+") || tmpTexto.equals("-") || tmpTexto.equals("*") || tmpTexto.equals("/")) {
                    if (f.count() >= 2) {
                        operandoB = (int) f.pull();
                        operandoA = (int) f.pull();
                        if (tmpTexto.equals("+")) {
                            Operacion = operandoA + operandoB;
                            f.push(Operacion);
                        } else if (tmpTexto.equals("-")) {
                            Operacion = operandoA - operandoB;
                            f.push(Operacion);
                        } else if (tmpTexto.equals("*")) {
                            Operacion = operandoA * operandoB;
                            f.push(Operacion);
                        } else if (tmpTexto.equals("/")) {
                            if (operandoB == 0) {
                                System.out.println("Error! Division por 0");
                                existeError = true;
                                break;
                            } else {
                                Operacion = operandoA / operandoB;
                                f.push(Operacion);
                            }
                        }
                    } else {
                        System.out.println("Error! Insuficientes operandos para realizar la operacion [" + tmpTexto + "]");
                        existeError = true;
                        break;
                    }
                } else {
                    System.out.println("Error! Operador invalido [" + tmpTexto + "]");
                    existeError = true;
                    break;
                }
            }
        }
        if (!existeError) {
            if (f.count() == 1) {
                calculo = (int) f.pull();
                return calculo;
            } else {
                System.out.println("Error! Insuficientes Operadores");
            }
        }
        return calculo;
    }


    /**
     * @param ch objeto de tipo caracter que representa un operando
     * @return un int que representa el tipo de caracter que es, buscando el tipo de operando a utilizar en los calculos
     */
    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }


    /**
     * @param exp String con expresion InFix que sera traducida
     * @param f Objeto de tipo Stack que sera utilizado para realizar traduccion
     * @return String con expresion en formato PosFix
     */
    static String infixToPostfixStack(String exp, Stack<Character> f) {
        String result = new String("");

        for (int i = 0; i < exp.length(); ++i) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
                result += " ";
            } else if (c == '(')
                f.push(c);

            else if (c == ')') {
                while (!f.isEmpty() && f.peek() != '(') {
                    result += f.pull();
                    result += " ";
                }

                f.pull();
            } else {
                while (!f.isEmpty() && Prec(c) <= Prec(f.peek())) {

                    result += f.pull();
                    result += " ";
                }
                f.push(c);
            }

        }

        while (!f.isEmpty()) {
            if (f.peek() == '(')
                return "Invalid Expression";
            result += f.pull();
            result += " ";
        }
        System.out.println(result);
        return result;
    }
}

