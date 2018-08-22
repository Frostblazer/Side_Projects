import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;

public class Password_Generator {

	private JFrame frame;
	private JTextField password_length;
	private JTextField password_generated;
	private String char_list = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
	private int string_length;
	private String Password = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Password_Generator window = new Password_Generator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Password_Generator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Password Generator");
		frame.setBounds(100, 100, 360, 304);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creates a label
		JLabel Label = new JLabel("Enter the length of password");
		Label.setBounds(23, 71, 189, 35);
		frame.getContentPane().add(Label);
		
		//Creates the password_length textbox
		password_length = new JTextField();
		password_length.setBounds(207, 78, 86, 20);
		frame.getContentPane().add(password_length);
		password_length.setColumns(10);
		
		//Creates the Generate Password button
		JButton Generatebtn = new JButton("Generate Password");
		Generatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//Resets the password_length to a clear textbox 
				Password = "";
				password_generated.setText(Password.toString());
				string_length = Integer.parseInt(password_length.getText());
				
				//Create instance of SecureRandom class
				SecureRandom number = new SecureRandom();
				
				//Loop that loops through and creates a random character for each index of the password_length 
				for(int i = 0; i < string_length; i++)
					{
					// Generate random integers in range 0 to 70
						int randomNumber = number.nextInt(71);
						//Cuts the String char_list according to the random number generated and concatenates it to Password 
						if(randomNumber == 0)
							{
								Password += char_list.substring(0, 0);
							}
						else
							{
								Password += char_list.substring(randomNumber - 1, randomNumber);
							}
					}
				//Sets the newly created Password to the password_generated textbox
				password_generated.setText(Password.toString());
			}
		});
		Generatebtn.setBounds(79, 165, 167, 20);
		frame.getContentPane().add(Generatebtn);
		
		//Creates the password_generated textbox
		password_generated = new JTextField();
		password_generated.setBounds(79, 134, 167, 20);
		frame.getContentPane().add(password_generated);
		password_generated.setColumns(10);
		
		//Creates Clear Password Button
		JButton Clearbtn = new JButton("Clear Password");
		Clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Resets the generated password to a clear textbox
				Password = "";
				password_length.setText("");
				password_generated.setText(Password.toString());
			}
		});
		Clearbtn.setBounds(79, 196, 167, 20);
		frame.getContentPane().add(Clearbtn);
	}
}
