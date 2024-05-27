import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static int[] indegree;
    public static int[] time;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] result;
        time = new int[N + 1];
        indegree = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 1; i < N + 1; i++) {
            in = br.readLine().split(" ");
            time[i] = Integer.parseInt(in[0]);
            for(int j = 1; j < in.length - 1; j++) {
                graph.get(Integer.parseInt(in[j])).add(i);
                indegree[i]++;
            }
        }
        result = time.clone();
        topologySort(graph, N, result);
        for(int i = 1; i < N + 1; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static void topologySort(Map<Integer, List<Integer>> graph, int N, int[] result) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }
        while(!queue.isEmpty()) {
            int node = queue.poll();
            for(int neighbor : graph.get(node)) {
                indegree[neighbor]--;
                result[neighbor] = Math.max(result[neighbor], result[node] + time[neighbor]);
                if(indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
    }
}
