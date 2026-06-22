import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {
    private static final int SHIFT = 3;

    public static String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c - base + SHIFT) % 26 + base));
            } else if (Character.isDigit(c)) {
                sb.append((char) ((c - '0' + SHIFT) % 10 + '0'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String decrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                sb.append((char) ((c - base - SHIFT + 26) % 26 + base));
            } else if (Character.isDigit(c)) {
                sb.append((char) ((c - '0' - SHIFT + 10) % 10 + '0'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Choose option: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter input file path: ");
        String inPath = scanner.nextLine();
        System.out.print("Enter output file path: ");
        String outPath = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(inPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String processed = option == 1 ? encrypt(line) : decrypt(line);
                bw.write(processed);
                bw.newLine();
            }
            System.out.println("Done.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        scanner.close();
    }
}
