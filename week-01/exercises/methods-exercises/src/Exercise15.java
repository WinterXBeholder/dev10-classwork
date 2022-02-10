import java.util.Scanner;
public class Exercise15 {
    /* FIZZ BUZZ

    Historically, the Fizz Buzz (https://en.wikipedia.org/wiki/Fizz_buzz) problem was used in programming interviews.
    Not sure if it still is. Just in case, we'll get it out of the way in Milestone 1.

    Write a program to:
    - Prompt a user for a positive integer and store the result. (Could reuse a readInt method.)
    - Loop from the number 1 to the user's integer.
    - If the number is divisible by 3, print Fizz.
    - If the number is divisible by 5, print Buzz.
    - If the number is divisible by both 3 and 5, print Fizz Buzz.
    - If the number is not divisible by either 3 or 5, print the number.

    Example Output:
    1
    2
    Fizz
    4
    Buzz
    Fizz
    7
    8
    Fizz
    Buzz
    11
    Fizz
    13
    14
    Fizz Buzz
    16
    17
    Fizz
     */
    public static void main(String[] args) {
        int end = getInt(1);
        for(int i = 1; i <= end; i++) {
            System.out.println("" + (i%3==0 ? (i%5==0 ? "Fizz Buzz" : "Fizz") : (i%5==0 ? "Buzz" : i)));
        }
        // If I wanted to change the numbers, I would store them as a variable and accept them as arguments in a separate method
        // If I wanted to point out additional divisors, I would attempt recursion
    }


    public static int getInt() {
        Scanner console = new Scanner(System.in);
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
            }
        } while (!isInt);
        return input;
    }

    public static int getInt(int min) {
        Scanner console = new Scanner(System.in);
        int input = 0;
        boolean isInt = false;
        do {
            try {
                System.out.printf("Enter an Integer greater than %s:%n", min);
                input = Integer.parseInt(console.nextLine());
                isInt = input > min;
            } catch (NumberFormatException e) {
                System.out.println("That's not an Integer");
                isInt = false;
            }
        } while (!isInt);
        return input;
    }





}





