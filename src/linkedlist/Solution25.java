package linkedlist;

/* Solution for task 'Sum Lists' 2.5 */
public class Solution25 {
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "125";

        int N1 = num1.length();
        int N2 = num2.length();

        DoubleLinkedList<Integer> linkedList = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> linkedList2 = new DoubleLinkedList<>();

        while (N1-- > 0) {
            linkedList.addBack(num1.charAt(N1) - '0');
        }

        while(N2-- > 0) {
            linkedList2.addBack(num2.charAt(N2) - '0');
        }

        linkedList.printForward();
        linkedList2.printForward();

        getSum(linkedList, linkedList2).printForward();
    }

    private static DoubleLinkedList<Integer> getSum(DoubleLinkedList<Integer> list1,
                                                    DoubleLinkedList<Integer> list2) {
        DoubleLinkedList<Integer> result = new DoubleLinkedList<>();

        int tens = 0;
        while (list1.size() > 0 && list2.size() > 0) {
            int a = list1.removeLast();
            int b = list2.removeLast();

            int sum = a + b + tens;
            tens = 0;
            if (sum <= 9) {
                result.addFront(sum);
            } else {
                result.addFront(sum - 10);
                ++tens;
            }
        }

        addLeft(list1, result, tens);
        addLeft(list2, result, tens);

        return result;
    }

    private static void addLeft(DoubleLinkedList<Integer> list, DoubleLinkedList<Integer> result, int tens) {
        while (list.size() > 0) {
            int a = list.removeLast() + tens;
            tens = 0;
            if (a >= 10) {
                ++tens;
                result.addFront(a - 10);
            } else {
                result.addFront(a);
            }
        }


    }
}
