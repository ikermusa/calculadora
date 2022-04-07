package principal;
import menu.Menu;
import operaciones.Operaciones;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
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
	private static final LogManager logManager = LogManager.getLogManager();
	private static final Logger LOGGER = Logger.getLogger("confLogger");

	static {

		try {

			logManager.readConfiguration(new FileInputStream("./configuracion/configLognulo.properties"));

		}

		catch (IOException exception) {

			LOGGER.log(Level.SEVERE, "Error al cargar la configuracion.", exception);
		}
	}
	
	
	
    public static void main(String[] args) {
    	
    	configurarLog();
    	
    	int resultado = 0;
    	String operacion = "";
    	int[] operandos = new int[2];
    	Menu menu = new Menu();
    	Operaciones operaciones = new Operaciones();
    	
       
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
    
    public static void configurarLog() {
    	LOGGER.setUseParentHandlers(false);

    	Handler fileHandler = null;
    	Handler consoleHandler  = new ConsoleHandler();
    	
    	//si no consigue meter en la ruta lanza error en consola
    	try {
    	fileHandler  = new FileHandler("./operaciones.log");;
    	}catch(IOException exception){
    	       LOGGER.log(Level.SEVERE, "Ocurrio un error en FileHandler.", exception);
    	   }

    	//Asignar handlers al objeto LOGGER
    	LOGGER.addHandler(consoleHandler);
    	LOGGER.addHandler(fileHandler);

    	//Establecer niveles a handlers y LOGGER
    	consoleHandler.setLevel(Level.WARNING);
    	fileHandler.setLevel(Level.FINE);
    	LOGGER.setLevel(Level.FINE);
    }
    
}