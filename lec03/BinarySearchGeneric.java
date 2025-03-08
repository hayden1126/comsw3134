public class BinarySearchGeneric {

    public static <E extends Comparable<E>> // ie E can be treated as a comparable to E
        int BinarySearch(E[] a, E value) {
            
            int start = 0;
            int stop = a.length - 1;

            while (start<=stop) {
                int mid = (start+stop)/2;

                int compareResult = a[mid].compareTo(value);
                if(compareResult == 0) {
                    return mid;
                } else if (compareResult > 0) {
                    // if the value exists, it's in the lower half
                    stop = mid - 1;
                } else { // id compareResult < 0
                    // if the value exists, it's in the upper half
                    start = mid + 1;
                }
            }

            return -1;
                
        }

    public static <E extends Comparable<E>>
        int binarySearchRecursive(E[] a, E value) {
            
            int start = 0;
            int stop = a.length - 1;

            return binarySearchRecursive(a, value, start, stop);
        }

    private static <E extends Comparable<E>>
        int binarySearchRecursive(E[] a, E value, int start, int stop) {
            
            if (start>stop) {
                return -1;
            }

            int mid = (start+stop)/2;

            int compareResult = a[mid].compareTo(value);
            if(compareResult == 0) {
                return mid;
            } else if (compareResult > 0) {
                // if the value exists, it's in the lower half
                return binarySearchRecursive(a, value, start, mid-1);
            } else { // id compareResult < 0
                // if the value exists, it's in the upper half
                return binarySearchRecursive(a, value, mid+1, stop);
            }
        }

}