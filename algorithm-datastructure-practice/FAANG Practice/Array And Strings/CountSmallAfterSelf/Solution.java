/***

@Author Omkar Malve

315. Count of Smaller Numbers After Self

You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].


***/
class Solution {

    static class Pair {
        public int i, d;
        Pair(int i, int d) {
            this.i = i; this.d = d;
        }
        public String toString() {
            return "[i:"+ i + ", d:" + d +"]";
        }
    }
    static int ans[];

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        ans = new int[n];

        for (int x = 0; x < n; x++) {
            arr[x] = new Pair(x, nums[x]);
        }

        mergeSort(arr, 0, n - 1);
        return Arrays.stream(ans).boxed().collect(Collectors.toList());
    }

    private void mergeSort(Pair[] a, int st, int ed) {
        if (st >= ed) return;
        int m = (st + ed)/2;
        mergeSort(a, st, m);
        mergeSort(a, m + 1, ed);
        merge(a, st, m, ed);
    }

    private void merge(Pair[] a, int s, int m, int e) {
        Pair[] left = new Pair[m - s + 1];
        Pair[] right = new Pair[e - m];

        for (int i = s; i <= m; i++) left[i - s] = a[i];
        for (int i = m + 1; i <= e; i++) right[i - m - 1] = a[i];

        int i = 0, j = 0, k = s;
        int ct = 0;

        while (i < left.length && j < right.length) {
            //System.out.println(" left-" + left[i] + ", right-" + right[j]);
            if (right[j].d < left[i].d) {
                ct++;
                a[k++] = right[j++];
            } else { // while merging if right is less we can add count to cur
                ans[left[i].i] += ct;
                a[k++] = left[i++];
            }
        }

        // Remaining merge
        while (i < left.length) {
            ans[left[i].i] += ct;
            a[k++] = left[i++];
        }

        while (j < right.length) {
            a[k++] = right[j++];
        }
    }
}