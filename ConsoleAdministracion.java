import java.util.Scanner;
import java.io.*;


public class ConsoleAdministracion {
	
	public static void StringPosicion(int size, String texto)
	{
		int left = size/2;
		int right = left;
		String format = "%" + left + "s%-" + right + "s"+ "%n";
		System.out.printf(format,"", texto);
	}
	public static  void EspacioEjeY(int espacio)
	{
		for(int i=0 ; i<=espacio; i++)
		{
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
	//	Console console = System.console();
		Scanner scanner = new Scanner(System.in);
		String usuario;
		String clave= "AguanteJava";
		String hola ="2";
		StringPosicion(18,"Programa Nacional de Sistematizacion de Procedimientos en Hospitales");
		System.out.flush();
		StringPosicion(50,"Bienvenido a la Consola de Administración");
		EspacioEjeY(2);
		StringPosicion(2,"Ingrse su Usuario");
		//System.out.println("Programa Nacional de Sistematizacion de Procedimientos en Hospitales");
		//System.out.println("Bienvenido a la Consola de Administración");
		//System.out.println("Ingrese su Usuario");
		usuario = scanner.nextLine();
		EspacioEjeY(1);
		StringPosicion(2,"Hola " + usuario );
		//System.out.close(); cierra la terminal
		//System.out.flush();
		EspacioEjeY(1);
		StringPosicion(2,"Ingrese la contraseña");	
	//	char [] prueba = console.readPassword("Password:");
		if(scanner.nextLine().equals(clave))
		{
			EspacioEjeY(2);
			StringPosicion(60,"La clave es correcta");
			
		}
		else
		{
			EspacioEjeY(2);
			StringPosicion(80,"Error");
		}
	
		System.exit(0);
		
	}

}
