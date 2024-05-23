import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[][] matrix;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int[][] matrix = new int[N][M];

        //동서 남북
        int[] moveX = {1, -1, 0, 0};
        int[] moveY = {0, 0, 1, -1};

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            in = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                matrix[i][j] = Integer.parseInt(in[j]);
            }
        }

        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = point.x + moveX[i];
                int y = point.y + moveY[i];
                if(x < 0 || x > N - 1)
                    continue;
                if(y < 0 || y > M - 1)
                    continue;
                if(matrix[x][y] == 0)
                    continue;
                if(matrix[x][y] == 1){
                    queue.add(new Point(x, y));
                    matrix[x][y] += matrix[point.x][point.y];
                }
            }
        }
        System.out.println(matrix[N - 1][M - 1]);
    }

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
