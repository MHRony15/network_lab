import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket sock = new Socket("localhost", 3333);
		Scanner in = new Scanner(sock.getInputStream());
		PrintWriter pr = new PrintWriter(sock.getOutputStream(), true);
		System.out.println("Success");
		TimeUnit.SECONDS.sleep(2);
		pr.println("Hello");
		System.out.println(in.nextLine());
		TimeUnit.SECONDS.sleep(2);
		pr.println("Time");
		System.out.println(in.nextLine());
		TimeUnit.SECONDS.sleep(2);
		pr.println("Date");
		System.out.println(in.nextLine());
		TimeUnit.SECONDS.sleep(2);
		pr.println("DateTime");
		System.out.println(in.nextLine());
	}

}
