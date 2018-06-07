import javax.swing.*;
import java.awt.event.*;
public class PanelDeAdministracion extends JFrame {
	

	private JButton button1;
	private JFrame windows;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JTextField textField2;
	private JTextField textField1;
	private JPanel panel;
	private static int numeroClave = 0;
	//private static String usuarioClave;
	private static String contrasena;
	private static String subString;
	private static String usuarioContrasena="";
	private static String usuario;
	private static String usuarioUsuario="";
	
	public PanelDeAdministracion(String Contrasena, String Usuario)
	{
		PanelDeAdministracion.usuario = Usuario;
		PanelDeAdministracion.contrasena = Contrasena;
		windows = new JFrame();
		label1 = new JLabel("Programa Nacional de Sistematizacion de Procedimientos en Hospitales");
		label2 = new JLabel("Bienvenido a la Consola de Administración");
		label3 = new JLabel("El usuario y/o contraseña es incorrecta");
		textField1 = new JTextField();
		textField2 = new JTextField();
		button1 = new JButton("Aceptar");
		label3.setVisible(false);
		button1.addActionListener(BotonPresionado(textField1,textField2,panel,label3));
		textField1.addMouseListener(LimpiarTexto(textField1));
		textField2.addMouseListener(LimpiarTexto(textField2));
		textField2.addKeyListener(ClaveOcultar(textField2));
		panel = new JPanel();
		panel.setLayout(null);
		label1.setBounds(30,5,450,30);
		label2.setBounds(105,35,300,20);
		label3.setBounds(125,100,300,20);
		textField1.setBounds(150,150,150,25);
		textField1.setText("Usuario");
		textField2.setBounds(150,200,150,25);
		textField2.setText("Contraseña");
		button1.setBounds(150, 250, 150, 25);
		panel.add(button1);
		panel.add(textField1);
		panel.add(textField2);
		panel.add(label2);
		panel.add(label1);
		panel.add(label3);
		windows.setContentPane(panel);
		windows.pack();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setSize(500,500);
		//windows.setVisible(true);
		windows.setTitle("Panel de Control");
		windows.setVisible(true);
	}
	
	public static ActionListener BotonPresionado(JTextField usuario, JTextField clave, JPanel panel, JLabel mensaje)
	{
		ActionListener evento;
		evento = new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						usuarioUsuario = usuario.getText();
						usuario.setText("");
						clave.setText("");
						if(Revisar())
						{
							System.exit(0);
						}
						else
						{
							mensaje.setVisible(true);
						}
						usuarioContrasena="";
						usuarioUsuario="";
						numeroClave=0;
					}
				};
		return evento;
	}
	
	public static MouseListener LimpiarTexto(JTextField texto)
	{
		MouseListener evento;
		evento = new MouseListener()
				{

					@Override
					public void mouseClicked(MouseEvent e) {
						texto.setText("");
						
					}

					@Override
					public void mouseEntered(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseExited(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mousePressed(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void mouseReleased(MouseEvent e) {
						// TODO Auto-generated method stub
						
					}
				};
		return evento;
	}
	
	public static KeyListener ClaveOcultar(JTextField texto)
	{
		KeyListener evento;
		evento = new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) {
						//claveMostrar = claveMostrar+"*";
						//texto.setText(Integer.toString(a));
						
					}

					@Override
					public void keyReleased(KeyEvent e) {						
						System.out.println(e.getKeyCode());
						if(e.getKeyCode()>=48 && e.getKeyCode()<=90)
						{
							
							texto.setText("");
							texto.setText(OcultarContraseña());
							usuarioContrasena += Character.toString(e.getKeyChar());
						}
						else if(e.getKeyCode()==8)
						{
							try
							{
								//Terminar de resolver esto problema al borrar 
								numeroClave = numeroClave<=0? 0: numeroClave--;
								System.out.println(Integer.toString(usuarioContrasena.length()));
								subString = usuarioContrasena.length()>=0? usuarioContrasena.substring(0,usuarioContrasena.length()-1):"";
								usuarioContrasena= subString;
							}
							catch(Exception e1)
							{
								System.out.println(e1.getMessage());
							}
						}
						
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				};
		
		return evento;
	}
	public static String OcultarContraseña()
	{
		numeroClave++;
		String claveOculta = "";
		for (int i = 0; i < numeroClave; i++) 
		{
			claveOculta+="*";
		}
		return claveOculta;
		
	}
	
	
	public static Boolean Revisar()
	{
		System.out.println(usuarioContrasena);
		System.out.println(contrasena);
		Boolean comparacionClave = usuarioContrasena.equals(contrasena)?true:false;
		Boolean comparacionUsuario = usuarioUsuario.equals(usuario)?true:false;
		return (comparacionClave && comparacionUsuario);
	}
	public static void main(String[] args) 
	{
		new PanelDeAdministracion("AguanteJava","Francisco");
	}
}
