/****

@Author Omkar Malve

Total Subtrees with Given SUM

Input will be level Order

****/
public Solution {
	static int[] nums;

	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		nums = new int[n];		
		for(int i  = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		TreeNode rt = createTree();
		int k = sc.nextInt(); // this is sum to be
		System.out.println(findSumCount(rt, k));
	}
	
	public static int findSumCount(TreeNode rt, int k) {
		int ans = 0;
		if(rt == null) return 0;
		if(Sum(rt) == k) {
			ans++;
		}
		return ans + findSumCount(rt.left, k) + findSumCount(rt.right, k);
	}
		
	public static int sum(TreeNode n) {
		if(n == null) return 0;
		return n.val + sum(n.left) + sum(n.right);
	}

	public static TreeNode createTree() {
		if (nums.length == 0) return null;
		TreeNode rt = new TreeNode(nums[0]);
		Queue<TreeNode> q = new Queue<>();
		q.add(rt);
		int i = 1;
		while (!q.isEmpty() && i < nums.length) {
			TreeNode cur = q.pop();
			int t = nums[i++];
			cur.left  = new TreeNode(t);
			q.add(cur.left);
			if (i >= nums) break;

			t = nums[i++];
			cur.right = new TreeNode(t);
			q.add(cur.right);
			if (i >= nums) break;
		} 
		return rt;
	}

	public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
       }
   }
}