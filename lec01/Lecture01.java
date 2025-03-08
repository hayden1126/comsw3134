package lec01;
public class Lecture01 {
    public static void main(String[] args){
        int[] arr_a = new int[9];
        int[] arr_b = {1, 2, 3, 4, 5};
        int[] arr_c = {1, 3, 4, 7, 9, 21, 35};
        System.out.println(arr_a.length);
        System.out.println(arr_b[3]);
        System.out.println(linearSearch(arr_b, 2));
    }

    public static int linearSearch(int[] a, int x){
        for (int i=0; i<a.length; i++){
            if (a[i] == x)
                return i;
        }
        return -1;
    }
}

// public static int binarySearch(int[] a, int x){
//     int start = 0;
//     int stop = a.length - 1;

//     while (start <= stop){
            
//     }
// }