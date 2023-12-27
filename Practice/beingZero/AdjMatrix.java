package beingZero;

import java.util.Scanner;

public class AdjMatrix {

    static void printDegree(int[] rj) {
        for (int i = 0; i < rj.length; i++)
            System.out.print(rj[i]+" ");
        
            System.out.println();
    }

    static int[] calcOutDegree(int[][] adjMat) {

        int[] outDeg = new int[adjMat.length];

        for (int i = 0; i < adjMat.length; i++) {
            int c = 0;
            for (int j = 0; j < adjMat[0].length; j++) {
                if (adjMat[i][j] != 0)
                    c++;
            }
            outDeg[i] = c;
        }

        return outDeg;

    }
    static int[] calcInDegree(int[][] adjMat) {

        int[] outDeg = new int[adjMat.length];

        for (int i = 0; i < adjMat.length; i++) {
            int c = 0;
            for (int j = 0; j < adjMat[0].length; j++) {
                if (adjMat[j][i] != 0)
                    c++;
            }
            outDeg[i] = c;
        }

        return outDeg;

    }

    static void printAns(int[][] adjMat) {
        for (int i = 0; i < adjMat.length; i++) {
            for (int j = 0; j < adjMat[0].length; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner rj = new Scanner(System.in);

        System.out.println("Enter nv, ne");

        int nv = rj.nextInt();
        int ne = rj.nextInt();

        System.out.println("Enter values.......");

        int adjMat[][] = new int[nv][ne];

        for (int j = 0; j < ne; j++) {
            int u = rj.nextInt(), v = rj.nextInt();
            adjMat[u][v] = 1;
        }

        printAns(adjMat);
        System.out.println("Out degree......");
        printDegree(calcOutDegree(adjMat));
        System.out.println("In degree......");
        printDegree(calcInDegree(adjMat));
        rj.close();

    }
}
