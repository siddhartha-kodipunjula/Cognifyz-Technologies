import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter base currency (e.g., USD): ");
        String base = scanner.next().toUpperCase();
        System.out.print("Enter target currency (e.g., INR, EUR, GBP): ");
        String target = scanner.next().toUpperCase();

        try {
            String urlStr = "https://api.exchangerate-api.com/v4/latest/" + base;
            URL url = new URL(urlStr);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) sb.append(line);
            br.close();

            String json = sb.toString();
            String search = "\"" + target + "\":";
            int idx = json.indexOf(search);
            if (idx == -1) {
                System.out.println("Target currency not found.");
                scanner.close();
                return;
            }
            int colon = idx + search.length();
            while (colon < json.length() && (json.charAt(colon) == ' ' || json.charAt(colon) == ':')) colon++;
            int comma = json.indexOf(',', colon);
            if (comma == -1) comma = json.indexOf('}', colon);
            String rateStr = json.substring(colon, comma).trim();
            double rate = Double.parseDouble(rateStr);
            double converted = amount * rate;
            System.out.printf("%.2f %s = %.2f %s%n", amount, base, converted, target);
        } catch (Exception e) {
            System.out.println("Error fetching rates: " + e.getMessage());
        }
        scanner.close();
    }
}
