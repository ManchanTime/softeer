import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split("");
        int x = (in[0].charAt(0) - 'a');
        int y = Integer.parseInt(in[1]) - 1;
        List<Pair> moves = new ArrayList<>();
        int result = 8;
        moves.add(new Pair(2, 1));
        moves.add(new Pair(2, -1));
        moves.add(new Pair(1, 2));
        moves.add(new Pair(1, -2));
        moves.add(new Pair(-2, 1));
        moves.add(new Pair(-2, -1));
        moves.add(new Pair(-1, 2));
        moves.add(new Pair(-1, -2));

        for (Pair move : moves) {
            int tmpX = x + move.x;
            int tmpY = y + move.y;

            if((tmpX >= 8) || (tmpX < 0)){
                result--;
            }
            else if((tmpY >= 8) || (tmpY < 0)){
                result--;
            }
        }

        System.out.println(result);
    }

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
    }
}
