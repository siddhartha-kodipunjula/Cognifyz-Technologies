import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of grades: ");
        int n = scanner.nextInt();
        double sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            sum += scanner.nextDouble();
        }
        double avg = sum / n;
        System.out.printf("Average grade: %.2f%n", avg);
        scanner.close();
    }
}
