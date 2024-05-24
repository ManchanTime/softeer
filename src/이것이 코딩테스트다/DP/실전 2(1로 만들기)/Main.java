import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        int[] store = new int[X + 1];
        store[1] = 0;
        // X % 5 == 0 -> X = X / 5;
        // X % 3 == 0 -> X = X / 3;
        // X % 2 == 0 -> X = X / 2;
        // X = X - 1;
        for (int i = 2; i < X + 1; i++) {
            store[i] = store[i-1] + 1;
            if (i % 2 == 0) {
                store[i] = Math.min(store[i], store[i / 2] + 1);
            }
            if (i % 3 == 0) {
                store[i] = Math.min(store[i], store[i / 3] + 1);
            }
            if (i % 5 == 0) {
                store[i] = Math.min(store[i], store[i / 5] + 1);
            }
        }
        System.out.println(store[X]);
    }
}
