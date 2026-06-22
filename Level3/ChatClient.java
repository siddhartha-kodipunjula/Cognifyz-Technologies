import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static Socket socket;
    private static BufferedReader in;
    private static BufferedWriter out;

    public static void main(String[] args) {
        try {
            socket = new Socket("localhost", 12345);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            new Thread(new ReadThread()).start();
            Scanner scanner = new Scanner(System.in);
            String msg;
            while (true) {
                msg = scanner.nextLine();
                out.write(msg);
                out.newLine();
                out.flush();
                if (msg.equalsIgnoreCase("exit")) break;
            }
            scanner.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }

    private static class ReadThread implements Runnable {
        public void run() {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("Server: " + msg);
                    if (msg.equalsIgnoreCase("exit")) break;
                }
            } catch (IOException e) {
                System.out.println("Read error: " + e.getMessage());
            }
        }
    }
}
