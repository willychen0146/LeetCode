import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        for(int i : stones)
            maxPQ.add(i);
        while(maxPQ.size() >= 2){
            int heaviest = maxPQ.poll();
            int sceondHeaviest = maxPQ.poll();
            if(heaviest == sceondHeaviest)
                continue;
            else
                maxPQ.add(heaviest - sceondHeaviest);
        }
        if(!maxPQ.isEmpty())
            return maxPQ.poll();
        else
            return 0;
    }
}