package menu;
import java.util.Scanner;
public class Menu {
    private static Scanner teclado = new Scanner(System.in);
    
    /**
     * 
     * @author iker
     * 
     * @apiNote se crea un array de dos posiciones y se le pide al usuario que dos valores tendra
     * 
     * @return devuelve un array con los valores metidos por el usuario
     */
    
    public int[] pedirNumeros(){
        int[] ret = new int[2];
        System.out.print ("Operando 1: ");
        ret [0] = teclado.nextInt();
        System.out.print ("Operando 2: ");
        ret [1] = teclado.nextInt();
        return ret;
    }
    
    /**
     * @author iker
     * 
     * @apiNote es un bucle para pedir si quiere sumar, restar, dividir o multiplicar
     * 
     * @return devuelve un string con la operacion que el usuario quiera hacer
     */
    
    public String menuOpciones() {
        String ret = "";
        do {
            System.out.print ("Operaciones [+, -, *, /, %]: ");
            ret = teclado.next();
        } while (!((ret.equalsIgnoreCase("+")) || (ret.equalsIgnoreCase("-")) ||
                (ret.equalsIgnoreCase("*")) || (ret.equalsIgnoreCase("/")) ||
                (ret.equalsIgnoreCase("%"))
                ));
                return ret;
    }
    
    /**
     * @author iker
     * 
     * @apiNote este metodo es un bucle para pedir si quiere seguir con la calculadora.
     * 
     * @return devuelve un boolean de si quiere o no seguir con la calculadora
     */
    
    public boolean repetir(){
        boolean ret = false;
        String respuesta;
        do {
            System.out.print ("¿Desea continuar trabajando con la calculadora? [s / n]");
            respuesta = teclado.next();
        } while (!((respuesta.equalsIgnoreCase("s")) || (respuesta.equalsIgnoreCase("n"))
                    ));
                    
        if (respuesta.equalsIgnoreCase("s")){
            ret = true;
        }
        return ret;
    }
}