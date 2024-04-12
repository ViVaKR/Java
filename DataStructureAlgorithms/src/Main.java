import java.util.*;

// TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {

        int choice = 4;
        switch (choice) {
            case 1:
                StackDemo();
                break;
            case 2:
                QueueDemo();
                break;
            case 3:
                LinkedListsDemo();
                break;
            case 4: // merge short
                // --> recursively divide array in 2, sort, re-combine
                // run-time complexity  = O(n Log n)
                // space complexity     = O(n)
                int[] array = {8, 2, 5, 3, 4, 7, 6, 1};
                mergeSort(array);
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i] + " ");
                }
                break;
        }
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        if (length <= 1) return; // base case

        int middle = length / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length - middle];

        int i = 0; //left array
        int j = 0; // right array

        for (; i < length; i++) {
            if (i < middle) {
                leftArray[i] = array[i];
            } else {
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r= 0; // indices

        while (l < leftSize && r < rightSize){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }

        while (l < leftSize){
            array[i] = leftArray[l];
            i++;
            l++;
        }

        while (r < rightSize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    private static void LinkedListsDemo() {
        //
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.offer("A");
        linkedList.offer("B");
        linkedList.offer("C");
        linkedList.offer("D");
        linkedList.offer("F");
        // linkedList.pop();
        linkedList.add(4, "E");
        linkedList.remove("E");
        linkedList.poll();
        System.out.println(linkedList);
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.peekLast());
    }

    private static void QueueDemo() {
        // FIFO
        // add = enqueue, offer()
        // remove = dequeue, poll()
        // element() peek()

        // Where are queues useful?
        // Keyboard Buffer
        // Printer queue
        // Used LinkedList

        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.isEmpty());
        queue.offer("Karen");
        queue.offer("Chad");
        queue.offer("Steve");
        queue.offer("Harold");
//        queue.poll();
//        queue.poll();
//        queue.element();
        System.out.println(queue.isEmpty());
        System.out.println(queue);
        System.out.println(queue.peek());
        System.out.println(queue.contains("Harold"));

        // Priority Queue
        Queue<Double> queue1 = new PriorityQueue<>(Collections.reverseOrder()); // DESC,  Sort ASC (default)
        queue1.offer(3.0);
        queue1.offer(2.5);
        queue1.offer(4.0);
        queue1.offer(1.5);
        queue1.offer(2.0);
        while (!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }
    }

    private static void StackDemo() {
        Stack<String> stack = new Stack<>();
        stack.push("Minecraft");
        stack.push("Skyrim");
        stack.push("DOOM");
        stack.push("Borderlands");
        stack.push("FFVII");
//        String favGame = stack.pop();
//        System.out.println(stack.peek());
//        System.out.println(stack.search("DOOM"));
    }
}
