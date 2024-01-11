package codechef;

import java.util.Scanner;
import java.util.Arrays;

class Rajgopal {

    static class Utils {

        static boolean check(int a) {
            return a == 1;
        }

        static Scanner getReader() {
            return new Scanner(System.in);
        }

        static void getWriter(String kl) {
            System.out.print(kl);
        }

        static boolean checker(String kl) {

            return kl.equals("W");

        }

        static int[] getArr(Scanner rj) {

            int[] a = new int[2];

            // Reading array A
            a[0] = rj.nextInt();
            a[1] = rj.nextInt();

            return a;

        }

        static void rajaMaker(int[] klRA) {

            for (int element : klRA)
                getWriter(element + " ");

            System.out.println();
        }

    }

    static void solvedByRaja(int klSA, int klSB, int ygtB, Scanner rj) {

        try {

            int[] klRA = new int[klSA], klRB = new int[klSB];

            for (int i = 0; i < klSA; i++)
                klRA[i] = rj.nextInt();

            for (int i = 0; i < klSB; i++) {
                klRB[i] = rj.nextInt();
                ygtB = Math.max(klRB[i], ygtB);
            }

            Arrays.sort(klRA, klSA - ygtB, klSA);

            Rajgopal.Utils.rajaMaker(klRA);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}

public class Codechef {

    public static void main(String[] args) {

        try (Scanner rj = Rajgopal.Utils.getReader()) {

            int t = rj.nextInt();

            while (t-- > 0) {
                // Output the result for the current test case
                Rajgopal.solvedByRaja(rj.nextInt(), rj.nextInt(), 0, rj);

            }

        }

    }
}
