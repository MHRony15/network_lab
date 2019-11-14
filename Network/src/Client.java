import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
  public static void main(String[] argv) throws Exception {
    Socket sock = new Socket("192.168.1.2", 23456);
    byte[] mybytearray = new byte[1024];
    InputStream is = sock.getInputStream();
    FileOutputStream fos = new FileOutputStream("rony.txt");
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    int bytesRead = is.read(mybytearray, 0, mybytearray.length);
    bos.write(mybytearray, 0, bytesRead);
    PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
    out.println("File Recieved Successfully.");
    bos.close();
    sock.close();
  }
}
