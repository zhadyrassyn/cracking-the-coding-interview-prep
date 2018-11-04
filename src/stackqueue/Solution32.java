package stackqueue;

import java.util.EmptyStackException;
import java.util.Stack;

/* Solution for task 3.2 'Stack min' */
public class Solution32 {

    public static class StackMin extends Stack<Integer> {

        private Stack<Integer> min = new Stack<>();

        public Integer pop() {
            Integer data = super.pop();
            min.pop();
            return data;
        }

        public void push(int item) {

            if (isEmpty()) {
                super.push(item);
                min.push(item);
            } else {
                super.push(item);

                int lastMin = min.peek();

                if (item < lastMin) {
                    min.push(item);
                } else {
                    min.push(lastMin);
                }
            }

        }

        public Integer min() {
            return min.peek();
        }
    }

    public static void main(String[] args) {
        StackMin stackMin = new StackMin();

        stackMin.push(5);
        stackMin.push(6);
        stackMin.push(7);
        stackMin.push(2);
        stackMin.push(10);

        System.out.println(stackMin.min()); //2

        stackMin.pop();
        stackMin.pop();

        System.out.println(stackMin.min()); //5
    }
}
