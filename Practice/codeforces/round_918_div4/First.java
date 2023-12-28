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

        static void getWriter(int kl) {
            System.out.println(kl);
        }

        static char[] getArr(int n) {

            char[] resAns = new char[n];
            Arrays.fill(resAns, 'P');

            return resAns;

        }

    }

    static int solvedByRaja(int kla, int klb, int klc) {

        try {

            return (kla == klb) ? klc : (kla == klc) ? klb : kla;


        } catch (Exception e) {

            e.printStackTrace();

        }

        return -1;

    }

}

public class First {

    public static void main(String[] args) {
        try (Scanner rj = Rajgopal.Utils.getReader()) {
            int klt = rj.nextInt();

            while (klt-- > 0)
                Rajgopal.Utils.getWriter(Rajgopal.solvedByRaja(rj.nextInt(), rj.nextInt(), rj.nextInt()));
        }
    }

}
