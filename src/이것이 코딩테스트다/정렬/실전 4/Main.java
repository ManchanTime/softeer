import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        Integer[] A = init(br, N);
        Integer[] B = init(br, N);
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < M; i++) {
            if (A[i] < B[i]) {
                int tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;
            }
        }

        int sum = 0;
        for(int i=0;i<N;i++){
            sum += A[i];
        }
        System.out.println(sum);
    }

    public static Integer[] init(BufferedReader br, int N) throws IOException {
        Integer[] result = new Integer[N];
        String[] in = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            result[i] = Integer.parseInt(in[i]);
        }
        return result;
    }
}
