import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] members = new int[N];
        String[] in = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            members[i] = Integer.parseInt(in[i]);
        }

        Arrays.sort(members);
        int result = 0;
        int count = 0;
        for(int i : members) {
            count++;
            if(count >= i) {
                result++;
                count = 0;
            }
        }
        System.out.println(result);
    }
}
