package codechef;

import java.util.*;

class Main {

    static final int MOD = 998244353;

    static class InputReader {

        static Scanner getScanner() {

            return new Scanner(System.in);

        }

        static int nextInt(Scanner scanner) {

            return scanner.nextInt();

        }

        static long nextLong(Scanner scanner) {

            return scanner.nextLong();

        }

        static long[] readLongArray(Scanner scanner, int size) {

            long[] arr = new long[size];
            for (int i = 0; i < size; i++) {
                arr[i] = nextLong(scanner);
            }
            return arr;

        }

        static Map<Long, Long> getMapOb(){
            return new HashMap<>();
        }
        static ArrayList<Long> getListOb(){
            return new ArrayList<>();
        }

    }

    static class UniqueElements {

        static void printUniqueElements(Scanner scanner) {

            List<Long> uniqueList = Main.InputReader.getListOb();

            long n = InputReader.nextLong(scanner);

            long[] array = InputReader.readLongArray(scanner, 2 * (int) n);
            
            Map<Long, Long> countMap = Main.InputReader.getMapOb();

            for (int i = 0; i < 2 * n; i++) {

                if (!countMap.containsKey(array[i])) uniqueList.add(array[i]);
                
                countMap.put(array[i], countMap.getOrDefault(array[i], 0L) + 1);
            
            }
            
            for (int i = 0; i < n; i++) System.out.print(uniqueList.get(i) + " ");
            
            System.out.println();
            
        }
    }

}

public class Codechef {

    public static void main(String[] args) {

        try (Scanner scanner = Main.InputReader.getScanner()) {

            int t = Main.InputReader.nextInt(scanner);
            while (t-- > 0) Main.UniqueElements.printUniqueElements(scanner);
            
        }

    }

}
