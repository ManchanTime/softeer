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
        in = br.readLine().split(" ");
        int[] lengths = new int[N];
        for(int i = 0; i < N; i++) {
            lengths[i] = Integer.parseInt(in[i]);
        }
        Arrays.sort(lengths);
        int max = 0;
        for(int i = 0; i < N; i++) {
            if(max < lengths[i]) {
                max = lengths[i];
            }
        }

        System.out.println(binarySearch(lengths, 0, max, M));
    }

    public static int binarySearch(int[] lengths, int start, int end, int target) {
        int result = 0;
        int cnt = 0;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            cnt = count(mid, lengths);
            if (cnt >= target) {
                start = mid + 1;
                result =  mid;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static int count(int mid, int[] lengths) {
        int result = 0;
        for (int length : lengths) {
            if (length - mid >= 0) {
                result += length - mid;
            }
        }
        return result;
    }
}
