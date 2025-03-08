public class TwoStacksTest {
    public static void main(String[] args) {
        TwoStacks<Integer> myStacks = new TwoStacks<>();

        System.out.println(myStacks.isEmpty1());
        
        for (int i=0; i<10; i++) {
            myStacks.push1(i);
        }
        for (int i=0; i<10; i++) {  
            myStacks.push2(i);
        }
        for (int i=0; i<10; i++) {
            System.out.println(myStacks.pop1());
        }
        for (int i=0; i<6; i++) {
            System.out.println(myStacks.pop2());
        }
    }
}
