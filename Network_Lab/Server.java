import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Server {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		ServerSocket servsock = new ServerSocket(3333);
		Socket sock = servsock.accept();
		Scanner in = new Scanner(sock.getInputStream());
		PrintWriter pr = new PrintWriter(sock.getOutputStream(), true);
		System.out.println(in.nextLine());
		pr.println("Welcome");
		System.out.println(in.nextLine());
		pr.println(LocalTime.now());
		System.out.println(in.nextLine());
		pr.println(LocalDate.now());
		System.out.println(in.nextLine());
		pr.println(LocalDateTime.now());
	}

}
