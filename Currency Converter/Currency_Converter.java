import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Currency_Converter {

	private JFrame frame;
	private JTextField First_Currency_To_Convert;
	double FirstValue, Result;
	private JTextField Converted_Currency;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Currency_Converter window = new Currency_Converter();
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
	public Currency_Converter() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Creates Frame
		frame = new JFrame("Currency Converter");
		frame.setBounds(100, 100, 379, 298);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//This is the Converting label
		JLabel Label_Converting = new JLabel("Converting");
		Label_Converting.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Label_Converting.setBounds(30, 50, 100, 20);
		frame.getContentPane().add(Label_Converting);
		
		//This is the textbox where the first currency you are trying to convert goes
		First_Currency_To_Convert = new JTextField();
		First_Currency_To_Convert.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		First_Currency_To_Convert.setBounds(115, 50, 100, 20);
		frame.getContentPane().add(First_Currency_To_Convert);
		First_Currency_To_Convert.setColumns(10);
		
		//This is the first dropbox of currencies
		JComboBox currenciesList = new JComboBox();
		currenciesList.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		currenciesList.addItem("U.S. Dollar");
		currenciesList.addItem("Europeon Euro");
		currenciesList.addItem("British Pound");
		currenciesList.setBounds(225, 50, 100, 20);
		frame.getContentPane().add(currenciesList);
		
		//This is the To label
		JLabel lblTo = new JLabel("To");
		lblTo.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblTo.setBounds(150, 92, 35, 25);
		frame.getContentPane().add(lblTo);
		
		//This is the second dropbox of currencies
		JComboBox currenciesList2 = new JComboBox();
		currenciesList2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		currenciesList2.addItem("U.S. Dollar");
		currenciesList2.addItem("Europeon Euro");
		currenciesList2.addItem("British Pound");
		currenciesList2.setBounds(225, 100, 100, 20);
		frame.getContentPane().add(currenciesList2);
		
		//This is the convert btn
		JButton btnConvert = new JButton("Convert");
		btnConvert.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String Convertion;
				FirstValue = Double.parseDouble(First_Currency_To_Convert.getText());
				String FirstCurrency = (String)currenciesList.getSelectedItem();
				String SecondCurrency = (String)currenciesList2.getSelectedItem();
				
				if(FirstCurrency == "U.S. Dollar" && SecondCurrency == "U.S. Dollar")
				{
					Result = FirstValue * 1;
					Convertion = Double.toString(Result);
					Converted_Currency.setText("$" + Convertion);
				}
				else if(FirstCurrency == "U.S. Dollar" && SecondCurrency == "Europeon Euro")
				{
					Result = FirstValue * .8695;
					Convertion = Double.toString(Result);
					Convertion = String.format("%.2f", Result);
					Converted_Currency.setText("€" + Convertion);
				}
				else if(FirstCurrency == "U.S. Dollar" && SecondCurrency == "British Pound")
				{
					Result = FirstValue * .7803;
					Convertion = Double.toString(Result);
					Convertion = String.format("%.2f", Result);
					Converted_Currency.setText("£" + Convertion);
				}
				else if(FirstCurrency == "Europeon Euro" && SecondCurrency == "U.S. Dollar")
				{
					Result = FirstValue * 1.1502;
					Convertion = Double.toString(Result);
					Convertion = String.format("%.2f", Result);
					Converted_Currency.setText("$" + Convertion);
				}
				else if(FirstCurrency == "Europeon Euro" && SecondCurrency == "Europeon Euro")
				{
					Result = FirstValue * 1;
					Convertion = Double.toString(Result);
					Convertion = String.format("%.2f", Result);
					Converted_Currency.setText("€" + Convertion);
				}
				else if(FirstCurrency == "Europeon Euro" && SecondCurrency == "British Pound")
				{
					Result = FirstValue * .8975;
					Convertion = Double.toString(Result);
					Convertion = String.format("%.2f", Result);
					Converted_Currency.setText("£" + Convertion);
				}
				else if(FirstCurrency == "British Pound" && SecondCurrency == "U.S. Dollar")
				{
					Result = FirstValue * 1.2815;
					Convertion = Double.toString(Result);
					Convertion = String.format("%.2f", Result);
					Converted_Currency.setText("$" + Convertion);
				}
				else if(FirstCurrency == "British Pound" && SecondCurrency == "Europeon Euro")
				{
					Result = FirstValue * 1.1142;
					Convertion = Double.toString(Result);
					Convertion = String.format("%.2f", Result);
					Converted_Currency.setText("€" + Convertion);
				}
				else if(FirstCurrency == "British Pound" && SecondCurrency == "British Pound")
				{
					Result = FirstValue * 1;
					Convertion = Double.toString(Result);
					Convertion = String.format("%.2f", Result);
					Converted_Currency.setText("£" + Convertion);
				}
				
			}
		});
		btnConvert.setBounds(115, 150, 100, 20);
		frame.getContentPane().add(btnConvert);
		
		//This is the textbox for when the currency is converted
		Converted_Currency = new JTextField();
		Converted_Currency.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		Converted_Currency.setBounds(115, 200, 100, 20);
		frame.getContentPane().add(Converted_Currency);
		Converted_Currency.setColumns(10);
		
	}
}
