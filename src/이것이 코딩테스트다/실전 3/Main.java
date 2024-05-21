import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int x, y;
        int nowLook;
        int[][] map = new int[N][M];
        boolean[][] check = new boolean[N][M];
        int count = 0;
        int result = 1;
        //북 동 남 서
        int[] lookX = {0, 1, 0, -1};
        int[] lookY = {-1, 0, 1, 0};
        in = br.readLine().split(" ");
        x = Integer.parseInt(in[0]);
        y = Integer.parseInt(in[1]);
        check[x][y] = true;
        nowLook = Integer.parseInt(in[2]);

        for (int i = 0; i < N; i++) {
            in = br.readLine().split(" ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(in[j]);
            }
        }

        while(true) {
            nowLook = (nowLook + 3) % 4;
            int tmpX = x + lookX[nowLook];
            int tmpY = y + lookY[nowLook];
            if(!check[tmpX][tmpY] && map[tmpX][tmpY] != 1){
                x = tmpX;
                y = tmpY;
                check[x][y] = true;
                result++;
            }
            else{
                count++;
            }
            if(count == 4){
                x = x - lookX[nowLook];
                y = y - lookY[nowLook];
                if(map[x][y] == 1){
                    break;
                }
                count = 0;
            }
        }

        System.out.println(result);
    }
}
