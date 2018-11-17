package application;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class Cliente {

	private JFrame frmTriviaBoricua;
	private JTextField txtIpAddress;
	private BufferedReader in;
	private PrintWriter out;
	
	public static String player;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
					window.frmTriviaBoricua.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public Cliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTriviaBoricua = new JFrame();
		frmTriviaBoricua.setTitle("Trivia Boricua");
		frmTriviaBoricua.setBounds(100, 100, 437, 300);
		frmTriviaBoricua.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTriviaBoricua.getContentPane().setLayout(null);
		frmTriviaBoricua.setLocationRelativeTo(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(0, 0, 419, 253);
		frmTriviaBoricua.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter IP Address of the Server:");
		lblNewLabel.setBounds(80, 66, 246, 22);
		panelLogin.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		txtIpAddress = new JTextField();
		txtIpAddress.setBounds(122, 101, 150, 22);
		panelLogin.add(txtIpAddress);
		txtIpAddress.setText("IP Address");
		txtIpAddress.setColumns(10);
		txtIpAddress.selectAll();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(156, 137, 87, 25);
		panelLogin.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				player = getServerAddress();
				/*
				try {
					run();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				Name name = new Name();
				name.setVisible(true);
				name.setLocationRelativeTo(null);
				frmTriviaBoricua.setVisible(false);
			}
		});
	}
	private String getServerAddress() {
		return txtIpAddress.getText();
	}
	
	 /**
     * Connects to the server then enters the processing loop.
     */
    private void run() throws IOException {

        // Make connection and initialize streams
        String serverAddress = getServerAddress();
      
        Socket socket = new Socket(serverAddress, 9001);
        System.out.println(socket);
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        /*// Process all messages from server, according to the protocol.
        while (true) {
            String line = in.readLine();
            if (line.startsWith("SUBMITNAME")) {
                out.println(getName());
            } else if (line.startsWith("NAMEACCEPTED")) {
                textField.setEditable(true);
            } else if (line.startsWith("MESSAGE")) {
                messageArea.append(line.substring(8) + "\n");
            }
        }
        */
    }
}
