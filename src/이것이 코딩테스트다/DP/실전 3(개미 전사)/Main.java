import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] store = new int[N];
        String[] in = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            store[i] = Integer.parseInt(in[i]);
        }
        int[] check = new int[N];
        check[1] = store[1];

        for(int i = 2; i < N; i++) {
            check[i] = Math.max(check[i-2] + store[i], check[i-1]);
        }
        System.out.println(check[N-1]);
    }
}
