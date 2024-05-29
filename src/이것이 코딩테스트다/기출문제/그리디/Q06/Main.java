import java.util.*;
class Solution {
    public int solution(int[] food_times, long k) {
        int foods = food_times.length;
        long times = 0;
        for (int i = 0; i < foods; i++) {
            times += food_times[i];
        }
        if (times <= k) 
            return -1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2){
                return o1.time - o2.time;
            }
        });
        for(int i=0;i<foods;i++){
            int n = i + 1;
            int time = food_times[i];
            pq.add(new Pair(time, n));
        }
        
        times = 0;
        long previous = 0;
        long remain = foods;
        
        while(true) {
            Pair now = pq.peek();
            if((times + (now.time - previous) * remain > k)){
                break;
            }
            pq.poll();
            times += (now.time - previous) * remain;
            remain--;
            previous = now.time;
        }
        // 남은 음식 중에서 몇 번째 음식인지 확인하여 출력
        ArrayList<Pair> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }
        // 음식의 번호 기준으로 정렬
        Collections.sort(result, new Comparator<Pair>() { 
            @Override
            public int compare(Pair a, Pair b) {
                return Integer.compare(a.n, b.n);
            }
        });
        return result.get((int) ((k - times) % remain)).n;
    }
    
    public static class Pair {
        int time;
        int n;
        public Pair(int time, int n) {
            this.time = time;
            this.n = n;
        }
    }
}
