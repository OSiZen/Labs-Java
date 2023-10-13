import java.util.Scanner;

public class lab2_task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("\nВведiть n (к-сть чисел): ");
        int n = input.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Число " + (i + 1) + " = ");
            arr[i] = input.nextInt();
        }
        input.close();
        for (int i = 0; i < arr.length; i++) {
            boolean check = true;
            String number = Integer.toString(arr[i]);
            for (int j = 0; j < number.length() - 1; j++) {
                for (int k = j + 1; k < number.length(); k++) {    
                    if (number.charAt(j) == number.charAt(k)) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                System.out.println("\nПерше число, яке складається з рiзних цифр це число " + (i + 1));
                break;
            }
        }
        System.out.print("\n");
    }
}