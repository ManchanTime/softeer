import java.io.*;
import java.util.*;

public class Main {

    public static int[][] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        matrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            in = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(in[j]);
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(check(i, j)){
                    result++;
                }
            }
        }
        System.out.println(result);
    }

    public static boolean check(int x, int y) {
        if(x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1) {
            return false;
        }
        if(matrix[x][y] == 0) {
            matrix[x][y] = 1;
            check(x - 1, y);
            check(x + 1, y);
            check(x, y - 1);
            check(x, y + 1);
            return true;
        }
        return false;
    }
}
