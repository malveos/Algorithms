/***

@Author Omkar Malve

636. Exclusive Time of Functions

On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.

Function calls are stored in a call stack: when a function call starts, its ID is pushed onto the stack, and when a function call ends, its ID is popped off the stack. The function whose ID is at the top of the stack is the current function being executed. Each time a function starts or ends, we write a log with the ID, whether it started or ended, and the timestamp.

You are given a list logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}". For example, "0:start:3" means a function call with function ID 0 started at the beginning of timestamp 3, and "1:end:2" means a function call with function ID 1 ended at the end of timestamp 2. Note that a function can be called multiple times, possibly recursively.

A function's exclusive time is the sum of execution times for all function calls in the program. For example, if a function is called twice, one call executing for 2 time units and another call executing for 1 time unit, the exclusive time is 2 + 1 = 3.

Return the exclusive time of each function in an array, where the value at the ith index represents the exclusive time for the function with ID i.

***/
class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int [] ans = new int[n];
        for (int i = 0; i < n; i++) ans[i] = 0;

        Stack<Integer> st = new Stack<>();
        int curTime = 0;
        for (int i = 0; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");
            int id = Integer.parseInt(log[0]);
            String type = log[1];
            int time = Integer.parseInt(log[2]);

            if (st.isEmpty()) {
                st.push(id);
                curTime = time;
            } else if (type.equals("start")) {
                int curID = st.peek();
                //System.out.println("Id-"+ curID + " val [time - curTime]:" + time + "-" +curTime);
                ans[curID] += time - curTime;
                st.push(id);
                curTime = time;
            } else {
                st.pop();
                //System.out.println("Id-"+ id + " val [time - curTime]:" + time + "-" + curTime + "+1");
                ans[id] += time - curTime + 1;
                curTime = time + 1;
            }
            //printData(st, curTime, ans);
        }
        return ans;
    }

    private void printData(Stack<Integer> st, int t, int[] ans){
        System.out.print("Stack: " + Arrays.toString(st.toArray()) + " Ans:"+ printArr(ans));
        System.out.print("\n CurTime: " + t + "\n\n");
    }
    
    private String printArr(int[] a) {
        String s = "[";
        for (int x: a)
            s+=" "  + x + ",";
        s+="]";
        return s;
    }
}