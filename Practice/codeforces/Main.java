package codeforces;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                int n = scanner.nextInt(), q = scanner.nextInt();
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) arr[i] = scanner.nextLong();
                long[] freq = new long[n];
                for (int i = 0; i < n; i++) {
                    if (i != 0) freq[i] = freq[i - 1];
                    if (arr[i] == 1) freq[i]++;
                }
                Tree.buildSparseTable(arr, n);
                Raja.processQueries(q, freq);
            }
        }
    }
}

class Raja {
    static void processQueries(int q, long[] freq) {
        Scanner scanner = new Scanner(System.in);
        while (q-- > 0) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            if (l == r) {
                System.out.println("NO");
                continue;
            }
            if (Raja.findCount(freq, l, r) == 0) {
                System.out.println("YES");
                continue;
            }
            long cnt = Raja.findCount(freq, l, r);
            long sumOfRest = Tree.query(l, r) - cnt;
            long cntOfRest = r - l + 1 - cnt;
            if (cnt <= sumOfRest - cntOfRest) {
                System.out.println("YES");
                continue;
            }
            System.out.println("NO");
        }
        scanner.close();
    }

    static long findCount(long[] freq, int l, int r) {
        if (l == 0) {
            return freq[r];
        }
        return freq[r] - freq[l - 1];
    }
}

class Tree {
    static long[][] st;

    static void buildSparseTable(long[] arr, int N) {
        st = new long[N][20];
        for (int i = 0; i < N; i++) {
            st[i][0] = arr[i];
        }
        for (int j = 1; j < 20; j++) {
            for (int i = 0; i + (1 << j) <= N; i++) {
                st[i][j] = st[i][j - 1] + st[i + (1 << (j - 1))][j - 1];
            }
        }
    }

    static long query(int L, int R) {
        long sum = 0;
        for (int j = 19; j >= 0; j--) {
            if ((1 << j) <= R - L + 1) {
                sum += st[L][j];
                L += 1 << j;
            }
        }
        return sum;
    }
}
