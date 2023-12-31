package arrays;

import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> ls = new HashMap<>();

        for(String x:strs){

            char ch[] = x.toCharArray();

            Arrays.sort(ch);

            String es = new String(ch);

            if(!ls.containsKey(es)) {

                ls.put(es, new ArrayList<>());

            }

            ls.get(es).add(x);

        }

        return new ArrayList<>(ls.values());

    }
}

