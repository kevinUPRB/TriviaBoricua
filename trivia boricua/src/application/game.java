package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class game extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					game frame = new game();
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
	public game() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JList listPlayers = new JList();
		listPlayers.setBounds(15, 86, 143, 143);

		//esto no va aqui
		DefaultListModel modelo = new DefaultListModel();

		modelo.addElement(Name.playerName);

		listPlayers.setModel(modelo);

		contentPane.add(listPlayers);


		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPlayers.setBounds(46, 57, 67, 16);
		contentPane.add(lblPlayers);

		JButton btnPlay = new JButton("Play");
		btnPlay.setEnabled(false);
		btnPlay.setBounds(37, 242, 97, 25);
		contentPane.add(btnPlay);
		
		JLabel lblTriviaBoricua = new JLabel("Trivia Boricua");
		lblTriviaBoricua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTriviaBoricua.setBounds(511, 46, 143, 39);
		contentPane.add(lblTriviaBoricua);
		
		JPanel panelJuego = new JPanel();
		panelJuego.setBounds(247, 98, 650, 304);
		panelJuego.setBorder(BorderFactory.createTitledBorder(""));
		contentPane.add(panelJuego);
		panelJuego.setLayout(null);
		
		ButtonGroup radioButtons = new ButtonGroup();
		
		JRadioButton rdbtnRespuesta1 = new JRadioButton("New radio button");
		rdbtnRespuesta1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnRespuesta1.setBounds(42, 72, 596, 25);
		panelJuego.add(rdbtnRespuesta1);
		
		JRadioButton rdbtnRespuesta2 = new JRadioButton("New radio button");
		rdbtnRespuesta2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnRespuesta2.setBounds(42, 112, 600, 25);
		panelJuego.add(rdbtnRespuesta2);
		
		JRadioButton rdbtnRespuesta3 = new JRadioButton("New radio button");
		rdbtnRespuesta3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnRespuesta3.setBounds(42, 153, 596, 25);
		panelJuego.add(rdbtnRespuesta3);
		
		JRadioButton rdbtnRespuesta4 = new JRadioButton("New radio button");
		rdbtnRespuesta4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnRespuesta4.setBounds(42, 190, 596, 25);
		panelJuego.add(rdbtnRespuesta4);
		
		//grupo de los botones
		radioButtons.add(rdbtnRespuesta1);
		radioButtons.add(rdbtnRespuesta2);
		radioButtons.add(rdbtnRespuesta3);
		radioButtons.add(rdbtnRespuesta4);
		
		JLabel lblPregunta = new JLabel("Pregunta");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPregunta.setBounds(42, 13, 596, 25);
		panelJuego.add(lblPregunta);
		
		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGo.setBounds(285, 266, 97, 25);
		panelJuego.add(btnGo);
	}
}
