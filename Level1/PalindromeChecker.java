import java.util.Scanner;

public class PalindromeChecker {
    public static boolean isPalindrome(String s) {
        String filtered = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0, right = filtered.length() - 1;
        while (left < right) {
            if (filtered.charAt(left) != filtered.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();
        scanner.close();
        System.out.println(isPalindrome(input) ? "Palindrome" : "Not a palindrome");
    }
}
