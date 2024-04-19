package Algorithm;

public class Sort {
    public int[] bubbleSort(int[] arr) {
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                // Swap an element with the next element if it's larger
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        System.out.println("Bubble sort time: " + time);

        return arr;
    }

    public int[] selectionSort(int[] arr) {
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            int smallest = arr[i];
            int index = arr[i];
            // find the smallest element of the rest of the array
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < smallest) {
                    smallest = arr[j];
                    index = j;
                }
            }
            // replace the current element with the smallest of the rest of the array
            arr[index] = arr[i];
            arr[i] = smallest;
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        System.out.println("Selection sort time: " + time);

        return arr;
    }

    public int[] insertionSort(int[] arr) {
        long startTime = System.nanoTime();

        int key, j;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                // variable "key" is the data needed to be placed again in the correct place
                key = arr[i];
                j = i;
                // check if the left index of the current index is greater than the key, if so shift the left index into the current
                while (j > 0 && arr[j - 1] > key) {
                    arr[j] = arr[j - 1];
                    j -= 1;
                }
                // place key into the correct place
                arr[j] = key;
            }
        }

        long endTime = System.nanoTime();
        long time = (endTime - startTime);
        System.out.println("Insertion sort time: " + time);

        return arr;
    }
}
