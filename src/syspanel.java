import java.util.Scanner;

	public class syspanel {

		public static void main(String[] args) {		
			String usr,pass;
			Scanner in = new Scanner(System.in);
			
			System.out.println("Programa Nacional de Sistematizacion de Procedimientos en Hospitales");
			System.out.println("Bienvenido a la Consola de Administración\n");
			
			System.out.print("Ingrese usuario: ");
			usr = in.next();
			System.out.println("\nHola "+usr);
			
			System.out.print("Ingrese Clave  : ");
			pass = in.next();
			
			if (pass.equals("AguanteJava"))
			{
				System.out.print("Mensaje de exito.");
				
			} else
			{
				System.out.print("Mensaje de error.");
			}
		}

	}

