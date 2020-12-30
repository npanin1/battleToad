import org.junit.Test;

import java.io.IOException;

public class SubTest {
    @Test
    public void test0(){
        try {
            FindSubString.SubString("input.txt", "want");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
