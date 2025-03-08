
class Problem3 {

    public static void main(String[] args) {

        BigO tester = new BigO();
        int n = 10;

        
        for (int i=1; i<=n; i++) {

            long startTime = System.nanoTime();
            tester.cubic(i);
            long endTime = System.nanoTime();

            System.out.println("Cubic: i= " + i + " ; runtime= " + (endTime-startTime));

        }

        for (int i=1; i<=n; i++) {

            long startTime = System.nanoTime();
            tester.exp(i);
            long endTime = System.nanoTime();

            System.out.println("Exp: i= " + i + " ; runtime= " + (endTime-startTime));

        }

        for (int i=1; i<=n; i++) {

            long startTime = System.nanoTime();
            tester.constant(i);
            long endTime = System.nanoTime();

            System.out.println("Constant: i= " + i + " ; runtime= " + (endTime-startTime));

        }

    }

}