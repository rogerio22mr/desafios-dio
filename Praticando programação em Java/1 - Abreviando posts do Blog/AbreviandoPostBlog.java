import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AbreviandoPostBlog {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine()){
            String verify = scanner.nextLine();

            if(verify.isEmpty() || verify.equals(".")){
                break;
            } else {
                phraseReduction(verify);
            }
        }
    }

    public static void phraseReduction(String phrase) {
        String[] phraseArray = phrase.split(" ");
        String[] phraseArrayDistinct = Arrays.stream(phrase.split(" "))
                .distinct().sorted().toArray(String[]::new);

        if (phraseArray.length == 0) {
            return ;
        }

        String[] alphabetArray =
                new String[] {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                        "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        int count = 0;
        String[] phraseReplaced = Arrays.copyOf(phraseArray, phraseArray.length);
        List<String> words = new ArrayList<>();

        for(String letter : alphabetArray){
            List<String> wordsByLetter = GetWordsByLetter(phraseArrayDistinct, letter);

            if(wordsByLetter != null){
                String word = GetHighestWord(phraseArray, wordsByLetter);

                words.add(word);
                count++;
                replace(phraseReplaced, word);
            }
        }

        print(phraseReplaced, count, words);
    }

    private static void print(String[] phraseReplaced, int count, List<String> words){
        System.out.println(String.join(" ", phraseReplaced));
        System.out.println(count);

        for(String word : words){
            System.out.println(word.charAt(0) + ". = " + word);
        }
    }

    private static List<String> GetWordsByLetter(String[] phraseArrayDistinct, String letter){
        //list only words with letter target
        List<String> words = new ArrayList<>();

        for (String wordDistinct : phraseArrayDistinct) {
            if(wordDistinct.length() > 2 &&
                    (letter.charAt(0) == wordDistinct.charAt(0))
            ){
                words.add(wordDistinct);
            }
        }

        if(words.size() == 0){
            return null;
        }

        return words;
    }

    private static String GetHighestWord(String[] phraseArray, List<String> words){
        int lengthReduced = 0;
        String word = null;

        for (String _word : words) {
            int _count = CountWordRepeated(phraseArray, _word) ;
            int _lengthReduced = (_count * _word.length()) - (_count * 2);

            if(lengthReduced == 0 || (_lengthReduced > lengthReduced)
            ){
                lengthReduced = _lengthReduced;
                word = _word;
            }
        }

        return word;
    }

    private static int CountWordRepeated(String[] phraseArray, String word){
        int count = 0;

        for (String _word : phraseArray) {
            if (_word.equals(word)) {
                count++;
            }
        }

        return count;
    }

    private static void replace(String[] outPhraseArray, String word){
        for (int i = 0; i < outPhraseArray.length; i++) {
            if(outPhraseArray[i].equals(word)){
                outPhraseArray[i] = word.charAt(0) + ".";
            }
        }
    }

}
