import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Main {

    public static int maxTime = 0;
    public static int maxCity = 0;
    public static int INF = Integer.MAX_VALUE;
    public static List<Pair>[] nodes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");

        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int C = Integer.parseInt(in[2]);
        nodes = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            nodes[i] = new ArrayList<>();
        }
        nodes[0].add(new Pair(0, 0));
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int start = Integer.parseInt(in[0]);
            int end = Integer.parseInt(in[1]);
            int value = Integer.parseInt(in[2]);
            nodes[start].add(new Pair(end, value));
        }

        dijstra(N, C);

        System.out.println(maxCity-1 + " " + maxTime);
    }

    public static void dijstra(int N, int start) {
        int[] distance = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        PriorityQueue<Pair> pq;
        pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.value - o2.value;
            }
        });

        pq.add(new Pair(start, 0));
        while(!pq.isEmpty()) {
            Pair nowNode = pq.poll();
            int now = nowNode.end;
            if(visited[now])
                continue;
            visited[now] = true;

            for(Pair pair : nodes[now]) {
                if(distance[pair.end] > distance[now] + pair.value) {
                    distance[pair.end] = distance[now] + pair.value;

                    pq.add(new Pair(pair.end, distance[pair.end]));
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            if(distance[i] != INF){
                maxCity++;
                maxTime = Math.max(maxTime, distance[i]);
            }
        }
    }

    public static class Pair {
        int end;
        int value;
        public Pair(int end, int value) {
            this.end = end;
            this.value = value;
        }
    }
}
