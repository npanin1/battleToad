import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;

public class SubTest {
    @Test
    public void test0(){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/test/resources/input.txt"), StandardCharsets.UTF_8);
            ArrayList<Long> res = FindSubString.subString(inputStreamReader, "want");
            Long[] rightAns = new Long[]{2L, 18L, 23L, 37L};

            assertArrayEquals(rightAns, res.toArray());
            inputStreamReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test1(){
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/test/resources/input1.txt"), StandardCharsets.UTF_8);
            ArrayList<Long> res = FindSubString.subString(inputStreamReader, "ababc");
            Long[] rightAns = new Long[]{2L};

            assertArrayEquals(rightAns, res.toArray());
            inputStreamReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*@Test
    public void test2(){
        try {
            File tmpFile = File.createTempFile("text", ".txt", new File("src/test/resources"));

            String str = "I am a Globglobgabgalab and I love books";


            try(FileWriter writer = new FileWriter(tmpFile.getName(), true))
            {
                writer.write("qq");
                for(int i = 0; i < 100000000; i++){
                    writer.write(str);
                }
                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }

            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream("src/test/resources/" + tmpFile.getName()), StandardCharsets.UTF_8);

            ArrayList<Long> res = FindSubString.subString(inputStreamReader, "qq");
            Long[] rightAns = new Long[]{0L};


            assertArrayEquals(rightAns, res.toArray());
            inputStreamReader.close();

            tmpFile.deleteOnExit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}