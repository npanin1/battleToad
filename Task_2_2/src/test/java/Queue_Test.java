import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class Queue_Test {
    @Test
    public void test(){
        Pr_Queue<Integer, Integer> queue = new Pr_Queue<>();
        queue.insert(2, 11);
        queue.insert(4, 13);
        queue.insert(3, 12);
        queue.insert(6, 15);
        queue.insert(5, 14);
        queue.insert(1, 12123);
        assertEquals(Integer.valueOf(12123), queue.extract_Minimum());
        assertEquals(Integer.valueOf(11), queue.extract_Minimum());
        assertEquals(Integer.valueOf(12), queue.extract_Minimum());
        queue.insert(2, 1111);
        assertEquals(Integer.valueOf(1111), queue.extract_Minimum());
        assertEquals(Integer.valueOf(13), queue.extract_Minimum());
        assertEquals(Integer.valueOf(14), queue.extract_Minimum());
    }
    @Test
    public void test1(){
        Pr_Queue<Integer, String> queue = new Pr_Queue<>();
        queue.insert(1, "11");
        queue.insert(3, "13");
        queue.insert(2, "12");
        queue.insert(5, "15");
        queue.insert(4, "14");
        queue.insert(0, "12123");
        assert(queue.extract_Minimum().equals("12123"));
        assert(queue.extract_Minimum().equals("11"));
        assert(queue.extract_Minimum().equals("12"));
        queue.insert(2, "1111");
        assert(queue.extract_Minimum().equals("1111"));
        assert(queue.extract_Minimum().equals("13"));
        assert(queue.extract_Minimum().equals("14"));
    }
    @Test
    public void test2(){
        Pr_Queue<Integer, Integer> queue = new Pr_Queue<>();
        queue.insert(20, 1);
        queue.insert(15, 2);
        queue.insert(10, 3);
        queue.insert(0, 4);

        Stream<Integer> stream1 = Stream.of(4, 3, 2, 1);
        Stream<Integer> stream2 = queue.stream();

        Iterator<?> iter1 = stream1.iterator(), iter2 = stream2.iterator();
        while(iter1.hasNext() && iter2.hasNext()) {
            assertEquals(iter1.next(), iter2.next());
        }
    }
}
