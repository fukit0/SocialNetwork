package socialnetwork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu implements Menu {
	
	public int show()
	{
		BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\n1. Sign up"+"\n" +
						   "2. Sign in"+"\n" +
						   "3. Exit");	
		
		int input;
		try {
			input = Integer.parseInt(bufferRead.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			input = -999;
			System.out.println("Invalid input!");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			input = -999;
			System.out.println("Invalid input!");
		}
		
		return input;
		
	}
}
