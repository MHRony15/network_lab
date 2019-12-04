import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerManik{
	@SuppressWarnings("resource")
	public static void main(String []args) throws IOException {
		ServerSocket servsock = new ServerSocket(34567);
		Socket sock = servsock.accept();
		Scanner in = new Scanner(sock.getInputStream());
		InputStream is = sock.getInputStream();
		FileOutputStream fos = new FileOutputStream("M.txt");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
		String FileName = in.nextLine();
		int FileSize = in.nextInt();
		byte[] bytearray = new byte[FileSize];
		
		int filebyte = is.read(bytearray, 0, bytearray.length);
		bos.write(bytearray, 0, filebyte);
		
		System.out.println("Incoming File: " + FileName);
		System.out.println("Size: " + FileSize + " Byte");
		if(FileSize == filebyte)System.out.println("File is Verified");
		else System.out.println("File is Corrupted. Incoming File Size: " + filebyte);
		out.println("File Recieved Successfully.");
		bos.close();
	    sock.close();
	}
}
