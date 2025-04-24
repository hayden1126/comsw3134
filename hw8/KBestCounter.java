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

}