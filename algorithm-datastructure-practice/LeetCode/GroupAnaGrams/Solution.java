/***
@Author Omkar Malve

Group Anagrams

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

***/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> ans = new ArrayList<>();
        if (strs == null)
            return ans;

        Map<String, List<String>> analgramMap = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String mapKey = new String(chars);
            if(analgramMap.containsKey(mapKey)) {
                analgramMap.get(mapKey).add(strs[i]);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                analgramMap.put(mapKey, strList);
            }
        }
        ans.addAll(analgramMap.values());
        return ans;
    }
}