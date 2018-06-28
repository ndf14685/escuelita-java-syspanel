package escuelita.java.DTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import escuelita.java.DTO.PacienteHospitalMunizDTO;
import escuelita.java.operadores.Operadores;

public class PacienteHospitalMuñiz {
	
	public static final int QUANTITY_ANTECEDENT= 3;
	
	static PacienteHospitalMunizDTO [] formPatient = new PacienteHospitalMunizDTO[20];
	
	private static void LoadFileHospital (String routeTxtOperator )
	{
		//Operadores.RouteTxtOperator = routeTxtOperator;
		int lenghtFile;
		File file = new File(routeTxtOperator);
		try 
		{
			lenghtFile	= GetLenghtFile(file);
			LoadPatient(lenghtFile,file);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void LoadPatient(int lenghtArray, File HospitalFile) throws IOException
	{
		String lineRead;
		String idPatient;
		String dateDeparture;
		String [] antecedent = new String[QUANTITY_ANTECEDENT];
		String noteDoctor;
		int count=0;
		for (int i = 0; i < formPatient.length; i++) {
			formPatient[i]= new PacienteHospitalMunizDTO();
		}
		FileReader Fr = new FileReader(HospitalFile);
		BufferedReader Br = new BufferedReader(Fr);
		while((lineRead = Br.readLine())!=null)
		{
			//formPatient[count]= new PacienteHospitalMunizDTO();
			formPatient[count].setId(lineRead.substring(0, 9));
			formPatient[count].setFechaAlta(lineRead.substring(9, 19));
			antecedent[0]=lineRead.substring(19, 39);
			antecedent[1]=lineRead.substring(39, 59);
			antecedent[2]=lineRead.substring(59, 79);
			formPatient[count].setAntecendente(antecedent);
			formPatient[count].setNotasDoctor(lineRead.substring(79, 178));
			System.out.println(lineRead.substring(0, 9));
			System.out.println(lineRead.substring(9, 19));
			System.out.println(lineRead.substring(19, 39));
			System.out.println(lineRead.substring(39, 59));
			System.out.println(lineRead.substring(59, 79));
			System.out.println(lineRead.substring(79, 178));	
			count++;
		}
		Br.close();
		
	}
	
	private static int GetLenghtFile(File HospitalFile) throws IOException, FileNotFoundException
	{	
		int lenghtFile=0;
		String lineRead;
		FileReader Fr = new FileReader(HospitalFile);
		BufferedReader Br = new BufferedReader(Fr);
		while((lineRead = Br.readLine())!=null) {
			lenghtFile++;
	    	}
		Br.close();
		return lenghtFile;
	}
	
	
	public static void main(String[] args) {
		LoadFileHospital("C:/Users/usuario/Desktop/HospitalMuniz.txt");	
	}
}

