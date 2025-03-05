package Utils;

public class Sorting {

    static public <T extends Comparable<T>> T[] quickSort(T[] arr, int first, int last) {

        if (first < last) {

            int pivotIndex = partition(arr, first, last);

            // recursive steps

            quickSort(arr, first, pivotIndex - 1); // sort left side
            quickSort(arr, pivotIndex + 1, last); // sort right side

        }

        return arr; // done (base case)

    }
    
    // Quick Sort Internals
    
    static private <T extends Comparable<T>> int partition(T[] arr, int first, int last) {

        T pivot = arr[last];
        int i = first - 1;

        for (int j = first; j < last; j++) {

            if (arr[j].compareTo(pivot) < 0) {

                i++;
                swap(arr, i, j);

            }

        }

        swap(arr, i + 1, last);

        return i + 1;

    }

    static private <T> void swap(T[] arr, int i, int j) {

        T temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;

    }

}