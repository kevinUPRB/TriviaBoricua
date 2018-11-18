package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server extends Thread {
	
	public static int count = 0;
	public Socket connectionSocket;
    public DataInputStream inputStream;
    public DataOutputStream outputStream;
    
	public static ArrayList<String> players;

    
    public Server(Socket serverSocket) throws IOException{
    	this.connectionSocket = serverSocket;
    	players = new ArrayList<String>();
    }
    
    public void run() {

    	try {
    	
	    	System.out.println("Conexion Establecida con " + this.connectionSocket);
	
	    	 // set up input and output streams
	        this.inputStream = new DataInputStream(connectionSocket.getInputStream());
	        this.outputStream = new DataOutputStream(connectionSocket.getOutputStream()); 
	        
	        System.out.println("Run method de server");
//	        players.add(this.inputStream.readUTF());
//	        count++;
	        while(count != 2){
	        	players.add(this.inputStream.readUTF());
	        	System.out.println(count);
		        count++;
	        }
	        
	        System.out.println("Total Players " + players.size());
	        
	    	for(String name: players){
				System.out.println(name);
			}
//	        readData();
//	        count++;
	        

    	} catch (IOException e) {
			e.printStackTrace();
		}
    
    }
    
    // Debug
    public void readData() throws IOException{
    	
    	System.out.println(this.connectionSocket  + "Jugador # " + count + ": " + this.inputStream.readUTF());
    	
    }
    
    public void sendPlayers() throws IOException{
    	
    	for(String player: players){
    		this.outputStream.writeUTF(player);
    	}
    	
    	this.outputStream.flush();
    	
    }
    
    
    public static void main(String[] args) throws Exception {
    	
        System.out.println("The trivia server is running.");
        ServerSocket server = new ServerSocket(9001);
        try {
            while (true) {
                new Server(server.accept()).start();
            }
        } finally {
            server.close();
        }
        	
        
    }
    
    

}
