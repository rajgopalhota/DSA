import java.util.*;

class Solution {

    int celebrity(int M[][], int n) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) st.push(i);
        
        while (st.size() > 1) {

            int a1 = st.pop(), a2 = st.pop();

            if (M[a1][a2] == 0) st.push(a1);
            else if (M[a2][a1] == 0) st.push(a2);
            
        }

        if (st.size() == 0) return -1;
        
        int cri = st.pop();
        for (int j = 0; j < n; j++) if (M[cri][j] == 1) return -1;

        for (int i = 0; i < n; i++) {

            if (i == cri) continue;
            
            if (M[i][cri] == 0) return -1;

        }
        return cri;
        
    }
}