public class CalcIInPostFix {
    public int EvaluatePostFixStack(String expresion, Stack f) {
        expresion = InFixToPosFix(expresion, f);
        int calculo = 0 ;
        String tmpTexto = "";
        boolean isNumeric = false;
        int numValido = 0;
        int Operacion = 0;
        int operandoB;
        int operandoA;
        boolean existeError = false;
        String[] expresionSplit = expresion.split(" ");
        for (int i = 0; i<expresionSplit.length; i++ ){
            tmpTexto = expresionSplit[i];
            // Se verifica que el numero que viene en el texto es correcto
            try {
                Integer.parseInt(tmpTexto);
                isNumeric = true;
            } catch (NumberFormatException excepcion) {
                isNumeric = false;
            }
            // Al verificar que es correcto se insertara en pila
            if (isNumeric){
                numValido = Integer.parseInt(tmpTexto);
                f.push(numValido);
            }
            // Se verificara si este es un tipo de operador
            else{
                if(tmpTexto.equals("+")|| tmpTexto.equals("-")|| tmpTexto.equals("*")|| tmpTexto.equals("/")){
                    if(f.count() >=2){
                        operandoB = (int) f.pull();
                        operandoA = (int) f.pull();
                        if(tmpTexto.equals("+")){
                            Operacion = operandoA + operandoB;
                            f.push(Operacion);
                        }
                        else if(tmpTexto.equals("-")) {
                            Operacion = operandoA - operandoB;
                            f.push(Operacion);
                        }
                        else if(tmpTexto.equals("*")) {
                            Operacion = operandoA * operandoB;
                            f.push(Operacion);
                        }
                        else if(tmpTexto.equals("/")) {
                            if(operandoB == 0){
                                System.out.println("Error! Division por 0");
                                existeError = true;
                                break;
                            }
                            else{
                                Operacion = operandoA / operandoB;
                                f.push(Operacion);
                            }
                        }
                    }
                    else{
                        System.out.println("Error! Insufiecientes operandos para realizar la operacion ["+tmpTexto+"]");
                        existeError = true;
                        break;
                    }
                }
                else{
                    System.out.println("Error! Operador invalido ["+tmpTexto+"]");
                    existeError = true;
                    break;
                }
            }
        }
        if(!existeError){
            if(f.count() == 1 ){
                calculo = (int) f.pull();
                return calculo;
            }
            else{
                System.out.println("Error! Insuficientes Operadores");
            }
        }
        return calculo;
    }

    public int EvaluateInFix(String expresion) {
        return 1;
    }

    public int Prec(char i){
        switch (i){
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

    public String InFixToPosFix(String expresion, Stack f){
        String resultado = new String ("");

        for (int i = 0; i<expresion.length(); ++i)
        {
            char c = expresion.charAt(i);

            if (Character.isLetterOrDigit(c)){
                resultado += c;
            }
            else if (c == '('){
                f.push(c);
            }
            else if (c == ')'){
                while (!f.isEmpty() && !f.peek().equals(')')){
                    resultado += f.pop();
                }
                f.push(c);
            }
            else {
                while(!f.isEmpty() && Prec(c) <= Prec((Character) f.peek())){
                    resultado += f.pop();
                }
                f.push(c);
            }
        }

        while (!f.isEmpty()){
            if(f.peek().equals(')')){
                return "Error";
            }
            resultado += f.pop();
        }
        return resultado;
    }
}
