/***

@Author Omkar Malve

155. Min Stack
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


***/
class MinStack {
    // Can use LinkedList of Node with saving min till that point.
    private final Stack<Integer> st;
    private final PriorityQueue<Integer> pq;
    public MinStack() {
        st = new Stack<>();
        pq = new PriorityQueue<>(5, (a,b) -> a.compareTo(b));
    }

    public void push(int val) {
        st.push(val);
        pq.add(val);
    }

    public void pop() {
        int val = st.pop();
        pq.remove(val);
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return pq.peek();
        // int m = Integer.MAX_VALUE;
        // for (int i : st)
        //     m = Math.min(m, i);
        // return m;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */