import java.io.*;
import java.net.Socket;

public class Client {

    private static Socket clientSocket; //сокет для общения
    private static BufferedReader reader; // нам нужен ридер читающий с консоли, иначе как
    // мы узнаем что хочет сказать клиент?
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try {
                clientSocket = new Socket("localhost", 4004);
                reader = new BufferedReader(new InputStreamReader(System.in));
                // читать соообщения с сервера
                String word;
                String param;
                String serverWord;
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                do {
                    System.out.println("What you want to know? Print 'allStudents' to get list of all students? or print 'details' to get" +
                            "info about student by his/her id");
                    word = reader.readLine();
                    if (word.equals("allStudents") || word.equals("details")) {
                        if (word.equals("details")) {
                            System.out.println("Print student id, you want know about");
                            param = reader.readLine();
                            word += " " + param;
                        }
                        System.out.print("out");
                        out.write(word);
                        out.flush();
                        serverWord = in.readLine();
                        System.out.println(serverWord);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                while (!reader.equals("stop"));

            } finally {
                System.out.println("Client closed");
                clientSocket.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
