import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Temperature Converter ===");
        System.out.print("Enter temperature value: ");
        double value = scanner.nextDouble();
        System.out.print("Enter unit (C/F): ");
        String unit = scanner.next().toUpperCase();
        double result;
        String targetUnit;
        if (unit.equals("C")) {
            result = (value * 9.0 / 5.0) + 32;
            targetUnit = "Fahrenheit";
        } else if (unit.equals("F")) {
            result = (value - 32) * 5.0 / 9.0;
            targetUnit = "Celsius";
        } else {
            System.out.println("Invalid unit. Use C or F.");
            scanner.close();
            return;
        }
        System.out.printf("Converted: %.2f %s%n", result, targetUnit);
        scanner.close();
    }
}
