import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] coins = new int[N];
        String[] in = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(coins);

        int target = 1;
        for(int i : coins) {
            if(i > target ){
                System.out.println(target);
                break;
            }
            target += i;
        }
    }
}
