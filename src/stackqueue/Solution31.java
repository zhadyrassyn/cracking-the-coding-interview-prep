package stackqueue;

/* Solution for task 3.1 'Three in One' */
public class Solution31 {

    private static class ThreeStack<T> {
        private Object[] arr;
        int capacity = 4;
        int[] stackSize = new int[3];

        public ThreeStack() {
            arr = new Object[capacity * 3];
        }

        public void push(int k, T elem) {
            if (stackSize[k] == capacity) {
                capacity *= 2;
                Object[] temp = new Object[capacity * 3];
                for(int i = 0; i < stackSize.length; i++) {
                    for (int j = i * capacity/2, j1 = i * capacity; j < i * capacity/2 + stackSize[i]; j++, j1++) {
                        temp[j1] = arr[j];
                    }
                }

                arr = temp;
            }

            arr[k * capacity + stackSize[k]] = elem;
            ++stackSize[k];
        }

        public Object peek(int k) {
            return arr[k * capacity + stackSize[k] - 1];
        }

        public int size(int k) {
            return stackSize[k];
        }

        public Object pop(int k) {
            Object temp = arr[k * capacity + stackSize[k] - 1];
            arr[k * capacity + stackSize[k] - 1] = null;
            --stackSize[k];
            return temp;
        }

        public void print() {
            for (int i = 0; i < stackSize.length; i++) {
                System.out.print("Stack " + i + ": ");
                for (int j = capacity * i; j < capacity * i + stackSize[i]; j++) {
                    System.out.print(arr[j] + ", ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        ThreeStack<Integer> threeStack = new ThreeStack<>();
        threeStack.push(0, 10);
        threeStack.push(1, 20);
        threeStack.push(2, 30);
        threeStack.push(0, 11);
        threeStack.push(0, 12);
        threeStack.push(0, 13);
        threeStack.push(0, 14);
        threeStack.push(0, 15);
        threeStack.push(0, 17);
        threeStack.push(0, 18);
        threeStack.push(0, 19);
        threeStack.push(0, 199);
        threeStack.push(1, 21);
        threeStack.push(1, 22);
        threeStack.push(1, 23);
        threeStack.push(1, 24);
        threeStack.push(1, 25);
        threeStack.push(2, 31);
        threeStack.push(2, 32);

        threeStack.print();

        System.out.println("CAPACITY: " + threeStack.capacity);

        System.out.println("PEEKS: ");
        System.out.println(threeStack.peek(0));
        System.out.println(threeStack.peek(1));
        System.out.println(threeStack.peek(2));

        System.out.println("SIZES:");
        System.out.println(threeStack.size(0));
        System.out.println(threeStack.size(1));
        System.out.println(threeStack.size(2));

        System.out.println("POPS: " );
        System.out.println(threeStack.pop(0));
        System.out.println(threeStack.size(0));

        System.out.println(threeStack.pop(1));
        System.out.println(threeStack.size(1));

        System.out.println(threeStack.pop(2));
        System.out.println(threeStack.size(2));

        threeStack.print();
    }
}
