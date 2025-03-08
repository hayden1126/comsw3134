// The second method, checkFile, should read in the file character by character and 
// check to make sure that all { }’s, ( )'s, [ ]'s, " "’s, and /* */’s are properly balanced. 
// Make sure to ignore characters within literal strings (" ") and comment blocks (/* */). 
// Process the file by iterating through it one character at a time. During iteration, 
// the symbol currently pointed to in the loop will be referred to as <Current Symbol> henceforth.

import java.util.Stack;
import java.io.FileReader;
import java.io.IOException;

class SymbolBalance implements SymbolBalanceInterface {
    private String filename;
    private FileReader fr;

	public void setFile(String filename) {
        this.filename = filename;
    }   

	public BalanceError checkFile() {

        int lineNumber = 1;
        boolean isComment = false;
        boolean prevWasAsterisk = false;
        boolean prevWasSlash = false;

        Stack<Character> balanceStack = new Stack<>();
        char[] startBracket = new char[126];
        startBracket[(int) ')'] = '(';
        startBracket[(int) ']'] = '[';
        startBracket[(int) '}'] = '{';
        int i;

        try {
            fr = new FileReader(filename);
            while ((i = fr.read()) != -1) {           
                char ch = (char) i;
                if (i == '\n') { // if newline
                    lineNumber++; 
                    continue;
                }
                
                if (!balanceStack.isEmpty()){
                    if (balanceStack.peek() == '*') { // if in a comment
                        if (prevWasAsterisk && ch == '/') { // check end comment
                            balanceStack.pop();
                        } else {
                            prevWasAsterisk = (ch == '*');
                        }
                        continue;
                    }
                    else if (balanceStack.peek() == '\"') { // if in a string
                        if (ch == '\"') { // check end of string
                            balanceStack.pop();
                        }
                        continue;
                    }
                }
                
                if (prevWasSlash && ch == '*') { // if comment start
                    balanceStack.push('*');
                    continue;
                } else {
                    prevWasSlash = (ch == '/');
                    if (prevWasSlash) { continue; }
                }
                
                if ("{([\"".indexOf(ch) != -1) { // if open bracket or string start
                    balanceStack.push(ch);
                } 
                else if ("})]".indexOf(ch) != -1) { // if close bracket
                    if (balanceStack.isEmpty()) {
                        return new EmptyStackError(lineNumber);
                    }
                    char bracket1 = startBracket[(int) ch];
                    char symbolPopped = balanceStack.pop();
                    if (symbolPopped != bracket1) { 
                        return new MismatchError(lineNumber, ch, symbolPopped);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }

        if (!balanceStack.isEmpty()) {
            return new NonEmptyStackError(balanceStack.peek(), balanceStack.size());
        }
        return null;
    }
}