package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class queue extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					queue frame = new queue();
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
	public queue() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JList listPlayers = new JList();
		listPlayers.setBounds(149, 48, 143, 143);

		DefaultListModel modelo = new DefaultListModel();

		modelo.addElement(Name.playerName);

		listPlayers.setModel(modelo);

		contentPane.add(listPlayers);


		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayers.setBounds(187, 19, 67, 16);
		contentPane.add(lblPlayers);

		JButton btnPlay = new JButton("Play");
		btnPlay.setEnabled(false);
		btnPlay.setBounds(170, 215, 97, 25);
		contentPane.add(btnPlay);
	}
}
