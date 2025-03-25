package Utils;

/*
 * Sorting provides a static quickSort method which can sort any array of Comparable objects.
 * It also has some internals relevant to the public quickSort method.
*/

public class Sorting {

    static public <T extends Comparable<T>> T[] quickSort(T[] arr, int first, int last) {

        // this is similar to merge sort, but saves space by not creating new arrays
        // in some cases, our way of choosing the pivot may not be ideal: https://www.geeksforgeeks.org/when-does-the-worst-case-of-quicksort-occur/

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

        T pivot = arr[last]; // we just choose the last element as pivot
        int i = first - 1; // index of smaller element

        for (int j = first; j < last; j++) { // loop through all elements

            if (arr[j].compareTo(pivot) < 0) {

                i++;
                swap(arr, i, j); // put the smaller element in the front

            }

        }

        swap(arr, i + 1, last); // put the pivot in the right place
        
        // all elements smaller than the pivot are on the left side, and all elements larger than the pivot are on the right side

        return i + 1; // new pivot index

    }

    static private <T> void swap(T[] arr, int i, int j) {

        // simple swap function to move i to j and j to i

        T temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;

    }

}