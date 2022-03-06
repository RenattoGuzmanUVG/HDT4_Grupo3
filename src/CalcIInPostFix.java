public class CalcIInPostFix {
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

    public int EvaluateInFix(String expresion, List f) {
        expresion = infixToPostfixList(expresion, f);
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
                f.InsertAtStart(numValido);
            }
            // Se verificara si este es un tipo de operador
            else {
                if (tmpTexto.equals("+") || tmpTexto.equals("-") || tmpTexto.equals("*") || tmpTexto.equals("/")) {
                    if (f.count() >= 2) {
                        operandoB = (int) f.Get(0);
                        f.DeleteAtStart();
                        operandoA = (int) f.Get(0);
                        f.DeleteAtStart();
                        if (tmpTexto.equals("+")) {
                            Operacion = operandoA + operandoB;
                            f.InsertAtStart(Operacion);
                        } else if (tmpTexto.equals("-")) {
                            Operacion = operandoA - operandoB;
                            f.InsertAtStart(Operacion);
                        } else if (tmpTexto.equals("*")) {
                            Operacion = operandoA * operandoB;
                            f.InsertAtStart(Operacion);
                        } else if (tmpTexto.equals("/")) {
                            if (operandoB == 0) {
                                System.out.println("Error! Division por 0");
                                existeError = true;
                                break;
                            } else {
                                Operacion = operandoA / operandoB;
                                f.InsertAtStart(Operacion);
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
                System.out.println(Operacion);
            }
        }
        if (!existeError) {
            if (f.count() == 1) {
                calculo = (int) f.Get(0);
                f.DeleteAtStart();
                return calculo;
            } else {
                System.out.println("Error! Insuficientes Operadores");
            }
        }
        return calculo;
    }
    static int Prec(char ch)
    {
        switch (ch)
        {
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


    static String infixToPostfixStack(String exp, Stack<Character> f)
    {
        String result = new String("");

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
                result += " ";
            }

            else if (c == '(')
                f.push(c);

            else if (c == ')')
            {
                while (!f.isEmpty() && f.peek() != '(') {
                    result += f.pull();
                    result += " ";
                }

                f.pull();
            }
            else
            {
                while (!f.isEmpty() && Prec(c) <= Prec(f.peek())){

                    result += f.pull();
                    result += " ";
                }
                f.push(c);
            }

        }

        while (!f.isEmpty()){
            if(f.peek() == '(')
                return "Invalid Expression";
            result += f.pull();
            result += " ";
        }
        System.out.println(result);
        return result;
    }
    static String infixToPostfixList(String exp, List<Character> f)
    {
        String result = new String("");

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result += c;
                result += " ";
            }

            else if (c == '(')
                f.InsertAtStart(c);

            else if (c == ')')
            {
                while (!f.isEmpty() && f.Get(0) != '(') {
                    result += f.Get(0);
                    result += " ";
                    f.DeleteAtStart();
                }

                f.DeleteAtStart();
            }
            else
            {
                while (!f.isEmpty() && Prec(c) <= Prec(f.Get(0))){

                    result += f.Get(0);
                    result += " ";
                    f.DeleteAtStart();
                }
                f.InsertAtStart(c);
            }

        }

        while (!f.isEmpty()){
            if(f.Get(0) == '(')
                return "Invalid Expression";
            result += f.Get(0);
            result += " ";
            f.DeleteAtStart();
        }
        System.out.println(result);
        return result;
    }
}
