import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMsg {

	public static void main(String[] args) throws IOException {
		try ( ServerSocket listener = new ServerSocket(1239)) {
            System.out.println("The date server is running...");
            while (true) {
                try (Socket socket = listener.accept()) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Hello World, My Name is Mehedy.");
                    
                }
            }
        }
    }

	

}
