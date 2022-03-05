public class CalcIInPostFix {
    public int EvaluatePostFixStack(String expresion, Stack<Integer> f) {
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
}
