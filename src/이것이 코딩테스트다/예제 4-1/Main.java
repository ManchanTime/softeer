import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] in = br.readLine().split(" ");
        List<String> move = new ArrayList<>(Arrays.asList(in));
        Pair location = new Pair(0, 0);
        for (String m : move) {
            if (m.equals("R")) {
                if (location.getX() != (N - 1)) {
                    location.setX(location.getX() + 1);
                }
            } else if (m.equals("L")) {
                if (location.getX() != 0) {
                    location.setX(location.getX() - 1);
                }
            } else if (m.equals("U")) {
                if (location.getY() != 0) {
                    location.setY(location.getY() - 1);
                }
            } else {
                if (location.getY() != (N - 1)) {
                    location.setY(location.getY() + 1);
                }
            }
        }
        System.out.println((location.getY() + 1) + " " + (location.getX() + 1));
    }

    public static class Pair {
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public void setX(int x) {
            this.x = x;
        }
        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }
}
