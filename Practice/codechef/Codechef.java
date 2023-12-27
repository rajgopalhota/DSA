package codechef;

import java.util.Scanner;

class Rajgopal {

    static class Utils {

        static boolean check(int a) {
            return a == 1;
        }

        static Scanner getReader() {
            return new Scanner(System.in);
        }

        static void getWriter(int kl) {
            System.out.println(kl);
        }

        static int[] getArr(Scanner rj) {

            int[] a = new int[2];

            // Reading array A
            a[0] = rj.nextInt();
            a[1] = rj.nextInt();

            return a;

        }

    }

    static int solvedByRaja(int[] a){

        try{

            return (a[1] >= a[0] - 1) ? 1 : Math.max(2, a[0] - a[1] * 2);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
        
    }

}

public class Codechef {

    public static void main(String[] args) {

        try (Scanner rj = Rajgopal.Utils.getReader()) {

            int t = rj.nextInt();

            while (t-- > 0) {
                // Output the result for the current test case
                Rajgopal.Utils.getWriter(Rajgopal.solvedByRaja(Rajgopal.Utils.getArr(rj)));
            }

        }

    }
}

