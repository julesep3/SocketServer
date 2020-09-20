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
			System.out.println("Client started");
			Socket socket = new Socket("localhost", 5000);
			userInput = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Say 'Hello' to server");
			String str = userInput.readLine();
			output = new PrintWriter(socket.getOutputStream(), true);
			output.println(str);
			reply = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			System.out.println(reply.readLine());
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
