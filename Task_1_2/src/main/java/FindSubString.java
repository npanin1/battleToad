import java.io.FileInputStream;
import java.io.IOException;

public class FindSubString {

    public static int SubString(String filepath, String sub) throws IOException {
        int res = -1;
        try(FileInputStream fin = new FileInputStream(filepath)){
            int i=-1, len = sub.length(), cnt = 0;;
            i=fin.read();
            while(i!=-1){

                if((char)i == sub.charAt(0)){
                    int beg = cnt, local_cnt = cnt;
                    while((i=fin.read())!=-1 && local_cnt - cnt + 1 != len && i == sub.charAt(local_cnt - beg + 1)){
                        local_cnt++;
                    }
                    if(local_cnt - cnt  + 1 == len){
                        System.out.println("{" + beg + "}");
                        res = beg;
                        break;
                    }
                    else{
                        cnt = local_cnt;
                        continue;
                    }
                }
                cnt++;
                i=fin.read();
            }
            if(i == -1){
                System.out.println("{}");

            }
        }
        return res;
    }
}
