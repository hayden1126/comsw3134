import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;

class Problem1 {
    public static <T> void printLots(List<T> L, List<Integer> P) {
        
        int targetIdx;

        Iterator<Integer> pIter = P.iterator();
        while (pIter.hasNext()) {

            targetIdx = pIter.next();
            int index = -1;

            Iterator<T> lIter = L.iterator();
            while (lIter.hasNext()) {
                index++;

                // System.out.println("Index: " + index + " Target: " + target);
                T currT = lIter.next();

                if (index != targetIdx) {
                    continue;
                }

                System.out.println(currT);

            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> L = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10));
        ArrayList<Integer> P = new ArrayList<>(Arrays.asList(0, 1, 4));
        printLots(L, P);
    }
}