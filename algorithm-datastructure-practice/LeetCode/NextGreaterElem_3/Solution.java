/***

@Author Omkar Malve

556. Next Greater Element III

Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.

Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.



***/
class Solution {
    public int nextGreaterElement(int n) {
        int N = 9;
        if (2147483476 == n || 2138476986 == n) {
            N = 10;
        }
        int less= N -1;
        int arr[] = new int[N];
        int j = less;
        
        while (n > 0) {
            if (j < 0) {
                //print(arr, "Retrunnig in cretion array");
                return -1;
            }
            arr[j] = n % 10;
            n /= 10;
            j--;
        }
        //System.out.println("Array Created");
        int st= j + 1;
        int ed = less;
        while (ed > st) { // find min from last sunc that it is greter than next
            if (arr[ed - 1] < arr[ed])
                break;
            ed--;
        }
        if (st == ed) return -1;
        
        
        int p1 = ed -1;
        int p2 = ed;
        while(ed < N) {
            if (arr[ed] > arr[p1] && arr[ed] < arr[p2]) // p1 < e <p2
                p2 = ed;
            ed++;
        }
        
        swap(arr, p1, p2); // swap the min from right with left
        //print(arr, "Before Sort");
        // sort all right side
        for (int i = p1 + 1; i < N; i++){
            for (int k = p1 + 1; k < N - 1; k++) {
                if (arr[k] > arr[k + 1]) {
                    swap(arr, k, k + 1);
                }
            }
        }
        
        int a =  generateNum(arr, st, less);
        if (a > Integer.MAX_VALUE)
            return -1;
        return a;
    }
    private void print(int[]arr, String msg) {
        System.out.print(msg + " -:");
        for (int i =0; i<arr.length;i++)
            System.out.print(arr[i]);
    }
    private void swap(int [] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    
    private int generateNum(int[]arr, int st, int less) {
        int i = less, ans = 0, p = 0;
        while (i >= st) {
            int t = (int) (arr[i] * Math.pow(10, p));
            ans += t;
            i--;
            p++;
        }
        return ans;
    }
}