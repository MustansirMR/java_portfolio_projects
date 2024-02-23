package java_portfolio_projects.num_guessing_game;
import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int computerNum = (int) (Math.random() * 10 + 1);

        int userNum = 0;
        int userTry = 0;

        while(userNum != computerNum) {
            System.out.println("enter a number between 1 and 10:");
            try {
                userNum = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("invalid input.");
                sc.next();
                continue;
            }
            if (userNum <= 0 || userNum > 10) {
                System.out.println("Invalid guess.");
            } else if (userNum < computerNum) {
                System.out.println("Your guess is too low.\nNumber of tries: " + ++userTry);
            } else if (userNum > computerNum) {
                System.out.println("You guess is too high.\nNumber of tries: " + ++userTry);
            } else {
                System.out.println("Correct!\nNumber of tries: " + ++userTry);
                break;
            }
        }
    }
}
