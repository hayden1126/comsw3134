public class test {
    public static void main(String[] args) {

        String word = "testing";
        for (int i=0; i<word.length()-1; i++) {
            System.out.println(i);
            String tmp = word.substring(0,i) + word.charAt(i+1) + word.charAt(i) + word.substring(i+2);
            System.out.println(tmp);
        }
    }

}
