import org.junit.Test;


import java.io.IOException;

public class SubTest {
    @Test
    public void test0(){
        try {
            int res = FindSubString.SubString("input.txt", "want");
            assert res == 2;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        try {
            int res = FindSubString.SubString("input1.txt", "want");
            assert res == 12;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
