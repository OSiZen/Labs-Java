package lab4_task2.ui;
import lab4_task2.bank.Client;
import lab4_task2.bank.Account;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Interface {
    public static List<Client> listClients = new ArrayList<>();

    public static void menu() {
        System.out.println("\n### Меню");
        System.out.println("1. Створити нового клiєнта");
        System.out.println("2. Iнформацiю про клiєнта");
        System.out.println("3. Створити банкiвський рахунок");
        System.out.println("4. Пошук банкiвського рахунку (з вiдсортованим виглядом)");
        System.out.println("5. Додати/зняти кошти з банкiвського рахунку");
        System.out.println("6. Заблокувати/розблокувати банкiвський рахунок");
        System.out.println("7. Обчислити загальний баланс клiєнта серед усiх його банкiвських рахункiв");
        System.out.println("8. Обчислити суму позитивних i негативних балансiв клiєнта по всiм його банкiвським рахункам");
        System.out.println("###");
    }

    public static void addClient(Scanner scanner) {
        System.out.print("Введiть прiзвище: ");
        String surname = scanner.next();
        System.out.print("Введiть iм'я: ");
        String name = scanner.next();
        System.out.print("Введiть по батьковi: ");
        String patronymic = scanner.next();
        System.out.print("Введiть дату народження: ");
        String dateOfBirth = scanner.next();
        System.out.print("Введiть мобiльний номер: ");
        String mobileNumber = scanner.next();
        System.out.print("Введiть мiсто проживання: ");
        String city = scanner.next();
        scanner.nextLine();
        System.out.print("Введiть адресу проживання: ");
        String address = scanner.nextLine();
        Client client = new Client(surname, name, patronymic, dateOfBirth, mobileNumber, city, address);
        listClients.add(client);
        System.out.println("Створено нового клiєнта з таким ID: " + client.getId());
    }

    private static Client findClientById(int idClient) {
        for (Client client : listClients) {
            if (client.getId() == idClient) {
                return client;
            }
        }
        return null;
    }

    private static Client findClientByCardNumber(long cardNumber) {
        for (Client client : listClients) {
            for (Account account : client.getBankAccounts()) {
                if (account.getCardNumber() == cardNumber) {
                    return client;
                }
            }
        }
        return null;
    }

    private static Account findAccountByCardNumber(Client client, long cardNumber) {
        for (Account account : client.getBankAccounts()) {
            if (account.getCardNumber() == cardNumber) {
                return account;
            }
        }
        return null;
    }

    public static void clientInfo(Scanner scanner) {
        System.out.print("Введiть ID клiєнта: ");
        int idClient = scanner.nextInt();
        Client client = findClientById(idClient);
        if (client != null) {
            client.displayInfo();
        } else {
            System.out.println("Клiєнта з таким ID не знайдено.");
        }
    }

    public static void createAccount(Scanner scanner) {
        System.out.print("Введiть ID клiєнта: ");
        int idClient = scanner.nextInt();
        Client client = findClientById(idClient);
        if (client != null) {
            String cardType = selectPaymentSystem(scanner);
            client.createBankAccount(cardType);
            Account newAccount = client.getBankAccounts().get(client.getBankAccounts().size() - 1);
            System.out.println("Створено новий банкiвський рахунок з номером карти: " + newAccount.getCardNumber());
        } else {
            System.out.println("Клiєнта з таким ID не знайдено.");
        }
    }

    private static String selectPaymentSystem(Scanner scanner) {
        String cardType = null;
        do {
            System.out.print("Виберiть платiжну систему (1- Mastercard, 2- Visa, 3- UnionPay): ");
            int number = scanner.nextInt();
            if (number == 1) {
                cardType = "Mastercard";
            } else if (number == 2) {
                cardType = "Visa";
            } else if (number == 3) {
                cardType = "UnionPay";
            } else {
                System.out.println("Невiрно обрано платiжну систему! Спробуйте ще раз.");
            }
        } while (cardType == null);
        return cardType;
    }

    public static void listAccounts(Scanner scanner) {
        System.out.print("Введiть ID клiєнта: ");
        int idClient = scanner.nextInt();
        Client client = findClientById(idClient);
        if (client != null) {
            List<Account> listAccounts = client.getBankAccounts();
            if (listAccounts.isEmpty()) {
                System.out.println("У клiєнта немає банкiвських рахункiв.");
            } else {
                listAccounts.sort(Comparator.comparingLong(Account::getCardNumber));
                System.out.println("Банкiвськi рахунки клiєнта:");
                for (Account account : listAccounts) {
                    account.displayInfo("short");
                }
            }
        } else {
            System.out.println("Клiєнта з таким ID не знайдено.");
        }
    }

    private static int selectOperation(Scanner scanner) {
        int operationChoice = 0;
        do {
            operationChoice = scanner.nextInt();
            if (operationChoice != 1 && operationChoice != 2) {
                System.out.println("Невiрно обрано операцiю! Спробуйте ще раз.");
            }
        } while (operationChoice != 1 && operationChoice != 2);
        return operationChoice;
    }

    public static void moneyManagement(Scanner scanner) {
        System.out.print("Введiть номер карти: ");
        long cardNumber = scanner.nextLong();
        Client client = findClientByCardNumber(cardNumber);
        if (client != null) {
            Account account = findAccountByCardNumber(client, cardNumber);
            System.out.print("Введiть PIN-код: ");
            short pinCode = scanner.nextShort();
            if (account.getPinCode() == pinCode) {
                if (account.isBlocked()) {
                    System.out.println("Рахунок заблоковано. Неможливо додавати/знiмати кошти.");
                } else {
                    System.out.println("Поточний баланс: " + account.getBalance());
                    System.out.print("Виберiть операцiю (1- Додати, 2- Зняти): ");
                    int operationChoice = selectOperation(scanner);
                    if (operationChoice == 1) {
                        System.out.print("Введiть суму для додавання: ");
                        double amount = Math.abs(scanner.nextDouble());
                        account.set(amount);
                    } else if (operationChoice == 2) {
                        System.out.print("Введiть суму для зняття: ");
                        double amount = Math.abs(scanner.nextDouble());
                        account.get(amount);
                    }
                    System.out.println("Оновлений баланс: " + account.getBalance());
                }
            } else {
                System.out.println("Невiрно введено PIN-код!");
            }
        } else {
            System.out.println("Невiрно введено номер банкiвської картки!");
        }
    }

    public static void accountStatus(Scanner scanner) {
        System.out.print("Введiть ID клiєнта: ");
        int idClient = scanner.nextInt();
        Client client = findClientById(idClient);
        if (client != null) {
            System.out.print("Введiть номер банкiвської картки: ");
            long cardNumber = scanner.nextLong();
            Account account = findAccountByCardNumber(client, cardNumber);
            if (account != null) {
                System.out.print("Введiть PIN-код: ");
                short pinCode = scanner.nextShort();
                if (account.getPinCode() == pinCode) {
                    System.out.print(account.isBlocked() ? "Розблокувати рахунок? (1- Так, 2- Нi):" : "Заблокувати рахунок? (1- Так, 2- Нi): ");
                    int operationChoice = selectOperation(scanner);
                    if (operationChoice == 1) {
                        if (account.isBlocked()) {
                            account.unblockAccount();
                            System.out.println("Рахунок розблоковано.");
                        } else {
                            account.blockAccount();
                            System.out.println("Рахунок заблоковано.");
                        }
                    }
                } else {
                    System.out.println("Невiрно введено PIN-код!");
                }
            } else {
                System.out.println("Невiрно введено номер банкiвської картки!");
            }
        } else {
            System.out.println("Клiєнта з таким ID не знайдено.");
        }
    }

    public static void calcTotalBalance(Scanner scanner) {
        System.out.print("Введiть ID клiєнта: ");
        int idClient = scanner.nextInt();
        Client client = findClientById(idClient);
        if (client != null) {
            double totalBalance = 0;
            List<Account> accounts = client.getBankAccounts();
            for (Account account : accounts) {
                totalBalance += account.getBalance();
            }
            System.out.println("Загальний баланс клiєнта: " + totalBalance);
        } else {
            System.out.println("Клiєнта з таким ID не знайдено.");
        }
    }

    public static void calcBalance(Scanner scanner) {
        System.out.print("Введiть ID клiєнта: ");
        int idClient = scanner.nextInt();
        Client client = findClientById(idClient);
        if (client != null) {
            double positive = 0;
            double negative = 0;
            List<Account> accounts = client.getBankAccounts();
            for (Account account : accounts) {
                double balance = account.getBalance();
                if (balance >= 0) {
                    positive += balance;
                } else {
                    negative += balance;
                }
            }
            System.out.println("Сума позитивних балансiв клiєнта: " + positive);
            System.out.println("Сума негативних балансiв клiєнта: " + negative);
        } else {
            System.out.println("Клiєнта з таким ID не знайдено.");
        }
    }
}