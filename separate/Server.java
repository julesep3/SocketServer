package separate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private static BufferedReader input = null;
	private static PrintWriter output = null;

	public static void main(String[] args) {

		try {
			System.out.println("Waiting for clients...");
			ServerSocket ss = new ServerSocket(5000);
			Socket s = ss.accept();
			System.out.println("Connection established!");

			input = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String str = input.readLine();
			output = new PrintWriter(s.getOutputStream(), true);
			output.println("Server says: " + str);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
