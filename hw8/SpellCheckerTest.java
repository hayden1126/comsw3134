import java.util.List;
import java.util.Set;

public class SpellCheckerTest {
    public static void main(String[] args) {
        SpellChecker sc = new SpellChecker("words.txt");

        List<String> incorrect = sc.getIncorrectWords("test.txt");

        for (String i : incorrect) {
            System.out.println("INCORRECT WORD: " + i);
            Set<String> suggestions = sc.getSuggestions(i);

            for (String s : suggestions) {
                System.out.println(s);
            }
            System.out.println("");
        }
    }
}
