package animals;

import java.time.LocalTime;
import java.util.*;

public class GameStart {
    public static void play(){

    checkTime(LocalTime.now());

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter an Animal: ");
    String input = scan.nextLine();
    processUserInput(input);


    String nextInput = scan.nextLine();
    response(nextInput);


}
    private static void checkTime(LocalTime ldt) {
        ldt = LocalTime.now();
        LocalTime noon = LocalTime.of(12, 0);
        LocalTime night = LocalTime.of(18, 0);
        LocalTime morning = LocalTime.of(5,0);
        if (ldt.isAfter(noon) && ldt.isBefore(night)){
            System.out.println("Good Afternoon");
        }
        if(ldt.isAfter(morning) && ldt.isBefore(noon)){
            System.out.println("Good Morning");
        }
        if(ldt.isAfter(night) && ldt.isBefore(morning)) {
            System.out.println("Good evening");
        }
    }

    private static void processUserInput(String UserInput) {
        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        UserInput = UserInput.toLowerCase();

        if (!UserInput.startsWith("a ") && !UserInput.startsWith("an ")) {
            if (UserInput.startsWith("the ")) {
                UserInput = UserInput.substring(4);
            }
            String prefix = vowels.contains(UserInput.charAt(0)) ? "an " : "a ";
            UserInput = prefix + UserInput;

        }
        System.out.printf("Is it %s?%n", UserInput);
    }

    private static void response(String answer){

        List<String> goodbye = new ArrayList<>(Arrays.asList("See you soon!", "Goodbye!", "Bye", "Have a nice day!"));

        List<String> wrongAnswer = new ArrayList<>(Arrays.asList("I'm not sure I caught you: was it yes or no?",
                "Funny, I still don't understand, is it yes or no?",
                "Oh, it's too complicated for me: just tell me yes or no.",
                "Could you please simply say yes or no?",
                "Oh, no, don't try to confuse me: say yes or no."));

        List<String> yes = new ArrayList<>(Arrays.asList("y", "yes", "yeah", "yep", "sure", "right", "affirmative",
                "correct", "indeed", "you bet", "exactly", "you said it"));

        List<String> no = new ArrayList<>(Arrays.asList("n", "no", "no way", "nah", "nope",
                "negative", "I don't think so", "yeah no"));

        answer = answer.trim().toLowerCase().replaceFirst("[!.]", "").stripLeading().stripTrailing();

        if(yes.contains(answer)){
            System.out.println("You answered: Yes");
        } else if(no.contains(answer)){
            System.out.println("You answered: No");
        } else {
            Collections.shuffle(wrongAnswer);
            System.out.println(wrongAnswer.get(1));
            Scanner scan = new Scanner(System.in);
            String inp = scan.nextLine();
            response(inp);
        }
        Collections.shuffle(goodbye);
        System.out.println(goodbye.get(1));

    }
}
