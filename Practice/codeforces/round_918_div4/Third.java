package codeforces.round_918_div4;

import java.util.*;

class Rajgopal {

    static class Utils {

        static boolean check(int a) {

            return a == 1;

        }

        static Scanner getReader() {

            return new Scanner(System.in);

        }

        static void getWriter(String kl) {

            System.out.println(kl);

        }

        static String mainLogic(int n, Scanner rj, long sum) {

            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = rj.nextLong();

            for (long el : a) sum += el;

            return (Rajgopal.solvedByRaja(sum, 1, 1000000001) != -1) ? "YES" : "NO";

        }

    }

    static long solvedByRaja(long val, long lo, long hi) {

        try {

            while (hi - lo > 1) {

                long mid = (lo + hi) / 2;

                if (mid * mid == val) return mid;
                
                else if (mid * mid < val) lo = mid;

                else hi = mid;
    
            }

            return (lo * lo == val) ? lo : (hi * hi == val) ? hi : -1;

        } catch (Exception e) {

            e.printStackTrace();

        }

        return 0;

    }

}

public class Third {
    public static void main(String[] args) {

        try (Scanner rj = Rajgopal.Utils.getReader()) {

            int klt = rj.nextInt();

            while (klt-- > 0)
                Rajgopal.Utils.getWriter(Rajgopal.Utils.mainLogic(rj.nextInt(), rj, 0));

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
