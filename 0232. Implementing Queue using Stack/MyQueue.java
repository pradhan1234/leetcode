class MyQueue {
    /** Two stacks to maintain the queue functionoing */
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue.
     * Always push to the first stack as the elements in the second stack are already in the queue form. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element.
     * If the second Stack is empty Pop the elements from the first stack and push it to the second stack.
     * So that now when we pop the elements off a stack it acts as a Queue */
    public int pop() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                int temp = s1.pop();
                s2.push(temp);
            }
        }
        return s2.pop();

    }

    /** Get the front element.
     *  The logic remains same as the pop. */
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                int temp = s1.pop();
                s2.push(temp);
            }
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty.
     * We need to check both the queues for emptyness. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
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