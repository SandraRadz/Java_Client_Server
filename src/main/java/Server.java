import controller.StudentController;
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
            try {
                server = new ServerSocket(4004);
                System.out.println("Server run");
                clientSocket = server.accept();
                try {
                    String word;
                    String result="";
                    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                    word = in.readLine();
                    System.out.println(word);
                    StudentController contr = new StudentController();
                    result = contr.parse(word);
                    out.write("Server:  " + result + "\n");
                    out.flush();
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println("Socket closed");
                    clientSocket.close();
                    // потоки тоже хорошо бы закрыть
                    in.close();
                    out.close();
                }
            } finally {
                System.out.println("Server closed");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}