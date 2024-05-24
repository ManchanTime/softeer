import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        int[] objects = new int[N];
        for (int i = 0; i < N; i++) {
            objects[i] = Integer.parseInt(in[i]);
        }
        int M = Integer.parseInt(br.readLine());
        in = br.readLine().split(" ");
        int[] finds = new int[M];
        for (int i = 0; i < M; i++) {
            finds[i] = Integer.parseInt(in[i]);
        }

        Arrays.sort(objects);
        for (int i = 0; i < M; i++) {
            result(finds[i], objects, 0, objects.length - 1);
        }
    }

    public static void result(int N, int[] objects, int start, int end) {
        if(start > end){
            System.out.print("no ");
            return;
        }
        int mid = (start + end) / 2;
        if(objects[mid] < N){
            result(N, objects, mid + 1, end);
        }
        else if(objects[mid] > N){
            result(N, objects, start, mid - 1);
        }
        else if(objects[mid] == N){
            System.out.print("yes ");
        }
    }
    //2 3 7 8 9
}
