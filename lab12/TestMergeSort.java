import edu.princeton.cs.algs4.Queue;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestMergeSort {

    @Test
    public void testMergeSort() {
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
        sortedRecord = MergeSort.mergeSort(record1);
        for (Integer i : sortedRecord) {
            Integer actual = sortedRecord.dequeue();
            Integer expected = record2.dequeue();
            assertEquals(expected, actual);
        }
    }


/*    @Test
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
    }*/

/*    @Test
    public void testMakeSingleItemQueues() {
        Queue<String> students = new Queue<>();
        students.enqueue("Alice");
        students.enqueue("Vanessa");
        students.enqueue("Ethan");
        System.out.println("[Original Queue]");
        System.out.println(students);
        for (String stu : students) {
            System.out.print(stu + ", ");
        }
        System.out.print("\n");
        Queue<Queue<String>> singleStudents;
        singleStudents = MergeSort.makeSingleItemQueues(students);
        System.out.println("[Single Queue]");
        System.out.println(singleStudents);
        for (Queue stu : singleStudents) {
            System.out.print(stu + ", ");
        }
        System.out.print("\n");
    }*/
}
