/*
Write a class called Palindrome that implements the provided the PalindromeInterface. 
It only requires a single method: isPalindrome which takes a String as a parameter. 
The method should make use of an instance of the MyStack class to verify whether the the String is a palindrome. 
Your method should ignore all spaces and be case insensitive. The method returns true if it is a palindrome, false if not.
*/

class Palindrome implements PalindromeInterface {

    public boolean isPalindrome(String x) {
        
        String xClean = x.toLowerCase().replaceAll("\\s", "");
        MyStack word = new MyStack();
        boolean result = true;

        for (int idx=0; idx<xClean.length(); idx++) {
            word.push(xClean.charAt(idx));
        }

        for (int idx=0; idx<xClean.length(); idx++) {
            if (!(word.pop().equals(xClean.charAt(idx)))) {
                result = false;
                break;
            }
        }

        return result;

    }

}