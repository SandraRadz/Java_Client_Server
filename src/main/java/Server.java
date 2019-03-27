import dao.impl.StudentDaoImpl;
import vo.Discipline;
import vo.Enrollment;
import vo.Student;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class Server {

    private static Socket clientSocket; //сокет для общения
    private static ServerSocket server; // серверсокет
    private static BufferedReader in; // поток чтения из сокета
    private static BufferedWriter out; // поток записи в сокет

    public static void main(String[] args) {
        try {
            try  {
                server = new ServerSocket(4004);
                System.out.println("Server runs");
                clientSocket = server.accept();
                try {
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                        String word = in.readLine();
                        System.out.println(word);
                        out.write("Client print : " + word + "\n");
                        out.flush();
                        System.out.println("Waiting for the next operation data...");
                        System.out.println();
                        Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    clientSocket.close();
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server stopped!");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}
