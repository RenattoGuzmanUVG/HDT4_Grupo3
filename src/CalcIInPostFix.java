public class CalcIInPostFix {
    public int EvaluatePostFix(String expresion) {
        int calculo = 0 ;
        StackArrayList pila = new StackArrayList();
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
                pila.push(numValido);
            }
            // Se verificara si este es un tipo de operador
            else{
                if(tmpTexto.equals("+")|| tmpTexto.equals("-")|| tmpTexto.equals("*")|| tmpTexto.equals("/")){
                    if(pila.count() >=2){
                        operandoB = (int) pila.pull();
                        operandoA = (int) pila.pull();
                        if(tmpTexto.equals("+")){
                            Operacion = operandoA + operandoB;
                            pila.push(Operacion);
                        }
                        else if(tmpTexto.equals("-")) {
                            Operacion = operandoA - operandoB;
                            pila.push(Operacion);
                        }
                        else if(tmpTexto.equals("*")) {
                            Operacion = operandoA * operandoB;
                            pila.push(Operacion);
                        }
                        else if(tmpTexto.equals("/")) {
                            if(operandoB == 0){
                                System.out.println("Error! Division por 0");
                                existeError = true;
                                break;
                            }
                            else{
                                Operacion = operandoA / operandoB;
                                pila.push(Operacion);
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
            if(pila.count() == 1 ){
                calculo = (int) pila.pull();
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
