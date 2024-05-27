import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    public static int[] indegree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        int N = Integer.parseInt(in[0]);
        int M = Integer.parseInt(in[1]);
        int[] parent = new int[N+1];
        List<NodeInfo> nodeInfoList = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= M; i++) {
            in = br.readLine().split(" ");
            int s = Integer.parseInt(in[0]);
            int e = Integer.parseInt(in[1]);
            int w = Integer.parseInt(in[2]);
            nodeInfoList.add(new NodeInfo(s, e, w));
        }

        nodeInfoList.sort(new Comparator<NodeInfo>() {
            @Override
            public int compare(NodeInfo o1, NodeInfo o2) {
                return o1.weight - o2.weight;
            }
        });

        int result = 0;
        int max = 0;
        for (NodeInfo nodeInfo : nodeInfoList) {
            if(findParent(parent, nodeInfo.s) != findParent(parent, nodeInfo.e)){
                result += nodeInfo.weight;
                max = nodeInfo.weight;
                unionParent(parent, nodeInfo.s, nodeInfo.e);
            }
        }
        System.out.println(result - max);
    }

    public static int findParent(int[] parent, int x) {
        if(parent[x] != x) {
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int[] parent, int x, int y) {
        x = findParent(parent, x);
        y = findParent(parent, y);
        if(x < y){
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
    }

    public static class NodeInfo {
        int s;
        int e;
        int weight;

        public NodeInfo(int s, int e, int weight) {
            this.s = s;
            this.e = e;
            this.weight = weight;
        }
    }
}
