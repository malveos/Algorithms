/***

@Author Omkar Malve

225. Implement Stack using Queues

Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue, which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively. You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.


***/
class MyStack {
    private final Queue<Integer> q1;
    private final Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
         if (q1.isEmpty()) {
            q1.add(x);
            while(!q2.isEmpty()) {
                q1.add(q2.poll());
            }
        } else {
            q2.add(x);
            while(!q1.isEmpty()) {
                q2.add(q1.poll());
            }
        }        
    }
    
    public int pop() {
       if (q1.isEmpty()) {
            return q2.poll();
        } else {
            return q1.poll();
        }
    }
    
    public int top() {
        if (q1.isEmpty()) {
            return q2.peek();
        } else {
            return q1.peek();
        }
    }
    
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