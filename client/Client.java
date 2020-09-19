import java.net.*;
import java.io.*;

public class Client {

	// initialize socket and input/output streams
	private Socket socket = null;
	private DataInputStream input = null;
	private DataOutputStream output = null;
	private BufferedReader reader = null;

	// constructor to put IP address and port
	public Client(String address, int port) {

		// establish a connection
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");

			//takes an input from the terminal
			System.out.println("Enter a message to send to server...");
			input = new DataInputStream(System.in);

			//sends output to the socket
			output = new DataOutputStream(socket.getOutputStream());
		}
		catch(UnknownHostException u) {
			System.out.println(u);
		}
		catch(IOException i) {
			System.out.println(i);
		}

		// String to read message from input tab
		String line = "";

		reader = new BufferedReader(new InputStreamReader(System.in));

		// keep reading until "Connection Over" is displayed on the screen
		while (!line.equals("Connection Over")) {
			try {
				line = reader.readline();
				output.writeUTF(line);
			}
			catch(IOException i) {
				System.out.println(i);
			}
		}

		// close the connection
		try {
			input.close();
			output.close();
			socket.close();
		}
		catch(IOException i) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		Client client = new Client("localhost", 5000);
	}
}