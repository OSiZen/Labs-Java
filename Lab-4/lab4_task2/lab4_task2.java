package lab4_task2;
import lab4_task2.ui.Interface;
import java.util.Scanner;

public class lab4_task2 {
    public static void main(String[] args) {
        Interface.menu();
        try (Scanner scanner = new Scanner(System.in, "Cp866")) {
            while (true) {         
                System.out.print("\nОберiть номер меню > ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Interface.addClient(scanner);
                        break;
                    case 2:
                        Interface.clientInfo(scanner);
                        break;
                    case 3:
                        Interface.createAccount(scanner);
                        break;
                    case 4:
                        Interface.listAccounts(scanner);
                        break;
                    case 5:
                        Interface.moneyManagement(scanner);
                        break;
                    case 6:
                        Interface.accountStatus(scanner);
                        break;
                    case 7:
                        Interface.calcTotalBalance(scanner);
                        break;
                    case 8:
                        Interface.calcBalance(scanner);
                        break;
                    default:
                        System.out.println("Обрано невiрний номер меню! Спробуйте ще раз.");
                        break;
                }
            }
        }
    }
}