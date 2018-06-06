import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PanelDeAdministracion extends JFrame {
	

	private JButton button1;
	private JFrame windows;
	private JLabel label1;
	private JLabel label2;
	private JTextField textField2;
	private JTextField textField1;
	private JPanel panel;
	
	public PanelDeAdministracion()
	{
		Object a = this;
		windows = new JFrame();
		label1 = new JLabel("Programa Nacional de Sistematizacion de Procedimientos en Hospitales");
		label2 = new JLabel("Bienvenido a la Consola de Administración");
		textField1 = new JTextField();
		textField2 = new JTextField();
		button1 = new JButton("Aceptar");
		button1.addActionListener(BotonPresionado(textField1,textField2));
		textField1.addMouseListener(LimpiarTexto(textField1));
		textField2.addMouseListener(LimpiarTexto(textField2));
		textField2.addKeyListener(ClaveOcultar(textField2));
		panel = new JPanel();
		panel.setLayout(null);
		label1.setBounds(30,5,450,30);
		label2.setBounds(105,35,300,20);
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
		windows.setContentPane(panel);
		windows.pack();
		windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		windows.setSize(500,500);
		//windows.setVisible(true);
		windows.setTitle("Panel de Control");
		windows.setVisible(true);
	}
	
	public static ActionListener BotonPresionado(JTextField usuario, JTextField clave)
	{
		ActionListener evento;
		evento = new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent arg0) {
						usuario.setText("");
						clave.setText("");
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
		String claveMostrar;
		String claveOcultar;
		KeyListener evento;
		evento = new KeyListener()
				{

					@Override
					public void keyPressed(KeyEvent e) {
						//claveMostrar = claveMostrar+"*";
						texto.setText(Integer.toString(a));
						
					}

					@Override
					public void keyReleased(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						// TODO Auto-generated method stub
						
					}
				};
		
		return evento;
	}
	public static void main(String[] args) 
	{
		PanelDeAdministracion windows = new PanelDeAdministracion();
	}
}
