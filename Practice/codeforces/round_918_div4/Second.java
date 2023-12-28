package codeforces.round_918_div4;

import java.util.*;

class Rajgopal {

    static class Utils {

        static Scanner getReader() {
            return new Scanner(System.in);
        }

        static void getWriter(char kl) {
            System.out.println(kl);
        }

        static char[][] getArr(char[][] sqr, Scanner rj) {

            for (int i = 0; i < 3; ++i) sqr[i] = rj.next().toCharArray();

            return sqr;

        }

    }

    static char solvedByRaja(char[][] sqr) {

        try {

            for (char ch = 'A'; ch <= 'C'; ++ch) {

                int row = 0, col = 0;

                for (int i = 0; i < 3; ++i) {

                    if (sqr[i][0] == ch || sqr[i][1] == ch || sqr[i][2] == ch) ++row;
                    
                    if (sqr[0][i] == ch || sqr[1][i] == ch || sqr[2][i] == ch) ++col;
                    
                }

                if (row < 3 && col < 3) return ch;

            }
            
            return ' ';

        } catch (Exception e) {

            e.printStackTrace();

        }

        return ' ';

    }

}

public class Second {
    public static void main(String[] args) {
        try (Scanner rj = Rajgopal.Utils.getReader()) {

            int klt = rj.nextInt();

            while (klt-- > 0)
                Rajgopal.Utils.getWriter(Rajgopal.solvedByRaja(Rajgopal.Utils.getArr(new char[3][3], rj)));

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
