import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class StackTest {
    @Test
    public void test0() {
        Task2_1_Stack d = new Task2_1_Stack();
        d.Push(7);
        d.Push(6);
        d.Push("sccvfdvfd");
        int res = d.Count();
        assert(res == 3);
        d.Pop();
        d.Pop();
        d.Push(244);
        res = d.Count();
        assert(res == 2);

    }
}
