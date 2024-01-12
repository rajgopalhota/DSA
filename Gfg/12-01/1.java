class Solution {

    String reverseWords(String S) {

        return Raja.getAns(0, S.split("\\."));
        
    }
    
}

class Raja{
    
    static String getAns(int left, String words[]){

        int right = words.length - 1;

        while (left < right) {
            
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
        
            left++; right--;
        
        }
        
        return String.join(".", words);

    }

}