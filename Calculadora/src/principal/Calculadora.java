package principal;
import menu.Menu;
import operaciones.Operaciones;

import java.io.IOException;
import java.util.logging.*;

/**
 * 
 * @author iker
 * 
 * @apiNote Esta clase es la que ejecuta las otras dos clases que son menu y operaciones.
 * Tambien tiene un bucle que comprueba si quiere repetir o no
 *
 */

public class Calculadora{
	private static final Logger LOGGER = Logger.getLogger(Calculadora.class.getName());
	
    public static void main(String[] args) {   
    	int resultado = 0;
    	String operacion = "";
    	int[] operandos = new int[2];
    	Menu menu = new Menu();
    	Operaciones operaciones = new Operaciones();
    	Handler fileHandler = null;
    	Handler consoleHandler  = new ConsoleHandler();
    	
    	
    	try {
    	fileHandler  = new FileHandler("./operaciones.log");;
    	}catch(IOException exception){
    	       LOGGER.log(Level.SEVERE, "Ocurrio un error en FileHandler.", exception);
    	   }
    	LogManager.getLogManager().reset();

    	//Asignar handlers al objeto LOGGER
    	LOGGER.addHandler(consoleHandler);
    	LOGGER.addHandler(fileHandler);

    	//Establecer niveles a handlers y LOGGER
    	consoleHandler.setLevel(Level.WARNING);
    	fileHandler.setLevel(Level.FINE);
    	LOGGER.setLevel(Level.FINE);
    	         
    	         
    	       
    	do {
    		operandos = menu.pedirNumeros();
    		operacion = menu.menuOpciones();
    	try {
    	if (operacion.equalsIgnoreCase("+")) {
    		resultado = operaciones.sumar(operandos[0], operandos[1]);
    		System.out.println("Resultado: " + resultado);
    	} else if (operacion.equalsIgnoreCase("-")) {
    		resultado = operaciones.restar(operandos[0], operandos[1]);
    		System.out.println("Resultado: " + resultado);
    	} else if (operacion.equalsIgnoreCase("*")) {
    		resultado = operaciones.multiplicar(operandos[0], operandos[1]);
    		System.out.println("Resultado: " + resultado);
    	} else if (operacion.equalsIgnoreCase("/")) {
    		resultado = operaciones.dividir(operandos[0], operandos[1]);
    		System.out.println("Resultado: " + resultado);
    	} else if (operacion.equalsIgnoreCase("%")) {
    		resultado = operaciones.resto(operandos[0], operandos[1]);
    		System.out.println("Resultado: " + resultado);
    	} else {
    		System.out.println("Operación no válida");
    	}
    		LOGGER.log(Level.FINE,"Operacion : "+ operacion + " | operando 1: " + operandos[0] + " | operando 2: " + operandos[1] + " | Resultado: " + resultado);
    	} catch (ArithmeticException e) {
    		System.out.println("Operacion aritmetica no valida " + e.getMessage());
    		LOGGER.log(Level.WARNING, "Division entre cero.");
    	}

    	} while (menu.repetir());
   	}
}