package application;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class game extends JFrame {

	private JPanel contentPane;
	ArrayList<String> preguntas = new ArrayList<String>();
	private String correctAns;//contestacion correcta
	public int count = 0;// counter respuestas correctas
	private int counter = 0;//counter preguntas

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
	 * @throws FileNotFoundException 
	 */
	public game() throws FileNotFoundException {
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

		if(modelo.getSize() > 1) {
			btnPlay.setEnabled(true);

			btnPlay.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					panelJuego.setBounds(247, 98, 650, 304);
					panelJuego.setBorder(BorderFactory.createTitledBorder(""));
					contentPane.add(panelJuego);
					panelJuego.setLayout(null);



				}
			});
		}

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
		rdbtnRespuesta1.setSelected(true);

		JLabel lblPregunta = new JLabel("Pregunta");
		lblPregunta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPregunta.setBounds(42, 13, 596, 25);
		panelJuego.add(lblPregunta);

		String[] setDePreguntas = splitPreguntas(preguntas);


		JButton btnGo = new JButton("Go");
		btnGo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnGo.setBounds(285, 266, 97, 25);
		panelJuego.add(btnGo);

		//Primera pregunta
		showQuestions(setDePreguntas, lblPregunta, rdbtnRespuesta1, rdbtnRespuesta2, rdbtnRespuesta3, rdbtnRespuesta4);


		//boton para las siguientes preguntas
		btnGo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				String userAns = radioButtons.getSelection().getActionCommand();//Button seleccionado

				//Compara la respuesta del usuario con la correcta.
				if(userAns.equals(correctAns)) {
					System.out.println(true);
					count++;// enviar al servidor
				}else {
					System.out.println(false);
				}

				//Segundo pregunta en adelante.
				showQuestions(setDePreguntas, lblPregunta, rdbtnRespuesta1, rdbtnRespuesta2, rdbtnRespuesta3, rdbtnRespuesta4);
				
				System.out.println(counter);//debug
				if(counter > 7) {
					btnGo.hide();
					lblPregunta.hide();
					rdbtnRespuesta1.hide();
					rdbtnRespuesta2.hide();
					rdbtnRespuesta3.hide();
					rdbtnRespuesta4.hide();
					
					
					//ESQECHIIIIIIIIIII necesito logica para colocar en ambas punta un jugador. Hasta el momento solo se ve uno obviamente
					JLabel lblPlayer = new JLabel(Name.playerName);
					lblPlayer.setFont(new Font("Tahoma", Font.PLAIN, 18));
					lblPlayer.setBounds(42, 13, 596, 25);
					panelJuego.add(lblPlayer);
					
					JLabel lblPuntuacion = new JLabel(String.valueOf(count));
					lblPuntuacion.setFont(new Font("Tahoma", Font.PLAIN, 18));
					lblPuntuacion.setBounds(42, 50, 596, 25);
					panelJuego.add(lblPuntuacion);
					
					//todo puntuaciones pero q se comparen en el servidor y devuelva quien gano.
					
					
					
				}
			}
		});

	}
	//metodo que mete las preguntas en un Arraylist y hace shuffle
	public void fillArrayList(ArrayList<String> arr) throws FileNotFoundException {
		String str = "";
		int idx=0;
		Scanner stringReader = new Scanner(new File("Math.txt"));//file
		while(stringReader.hasNext()) {//lectura y introduccion del archivo a un arraylist
			str = stringReader.nextLine();
			arr.add(idx++,str);
		}
		stringReader.close();
		Collections.shuffle(arr);
	}

	//todo debo cambiar el nombre a este metodo
	//Este metodo mete el arraylist a un arr
	public String[] splitPreguntas(ArrayList<String> preguntas) throws FileNotFoundException {
		fillArrayList(preguntas);//llamando al metodo duhhh
		Object[] arr =   preguntas.toArray(); //llenar objeto con contenido de un Arraylist
		String[] arr2 = new String[arr.length];

		for(int idx = 0 ; idx < arr.length ; idx++) {//quizas esto sea innecesario, me dio con hacer de mas
			arr2[idx] = (String) arr[idx];

		}

		return arr2;
	}

	//Logica para que las preguntas sigan mostrandose a medida en q se someten a evaluacion.
	public void showQuestions(String[] setDePreguntas, JLabel lblPregunta, 
			JRadioButton rdbtnRespuesta1, JRadioButton rdbtnRespuesta2,
			JRadioButton rdbtnRespuesta3, JRadioButton rdbtnRespuesta4) {
		String str = setDePreguntas[counter++];//una sola pregunta

		String[] pregunta= str.split("\\|");
		String pregunta1 = pregunta[0];//La pregunta
		correctAns = pregunta[4];//La respuesta correcta

		ArrayList<Integer> num= new ArrayList<>();//Para hacer shuffle a las opciones multiples
		num.add(1);
		num.add(2);
		num.add(3);
		num.add(4);
		Collections.shuffle(num);
		
		Object[] numShuffled = num.toArray();
		
		//Logica para mostrar las opciones en distinto orden
		String res1 = pregunta[(int) numShuffled[0]];
		String res2 = pregunta[(int) numShuffled[1]];
		String res3 = pregunta[(int) numShuffled[2]];
		String res4 = pregunta[(int) numShuffled[3]];

		//se asigna la pregunta
		lblPregunta.setText(pregunta1);
		
		//se la da un valor al buttones
		rdbtnRespuesta1.setActionCommand(res1);
		rdbtnRespuesta1.setText(res1);

		rdbtnRespuesta2.setActionCommand(res2);
		rdbtnRespuesta2.setText(res2);

		rdbtnRespuesta3.setActionCommand(res3);
		rdbtnRespuesta3.setText(res3);

		rdbtnRespuesta4.setActionCommand(res4);
		rdbtnRespuesta4.setText(res4);
	}
}
