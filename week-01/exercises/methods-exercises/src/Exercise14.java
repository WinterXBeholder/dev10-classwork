import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise14 {
    /* SHORT SURVEY

    Write a program that asks a user four questions and prints the results:
    - What is your first name?
    - What is your last name?
    - How many towns/cities have you lived in?
    - How many musical instruments can you play?

    Store each answer in a variable with an appropriate type.
    Print the results after the user has answered all four questions.

    Use methods to break the program into reusable blocks of code.
     */

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("What is your first name?");
        String firstName = getString(console);
        System.out.println("What is your last name?");
        String lastName = getString(console);
        System.out.println("How many towns/cities have you lived in?");
        int cities = getInt(console);
        System.out.println("How many musical instruments can you play?");
        int instruments = getInt(console);

        System.out.printf("%n%nResults:%n%nName: %s %s%nCities lived in: %s%nInstrument skills: %s%n", firstName, lastName, cities, instruments);

    }

    public static int getInt(Scanner console) {
        int input = 0;
        boolean isInt = false;
        do {
            try {
                System.out.println("Enter an Integer:");
                input = Integer.parseInt(console.nextLine());
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println("That's not an Integer");
                isInt = false;
            } catch (NoSuchElementException e) {
                System.out.printf("Scanner error: no element found%nNoSuchElementException%n");
                isInt = false;
            } catch (IllegalStateException e) {
                System.out.printf("Scanner error: scanner closed%IllegalStateException%n");
                isInt = false;
            }
        } while (!isInt);
        return input;
    }
    public static String getString(Scanner console) {
        String input = "";
        boolean isWord = false;
        do {
            try {
                System.out.println("Enter a word:");
                input = console.nextLine();
                isWord = input.matches("[a-zA-Z]+");
                if (!isWord) {
                    System.out.println("That's not a word");
                };
            } catch (NoSuchElementException e) {
                System.out.printf("Scanner error: probably no line element found%nNoSuchElementException%n");
                isWord = false;
            } catch (IllegalStateException e) {
                System.out.printf("Scanner error: scanner probably closed%IllegalStateException%n");
                isWord = false;
            }
        } while (!isWord);
        return input;
    }
}
