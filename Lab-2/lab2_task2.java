import java.util.Scanner;

public class lab2_task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nВведiть k (останнє значення): ");
        int k = input.nextInt();
        int mtrx[][] = new int[k][k];
        input.close();
        for(int i = 0; i < mtrx.length; i++){
            int val = i + 1;
            mtrx[0][i] = val;
            mtrx[i][0] = val;
        }
        for(int i = 0; i < mtrx.length; i++){
            for(int j = 0; j < mtrx.length; j++){
                System.out.print(mtrx[i][j] + "\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}