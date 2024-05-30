import java.util.Arrays;

public class BinaryHeapMerge {

    // Merge two binary heaps
    public static int[] mergeHeaps(int[] heap1, int[] heap2) {
        // Step 1: Combine the arrays
        int[] mergedHeap = new int[heap1.length + heap2.length];
        System.arraycopy(heap1, 0, mergedHeap, 0,heap1.length);
        System.arraycopy(heap2, 0, mergedHeap, heap1.length, heap2.length);

        // Step 2: Perform heapify operations
        int n = mergedHeap.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(mergedHeap, n, i);
        }

        return mergedHeap;
    }

    // Heapify operation
    private static void heapify(int[] heap, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // Compare with left child
        if (leftChild < n && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }

        // Compare with right child
        if (rightChild < n && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        // If largest is not the root
        if (largest != i) {
            int temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(heap, n, largest);
        }
    }

    // Main method to test the mergeHeaps function
    public static void main(String[] args) {
        int[] heap1 = {10, 5, 7, 12};
        int[] heap2 = {15, 3, 6, 9};
        System.out.println("Heap 1: " + Arrays.toString(heap1));
        System.out.println("Heap 2: " + Arrays.toString(heap2));
        // Merge the heaps
        int[] mergedHeap = mergeHeaps(heap1, heap2);

        // Output the merged heap
        System.out.println("Merged Heap: " + Arrays.toString(mergedHeap));
    }
}
