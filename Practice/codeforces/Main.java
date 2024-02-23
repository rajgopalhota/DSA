package codeforces;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InputReader reader = new InputReader();

        int testCases = reader.nextInt();

        while (testCases-- > 0) new LoopManager(reader, new OutputWriter()).processTest();

        reader.close();

    }
}

class InputReader {

    private Scanner scanner;

    public InputReader() {

        scanner = new Scanner(System.in);

    }

    public int nextInt() {

        return scanner.nextInt();

    }

    public void close() {

        scanner.close();

    }

}

class OutputWriter {

    public void printResult(int result) {

        System.out.println(result);

    }

}

class Logic {

    public static int countZerosBetweenOnes(int[] array, int f, int l, int abS) {

        for (int i = 0; i < array.length; i++) if (array[i] == 1) {

            if (f == -1) f = i;
            l = i;

        }

        for (int i = f; i <= l; i++) if (array[i] == 0) abS++;
        
        return abS;

    }
}

class LoopManager {

    private InputReader reader;
    private OutputWriter writer;

    public LoopManager(InputReader reader, OutputWriter writer) {

        this.reader = reader; this.writer = writer;

    }

    public void processTest() {

        int n = reader.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) a[i] = reader.nextInt();

        writer.printResult(Logic.countZerosBetweenOnes(a, -1, -1, 0));

    }

}
