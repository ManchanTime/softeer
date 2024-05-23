import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Pair> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            list.add(new Pair(in[0], Integer.parseInt(in[1])));
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.score - o2.score;
            }
        });
        for (Pair pair : list) {
            System.out.print(pair.name + " ");
        }
    }

    public static class Pair {
        String name;
        int score;
        public Pair(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
