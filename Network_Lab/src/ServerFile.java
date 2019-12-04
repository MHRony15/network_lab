import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerFile {
  public static void main(String[] args) throws IOException {
    ServerSocket servsock = new ServerSocket(9999);
    Socket sock = servsock.accept();
    Scanner in = new Scanner(sock.getInputStream());
    InputStream is = sock.getInputStream();
    FileOutputStream fos = new FileOutputStream("R.txt");
    PrintWriter out = new PrintWriter(sock.getOutputStream(),true);
    BufferedOutputStream bos = new BufferedOutputStream(fos);
    String FileName = in.nextLine();
    int FileSize = in.nextInt();
    byte[]  ByteArray = new byte[FileSize];
    
    int FileByte = is.read(ByteArray,0,ByteArray.length);
    bos.write(ByteArray,0,FileByte);
    System.out.println("Incoming File: "+ FileSize);
    System.out.println("Size: "+FileSize+"Bytes");
    if(FileSize== FileByte) System.out.println("File is Verifide");
    else System.out.println("File is Corrupted");
    out.println("File Resived Successfully");
    bos.close();
    sock.close();
    
    }
  }


