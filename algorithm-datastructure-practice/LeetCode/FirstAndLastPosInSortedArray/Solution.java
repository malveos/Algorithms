/***
 Find First and Last Position of Element in Sorted Array
 
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

**/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];        
        ans[0] = findElem(nums, 0, nums.length -1, target, true);
        ans[1] = findElem(nums, 0, nums.length -1, target, false);
        return ans;
    }
    
    private int findElem(int[] nums, int st, int ed, int target, boolean findingFirst) {
        int res = -1;
        
        while(st<=ed) {
            int mid = st  + ((ed - st)>>2);
            if(nums[mid] == target) {
                res = mid;
                if(findingFirst) {
                    ed = res - 1;
                } else {
                    st = res + 1;
                }
            } else if(nums[mid] > target) {
                ed = mid - 1;
            } else {
                st = mid + 1;
            }
        }        
        return res;
    }
}

/*class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[2];
        List<Integer> indices = new ArrayList<>(n);
        binarySearch(nums, 0, n-1, target, indices);
        if(indices.isEmpty()) {
            ans[0] = ans[1] = -1;
        } else {
            ans[0] = Collections.min(indices);
            ans[1] = Collections.max(indices);
        }
        return ans;
    }
                                                
    private void binarySearch(int[] nums, int st, int ed, int target, List<Integer> indices) {
        //System.out.println(st +":" + ed);
        if(st > ed)
            return;
        if(st == ed ) {
            if(nums[st] == target)
                indices.add(st);
            return;
        }
        if(st == ed - 1) {
            if(nums[st] == target)
                indices.add(st);
            if(nums[ed] == target)
                indices.add(ed);
            return;
        }
        
        int mid = (st + ed)/2;
        if(nums[mid] == target) {
            indices.add(mid);
            binarySearch(nums, st, mid, target, indices);
            binarySearch(nums, mid, ed, target, indices);
        } else if(nums[mid] < target) {
            binarySearch(nums, mid, ed, target, indices);
        } else {
            binarySearch(nums, st, mid, target, indices);
        }        
    }
}*/