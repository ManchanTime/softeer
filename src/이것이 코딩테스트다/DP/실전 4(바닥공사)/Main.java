import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] store = new int[N+1];
        store[1] = 1;
        store[2] = 3;
        for (int i = 3; i <= N; i++) {
            store[i] = (store[i-1] + store[i-2] * 2) % 796796;
        }
        System.out.println(store[N]);
        // 1. store[i-1] + 1;
        // 2. store[i-2] + 2;
    }
}
