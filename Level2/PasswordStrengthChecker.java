import java.util.Scanner;

public class PasswordStrengthChecker {
    public static String checkStrength(String password) {
        int score = 0;
        if (password.length() >= 8) score++;
        if (password.length() >= 12) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[^a-zA-Z0-9].*")) score++;

        if (score <= 2) return "Weak";
        if (score <= 3) return "Medium";
        if (score <= 4) return "Strong";
        return "Very Strong";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter password to check strength: ");
        String password = scanner.nextLine();
        System.out.println("Password strength: " + checkStrength(password));
        scanner.close();
    }
}
