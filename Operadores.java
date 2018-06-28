package escuelita.java.operadores;
import java.io.*;
import escuelita.java.DTO.PacienteHospitalMunizDTO;;


public class Operadores {

	public static String RouteTxtOperator;
	public static int LenghtFile=0;
	public static final int POSITION_ID = 0;
	public static File File;
	public static String LineRead;
	public static String[] TakenOperator; //cambiar el nombre de esta variable
	
	public Operadores (String routeTxtOperator )
	{
		Operadores.RouteTxtOperator = routeTxtOperator;
		File = new File(RouteTxtOperator);
		try {
			GetLenghtFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void GetLenghtFile() throws IOException, FileNotFoundException
	{	
		FileReader Fr = new FileReader(File);
		BufferedReader Br = new BufferedReader(Fr);
		while((LineRead = Br.readLine())!=null) {
			LenghtFile++;
	    	}
		Br.close();
	}
	public String [] GetIds() throws FileNotFoundException, IOException
	{
		String [] TakenIdArray;
		FileReader Fr = new FileReader(File);
		BufferedReader Br = new BufferedReader(Fr);
		TakenIdArray = new String [LenghtFile];
		for (int i = 0; (LineRead = Br.readLine())!=null; i++) {
			TakenOperator = LineRead.split(",");
			TakenIdArray[i] = TakenOperator[POSITION_ID];
			
		}
	    Br.close();
	    return TakenIdArray;
	}
	public String [] DataByIds(String Id) throws FileNotFoundException, IOException
	{
		
		FileReader Fr = new FileReader(File);
		BufferedReader Br = new BufferedReader(Fr);
		while((LineRead = Br.readLine())!=null) {
			TakenOperator = LineRead.split(",");
			//TakenOperator = LineRead.split(",", 4)
			if(TakenOperator[POSITION_ID].equals(Id))
			{
				Br.close();
				return TakenOperator;
			}
	    }
		
		Br.close();
		return null;
	}
	public void ShowByConsole() throws FileNotFoundException, IOException
	{
		FileReader Fr = new FileReader(File);
		BufferedReader Br = new BufferedReader(Fr);
		while((LineRead = Br.readLine())!=null) {
			System.out.println(LineRead);
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
