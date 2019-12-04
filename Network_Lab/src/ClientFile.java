import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientFile {
  public static void main(String[] argv) throws UnknownHostException, IOException {
    Socket sock = new Socket("localhost", 9999);
    String FileName = "Rony.txt";
    File MyFile = new File(FileName);
    int FileSize = (int) MyFile.length();
    OutputStream os = sock.getOutputStream();
    FileInputStream fos = new FileInputStream(MyFile);
    BufferedInputStream bis = new BufferedInputStream(fos);
    PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
    Scanner in = new Scanner(sock.getInputStream());
    out.println(FileName);
    out.println(FileSize);
    while(true) {
    	byte[] FileByte = new byte[FileSize];
    	bis.read(FileByte,0,FileByte.length);
    	os.write(FileByte,0,FileByte.length);
    	System.out.println("Server Response: "+ in.nextLine());
    	 bis.close();
    	 sock.close();
    	
    }
     
   
  }
}
