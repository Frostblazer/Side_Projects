import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	
	double firstNum;
	double secondNum;
	double result;
	String operations;
	String answer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frame.setBounds(100, 100, 277, 412);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creating Textfield
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 26));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(10, 11, 242, 51);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		//Row 1
		
		//Creating button back
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String back = null;
				
				if(textField.getText().length()>0){
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length()-1);
					back = strB.toString();
					textField.setText(back);
				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBounds(15, 73, 50, 50);
		frame.getContentPane().add(btnBack);
				
		//Creating button clear
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnClear.setBounds(75, 73, 50, 50);
		frame.getContentPane().add(btnClear);
				
		//Creating button %
		JButton btnPer = new JButton("%");
		btnPer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "%";
			}
		});
		btnPer.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPer.setBounds(135, 73, 50, 50);
		frame.getContentPane().add(btnPer);
						
		//Creating button +
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "+";
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnPlus.setBounds(195, 73, 50, 50);
		frame.getContentPane().add(btnPlus);
		
		//Row 2
		
		//Creating button 7
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String EnterNumber = textField.getText() + btn7.getText();
				textField.setText(EnterNumber);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn7.setBounds(15, 133, 50, 50);
		frame.getContentPane().add(btn7);
		
		//Creating button 8
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn8.getText();
				textField.setText(EnterNumber);
			}
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn8.setBounds(75, 133, 50, 50);
		frame.getContentPane().add(btn8);
		
		//Creating button 9
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn9.getText();
				textField.setText(EnterNumber);				
			}
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn9.setBounds(135, 133, 50, 50);
		frame.getContentPane().add(btn9);
				
		//Creating button -
		JButton btnSub = new JButton("-");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "-";
			}
		});
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnSub.setBounds(195, 133, 50, 50);
		frame.getContentPane().add(btnSub);
		
		//Row 3
		
		//Creating button 4
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn4.getText();
				textField.setText(EnterNumber);
			}
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn4.setBounds(15, 193, 50, 50);
		frame.getContentPane().add(btn4);
				
		//Creating button 5
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn5.getText();
				textField.setText(EnterNumber);
			}
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn5.setBounds(75, 193, 50, 50);
		frame.getContentPane().add(btn5);
				
		//Creating button 6
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn6.getText();
				textField.setText(EnterNumber);
			}
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn6.setBounds(135, 193, 50, 50);
		frame.getContentPane().add(btn6);
						
		//Creating button *
		JButton btnMult = new JButton("*");
		btnMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "*";
			}
		});
		btnMult.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnMult.setBounds(195, 193, 50, 50);
		frame.getContentPane().add(btnMult);
		
		//Row 4
		
		//Creating button 1
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn1.getText();
				textField.setText(EnterNumber);
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn1.setBounds(15, 253, 50, 50);
		frame.getContentPane().add(btn1);
				
		//Creating button 2
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn2.getText();
				textField.setText(EnterNumber);
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn2.setBounds(75, 253, 50, 50);
		frame.getContentPane().add(btn2);
				
		//Creating button 3
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn3.getText();
				textField.setText(EnterNumber);
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn3.setBounds(135, 253, 50, 50);
		frame.getContentPane().add(btn3);
						
		//Creating button /
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				firstNum = Double.parseDouble(textField.getText());
				textField.setText("");
				operations = "/";
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnDiv.setBounds(195, 253, 50, 50);
		frame.getContentPane().add(btnDiv);
		
		//Row 5
		
		//Creating button 0
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btn0.getText();
				textField.setText(EnterNumber);
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 24));
		btn0.setBounds(15, 313, 50, 50);
		frame.getContentPane().add(btn0);
				
		//Creating button Dec
		JButton btnDec = new JButton(".");
		btnDec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String EnterNumber = textField.getText() + btnDec.getText();
				textField.setText(EnterNumber);
			}
		});
		btnDec.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDec.setBounds(75, 313, 50, 50);
		frame.getContentPane().add(btnDec);
				
		//Creating button +/-
		JButton btnPM = new JButton("+/-");
		btnPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = ops * (-1);
				textField.setText(String.valueOf(ops));
			}
		});
		btnPM.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnPM.setBounds(135, 313, 50, 50);
		frame.getContentPane().add(btnPM);
						
		//Creating button equals
		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String answer;
				secondNum = Double.parseDouble(textField.getText());
				if(operations == "+")
				{
					result = firstNum + secondNum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operations == "-")
				{
					result = firstNum - secondNum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operations == "*")
				{
					result = firstNum * secondNum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operations == "/")
				{
					result = firstNum / secondNum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				else if(operations == "%")
				{
					result = firstNum % secondNum;
					answer = String.format("%.2f", result);
					textField.setText(answer);
				}
				
			}
		});
		btnEquals.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnEquals.setBounds(195, 313, 50, 50);
		frame.getContentPane().add(btnEquals);
		
	}
}
