import java.util.Scanner;

public class RandomPasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+<>?";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Include lowercase? (y/n): ");
        boolean useLower = scanner.nextLine().equalsIgnoreCase("y");
        System.out.println("Include uppercase? (y/n): ");
        boolean useUpper = scanner.nextLine().equalsIgnoreCase("y");
        System.out.println("Include numbers? (y/n): ");
        boolean useDigits = scanner.nextLine().equalsIgnoreCase("y");
        System.out.println("Include special characters? (y/n): ");
        boolean useSpecial = scanner.nextLine().equalsIgnoreCase("y");

        StringBuilder pool = new StringBuilder();
        if (useLower) pool.append(LOWERCASE);
        if (useUpper) pool.append(UPPERCASE);
        if (useDigits) pool.append(DIGITS);
        if (useSpecial) pool.append(SPECIAL);

        if (pool.length() == 0) {
            System.out.println("At least one character set must be selected.");
            scanner.close();
            return;
        }

        StringBuilder password = new StringBuilder();
        boolean hasLower = false, hasUpper = false, hasDigit = false, hasSpecial = false;
        java.util.Random rand = new java.util.Random();

        if (useLower) {
            password.append(LOWERCASE.charAt(rand.nextInt(LOWERCASE.length())));
            hasLower = true;
        }
        if (useUpper) {
            password.append(UPPERCASE.charAt(rand.nextInt(UPPERCASE.length())));
            hasUpper = true;
        }
        if (useDigits) {
            password.append(DIGITS.charAt(rand.nextInt(DIGITS.length())));
            hasDigit = true;
        }
        if (useSpecial) {
            password.append(SPECIAL.charAt(rand.nextInt(SPECIAL.length())));
            hasSpecial = true;
        }

        int currentLength = password.length();
        for (int i = currentLength; i < length; i++) {
            char c = pool.charAt(rand.nextInt(pool.length()));
            password.append(c);
            if (LOWERCASE.indexOf(c) >= 0) hasLower = true;
            if (UPPERCASE.indexOf(c) >= 0) hasUpper = true;
            if (DIGITS.indexOf(c) >= 0) hasDigit = true;
            if (SPECIAL.indexOf(c) >= 0) hasSpecial = true;
        }

        char[] arr = password.toString().toCharArray();
        for (int i = arr.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        String finalPass = new String(arr);
        StringBuilder display = new StringBuilder();
        display.append("Generated password: ").append(finalPass).append("\n");
        display.append("Strength: ");
        int strength = 0;
        if (length >= 8) strength++;
        if (hasLower) strength++;
        if (hasUpper) strength++;
        if (hasDigit) strength++;
        if (hasSpecial) strength++;
        if (strength <= 2) display.append("Weak");
        else if (strength <= 3) display.append("Medium");
        else if (strength <= 4) display.append("Strong");
        else display.append("Very Strong");
        System.out.println(display.toString());
        scanner.close();
    }
}
