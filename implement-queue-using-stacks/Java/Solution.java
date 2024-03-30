import java.util.Stack;

class MyQueue {
    Stack<Integer> preStack;
    Stack<Integer> postStack;
    public MyQueue() {
        preStack = new Stack<>();
        postStack = new Stack<>();
    }
    
    public void push(int x) {
        preStack.push(x);
    }
    
    public int pop() {
        if(postStack.empty()){
            while(!preStack.empty()){
                postStack.push(preStack.pop());
            }
        }
        return postStack.pop();
    }
    
    public int peek() {
        if(postStack.empty()){
            while(!preStack.empty()){
                postStack.push(preStack.pop());
            }
        }
        return postStack.peek();        
    }
    
    public boolean empty() {
        return preStack.empty() && postStack.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */