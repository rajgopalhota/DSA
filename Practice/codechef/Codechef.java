package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

class Rajgopal {

    static class Main {
        static void rajaLogic(long x, long n) {
            if (x == 0) {
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            } else if (n - x <= 1) {
                System.out.println("-1");
            } else {
                long a = n - 1 - x;
                x = n + 1 - a;

                System.out.print(x + " ");

                int c = 1;

                for (int i = 1; i < n; i++) {
                    if (i == x) {
                        c++;
                    }
                    System.out.print(c + " ");
                    c++;
                }
                System.out.println();
            }
        }
    }

    static class Utils {

        static boolean check(int rxA) {
            return rxA == 1;
        }

        static Stack<Integer> getStk() {
            return new Stack<>();
        }

        static Scanner getReader() {
            return new Scanner(System.in);
        }

        static BufferedReader getReader(int m) {
            return new BufferedReader(new InputStreamReader(System.in));
        }

        static void getWriter(String kl) {
            System.out.println(kl);
        }

        static int[] getIntArr(Scanner rj, int size) {
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rj.nextInt();
            }
            return arr;
        }

        static long[] getLongArr(Scanner rj, int size) {
            long[] arr = new long[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rj.nextLong();
            }
            return arr;
        }
    }

    static void solveProblem(int t, Scanner rj) {

        while (t > 0) {
            
            t--;
            long n = rj.nextLong();
            long x = rj.nextLong();

            Rajgopal.Main.rajaLogic(x, n);

        }
    }

}

public class Codechef {

    public static void main(String[] args) throws Exception {
        Scanner rj = Rajgopal.Utils.getReader();

        try (BufferedReader br = Rajgopal.Utils.getReader(0)) {
            int t = Integer.parseInt(rj.next());
            Rajgopal.solveProblem(t, rj);
        } finally {
            rj.close();
        }
    }
}
