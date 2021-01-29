import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import static java.lang.Integer.max;

public class FindSubString {

    public static ArrayList<Long> subString(InputStreamReader filepath, String sub) throws IOException {

        if (filepath == null) {
            throw new NullPointerException("No such file");
        }
        if (sub == null) {
            throw new NullPointerException("Substring to search is null");
        }

        ArrayList<Long> res = new ArrayList<>();

        long cnt = 0;
        int len = sub.length();
        char[] buf = new char[len * 2];

        int readed = filepath.read(buf, len, len);

        if (readed < len) {
            return res;
        }
        boolean lastScan = false;
        do {
            System.arraycopy(buf, len, buf, 0, len);
            if (readed == len) {

                readed = filepath.read(buf, len, len);
                if(readed < len){
                    readed = max(readed, 0);
                    readed++;
                    lastScan = true;
                }
            }

            for (int i = 0; i < readed; i++) {
                boolean isSubStr = false;
                for (int j = 0; j < len; j++) {
                    if (buf[i + j] != sub.charAt(j)) {
                        break;
                    }
                    if (j == len - 1) {
                        isSubStr = true;
                        break;
                    }
                }
                if (isSubStr) {
                    res.add(cnt);
                }
                cnt++;
            }
        } while (!lastScan);


        return res;

    }
}
