import java.io.*;
import java.net.*;

public class SMTPmailClient {

	public static void main(String[] args) throws IOException {
		Socket s = new Socket("localhost",25);
		PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
		BufferedReader br =new BufferedReader(new InputStreamReader(s.getInputStream()));
		
		pw.println("HELO "+"localhost");
		System.out.println("Responce1: " + br.readLine());
		
		pw.println("MAIL FROM: "+"mahady@rmail.com");
		System.out.println("Responce2: " + br.readLine());
		pw.println("RCPT TO: "+"rony@rmail.com");
		System.out.println("Responce3: " + br.readLine());
		pw.println("DATA");
		System.out.println("Responce4: " + br.readLine());
		pw.println("Subject: SMTPMail");
		pw.println();
		pw.println("HEllow !!! I am Rony ");
		pw.println();
		pw.println(".");
		System.out.println("Responce5: " + br.readLine());
		pw.println("QUIT");
		System.out.println("Responce6: " + br.readLine());
		System.out.println("Responce7: " + br.readLine());
		
		
		

	}

}
