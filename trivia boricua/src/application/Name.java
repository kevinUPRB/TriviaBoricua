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
import java.awt.event.ActionEvent;

public class Name extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static String playerName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
				
				queue q = new queue();
				q.setVisible(true);
				q.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(156, 156, 97, 25);
		contentPane.add(btnNewButton);
	}

}
