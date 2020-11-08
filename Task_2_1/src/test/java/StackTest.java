import org.junit.Test;

public class StackTest {
    @Test
    public void test0() {
        Stack<Integer> arr = new Stack<>();
        arr.push(69);
        arr.push(34);
        arr.pop();
        assert(arr.count() == 1);
        for(int i = 0; i < 100; i++){
            arr.push(i);
        }
        assert(arr.count() == 101);
        assert(arr.pop() == 99);
    }

    @Test
    public void test1() {
        Stack<String> arr = new Stack<>();
        arr.push("sneg");
        arr.push("idet");
        arr.pop();
        assert(arr.count() == 1);
        for(int i = 0; i < 100; i++){
            arr.push(Integer.toString(i));
        }
        assert(arr.count() == 101);
        assert(arr.pop().equals("99"));
    }
}
