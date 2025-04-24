import java.util.*;

public class KBestCounter<T extends Comparable<? super T>> implements KBest<T>
{
    int k;
    PriorityQueue<T> queue;

    public KBestCounter(int k) {
        this.k = k;
        queue = new PriorityQueue<T>();
    }

	public void count(T x) {
        // process the next element in the set of data. This operation must run in at worst O(log k) time.
        queue.add(x);

        if (queue.size() > k) {
            queue.poll();
        }
    }

	public List<T> kbest() {
        PriorityQueue<T> tmpQueue = new PriorityQueue<T>(queue);
        List<T> result = new ArrayList<T>();

        while (!tmpQueue.isEmpty()) {
            result.add(tmpQueue.poll());
        }

        return result;
    }

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