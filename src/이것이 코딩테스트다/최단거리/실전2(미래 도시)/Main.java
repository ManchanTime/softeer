import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int target;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int INF = 987654321;
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int[][] road = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(road[i], INF);
        }
        for(int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0])-1;
            int y = Integer.parseInt(in[1])-1;
            road[x][y] = 1;
            road[y][x] = 1;
        }
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if (i == j) {
                    road[i][j] = 0;
                }
            }
        }

        in = br.readLine().split(" ");
        int X = Integer.parseInt(in[0]) - 1;
        int K = Integer.parseInt(in[1]) - 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    road[j][k] = Math.min(road[j][k], road[j][i] + road[i][k]);
                }
            }
        }

        int result = road[0][K] + road[K][X];
        if(result >= INF){
            System.out.println("-1");
        }else System.out.println(result);
    }
}
