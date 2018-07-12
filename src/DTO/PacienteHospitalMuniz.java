package escuelita.java.DTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import escuelita.java.DTO.PacienteHospitalMunizDTO;

public class PacienteHospitalMuniz {
	
	public static final int QUANTITY_ANTECEDENT= 3;
	public static final int START_READ_ID= 0;
	public static final int END_READ_ID= 9;
	public static final int START_READ_DATE_OUTPUT= 9;
	public static final int END_READ_DATE_OUTPUT= 19;
	public static final int START_READ_ANTECEDENT_1= 19;
	public static final int END_READ_ANTECEDENT_1= 39;
	public static final int START_READ_ANTECEDENT_2= 39;
	public static final int END_READ_ANTECEDENT_2= 59;
	public static final int START_READ_ANTECEDENT_3= 59;
	public static final int END_READ_ANTECEDENT_3= 79;
	public static final int START_READ_DOCTOR_NOTES= 79;
	public static final int END_READ_DOCTOR_NOTES= 178;
	
	static PacienteHospitalMunizDTO [] formPatient ;
	
	
	public PacienteHospitalMuniz(String routeTxtData)
	{
		LoadFileHospital(routeTxtData);	     
		//"C:/Users/usuario/Desktop/HospitalMuniz.txt"
	}
	
	private static void LoadFileHospital (String routeTxtData )
	{
		//Operadores.RouteTxtOperator = routeTxtOperator;
		int lenghtFile;
		File file = new File(routeTxtData);
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
		String [] antecedent = new String[QUANTITY_ANTECEDENT];
		int count=0;
		formPatient= new PacienteHospitalMunizDTO[lenghtArray];
		for (int i = 0; i < formPatient.length; i++) {
			formPatient[i]= new PacienteHospitalMunizDTO();
		}
		FileReader Fr = new FileReader(HospitalFile);
		BufferedReader Br = new BufferedReader(Fr);
		while((lineRead = Br.readLine())!=null)
		{
			SetClinicalHistory(Br, count, lineRead,antecedent);
			count++;
		}
		Br.close();
		
	}
	
	
	private static void SetClinicalHistory(BufferedReader Br, int index, String lineRead, String [] antecedent )
	{
		formPatient[index].setId(lineRead.substring(START_READ_ID, END_READ_ID));
		formPatient[index].setFechaAlta(lineRead.substring(START_READ_DATE_OUTPUT, END_READ_DATE_OUTPUT));
		antecedent[0]=lineRead.substring(START_READ_ANTECEDENT_1, END_READ_ANTECEDENT_1);
		antecedent[1]=lineRead.substring(START_READ_ANTECEDENT_2, END_READ_ANTECEDENT_2);
		antecedent[2]=lineRead.substring(START_READ_ANTECEDENT_3, END_READ_ANTECEDENT_3);
		formPatient[index].setAntecendente(antecedent);
		formPatient[index].setNotasDoctor(lineRead.substring(START_READ_DOCTOR_NOTES, END_READ_DOCTOR_NOTES));	
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
	
	public PacienteHospitalMunizDTO GetPatient(int index)
	{
		return formPatient[index];
		
	}
	
	public static void main(String[] args) {
		
		PacienteHospitalMuniz hospitalMuniz = new PacienteHospitalMuniz("C:/Users/usuario/Desktop/HospitalMuniz.txt");
		System.out.println(formPatient[1].getFechaAlta());
		System.out.println(hospitalMuniz.GetPatient(2).getFechaAlta());
	}
	
}

