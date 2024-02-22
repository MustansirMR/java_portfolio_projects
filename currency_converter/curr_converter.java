package java_portfolio_projects.currency_converter;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class curr_converter {
    final static float USD_TO_EURO = 0.94F;
    final static float USD_TO_TAKA = 124.4F;
    final static float EURO_TO_TAKA = 134.4F;
    final static String[] CURRENCIES = {"usd", "euro", "taka"};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("currency to convert from: ");
        String from_curr = input.nextLine().toLowerCase(Locale.ROOT);

        System.out.print("currency to convert to: ");
        String to_curr = input.nextLine().toLowerCase();

        if(!(isValidCurrency(from_curr) && isValidCurrency(to_curr))) {
            System.out.println("Provided currencies are not supported.");
            System.exit(-1);
        }

        try {
            System.out.print("amount: ");
            float amount = input.nextFloat();
            if(amount <= 0) {
                throw new ArithmeticException("Error - positive number required");
            }
            convert(from_curr, to_curr, amount);
        } catch(ArithmeticException e) {
            System.out.println("Positive number required");
            System.exit(-1);
        } catch (InputMismatchException e) {
            System.out.println("amount must be a number");
            System.exit(-1);
        }
    }

    private static void convert(String from_curr, String to_curr, float amount) {
        switch (from_curr) {
            case "usd" -> {
                switch (to_curr) {
                    case "euro" -> System.out.println(USD_TO_EURO * amount);
                    case "taka" -> System.out.println(USD_TO_TAKA * amount);
                    case "usd" -> System.out.println(amount);
                }
            }
            case "euro" -> {
                switch (to_curr) {
                    case "usd" -> System.out.println(USD_TO_EURO / amount);
                    case "taka" -> System.out.println(EURO_TO_TAKA * amount);
                    case "euro" -> System.out.println(amount);
                }
            }
            case "taka" -> {
                switch (to_curr) {
                    case "usd" -> System.out.println(USD_TO_TAKA / amount);
                    case "euro" -> System.out.println(EURO_TO_TAKA / amount);
                    case "taka" -> System.out.println(amount);
                }
            }
        }
    }

    private static boolean isValidCurrency(String curr) {
        for (String currency : CURRENCIES) {
            if(curr.equals(currency)) {
                return true;
            }
        }
        return false;
    }
}
