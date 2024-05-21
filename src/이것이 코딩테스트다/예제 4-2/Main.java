import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i <= N; i++) {
            String h = i + "";
            if(h.contains("3")){
                result += 60 * 60;
                continue;
            }
            for (int j = 0; j < 60; j++) {
                String m = j + "";
                if(m.contains("3")){
                    result += 60;
                    continue;
                }
                for (int k = 0; k < 60; k++) {
                    String s = k + "";
                    if(s.contains("3")){
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
