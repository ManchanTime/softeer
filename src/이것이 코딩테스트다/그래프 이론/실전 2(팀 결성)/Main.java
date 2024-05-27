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
        int[] parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i = 1; i <= M; i++) {
            in = br.readLine().split(" ");
            int a = Integer.parseInt(in[0]);
            int b = Integer.parseInt(in[1]);
            int c = Integer.parseInt(in[2]);
            if (a == 0) {
                unionParent(parent, b, c);
            }
            else{
                if(findParent(parent, b) != findParent(parent, c)){
                    System.out.println("NO");
                }else{
                    System.out.println("YES");
                }
            }
        }
    }

    public static int findParent(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = findParent(parent, parent[x]);
        }
        return parent[x];
    }

    public static void unionParent(int[] parent, int x, int y){
        x = findParent(parent, x);
        y = findParent(parent, y);
        if(x < y) {
            parent[y] = x;
        }
        else{
            parent[x] = y;
        }
    }
}
