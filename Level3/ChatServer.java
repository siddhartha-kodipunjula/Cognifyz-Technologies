import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer {
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(12345);
            System.out.println("Server started on port 12345. Waiting for client...");
            socket = serverSocket.accept();
            System.out.println("Client connected.");

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            new Thread(new ReadThread()).start();
            String msg;
            Scanner scanner = new Scanner(System.in);
            while (true) {
                msg = scanner.nextLine();
                out.write(msg);
                out.newLine();
                out.flush();
                if (msg.equalsIgnoreCase("exit")) break;
            }
            scanner.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }

    private static class ReadThread implements Runnable {
        public void run() {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Client: " + msg);
                    if (msg.equalsIgnoreCase("exit")) break;
                }
            } catch (IOException e) {
                System.out.println("Read error: " + e.getMessage());
            }
        }
    }
}
