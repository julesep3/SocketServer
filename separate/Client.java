package separate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	private static BufferedReader userInput = null;
	private static PrintWriter output = null;
	private static BufferedReader reply = null;

	public static void main(String[] args) {

		try {
			// creating connection
			System.out.println("Client started");
			Socket socket = new Socket("localhost", 5000);

			// create a userInput reader
			userInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Say 'Hello' to server");
			// assign user's input to str
			// readLine() waits for user input
			String str = userInput.readLine();
			// create output stream
			// true applies to auto "flush"
			output = new PrintWriter(socket.getOutputStream(), true);
			// send to server
			output.println(str);

			// create server reply input stream
			reply = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(reply.readLine());
			// user reply to socket
			str = userInput.readLine();
			output.println(str);

			System.out.println(reply.readLine());
			//str = userInput.readLine();
			output.println(str);

			str = userInput.readLine();
			output.println(str);
			System.out.println(reply.readLine());
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
}
