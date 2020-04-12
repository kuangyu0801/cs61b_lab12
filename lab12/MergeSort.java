import edu.princeton.cs.algs4.Queue;
import org.junit.Test;

public class MergeSort {
    /**
     * Removes and returns the smallest item that is in q1 or q2.
     *
     * The method assumes that both q1 and q2 are in sorted order, with the smallest item first. At
     * most one of q1 or q2 can be empty (but both cannot be empty).
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      The smallest item that is in q1 or q2.
     */
    private static <Item extends Comparable> Item getMin(
            Queue<Item> q1, Queue<Item> q2) {
        if (q1.isEmpty()) {
            return q2.dequeue();
        } else if (q2.isEmpty()) {
            return q1.dequeue();
        } else {
            // Peek at the minimum item in each queue (which will be at the front, since the
            // queues are sorted) to determine which is smaller.
            Comparable q1Min = q1.peek();
            Comparable q2Min = q2.peek();
            if (q1Min.compareTo(q2Min) <= 0) {
                // Make sure to call dequeue, so that the minimum item gets removed.
                return q1.dequeue();
            } else {
                return q2.dequeue();
            }
        }
    }

    /** Returns a queue of queues that each contain one item from items. */
    private static <Item extends Comparable> Queue<Queue<Item>>
            makeSingleItemQueues(Queue<Item> items) {
        // Your code here!
        Queue<Queue<Item>> singleItemQueue = new Queue<>();
        for (Item item : items) {
            Queue<Item> oneItem = new Queue<>();
            oneItem.enqueue(item);
            singleItemQueue.enqueue(oneItem);
        }
        return singleItemQueue;
    }

    /**
     * Returns a new queue that contains the items in q1 and q2 in sorted order.
     *
     * This method should take time linear in the total number of items in q1 and q2.  After
     * running this method, q1 and q2 will be empty, and all of their items will be in the
     * returned queue.
     *
     * @param   q1  A Queue in sorted order from least to greatest.
     * @param   q2  A Queue in sorted order from least to greatest.
     * @return      A Queue containing all of the q1 and q2 in sorted order, from least to
     *              greatest.
     *
     */
    private static <Item extends Comparable> Queue<Item> mergeSortedQueues(
            Queue<Item> q1, Queue<Item> q2) {
        // Your code here!
        Queue<Item> sortedQueue = new Queue<>();
        int q1Size = q1.size();
        int q2Size = q2.size();
        int mergeTime =  q1Size + q2Size;
        for (int i = 0; i < mergeTime; i += 1) {
            sortedQueue.enqueue(MergeSort.getMin(q1, q2));
        }
        return sortedQueue;
    }


    /** Returns a Queue that contains the given items sorted from least to greatest. */
    public static <Item extends Comparable> Queue<Item> mergeSort(
            Queue<Item> items) {
        // Your code here!
        //int size = items.size();
        Queue<Queue<Item>> singleItemQueue = makeSingleItemQueues(items);
        while (singleItemQueue.size() != 1) {
            Queue<Item> firstQueue = singleItemQueue.dequeue();
            Queue<Item> secondQueue = singleItemQueue.dequeue();
            singleItemQueue.enqueue(MergeSort.mergeSortedQueues(firstQueue, secondQueue));
        }
        items = singleItemQueue.dequeue();
        return items;
    }

    public static void main(String[] args) {
        Queue<String> students = new Queue<>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
        System.out.println("[Original Queue]");
        for (String stu : students) {
            System.out.print(stu + ", ");
        }
        System.out.print("\n");
        Queue<String> studentsMerge = MergeSort.mergeSort(students);
        System.out.println("[Sorted Queue]");
        for (String stu : studentsMerge) {
            System.out.print(stu + ", ");
        }
        System.out.print("\n");
    }

    @Test
    public void testMergeSortedQueues() {
        Queue<Integer> record1 = new Queue<>();
        Queue<Integer> record2 = new Queue<>();
        record1.enqueue(1);
        record1.enqueue(3);
        record1.enqueue(5);
        record2.enqueue(2);
        record2.enqueue(4);
        Queue<Integer> mergeQueue = MergeSort.mergeSortedQueues(record1, record2);
        System.out.println(mergeQueue);
    }
}
