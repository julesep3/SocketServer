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
			output.println("Server says: Hello, what is your name?");
			str = input.readLine();
			output.println("Server says: Hello " + str + ", please enter a number to receive its factorial...");
			str = input.readLine();
			int number = Integer.parseInt(input.readLine());
			number = calculateFactorial(number);
			output.println("Server says: Your answer is " + number + ". Have a good day.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	static int calculateFactorial(int number) {
		int factorial = number;
		for (int i = 1; i < number; i++) {
			factorial = factorial * i;
		}
		return factorial;
	}

}
