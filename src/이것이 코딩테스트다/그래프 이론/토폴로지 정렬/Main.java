import java.io.*;
import java.util.*;

public class Main {

    public static int[] indegree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        indegree = new int[N + 1];
        Map<Integer, List<Integer>> nodes = new HashMap<>();

        for(int i=1; i<=N; i++) {
            nodes.put(i, new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            indegree[y]++;
            nodes.get(x).add(y);
        }

        List<Integer> result = topologySort(nodes);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> topologySort(Map<Integer, List<Integer>> nodes) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < nodes.size(); i++) {
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            result.add(now);
            List<Integer> children = nodes.get(now);
            for(Integer child : children) {
                indegree[child]--;
                if(indegree[child] == 0){
                    q.add(child);
                }
            }
        }
        return result;
    }
}
