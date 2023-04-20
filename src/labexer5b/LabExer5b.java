/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labexer5b;
import java.util.Scanner;
/**
 *
 * @author glenn
 */
public class LabExer5b {

    /**
     * @param args the command line arguments
     */
    private static final int
            a = 0,
            b = 1,
            c = 2;
    private static final String[] questions = {
            "When was the initial release of Genshin Impact?",
            "Who runs the Wangsheng Funeral Parlour?",
            "Who is the Yuheng of the Liyue Qixing?",
            "In Mondstadt, who holds the official title of \"Librarian\"?",
            "Barbatos is also known as the current Archon of?",
            "Which of these characters ISN'T obtained for free?",
            "What martial arts group is Xingqiu in?",
            "Which of the current archons is the oldest?",
            "Which of these ISN'T a potential colour for a seelie pet?",
            "Who taught Razor to talk?"
    };
    private static final int[] answer_key = {c, b, a, c, a, b, a, c, b, a};
    private static final String[][] selections = {
            { // The correct answer is: c
                "(a) August 17, 2020",
                "(b) August 28 2021",
                "(c) September 28, 2020"
            },
            { // The correct answer is: b
                "(a) Zhongli",
                "(b) Hu Tao",
                "(c) Keqing"
            },
            { // The correct answer is: a
                "(a) Keqing",
                "(b) Ganyu",
                "(c) Ningguang"
            },
            { // The correct answer is: c
                "(a) Jean",
                "(b) Eula",
                "(c) Lisa"},
            { // The correct answer is: a
                "(a) Anemo",
                "(b) Electro",
                "(c) Dendro"
            },
            { // The correct answer is: b
                "(a) Kaeya",
                "(b) Razor",
                "(c) Barbara"
            }, 
            { // The correct answer is: a
                "(a) Guhua Clan",
                "(b) Guhra Clan",
                "(c) Guava Clan"
            },
            { // The correct answer is: c
                "(a) Barbatos",
                "(b) Raiden",
                "(c) Rex Lapis"
            },
            { // The correct answer is: b
                "(a) Blue",
                "(b) Red",
                "(c) Pink"
            },
            { // The correct answer is: a
                "(a) Lisa",
                "(b) Jean",
                "(c) Amber"
            }
           
    };
    private static int score = 0;
    private static final int max_points = questions.length * 2;
    private static int i = 0;
    private static int j = 0;
    private static boolean isQuizFinished = false;
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("ALON, Glenn S.");
        System.out.println("BSCS 1-1AA\n");
        System.out.println("The questions in this quiz are about Genshin Impact. \nThe items are worth 2 pts each: " +  questions.length + " * 2 = " + max_points + ".");

        Scanner scanner = new Scanner(System.in);
        
        while (!isQuizFinished)
        {
            while (i < questions.length) {
                System.out.println((i + 1) + ". " + questions[i]);
                for (j = 0; j < selections[i].length; j++) {

                    System.out.println(selections[i][j]);
                }
                System.out.print("Answer: ");
                String input = scanner.nextLine();
                try{
                    if (input == null || input == ""){
                        throw new NullPointerException();
                    }
                }
                catch(NullPointerException ex){
                    System.out.println("Please choose only the values: A, B, or C");
                    System.out.println("Try again.");
                    break;
                }
                
               char in = input.toLowerCase().charAt(0);
                try{
                    if (Character.isLetter(in)){
                        switch (in) {
                            case 'a', 'A' -> {
                            }
                            case 'b', 'B' -> {
                            }
                            case 'c', 'C' -> {
                            }
                            default -> throw new OutOfRangeException();
                        }
                    } 
                    if (!Character.isLetter(in)){
                        throw new NonLetterCharException();
                    }
                }
                catch(OutOfRangeException ex){
                    System.out.println("Please choose only the values: A, B, or C");
                    System.out.println("Try again.");
                    break;
                }
                catch(NonLetterCharException ex){
                    System.out.println("Please choose only the values: A, B, or C");
                    System.out.println("Try again.");;
                    break;
                }
                
                switch (in) {
                    case 'a' -> ValidateAnswers(a);
                    case 'b' -> ValidateAnswers(b);
                    case 'c' -> ValidateAnswers(c);                 
                }

                if (i == questions.length)
                {
                    isQuizFinished = true;
                }
            }
        }
        System.out.println("\nYou have gained a total of " + score + " points out of " + max_points + ".");
        scanner.close();
    }

    private static void ValidateAnswers (int input)
    {
        if (input == answer_key[i])
        {
            score = score + 2;
        }
        i++;
    }
    private static void reset(){
        score = 0;
        i = 0;
        j = 0;
    }
}

class OutOfRangeException extends Exception{
    public OutOfRangeException(){
        super("The input is out of range.");
    }
}
class NonLetterCharException extends Exception{
    public NonLetterCharException(){
        super("The input is not a letter.");
    }
}
