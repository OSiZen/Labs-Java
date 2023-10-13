import java.util.Random;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class lab2_task3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nВведiть n (розмiр матрицi): ");
        int n = input.nextInt();
        int a[][] = new int[n][n];
        input.close();

        Random rand = new Random();
        System.out.println("\nПочаткова матриця:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                a[i][j] = rand.nextInt(2 * n + 1) - n;
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }
        int[][] newA = listToArray(remove(removeZeroRows(listToArray(remove(a, 'r'))), 'c'));
        System.out.println("\nУщiльнена матриця:");
        for (int i = 0; i < newA.length; i++) {
            for (int j = 0; j < newA[0].length; j++) {
                System.out.print(newA[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> remove(int[][] mtrx, char c) {
        List<List<Integer>> temp = new ArrayList<>();
        int[][] currentMtrx = null;
        int row = 0;
        int colum = 0;
        if (c == 'r') {
            int[][] getMtrx = removeZeroRows(mtrx);
            row =  getMtrx.length;
            colum = getMtrx[0].length;
            currentMtrx = getMtrx;
        }
        else {
            row =  mtrx.length;
            colum = mtrx[0].length;
            currentMtrx = mtrx;
        }
        for (int i = 0; i < colum; i++) {
            List<Integer> tempRow = new ArrayList<>();
            for (int j = 0; j < row; j++) {
                tempRow.add(currentMtrx[j][i]);
            }
            temp.add(tempRow);
        }
        return temp;
    }

    private static int[][] removeZeroRows(int[][] mtrx) {
        boolean[] removeRow = new boolean[mtrx.length];
        int count = 0;
        for(int i = 0; i < mtrx.length; i++){
            boolean allZeros = true;
            for(int j = 0; j < mtrx[0].length; j++){
                if (mtrx[i][j] != 0){
                    allZeros = false;
                    break;
                }
            }           
            removeRow[i] = allZeros;
            if (allZeros){
                count++;
            }
        }
        if (count != 0) {
            int indx = -1;
            int[][] newMatrix = new int[mtrx.length - count][mtrx[0].length];
            for(int i = 0; i < mtrx.length; i++){
                if (!removeRow[i]) {
                    indx++;
                    newMatrix[indx] = mtrx[i];
                }
            }
            return newMatrix;
        } else {
            return mtrx;
        }
    }

    private static int[][] listToArray(List<List<Integer>> list) {
        int numRows = list.size();
        int numCols = list.get(0).size();
        int[][] matrix = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                matrix[i][j] = list.get(i).get(j);
            }
        }
        return matrix;
    }
}