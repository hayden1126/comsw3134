public class KBestCounterTest {
    public static void main(String[] args) {
        KBestCounter<Integer> kbc = new KBestCounter<Integer>(3);
        kbc.count(5);
        kbc.count(3);
        kbc.count(1);
        kbc.count(6);
        kbc.count(2);
        kbc.count(7);
        kbc.count(6);

        for (int i : kbc.kbest()) {
            System.out.println(i);
        }

    }
}
