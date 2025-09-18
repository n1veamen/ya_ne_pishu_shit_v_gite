//import java.util.Random;
//import java.util.Scanner;
//
//public class leetcode4 {
//    public void main(String[] args) {
//        String[] Words = {"rede", "great", "dala"};
//        int rndWordIndex = new Random().nextInt(Words.length);
//        String rndWord = Words[rndWordIndex];
//
//        System.out.println("Welcome to the Hangman game!");
//        System.out.println("You need to guess the word by entering one letter at a time.");
//        System.out.println("If you guess wrong, a stickman will be drawn step by step.");
//        System.out.println("You can win by guessing all the letters in the word before the stickman is fully drawn.");
//        System.out.println("Please enter a letter to start:");
//        Scanner scanner = new Scanner(System.in);
//        String[] status = {
//                "",
//                "|\n|",
//                "|\n|\n|\n|",
//                "| =\n|\n|\n|",
//                "| = |\n|\n|\n|",
//                "| = |\n|   0\n|\n|",
//                "| = |\n|   0\n|   |\n|",
//                "| = |\n|   0\n|   |\\\n|",
//                "| = |\n|   0\n|  /|\\\n|",
//                "| = |\n|   0\n|  /|\\\n|  /",
//                "| = |\n|   0\n|  /|\\\n|  / \\"
//        };
//        int statusOfStickman = 0;
//        String hiddenWord = "";
//        for (int i = 0; i < Words[0].length(); i++) {
//            hiddenWord += "_";
//        }
//        String[] splittedHiddenWord = hiddenWord.split("");
//        String[] splittedWord = Words[0].split("");
//        int uniqueCharsDict = 0;
//        boolean isGameStarted = true;
//        while (isGameStarted) {
//            if (uniqueCharsDict == splittedWord.length - 1) {
//                System.out.println("winwinwin");
//                break;
//            }
//            boolean fail = false;
//            boolean dfg = true;
//            String temp = "";
//            String inputChar = String.valueOf(scanner.next().charAt(0));
//            for (int i = 0; i < splittedWord.length; i++) {
//                if (inputChar.equals(splittedWord[i])) {
//                    splittedHiddenWord[i] = inputChar;
//                    if (splittedHiddenWord[i].equals(temp)) {
//                        dfg = false;
//                    }
//                    temp = inputChar;
//                } else if (i == splittedWord.length - 1) {
//                    if (dfg) {
//                        fail = true;
//                    }
//                }
//            }
//            if (!dfg) {
//                uniqueCharsDict += 1;
//            }
//            if (fail) {
//                statusOfStickman += 1;
//                System.out.println(status[statusOfStickman]);
//            }
//            for (int j = 0; j < splittedHiddenWord.length; j++) {
//                System.out.print(splittedHiddenWord[j]);
//            }
//            System.out.println();
//            if (statusOfStickman == status.length - 1) {
//                isGameStarted = false;
//                System.out.println("PROEBAL");
//            }
//            System.out.println("===============================================================");
//        }
//    }
//}

