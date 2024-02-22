package codeforces;
import java.util.*;

public class Raja {
    public static void main(String[] args) {

        new Executor().execute();

    }

}

class Executor {

    public void execute() {

        InputReader reader = new InputReader();
        
        
        int testCases = reader.nextInt();
        
        while (testCases-- > 0) {

            int n = 7;

            char[][] matrix = new char[n][n];
            new LoopManager().fillMatrix(reader, matrix, n);
            
            OutputWriter.printResult(new Logic().findMinPaints(matrix));

        }
        
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
    
    public String next() {

        return scanner.next();

    }
    
    public void close() {

        scanner.close();

    }

}

class Logic {

    public int findMinPaints(char[][] matrix) {
        
        int size = matrix.length;
        List<List<Integer>> oddBlackCells = new ArrayList<>(), evenBlackCells = new ArrayList<>();
        
        new LoopManager().findOddAndEvenBlackCells(matrix, size, oddBlackCells, evenBlackCells);
        
        return new LoopManager().findMinPaintsHelper(matrix, oddBlackCells, 1) + new LoopManager().findMinPaintsHelper(matrix, evenBlackCells, 0);
    
    }

}

class LoopManager {

    public void fillMatrix(InputReader reader, char[][] matrix, int size) {
        
        for (int i = 0; i < size; i++) matrix[i] = reader.next().toCharArray();
        
    }
    
    public void findOddAndEvenBlackCells(char[][] matrix, int size, List<List<Integer>> oddBlackCells, List<List<Integer>> evenBlackCells) {
        
        for (int i = 1; i < size - 1; i++) for (int j = 1; j < size - 1; j++) {
                
            if (((i + j) & 1) == 1 && matrix[i][j] == 'B') oddBlackCells.add(Arrays.asList(i, j));
            
            else if ((i + j) % 2 == 0 && matrix[i][j] == 'B') evenBlackCells.add(Arrays.asList(i, j));
            

        }
        
    }
    
    public int findMinPaintsHelper(char[][] matrix, List<List<Integer>> lst, int ck) {
        int minPaints = 1000;
        
        for (int i = 0; i < (1 << lst.size()); i++) {

            int currentPaints = 0;
            
            for (int j = 0; j < lst.size(); j++) if ((1 << j & i) != 0) {
                    
                matrix[lst.get(j).get(0)][lst.get(j).get(1)] = 'W';
                currentPaints++;

                
            }

            if (check(matrix, ck)) minPaints = Math.min(minPaints, currentPaints);

            for (int j = 0; j < lst.size(); j++) if ((1 << j & i) != 0) matrix[lst.get(j).get(0)][lst.get(j).get(1)] = 'B';
                
        }

        return minPaints;

    }
    
    private boolean check(char[][] matrix, int ck) {

        int size = matrix.length;

        for (int i = 1; i < size - 1; i++) for (int j = 1; j < size - 1; j++) if (((i + j) & 1) == ck) {
            
            if (matrix[i][j] == 'B') if (matrix[i - 1][j - 1] == 'B' && matrix[i - 1][j + 1] == 'B' && matrix[i + 1][j - 1] == 'B' && matrix[i + 1][j + 1] == 'B') {
                
                return false;

            }

        }

        return true;

    }
}

class OutputWriter {

    public static void printResult(int result) {

        System.out.println(result);

    }
    
}

