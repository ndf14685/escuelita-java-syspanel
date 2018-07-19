package escuelita.java.operadores;
import java.io.*;
import escuelita.java.DTO.PacienteHospitalMunizDTO;;


public class Operadores {

	public static String routeTxtOperator;
	public static int lenghtFile=0;
	public static final int POSITION_ID = 0;
	public static File file;
	public static String lineRead;
	public static String[] takenOperator; //cambiar el nombre de esta variable
	
	public Operadores (String RouteTxtOperator )
	{
		Operadores.routeTxtOperator = RouteTxtOperator;
		file = new File(routeTxtOperator);
		try {
			GetLenghtFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void GetLenghtFile() throws IOException, FileNotFoundException
	{	
		FileReader Fr = new FileReader(file);
		BufferedReader Br = new BufferedReader(Fr);
		while((lineRead = Br.readLine())!=null) {
			lenghtFile++;
	    	}
		Br.close();
	}
	public String [] GetIds() throws FileNotFoundException, IOException
	{
		String [] TakenIdArray;
		FileReader Fr = new FileReader(file);
		BufferedReader Br = new BufferedReader(Fr);
		TakenIdArray = new String [lenghtFile];
		for (int i = 0; (lineRead = Br.readLine())!=null; i++) {
			takenOperator = lineRead.split(",");
			TakenIdArray[i] = takenOperator[POSITION_ID];
			
		}
	    Br.close();
	    return TakenIdArray;
	}
	public String [] DataByIds(String Id) throws FileNotFoundException, IOException
	{
		
		FileReader Fr = new FileReader(file);
		BufferedReader Br = new BufferedReader(Fr);
		while((lineRead = Br.readLine())!=null) {
			takenOperator = lineRead.split(",");
			//TakenOperator = LineRead.split(",", 4)
			if(takenOperator[POSITION_ID].equals(Id))
			{
				Br.close();
				return takenOperator;
			}
	    }
		
		Br.close();
		return null;
	}
	public void ShowByConsole() throws FileNotFoundException, IOException
	{
		FileReader Fr = new FileReader(file);
		BufferedReader Br = new BufferedReader(Fr);
		while((lineRead = Br.readLine())!=null) {
			System.out.println(lineRead);
	    	}
		
		Br.close();
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
	/*	Operadores Op = new Operadores("C:/Users/usuario/eclipse-workspace/escuelita.java.operadores/Formulario.txt");
		try {
			String [] example = Op.GetIds();
			for (int i = 0; i < example.length; i++) {
				System.out.println(example[i]);
			}
			example = Op.DataByIds("3");
			System.out.println(example[1]);
			Op.ShowByConsole();
		} catch (Exception e) {
			// TODO: handle exception
		}*/
	}
}
