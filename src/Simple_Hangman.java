import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Simple_Hangman {
    public static <Char> void main(String[] args) {
    /*
        case 1:
            Welcome, let's play hangman!
            Here is the word I am thinking of: - - - - -
            Enter your guess: a
            You have guessed incorrectly 1/6 times.
            Your guess so far: -----
            Enter your guess: e
            Your guess so far: --e--
            Enter your guess: p
            You have guessed incorrectly 2/6 times.
            Your guess so far: --e--
            Enter your guess: c
            Your guess so far: c-e--
            Enter your guess: f
            You have guessed incorrectly 3/6 times.
            Your guess so far: c-e--
            Enter your guess: h
            Your guess so far: che--
            Enter your guess: s
            Your guess so far: chess
            You've won! The word was chess.
            Thank you for playing!
        case 2:
            Welcome, let's play hangman!
            Here is the word I am thinking of: - - - - - - - -
            Enter your guess: e
            Your guess so far: ------e-
            Enter your guess: w
            You have guessed incorrectly 1/6 times.
            Your guess so far: ------e-
            Enter your guess: r
            You have guessed incorrectly 2/6 times.
            Your guess so far: ------e-
            Enter your guess: t
            You have guessed incorrectly 3/6 times.
            Your guess so far: ------e-
            Enter your guess: y
            You have guessed incorrectly 4/6 times.
            Your guess so far: ------e-
            Enter your guess: e
            Your guess so far: ------e-
            Enter your guess: r
            You have guessed incorrectly 5/6 times.
            Your guess so far: ------e-
            Enter your guess: a
            Your guess so far: -a--a-e-
            Enter your guess: v
            You have guessed incorrectly 6/6 times.
            Your guess so far: -a--a-e-
            Sorry, you have no more guesses left. The word was pancakes.
            Thank you for playing!
     */
        int randomNumber;
        int count = 0;
        String letter;
        String correct [];
        boolean gotOne;
        int charCount = 0;

        ArrayList<String> words = new ArrayList<>();
        words.add("tree");
        words.add("rain");
        words.add("bear");
        words.add("encourage");
        words.add("promise");
        words.add("soup");
        words.add("chess");
        words.add("insurance");
        words.add("pancakes");
        words.add("stream");

        Scanner in = new Scanner(System.in);
        Random run = new Random();

        randomNumber = run.nextInt(words.size() - 1);

        // set the size of the array based on the word selected by random number.
        correct = new String [words.get(randomNumber).length()];

        for (int i = 0; i < correct.length; i++) {
            correct[i] = "-";
        }

        System.out.println("Welcome, let's play hangman!");
        System.out.print("Here is the word I am thinking of: ");
        for (int i = 0; i < words.get(randomNumber).length(); i++) {
            System.out.print("- "); // Give hint for user by giving the size of the word
        }
        System.out.println();

        /*
            the while loop stops when the user guess is incorrect 6 times
            and when the user find the correct word if the user find the correct word
            the length is the same. so the loop stop.
         */

        while(count != 6 && !(charCount == words.get(randomNumber).length())) {
            gotOne = false; // based on this variable we count the incorrect guesses.

            System.out.print("Enter your guess: ");
            letter =  in.nextLine();

            for (int j = 0; j < letter.length(); j++) {
                /*
                    check if the value entered by the user is equal with the word selected by the random
                    generator.
                    if true display you won and stop the while loop.
                 */
                if (words.get(randomNumber).equalsIgnoreCase(letter)){
                    System.out.println("You've won! The word was " + words.get(randomNumber) + ".");
                    count = 6;
                    break;
                }
                /*
                    for loop go through each word to
                    Check if the user guess match any letter in the word or not

                 */
                for (int i = 0; i < words.get(randomNumber).length(); i++) {
                    if (letter.charAt(j) == words.get(randomNumber).charAt(i)){
                        correct[i] = String.valueOf((letter.charAt(j)));
                        gotOne = true;
                    }
                }
                /*
                    if the user guess matches any letter counter of wrong guess will not add up.
                    if not it will add on the counter increase by 1.
                 */
                if (gotOne == false){
                    count++;
                    System.out.println("You have guessed incorrectly " + count + "/6 times.");
                }
                /*
                    This for loop display for user the letter the user guess correctly
                    and their positions.
                 */
                System.out.print("Your guess so far: " );
                for (int i = 0; i < correct.length; i++) {
                    if (!(correct[i].equals("-"))) {
                        System.out.print(correct[i]);
                    }else {
                        System.out.print("-");
                    }
                }
                /*
                    this for loop check if the user guess and find the word
                    then by counting the letters from we store the correct
                    guessed letters by the user it will compare the length
                    of both words
                    if this sizes are equal the while loop will stop

                 */
                charCount = 0;
                for (int i = 0; i < correct.length; i++) {

                    if (!(correct[i].equals("-"))){
                      charCount++;
                    }
                }
                System.out.println();

            }
        }


        if ((charCount == words.get(randomNumber).length())) {
            System.out.println("You've won! The word was " + words.get(randomNumber) + ".");
        } else {
            System.out.println("Sorry, you have no more guesses left. The word was " + words.get(randomNumber) + ".");
        }
        System.out.println("Thank you for playing!");

    }
}
