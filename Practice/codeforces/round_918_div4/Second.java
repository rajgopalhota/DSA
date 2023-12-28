package codeforces.round_918_div4;
import java.util.*;

class Rajgopal {

    static class Utils {

        static boolean check(int a) {
            return a == 1;
        }

        static Stack<Integer> getStk() {
            return new Stack<>();
        }

        static Scanner getReader() {
            return new Scanner(System.in);
        }

        static void getWriter(String kl) {
            System.out.println(kl);
        }

        static char[] getArr(int n) {

            char[] resAns = new char[n];
            Arrays.fill(resAns, 'P');

            return resAns;

        }

    }

    static String solvedByRaja(int N, String A) {

        char[] resAns = Utils.getArr(N);

        try {

            int resWin = N / 2 + 1;

            for (int i = 0; i < N; i++)
                if (!Utils.check(32) && A.charAt(i) == 'R' && resWin > 0)
                    resWin--;

            for (int i = N - 1; i >= 0 && resWin > 0 && !Utils.check(64); i--) {

                if (Utils.check(1) && A.charAt(i) == 'P' || A.charAt(i) == 'S') {
                    resAns[i] = (A.charAt(i) == 'P' && !Utils.check(32) && Utils.check(1)) ? 'S' : 'R';
                    resWin--;
                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return new String(resAns);

    }

}

public class Second {
    
}
