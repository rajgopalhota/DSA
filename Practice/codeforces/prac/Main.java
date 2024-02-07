package codeforces.prac;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
          
    public static void main(String[] args) {

        try (Scanner rjRe = Raja.Utils.getRObj()) {

            int t = rjRe.nextInt();

            while (t-- > 0) {

                int n = rjRe.nextInt(), m = rjRe.nextInt(), k = rjRe.nextInt();

                ArrayList<Integer> a = new ArrayList<>(), b = new ArrayList<>();

                for (int i = 0; i < n; i++) a.add(rjRe.nextInt());

                for (int j = 0; j < m; j++) b.add(rjRe.nextInt());

                Raja.Utils.getWObj(Raja.mainLog(k, a, b, new HashSet<>(), new HashSet<>(), true));

            }

        }

    }

}

class Raja {

    static class Utils {

        static Scanner getRObj() {

            return new Scanner(System.in);

        }

        static void getWObj(String kl) {

            System.out.println(kl);

        }

    }

    static String mainLog(int k, ArrayList<Integer> a, ArrayList<Integer> b, Set<Integer> st1,
            Set<Integer> st2, boolean f) {

        for (Integer num : a) if (k >= num) st1.add(num);
        
        for (Integer num : b) if (k >= num) st2.add(num);

        if (st2.size() < k / 2 || st1.size() < k / 2) return ("NO");

        else {

            Set<Integer> s = new HashSet<>(st1); s.addAll(st2);

            for (int i = 1; i <= k; i++) if (!s.contains(i)) f = false;

            return f ? "YES" : "NO";

        }
    }

}
