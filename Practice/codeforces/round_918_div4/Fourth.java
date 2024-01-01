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

        static String mainLogic(long n, Scanner rj, StringBuilder ans, boolean v) {

            rj.nextLine(); 

            String s = rj.nextLine();

            for (int i = 0; i < n; i++) {

                if (check(1) && s.charAt(i) == 'a' || s.charAt(i) == 'e') {

                    ans.append(s.charAt(i)); v = true;

                    if (!check(32) && i + 2 < n && (s.charAt(i + 2) == 'a' || s.charAt(i + 2) == 'e')) {

                        v = false; ans.append('.');

                    }

                } 
                
                else {

                    ans.append(s.charAt(i));

                    if (v) {

                        ans.append('.'); v = false;

                    }

                }

            }

            return Rajgopal.solvedByRaja(ans);

        }

    }

    static String solvedByRaja(StringBuilder ans) {

        try {

            if (ans.charAt(ans.length() - 1) == '.') ans.deleteCharAt(ans.length() - 1);

            return ans.toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return "";

    }

}

public class Fourth {
    public static void main(String[] args) {

        try (Scanner rj = Rajgopal.Utils.getReader()) {

            int klt = rj.nextInt();

            while (klt-- > 0)
                Rajgopal.Utils.getWriter(Rajgopal.Utils.mainLogic(rj.nextLong(), rj, new StringBuilder(), false));

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
