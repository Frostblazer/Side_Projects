import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.awt.event.ActionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.JScrollPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public class Password_Manager {

	private JFrame frame;
	private JTextField enterUsername;
	private JTextField searchPassword;
	private JTextField updatePassword;
	private JTextField deletePassword;
	private JTextField enterPassword;
	private JTextField searchUsername;
	private JTextField updateUsername;
	private JTextField deleteUsername;
	private JTextField searchWebsite;
	private JTextField updateWebsite;
	private JTextField deleteWebsite;
	private JTextField enterWebsite;
	private JTextField return_password;
	private JLabel enter_username_label;
	private JLabel enter_password_label;
	private JLabel return_password_label;
	private JLabel update_password_label;
	private JLabel delete_password_label;
	private JLabel return_username_label;
	private JLabel update_username_label;
	private JLabel delete_username_label;
	private JButton search_username_password_website;
	private JButton update_username_password_website;
	private JButton delete_username_password_website;
	private JTabbedPane tabbedPane_1;
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
					Password_Manager window = new Password_Manager();
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
	public Password_Manager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Password Manager");
		frame.setBounds(100, 100, 310, 265);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(tabbedPane);
		
		//----------------Search Tab---------------------------//
		
		//Creates Search tab
		JPanel SearchTab = new JPanel();
		tabbedPane.addTab("Search", null, SearchTab, null);
		SearchTab.setLayout(null);
		
		//Creates label Search website
		JLabel return_website_label = new JLabel("Search Website");
		return_website_label.setBounds(49, 26, 118, 14);
		SearchTab.add(return_website_label);
		
		//Creates textfield for search website
		searchWebsite = new JTextField();
		searchWebsite.setBounds(166, 23, 86, 20);
		SearchTab.add(searchWebsite);
		searchWebsite.setColumns(10);
		
		//Creates label username
		JLabel lblNewLabel;
		return_username_label = new JLabel("Username");
		return_username_label.setBounds(49, 57, 107, 14);
		SearchTab.add(return_username_label);
		
		//Creates search username textfield
		searchUsername = new JTextField();
		searchUsername.setBounds(166, 54, 86, 20);
		SearchTab.add(searchUsername);
		searchUsername.setColumns(10);
		
		//Creates password label
		JLabel lblNewLabel_1;
		return_password_label = new JLabel("Password");
		return_password_label.setBounds(49, 88, 107, 14);
		SearchTab.add(return_password_label);
		
		//Creates password textfield
		searchPassword = new JTextField();
		searchPassword.setBounds(166, 85, 86, 20);
		SearchTab.add(searchPassword);
		searchPassword.setColumns(10);
		
		//Creates search button
		JButton btnNewButton;
		search_username_password_website = new JButton("Search");
		search_username_password_website.setBounds(166, 116, 86, 23);
		search_username_password_website.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String website;
				website = searchWebsite.getText();
				
				try
				{
					//Connects to database
					//Enter your connection url
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo?useSSL=false","root","password");
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT username, password from logininfo.userinfo where website =  '" + website +"';" );
					
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnsNumber = rsmd.getColumnCount();
					
					if (rs.next()) 
					{
						searchPassword.setText(rs.getString("password"));
					    searchUsername.setText(rs.getString("username"));
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
				
			}
		});
		SearchTab.add(search_username_password_website);
		
		//Creates Clear Password Button
		JButton Clearbtn = new JButton("Clear");
		Clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Resets the generated password to a clear textbox
				searchWebsite.setText("");
				searchUsername.setText("");
				searchPassword.setText("");
				
			}
		});
		Clearbtn.setBounds(166, 146, 86, 23);
		SearchTab.add(Clearbtn);
		
		//-------------------Create Tab--------------------------------
		
		//creates create tab
		JPanel CreateTab = new JPanel();
		tabbedPane.addTab("Create", null, CreateTab, null);
		CreateTab.setLayout(null);
		
		//creates enter the length of password label
		JLabel Label = new JLabel("Enter the length of password");
		Label.setBounds(21, 32, 189, 35);
		CreateTab.add(Label);
		
		//creates textfield for password length
		password_length = new JTextField();
		password_length.setBounds(192, 39, 86, 20);
		CreateTab.add(password_length);
		password_length.setColumns(10);
		
		//Creates the password_generated textbox
		password_generated = new JTextField();
		password_generated.setBounds(66, 78, 167, 20);
		CreateTab.add(password_generated);
		password_generated.setColumns(10);
		
		//creates button generate password
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
		Generatebtn.setBounds(66, 109, 167, 20);
		CreateTab.add(Generatebtn);
		
		//-----------------Enter Tab-----------------------------------
				
		//creates entertab
		JPanel EnterTab = new JPanel();
		tabbedPane.addTab("Enter", null, EnterTab, null);
		EnterTab.setLayout(null);
		
		//creates enter website label
		JLabel enter_website_label = new JLabel("Enter Website");
		enter_website_label.setBounds(49, 26, 86, 14);
		EnterTab.add(enter_website_label);
		
		//creates enter website textfield
		enterWebsite = new JTextField();
		enterWebsite.setBounds(166, 23, 86, 20);
		EnterTab.add(enterWebsite);
		enterWebsite.setColumns(10);
		
		//creates enter username label
		JLabel lblNewLabel_3;
		enter_username_label = new JLabel("Enter Username");
		enter_username_label.setBounds(49, 57, 107, 14);
		EnterTab.add(enter_username_label);
		
		//creates enter username textfield
		enterUsername = new JTextField();
		enterUsername.setBounds(166, 85, 86, 20);
		EnterTab.add(enterUsername);
		enterUsername.setColumns(10);
		
		//creates enter password label
		JLabel lblNewLabel_2;
		enter_password_label = new JLabel("Enter Password");
		enter_password_label.setBounds(49, 88, 107, 14);
		EnterTab.add(enter_password_label);
		
		//creates enter password textfield
		enterPassword = new JTextField();
		enterPassword.setBounds(166, 54, 86, 20);
		EnterTab.add(enterPassword);
		enterPassword.setColumns(10);
		
		//creates enter button
		JButton btnNewButton2 = new JButton("Enter");
		btnNewButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String website, username, password;
				website = enterWebsite.getText();
				username = enterUsername.getText();
				password = enterPassword.getText();
				
				try
				{
					//Connects to database
					//Enter your connection url
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo?useSSL=false","root","password");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("INSERT INTO logininfo.userinfo (website,username,password) VALUES ('"+website+"','"+username+"','"+password+"');" );
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
				//creates dialog message box that asks user do they what to clear text
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,"Infomation entered into database. Do you what to clear text?", "Successful", dialogButton);
				if(dialogButton == 0)
				{
					enterWebsite.setText("");
					enterUsername.setText("");
					enterPassword.setText("");
				}
				
				
			}
		});
		btnNewButton2.setBounds(166, 116, 86, 23);
		EnterTab.add(btnNewButton2);
		
		//Creates Clear Password Button
		JButton EnterClear = new JButton("Clear");
		EnterClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Resets the generated password to a clear textbox
				enterWebsite.setText("");
				enterUsername.setText("");
				enterPassword.setText("");
			}
		});
		EnterClear.setBounds(166, 146, 86, 23);
		EnterTab.add(EnterClear);
	
		//---------------Update Tab----------------------------------
		
		//Creates update tab
		JPanel UpdateTab = new JPanel();
		tabbedPane.addTab("Update", null, UpdateTab, null);
		UpdateTab.setLayout(null);
		
		//creates update website label
		JLabel update_website_label = new JLabel("Update Website");
		update_website_label.setBounds(49, 26, 98, 14);
		UpdateTab.add(update_website_label);
		
		//creates update website textfield
		updateWebsite = new JTextField();
		updateWebsite.setBounds(166, 23, 86, 20);
		UpdateTab.add(updateWebsite);
		updateWebsite.setColumns(10);
		
		//creates update username label
		JLabel UpdateUsername;
		update_username_label = new JLabel("Update Username");
		update_username_label.setBounds(49, 57, 107, 14);
		UpdateTab.add(update_username_label);
		
		//creates update username textfield
		updateUsername = new JTextField();
		updateUsername.setBounds(166, 54, 86, 20);
		UpdateTab.add(updateUsername);
		updateUsername.setColumns(10);
		
		//creates update password label
		JLabel UpdatePassword;
		update_password_label = new JLabel("Update Password");
		update_password_label.setBounds(49, 88, 107, 14);
		UpdateTab.add(update_password_label);
		
		//creates update password textfield
		updatePassword = new JTextField();
		updatePassword.setBounds(166, 85, 86, 20);
		UpdateTab.add(updatePassword);
		updatePassword.setColumns(10);
		
		//creates update button
		JButton Update;
		update_username_password_website = new JButton("Update");
		update_username_password_website.setBounds(166, 116, 86, 23);
		update_username_password_website.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String website, username, password;
				website = updateWebsite.getText();
				username = updateUsername.getText();
				password = updatePassword.getText();
				
				try
				{
					//Connects to database
					//Enter your connection url
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo?useSSL=false","root","password");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("update logininfo.userinfo set username = '" + username +"', password = '" + password + "' where website ='" + website +"';");}
					
		
				catch(Exception e)
				{
					System.out.println(e);
				}
				
				//creates dialog message box that asks user do they what to clear text
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,"Infomation updated. Do you what to clear text?", "Successful", dialogButton);
				if(dialogButton == 0)
				{
					updateWebsite.setText("");
					updateUsername.setText("");
					updatePassword.setText("");
				}
				
				
			}
		});
		UpdateTab.add(update_username_password_website);
		
		
		//Creates Clear Password Button
		JButton UpdateClear = new JButton("Clear");
		UpdateClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Resets the generated password to a clear textbox
				updateWebsite.setText("");
				updateUsername.setText("");
				updatePassword.setText("");
			}
		});
		UpdateClear.setBounds(166, 146, 86, 23);
		UpdateTab.add(UpdateClear);
		
		//---------------Delete Tab-------------------------
		
		//creates delete tab
		JPanel DeleteTab = new JPanel();
		tabbedPane.addTab("Delete", null, DeleteTab, null);
		DeleteTab.setLayout(null);
		
		//creates delete website label
		JLabel delete_website_label = new JLabel("Delete Website");
		delete_website_label.setBounds(49, 26, 98, 14);
		DeleteTab.add(delete_website_label);
		
		//creates delete website textfield
		deleteWebsite = new JTextField();
		deleteWebsite.setBounds(166, 23, 86, 20);
		DeleteTab.add(deleteWebsite);
		deleteWebsite.setColumns(10);
		
		//creates delete button
		JButton Delete;
		delete_username_password_website = new JButton("Delete");
		delete_username_password_website.setBounds(107, 67, 86, 23);
		delete_username_password_website.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String website;
				website = deleteWebsite.getText();
				
				//creates message box that asks users are they sure they what to delete information
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null,"Are you sure you what to delete information?", "Successful", dialogButton);
				if(dialogButton == 0)
				{
				
					try
					{
					//Connects to database
					//Enter your connection url
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo?useSSL=false","root","password");
					Statement stmt = con.createStatement();
					stmt.executeUpdate("delete from logininfo.userinfo where website ='" + website + "';");}
					
		
					catch(Exception e)
					{
					System.out.println(e);
					}
					
					//creates message box that informs user the information was deleted and if they what to clear text
					int dialogButton2 = JOptionPane.YES_NO_OPTION;
					int dialogResult2 = JOptionPane.showConfirmDialog(null,"Information Deleted. Do you what to clear text?", "Successful", dialogButton2);
					if(dialogButton == 0)
					{
						deleteWebsite.setText("");
					}
					else
					{
						
					}
					
				}
				else 
				{
					
				}
				
				
			}
		});
		DeleteTab.add(delete_username_password_website);
		
		//Creates Clear Password Button
		JButton deleteClear = new JButton("Clear");
		deleteClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Resets the generated password to a clear textbox
				deleteWebsite.setText("");
			}
		});
		deleteClear.setBounds(107, 105, 86, 23);
		DeleteTab.add(deleteClear);
	}
}
