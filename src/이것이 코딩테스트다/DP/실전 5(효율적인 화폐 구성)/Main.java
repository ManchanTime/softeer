import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int[] store = new int[M+1];
        Arrays.fill(store, 10001);
        int[] coin = new int[N];
        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        store[0] = 0;
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < N; j++) {
                if(i - coin[j] >= 0){
                    store[i] = Math.min(store[i - coin[j]] + 1, store[i]);
                }
            }
        }
        System.out.println(store[M] == 10001 ? -1 : store[M]);
    }
}
