package operaciones;
public class Operaciones{
	
	/**
	 * @author iker
	 * @param valor1
	 * @param valor2
	 * @return devuelve un entero que es la suma de los numero pasados por parametro
	 * 
	 */
	
    public int sumar (int valor1, int valor2){
        int numero;
        numero = valor1 + valor2;
        return numero;
    }
    
    /**
     * @author iker
     * @param valor1
     * @param valor2
     * @return devuelve un entero que es la resta de los numero pasados por parametro
     */
    
    public int restar (int valor1, int valor2){
        int numero;
        numero = valor1 - valor2;
        return numero;
    }
    
    /**
     * @author iker
     * 
     * @param valor1
     * @param valor2
     * @return  devuelve un entero que es la multiplicacion de los numero pasados por parametro
     * @throws ArithmeticException Para contemplar que se intenta dividir por 
     * 
     */
    
    public int multiplicar (int valor1, int valor2){
        int numero;
        numero = valor1 * valor2;
        return numero;
    }
    
    /**
     * Divide los dos numeros que recibe como parametro
     * @author iker
     * 
     * @param valor1
     * @param valor2
     * @return la division como numero entero
     * @throws ArithmeticException contemplamos la division entre cero
     */
    
    public int dividir (int valor1, int valor2) throws ArithmeticException{
        int numero;
        numero = valor1 / valor2;
        return numero;
    }
    
    /**
     * @author iker
     * 
     * @param valor1
     * @param valor2
     * 
     * @return devuelve un entero que es la division de los numeros metidos por parametro
     * 
     */
    
    public int resto (int valor1, int valor2){
        int numero;
        numero = valor1 % valor2;
        return numero;
    }
}