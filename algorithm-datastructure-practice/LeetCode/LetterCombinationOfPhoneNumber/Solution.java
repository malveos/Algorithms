/*****
@Author Omkar Malve

Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


****/

class Solution {
    public static Map<String, List<String>> cacheMap = new HashMap<>();
    static {
        cacheMap.put("2", List.of("a", "b", "c"));
        cacheMap.put("3", List.of("d", "e", "f"));
        cacheMap.put("4", List.of("g", "h", "i"));
        cacheMap.put("5", List.of("j", "k", "l"));
        cacheMap.put("6", List.of("m", "n", "o"));
        cacheMap.put("7", List.of("p", "q", "r", "s"));
        cacheMap.put("8", List.of("t", "u", "v"));
        cacheMap.put("9", List.of("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        if (null == digits || digits.length() == 0)
            return new ArrayList<>(1);
        if (digits.length() == 1) {
            return getRepresentation(digits.charAt(0));
        }
        
        List<String> subCalculatedSuffixes = letterCombinations(digits.substring(1));
        List<String> answerList = new LinkedList<>();
        List<String> prefixList = getRepresentation(digits.charAt(0));
        for (int i = 0; i < prefixList.size(); i++) {
            String a  = prefixList.get(i);
            for (int j = 0; j < subCalculatedSuffixes.size(); j++) {
                answerList.add(a + subCalculatedSuffixes.get(j));
            }
        }
        return answerList;
    }
    
    public static List<String> getRepresentation(char i) {
        return cacheMap.get(i + "");
    }
}