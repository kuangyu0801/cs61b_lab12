import edu.princeton.cs.algs4.Queue;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestQuickSort {
    @Test
    public void testQuickSort() {
        Queue<Integer> record1 = new Queue<>();
        Queue<Integer> record2 = new Queue<>();
        Queue<Integer> sortedRecord = new Queue<>();
        record1.enqueue(5);
        record1.enqueue(3);
        record1.enqueue(1);
        record1.enqueue(4);
        record1.enqueue(2);

        record2.enqueue(1);
        record2.enqueue(2);
        record2.enqueue(3);
        record2.enqueue(4);
        record2.enqueue(5);
        sortedRecord = QuickSort.quickSort(record1);
        for (Integer i : sortedRecord) {
            Integer actual = sortedRecord.dequeue();
            Integer expected = record2.dequeue();
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testQuickSortAllEqual() {
        Queue<Integer> record1 = new Queue<>();
        Queue<Integer> record2 = new Queue<>();
        Queue<Integer> sortedRecord = new Queue<>();
        record1.enqueue(2);
        record1.enqueue(2);
        record1.enqueue(2);
        record1.enqueue(2);
        record1.enqueue(2);

        record2.enqueue(2);
        record2.enqueue(2);
        record2.enqueue(2);
        record2.enqueue(2);
        record2.enqueue(2);
        sortedRecord = QuickSort.quickSort(record1);
        for (Integer i : sortedRecord) {
            Integer actual = sortedRecord.dequeue();
            Integer expected = record2.dequeue();
            assertEquals(expected, actual);
        }
    }
}
