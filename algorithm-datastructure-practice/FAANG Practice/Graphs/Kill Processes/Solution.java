/***

@Author Omkar Malve

582 Kill Process


**/
class Solution {
	public List<Integer> killProcesses(List<Integer> pids, List<Integer> parentPids, int kill) {
		Queue<Integer> q = new Queue<>();
		// MAp to maintain parent child relation
		Map<Integer, List<Integer>> mp = new HashMap<>();
		for (int i= 0; i < parentPids.size(); i++)
			mp.put(parentPids.get(i), mp.getOrDefault(parentPids.get(i), new ArrayList<>()).add(pids.get(i)));

		List<Integer> ans = new ArrayList<>(pid.size());
		q.add(kill);
		while(!q.isEmpty()) {
			int parent = q.poll();
			ans.add(parent);
			if (mp.get(parent) != null) {
				q.addAll(mp.get(parent));
			}
		}
		return ans;
	}
}