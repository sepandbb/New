import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class passwordChecker {

    public static <i> void main(String[] args) {

        int i;

        for (i = 5; i >= 0; i--) //Loop that continues until password matches or 5 attempts are expended
        {
            String passEntered = passwordAsk();
            checkIfPasswordEntered(passEntered);
            passwordCompare(i, passEntered);
        }
    }

    private static String passwordAsk() {

        System.out.println("Enter password:");
        Scanner reader = new Scanner(System.in);
        String passEntered = reader.nextLine();

        return passEntered;
    }

    private static void checkIfPasswordEntered(String passEntered) {

        if (passEntered.length() == 0)
        {
            System.out.println("No password entered");
            passwordAsk();
        }
    }

    public static void passwordCompare(int i, String passEntered) {

        String[] passwords = {"Hello world!", "Goodbye world!", "World!"};
        boolean match = Arrays.stream(passwords).anyMatch(passEntered::equals);

        if (match)
        {
            System.out.println("Correct password entered");
            System.exit(1);
        }
        else if (i != 0)
        {
            System.out.println("Try again..." + i + " attempt/s remaining.");
            Stack<String> incorrectPass = new Stack<>();
            incorrectPass.push(passEntered);
            System.out.println("Incorrect passwords entered: " + incorrectPass);
        }
        else
        {
            System.out.println("No attempts remaining");
            System.exit(1);
        }
    }
}



/*
{
        System.out.println(passEntered.length() == 0 ?
        "No password entered":
        "Incorrect password");
        }*/
