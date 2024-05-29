import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        in = br.readLine().split(" ");
        int[] count = new int[M + 1];
        for (int i = 0; i < N; i++) {
            count[Integer.parseInt(in[i])]++;
        }

        int result = 0;
        for (int i = 1; i <= M; i++) {
            N -= count[i];
            result += count[i] * N;
        }
        System.out.println(result);
    }
}
