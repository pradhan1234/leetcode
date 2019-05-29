/** Implement the following operations of a stack using queues.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 empty() -- Return whether the stack is empty.*/


/** Time Complexity:
 *  push(x) - O(1)
 *  pop() - O(n)
 *  top() - O(n)*/

class MyStack {

    /** Initialize your data structure here.
     * We are using 2 Queues where one will be empty when the other is being worked on.*/
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack.
     * If the Second Queue is empty then we add to the first Queue or else we add to the second Queue.
     * This is based on the logic that at any instance either one of the queue will be filled and
     * if both are empty then we add the element to the first queue.*/
    public void push(int x) {
        if(q2.isEmpty()){
            q1.add(x);
        }
        else{
            q2.add(x);
        }
    }

    /** Removes the element on top of the stack and returns that element.
     * We remove the element from the filled queue and add it to the one that is empty.
     * We do not add the last element and just remove it from the consideration.*/
    public int pop() {
        int temp = -1;
        if(!q1.isEmpty()){
            while(q1.size() > 1){
                temp = q1.remove();
                q2.add(temp);
            }
            temp = q1.remove();
        }
        else{
            while(q2.size() > 1){
                temp = q2.remove();
                q1.add(temp);
            }
            temp = q2.remove();
        }
        return temp;
    }

    /** Get the top element.
     * We use the same logic as pop but the only difference is that we do not remove the last element permanantly but we add that element into the other queue.*/
    public int top() {
        int temp = -1;
        if(!q1.isEmpty()){
            while(!q1.isEmpty()){
                temp = q1.remove();
                q2.add(temp);
            }
        }
        else{
            while(!q2.isEmpty()){
                temp = q2.remove();
                q1.add(temp);
            }
        }
        return temp;
    }

    /** Returns whether the stack is empty.
     * Simply check if both the queues are empty or not. If true then the stack is empty otherwise not.*/
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */