import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception {
        Sound.play("src/m3.wav");
        // grab a text file
        boolean Continue = true;
        while (Continue) {
            File sourceFile = new File("src/usa.txt");
            Scanner sc = new Scanner(sourceFile);
            Scanner inputDevice = new Scanner(System.in);
            ArrayList<String> words = new ArrayList<>();
            while (sc.hasNextLine()) {
                words.add(sc.nextLine());
            }
            //get a random word from the file and assign it to an array to split into chars .
            String puzzleWord = words.get((int) (Math.random() * words.size()));
            char[] wordArray = puzzleWord.toCharArray();
            char[] playerGuesses = new char[wordArray.length];

            for (int i = 0; i < wordArray.length; i++) {
                playerGuesses[i] = '?';
            }
            System.out.println("**********************************\n***Welcome To The Hang Man Game***");

            // limit the user guesses
            int guesses = 7;
            DrawHangman.drawHangman(guesses);
            System.out.println("\nthe word consists of "+wordArray.length+" letters");
            for (char ignored : wordArray) {
                System.out.print("_");
            }
            // create a while loop to enter the guesses
            boolean finish = false;

            while (!finish) {
                System.out.print("\nEnter a letter:\t");
                String guess = inputDevice.next();
                //check inputs

                while (guess.length() != 1 || Character.isDigit(guess.charAt(0))) {
                    System.out.println("You have a maximum of 7 wrong guesses");
                    System.out.println("please enter 1 letter-Try again");
                    guess = inputDevice.next();
                }
                //check if the guess in the word or not
                boolean found = false;
                for (int i = 0; i < wordArray.length; i++) {
                    if (guess.charAt(0) == wordArray[i]) {
                        playerGuesses[i] = wordArray[i];
                        System.out.println("your Guess is right, good job!");
                        found = true;
                    }
                }
                // action if the guess is not in the word
                if (!found) {
                    guesses--;
                    System.out.println("Wrong Guess");
                }
                // create a boolean to check if the user got the right word guessed
                boolean CorrectGuess = true;

                System.out.println("\nGuesses left :" + guesses);
                DrawHangman.drawHangman(guesses);
                System.out.println("\nthe word consists of "+wordArray.length+" letters");
                for (char playerGuess : playerGuesses) {
                    if (playerGuess == '?') {
                        System.out.print("_");
                        CorrectGuess = false;
                    } else {
                        System.out.print(playerGuess);
                    }
                }
                // message to be printed if the player guessed the word
                if (CorrectGuess) {
                    System.out.println("\nCongrats you did it ");
                    finish = true;

                }
                // print the word if guesses =0
                if (guesses == 0) {
                    System.out.print("\nYou lost!\nThe word is: ");

                    for (char ignored : wordArray) {
                        System.out.print(ignored);
                    }
                    System.out.println();
                    finish = true;

                }
            }
            System.out.print("\nContinue?(yes/no)\t");
            String answer = inputDevice.next();
            if (!(answer.equals("yes") || answer.equals("YES") || "Yes".equals(answer))) {
                Continue = false;
            }
        }System.out.println("\nBye!");
    }
}
