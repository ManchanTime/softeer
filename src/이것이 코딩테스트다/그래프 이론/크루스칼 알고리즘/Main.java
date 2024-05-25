import java.io.*;
import java.util.*;

public class Main {

    public static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        parent = new int[N + 1];
        List<NodeInfo> nodes = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]);
            int y = Integer.parseInt(in[1]);
            int value = Integer.parseInt(in[2]);
            nodes.add(new NodeInfo(x, y, value));
        }
        nodes.sort(new Comparator<NodeInfo>() {
            @Override
            public int compare(NodeInfo o1, NodeInfo o2) {
                return o1.value - o2.value;
            }
        });

        int result = 0;

        for(NodeInfo node: nodes) {
            int a = node.x;
            int b = node.y;
            int value = node.value;
            if(findParent(a) != findParent(b)) {
                unionParent(a, b);
                result += value;
            }
        }

        System.out.println(result);
    }

    public static int findParent(int x) {
        if(parent[x] != x) {
            parent[x] = findParent(parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int a, int b) {
        a = findParent(a);
        b = findParent(b);
        if (a < b) {
            parent[b] = a;
        }else parent[a] = b;
    }

    public static class NodeInfo {
        int x;
        int y;
        int value;

        public NodeInfo(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
