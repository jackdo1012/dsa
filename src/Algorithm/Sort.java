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
}
