package classicRoshambo;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ClassicGUI {

	private JFrame frame;
	private JTextField playerChoice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClassicGUI window = new ClassicGUI();
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
	public ClassicGUI() {
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JLabel labelTitle = new JLabel("Welcome to Roshambo!");
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setBounds(10, 10, 416, 55);
		frame.getContentPane().add(labelTitle);
		
		JLabel labelPlayerChoice = new JLabel("Player Choice\r\n");
		labelPlayerChoice.setHorizontalAlignment(SwingConstants.CENTER);
		labelPlayerChoice.setBounds(10, 75, 187, 37);
		frame.getContentPane().add(labelPlayerChoice);
		
		JLabel labelCpuChoice = new JLabel("CPU Choice");
		labelCpuChoice.setHorizontalAlignment(SwingConstants.CENTER);
		labelCpuChoice.setBounds(230, 75, 167, 40);
		frame.getContentPane().add(labelCpuChoice);
		
		playerChoice = new JTextField();
		playerChoice.setBounds(54, 122, 96, 19);
		frame.getContentPane().add(playerChoice);
		playerChoice.setColumns(10);
		
		
		
		JTextArea cpuChoiceOutput = new JTextArea();
		cpuChoiceOutput.setBounds(270, 125, 96, 22);
		frame.getContentPane().add(cpuChoiceOutput);
		
		JButton buttonBattle = new JButton("Battle!");
		buttonBattle.setBounds(170, 153, 85, 21);
		frame.getContentPane().add(buttonBattle);
			
		
		JTextArea outputResult = new JTextArea("Winner:");
		outputResult.setBounds(117, 184, 205, 37);
		frame.getContentPane().add(outputResult);
		
		JButton buttonClear = new JButton("clear");
		buttonClear.setBounds(341, 232, 85, 21);
		frame.getContentPane().add(buttonClear);
	}

}
