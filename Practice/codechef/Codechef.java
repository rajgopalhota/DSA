package codechef;

import java.util.*;

class Codechef {
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

    public long nextLong() {

        return scanner.nextLong();

    }

    public void close() {

        scanner.close();

    }

}


class OutputWriter {

    public void printResult(long result) {

        System.out.println(result);

    }

}

class Logic {

    static class Obj{
        
        static List<Long> getObj(){

            return new ArrayList<>();

        }

    }

    public static long calculateDifference(long n) {

        long originalN = n;
        List<Long> binaryDigits = Obj.getObj();

        while (n > 0) {

            binaryDigits.add(n % 2); n /= 2;

        }

        int j = binaryDigits.size() - 1;
        while (j >= 0 && binaryDigits.get(j) == 1) j--;
        

        int k = 0;
        while (k < binaryDigits.size() && binaryDigits.get(k) == 0) k++;

        long ans = 0;

        if (k > j) return ans;
        
        else {

            for (int i = j; i < binaryDigits.size(); i++) ans += Math.pow(2, i);
            
            return ans - originalN;

        }
    }

}

class LoopManager {

    private InputReader reader;
    private OutputWriter writer;

    public LoopManager(InputReader reader, OutputWriter writer) {

        this.reader = reader; this.writer = writer;

    }

    public void processTest() {
        
        writer.printResult(Logic.calculateDifference(reader.nextLong()));

    }
}
