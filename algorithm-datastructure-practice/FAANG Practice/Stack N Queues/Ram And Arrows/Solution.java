/****
@Author Omkar Malve

Sriram and Arrows

Both fire  arrows and left is + and right is -
So find out which arrows will remain in air


****/


public class Solution {

	public List<Integer> getArrows(List<Integer> arrows) {
		Stack<Integer> st = new Stack<>();
		for (int x : arrows) {
			if (!st.isEmpty() && st.top() > 0 && x < 0) { // Opposite arrows
				boolean insertNew = true;
				while (!st.isEmpty() && st.top() > 0 && x < 0) {
					if (Math.abs(x) == Math.abs(st.top())) { // same power so remove existing
						st.pop();
						insertNew = false;
					} else if (Math.abs(x) > Math.abs(st.top())) { // new has high power
						st.pop();// must remove old low power
						insertNew = true;
					} else { // new has low power
						// ignore;
						insertNew = false;
						break;
					}
				}
				if (insertNew) st.push(x);
			} else { // Same dirc arrows
				st.push(x);
			}
		}
		// Need reverse Order
		Stack<Integer> ans = new Stack<>(st.size());
		while(!st.isEmpty()) {
			ans.push(st.pop());
		}
		return new ArrayList<>(st);
	}

}