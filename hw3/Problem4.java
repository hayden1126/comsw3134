import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem4 {
    public static <T> void printReverseNTime(Node<T> head) {
        String output = "";
        Node<T> currNode = head;

        if (head != null) {output += head.data.toString(); }
        while (currNode.next != null) {
            currNode = currNode.next;
            output = String.format("%s\n%s", currNode.data.toString(), output);
        } // Adds each item to the front of the string

        System.out.println(output.strip());
    }

    class Node <T> {
        T data;
        Node<T> next;

        Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public static <T> void printReverse1Space(Node<T> head) {
        
        if (head == null) { return; }
        
        Node<T> endMarker = null;

        while (head != endMarker) {
            Node<T> currNode = head;
            while (currNode.next != null) {
                if (endMarker == null || currNode != endMarker) {
                    currNode = currNode.next;
                } else {
                    break;
                }
            }

            System.out.println(currNode.data.toString());
            endMarker = currNode;
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        myList.add(1); myList.add(2); myList.add(3);
        printReverseNTime(myList);
        printReverse1Space(myList);
    }
}
