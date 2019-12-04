import java.io.IOException;
import java.net.Socket;

import java.util.Scanner;

public class ClientMsg {
	public static void main(String[] arg) throws  IOException {
		Socket s = new Socket ("localhost",1239);
		Scanner in = new Scanner(s.getInputStream());
        System.out.println("Server response: " + in.nextLine());
		
	}
}
