import java.util.PriorityQueue;

class KthLargest {
    final PriorityQueue<Integer> pq = new PriorityQueue<>();;
    final int pqSize;

    public KthLargest(int k, int[] nums) {
        pqSize = k;
        for(int i : nums)
            pq.add(i);
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > pqSize)
            pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */