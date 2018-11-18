package application;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Name extends JFrame {

	private JPanel contentPane;
	private static JTextField textField;
	public static String playerName;
	private static BufferedReader in;
	private static PrintWriter out;
	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws UnknownHostException, IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Name frame = new Name();
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
	public Name() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayerName = new JLabel("Player Name:");
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayerName.setBounds(33, 89, 131, 16);
		contentPane.add(lblPlayerName);
		
		textField = new JTextField();
		textField.setBounds(148, 88, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = textField.getText();
				System.out.println(playerName + " : "+ Cliente.player);
				
				game q = null;
				try {
					q = new game();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				q.setVisible(true);
				q.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(156, 156, 97, 25);
		contentPane.add(btnNewButton);
	}

}
