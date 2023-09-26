import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введiть n цiлих чисел через кому: ");
        String line = input.nextLine();
        input.close();
        String[] lineToArray = line.split(",");
        int[] arr = new int[lineToArray.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(lineToArray[i]);
        }
        System.out.println("\nПростi числа:");
        for (int i = 0; i < arr.length; i++) {
            boolean prime = true;
            int number = arr[i];
            if (number >= 2) {
                for (int j = 2; j <= number; j++) {
                    if (number % j == 0 && j != number) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    System.out.println(number);
                }
            }
        }
    }
}