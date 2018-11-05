import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Timer_GUI extends JFrame {

	private JPanel contentPane;
	int i = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Timer_GUI frame = new Timer_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Timer_GUI() {
		setTitle("Timer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel secs = new JLabel("0");
		secs.setBounds(155, 91, 46, 14);
		contentPane.add(secs);
		
		Timer tm = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				secs.setText(Integer.toString(i));
				i++;
	
			}
		});
		
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tm.start();
			}
		});
		startButton.setBounds(36, 120, 89, 23);
		contentPane.add(startButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tm.stop();
			}
		});
		stopButton.setBounds(135, 120, 89, 23);
		contentPane.add(stopButton);
		
		JLabel secLabel = new JLabel("Seconds");
		secLabel.setBounds(145, 66, 55, 14);
		contentPane.add(secLabel);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				tm.stop();
				i = 0;
				secs.setText(Integer.toString(i));
				i++;
				
			}
		});
		resetButton.setBounds(234, 120, 89, 23);
		contentPane.add(resetButton);
		
		
	}
}
