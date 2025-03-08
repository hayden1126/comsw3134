package lec02;
public class Lecture02 {
    public static void main(String[] args){
        // System.out.println(fibonacci(5));
        // System.out.println(factorial(5));
        int n = Integer.parseInt(args[0]);
        for (int i=0; i<=n; i++){
            System.out.println(fibonacci(i));
        }
    }
    public static int fibonacci(int n){
        if (n==0) return 1;
        if (n==1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public static int factorial(int n){
        if (n==0) return 1;
        return n * factorial(n-1);
    }

    public static void interface(){
        ArrayList<String> stuff = new ArrayList<>();
    }
}
