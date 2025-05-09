import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;

public class SpellChecker implements SpellCheckerInterface{

    private HashSet<String> dict;

    public SpellChecker(String filename) {
        dict = new HashSet<String>();

        try (Scanner inFile = new Scanner(new File(filename))) {
            while (inFile.hasNext()) {
                String word = inFile.next().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
                dict.add(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }
    }

    public List<String> getIncorrectWords(String filename) {
        List<String> result = new ArrayList<String>();

        try (Scanner inFile = new Scanner(new File(filename))) {
            while (inFile.hasNext()) {
                String word = inFile.next().toLowerCase().replaceAll("[^A-Za-z0-9]", "");
                if (!dict.contains(word)) {
                    result.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
        }

        return result;
    }

	public Set<String> getSuggestions(String word) {

        Set<String> result = new HashSet<String>();

        // Add one character - add a character at every point in the string (including at the very beginning and end)
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i=0; i<alphabet.length(); i++) {
            char c = alphabet.charAt(i);
            
            for (int j=0; j<=word.length(); j++) {
                String tmp = word.substring(0, j) + c + word.substring(j);

                if (dict.contains(tmp)) {
                    result.add(tmp);
                }
            }
        }

        // Remove one character - remove one character at a time from each position in the string
        for (int i=0; i<word.length(); i++) {
            String tmp = word.substring(0,i) + word.substring(i+1);
            if (dict.contains(tmp)) {
                result.add(tmp);
            }
        }

        // Swap adjacent characters - swap every pair of adjacent characters in the string
        for (int i=0; i<word.length()-1; i++) {
            String tmp = word.substring(0,i) + word.charAt(i+1) + word.charAt(i) + word.substring(i+2);
            if (dict.contains(tmp)) {
                result.add(tmp);
            }
        }
        return result;
    }
}