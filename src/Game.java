import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws Exception{
    // grab a text file
        File sourceFile= new File("src/usa.txt");
        Scanner sc =new Scanner(sourceFile);
        Scanner inputDevice =new Scanner(System.in);
        ArrayList <String> words =new ArrayList<>();
        while(sc.hasNextLine()){
            words.add(sc.nextLine());
        }
        //get a random word from the file and assign it to an array to split into chars .
        String puzzleWord= words.get((int)(Math.random()*words.size()));
        char[] wordArray = puzzleWord.toCharArray();
        char[] playerGuesses = new char[wordArray.length];

        for (int i =0;i<wordArray.length;i++){
            playerGuesses[i] = '?';
        }
        System.out.println("*********************************");

        // limit the user guesses
        int guesses =7;
        drawHangman(guesses);
        // create a while loop to enter the guesses
        boolean finish =false;

        while (!finish){
            for (char ignored : wordArray) {
                System.out.print("_");

            }
            System.out.print("\nEnter a letter:\t");
            String guess =inputDevice.next();
            //check inputs


    }
}
