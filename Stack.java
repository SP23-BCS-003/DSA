public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int item) {
        if (top == maxSize - 1) {
            System.out.println("Stack Is Full");
        } else {
            stackArray[++top] = item;
            System.out.println("Pushed item: " + item);
        }
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack Is Empty");
            return -1;
        } else {
            int poppedItem = stackArray[top--];
            System.out.println("Popped item: " + poppedItem);
            return poppedItem;
        }
    }
}
