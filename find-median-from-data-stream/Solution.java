class MedianFinder {
    private Queue<Integer> smallHeap; //small elements - maxHeap
    private Queue<Integer> largeHeap; //large elements - minHeap

    public MedianFinder() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);   
    }
    
    public void addNum(int num) {
        smallHeap.add(num);

        // Make sure every element in small heap is <= large heap
        if (smallHeap.size() - largeHeap.size() > 1 ||
            !largeHeap.isEmpty() &&
            smallHeap.peek() > largeHeap.peek()) {
            largeHeap.add(smallHeap.poll());
        }
        // Check if the size between two heap are even
        if (largeHeap.size() - smallHeap.size() > 1) {
            smallHeap.add(largeHeap.poll());
        }   
    }
    
    public double findMedian() {
        // Size is equal
        if (smallHeap.size() == largeHeap.size()) {
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;
        } 
        // SmallHeap has more element
        else if (smallHeap.size() > largeHeap.size()) {
            return (double) smallHeap.peek();
        } 
        // Large size has more element
        else {
            return (double) largeHeap.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */