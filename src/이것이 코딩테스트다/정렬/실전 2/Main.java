import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}
