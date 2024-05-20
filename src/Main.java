import java.io.*;
import java.util.*;

public class Main {

    //문제 링크
    // https://softeer.ai/app/assessment/index.html?xid=102431&xsrfToken=ElPfqJVHAwAb9TXkTev0TNqQrr8Xu3mU&testType=practice
    public static List<Pair> member;
    public static int[] numbers;
    public static boolean[] isUsed;
    public static boolean[][] check;
    public static int n;
    public static int m;
    public static int result = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] in = br.readLine().split(" ");
        n = Integer.parseInt(in[0]);
        m = Integer.parseInt(in[1]);
        int[][] ground = new int[n][n];
        member = new ArrayList<>();
        numbers = new int[m];
        isUsed = new boolean[m];
        check = new boolean[n][n];
        for(int i=0;i<n;i++){
            in = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                ground[i][j] = Integer.parseInt(in[j]);
            }
        }
        for(int i=0;i<m;i++){
            in = br.readLine().split(" ");
            int x = Integer.parseInt(in[0]) - 1;
            int y = Integer.parseInt(in[1]) - 1;
            Pair user = new Pair(x, y, 0, ground[x][y], new boolean[n][n]);
            member.add(user);
            // Pair calc = getBest(ground, member.get(i));
            // check = deepCopy(calc.getRoute());
            // result += calc.getSum();
            //print(check);
        }
        recur(0, ground);
        System.out.println(result);
    }

    public static Pair getBest(int[][] ground, Pair location){
        Pair result = location;
        Queue<Pair> store = new LinkedList<>();
        store.add(location);
        while(!store.isEmpty()){
            Pair now = store.poll();
            int x = now.getX();
            int y = now.getY();
            boolean[][] route = now.getRoute();
            route[x][y] = true;
            if(now.getCount() == 3){
                if(result.getSum() < now.getSum()){
                    result = now;
                }
                continue;
            }
            if(x != 0 && !route[x-1][y]){
                route[x-1][y] = true;
                store.add(
                        new Pair(x-1, y, now.getCount() + 1, now.getSum() + ground[x-1][y], deepCopy(route))
                );
                route[x-1][y] = false;
            }
            if(y != 0 && !route[x][y-1]){
                route[x][y-1] = true;
                store.add(
                        new Pair(x, y-1, now.getCount() + 1, now.getSum() + ground[x][y-1], deepCopy(route))
                );
                route[x][y-1] = false;
            }
            if(x != (ground.length - 1) && !route[x+1][y]){
                route[x+1][y] = true;
                store.add(
                        new Pair(x+1, y, now.getCount() + 1, now.getSum() + ground[x+1][y], deepCopy(route))
                );
                route[x+1][y] = false;
            }
            if(y != (ground[0].length - 1) && !route[x][y+1]){
                route[x][y+1] = true;
                store.add(
                        new Pair(x, y+1, now.getCount() + 1, now.getSum() + ground[x][y+1], deepCopy(route))
                );
                route[x][y+1] = false;
            }
        }
        return result;
    }

    public static void recur(int x, int[][] ground) {
        if(x == m) {
            int tmp = 0;
            check = new boolean[n][n];
            for(int i=0;i<m;i++){
                member.get(numbers[i]).setRoute(deepCopy(check));
                Pair calc = getBest(ground, member.get(numbers[i]));
                check = deepCopy(calc.getRoute());
                tmp += calc.getSum();
            }
            result = Math.max(tmp, result);
            return;
        }
        for (int i = 0; i < m; i++) {
            if(!isUsed[i]) {
                isUsed[i] = true;
                numbers[x] = i;
                recur(x + 1, ground);
                isUsed[i] = false;
            }
        }
    }

    public static class Pair{
        int x;
        int y;
        int count;
        int sum;
        boolean[][] route;
        public Pair(int x, int y, int count, int sum, boolean[][] route){
            this.x = x;
            this.y = y;
            this.count = count;
            this.sum = sum;
            this.route = route;
        }
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        public int getCount(){
            return count;
        }
        public int getSum(){
            return sum;
        }
        public boolean[][] getRoute(){
            return route.clone();
        }
        public void setRoute(boolean[][] route){
            this.route = route;
        }
    }

    public static boolean[][] deepCopy(boolean[][] original) {
        if (original == null) {
            return null;
        }
        boolean[][] result = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i].clone();
        }
        return result;
    }

    public static void print(boolean[][] v){
        for(int i=0;i<v.length;i++){
            for(int j=0;j<v.length;j++){
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}