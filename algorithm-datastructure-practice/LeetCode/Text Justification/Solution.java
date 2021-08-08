/**

@Author Omkar Malve


 Text Justification
 
Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left-justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.


**/

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        
        
        // process all words create list of string per line
        // then adjust spaces
        
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int curLen = 0;

        for (String word : words) {
            if (curLen + word.length() + line.size() > maxWidth ) {
                // line size for maintaining at least one space per word.
                formatLine(result, line, curLen, maxWidth);

                // reset 
                line.clear();
                curLen = 0;
            }
            line.add(word);
            curLen += word.length();
        }

        if (line.size() > 0) // some words left in the last line
            formatLastLine(result, line, curLen, maxWidth);
     
        return result;
    }
    
    public void formatLastLine(List<String> result, List<String> line, int len, int maxWidth){
        int space = maxWidth - len;
        String processedLine = line.get(0);

        // add others with space and remaing spaces after end
        for (int i = 1; i< line.size(); i++) {
            processedLine += " " + line.get(i);
            space--;
        }

        // check if spaceLeft
        while (space > 0) {
            processedLine += " ";
            space--;
        }
        
        result.add(processedLine);
    }
    
    public void formatLine(List<String> result, List<String> line, int len, int maxWidth){
        int space = maxWidth - len;

        if(line.size() == 1){
            String temp = line.get(0);
            while(space > 0){
                temp += " "; 
                space--;
            }
            result.add(temp);
            return;
        }
        
        while(space > 0){
          for(int i = 0 ; i < line.size() - 1; i++) {
            line.set(i, line.get(i) + " ");
            space--; 
            if(space == 0){
                break;
            }  
          }
        }

        String temp ="";
        for(int i = 0; i < line.size(); i++){
           temp += line.get(i); 
        }
        
        result.add(temp);
    }
}