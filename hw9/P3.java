import java.util.Arrays;

public class P3 {
    public static <T extends Comparable<? super T>> int[] threewayPartition(T[] theList, int start, int end) {

        if (start-end+1 > theList.length || start >= end) {
            return new int[]{start, start};
        }
    
        T pivot = theList[start];
    
        int i = start+1;
        int j = end;
        int leftEq = start;
        int rightEq = end+1;
        boolean iWaiting = false;
        boolean jWaiting = false;
    
        while (i <= j) {
    
            if (!iWaiting)
            {
                int iCmp = theList[i].compareTo(pivot);
    
                if (iCmp > 0) 
                {
                    iWaiting = true;
                } 
                else if (iCmp < 0) 
                {
                    i++;
                } 
                else // equal to pivot
                {
                    swap(theList, i++, ++leftEq);
                }
            }

            if (iWaiting && i>=j) { break; }
    
            if (!jWaiting && j > i)
            {
                int jCmp = theList[j].compareTo(pivot);
    
                if (jCmp < 0) 
                {
                    jWaiting = true;
                } 
                else if (jCmp > 0) 
                {
                    j--;
                } 
                else // equal to pivot
                {
                    swap(theList, j--, --rightEq);
                }
            }
    
            if (iWaiting && jWaiting) 
            {
                swap(theList, i++, j--);
                iWaiting = false;
                jWaiting = false;
            }

            System.out.printf("i %d j %d\n", i, j);
        }

        // Swapping Equals back into the middle
        j = i--;
    
        for (int a=start; a<=leftEq; a++) {
            swap(theList, a, i--);
        }
        leftEq = i+1;
    
        for (int b=end; b>=rightEq; b--) {
            swap(theList, b, j++);
        }
        rightEq = j-1;
    
        return new int[]{leftEq, rightEq};
    }
    
    public static <T extends Comparable<? super T>> void swap(T[] theList, int a, int b) {
        T tmp = theList[a];
        theList[a] = theList[b];
        theList[b] = tmp; 
    }

    public static void main(String[] args) {
        Integer[] a = { 3, 9, 4, 2, 4, 7, 1, 4, 3 };
        System.out.println("Before partition: " + Arrays.toString(a));
        // partition between indices 0 and a.length-1
        int[] bounds = threewayPartition(a, 0, a.length-1);
        
        System.out.println("After partition: " + Arrays.toString(a));
        System.out.printf("equal block is from index %d to %d%n", bounds[0], bounds[1]);
    }
}