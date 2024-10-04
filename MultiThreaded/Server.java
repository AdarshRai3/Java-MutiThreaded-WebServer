
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;
import java.io.IOException;
import java.io.PrintWriter;
public class Server {
    int port=7000;
    public Consumer<Socket>getConsumer(){
        return (clientSocket) -> {
            try{
               PrintWriter toClient = new PrintWriter(clientSocket.getOutputStream(),true);
               toClient.println("Hello from the server");
               toClient.close();
               clientSocket.close();
            }catch(IOException ex){
               ex.printStackTrace();
            }
        };
    }
    public static void main(String[] args) {
        int port =7000;
        Server server = new Server();
        try{
            ServerSocket serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(100000);
            System.out.println("Server is listening on port: "+port);
            while(true){
                Socket acceptedConnection = serverSocket.accept();
                Thread thread = new Thread(()->server.getConsumer().accept(acceptedConnection));
                thread.start();
            }
        }catch(IOException ex){
            ex.printStackTrace();
        }
   }
}
