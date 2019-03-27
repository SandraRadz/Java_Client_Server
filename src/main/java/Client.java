import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket;
    private static BufferedReader reader;
    //private static BufferedReader in;
    //private static BufferedWriter out;


    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                //in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                //out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                ObjectOutputStream in = new ObjectOutputStream(fromClientSocket.getOutputStream());
                ObjectInputStream out = new ObjectInputStream(fromClientSocket.getInputStream());

                System.out.println("Print something");
                String word;
                String serverWord;

                word = reader.readLine();
                //out.write(word + "\n");
                //out.flush();
                //serverWord = in.readLine();
                System.out.println(serverWord);
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Client stopped");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
