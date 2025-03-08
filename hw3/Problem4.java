import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem4 {
    public static <T> void printReverseNTime(LinkedList<T> list) {
        String output = "";

       for (T item : list) {
            output = String.format("%s\n%s", item, output);
        }

        System.out.println(output.strip());
    }

    public static <T> void printReverse1Space(List<T> list) {
        
        if (list.isEmpty()) { return; }
        
        T endMarker = null;

        while (!list.get(0).equals(endMarker)) {
            T current = null;

            for (T item : list) {
                if (endMarker == null) {
                    current = item;
                } else if (!item.equals(endMarker)) {
                    current = item;
                } else {
                    break;
                }
            }

            System.out.println(current);
            endMarker = current;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(1); myList.add(2); myList.add(3);
        printReverseNTime(myList);
        printReverse1Space(myList);
    }
}
