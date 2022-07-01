/***

@Author Omkar Malve

1268. Search Suggestions System

You are given an array of strings products and a string searchWord.

Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.


***/
class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
       return getByBinarySearch(products, searchWord);
    }

    private List<List<String>> getByBinarySearch(String[] products, String searchWord) {
        Arrays.sort(products);
        int wn = searchWord.length();
        List<List<String>> ans = new ArrayList<>(wn);

        int left = 0, right = products.length - 1;        
        for (int i = 0; i < wn; i++) {
            while(left <= right && (products[left].length() <= i 
                                    || products[left].charAt(i) != searchWord.charAt(i)))
                left++;
            while(left <= right && (products[right].length() <= i 
                                    || products[right].charAt(i) != searchWord.charAt(i)))
                right--;
            
            List<String> ls = new ArrayList<>(3);
            for (int k = left; k <= right && k < left + 3; k++)
                ls.add(products[k]);
            ans.add(ls);
        }
        return ans;
    }

    private List<List<String>> getByStringManipulation(String[] products, String searchWord) {
        int wn = searchWord.length();
        List<List<String>> ans = new ArrayList<>(wn);
        // Use priorityQueue to store top 3 results
        PriorityQueue<String> pq = new PriorityQueue<>(3, (s1,s2) -> s1.compareTo(s2));

        List<String> toSearch = new ArrayList<>(products.length);
        for (String s : products)
            toSearch.add(s);

        for(int i = 1; i <= wn; i++) {
            String sub = searchWord.substring(0, i);
            
            List<String> matchedList = new ArrayList<>(3);
            for (String s : toSearch) {
                if (s.startsWith(sub)) {
                    pq.add(s);
                    //matchedList.add(s);
                }
            }

            int ct = 0;
            toSearch.clear();
            while(!pq.isEmpty() && ct < 3) {
                String val = pq.poll();
                matchedList.add(val);
                toSearch.add(val);
                ct++;
            }
            while(!pq.isEmpty()){
                toSearch.add(pq.poll());
            }
            ans.add(matchedList);
        }
        return ans;
    }
}