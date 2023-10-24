package lab4_task2.bank;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Client {
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String dateOfBirth;
    private String mobileNumber;
    private String city;
    private String address;
    private List<Account> bankAccounts;
    private Random rand = new Random();

    public Client(String surname, String name, String patronymic, String dateOfBirth, String mobileNumber, String city, String address) {
        this.id = Integer.parseInt(RandomNumber(1 + rand.nextInt(9)));
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.mobileNumber = mobileNumber;
        this.city = city;
        this.address = address;
        this.bankAccounts = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Account> getBankAccounts() {
        return bankAccounts;
    }

    public void displayInfo() {
        System.out.println("ПIБ: " + surname + " " + name + " " + patronymic);
        System.out.println("Дата народження: " + dateOfBirth);
        System.out.println("Мобiльний номер: " + mobileNumber);
        System.out.println("Мiсце проживання: " + city + " вул. " + address);
        if (!bankAccounts.isEmpty()) {
            System.out.println("Банкiвськi рахунки:");
            for (Account account : bankAccounts) {
                account.displayInfo("full");
            }
        }
    }

    public void createBankAccount(String paymentSystem) {
        long cardNumber = Long.parseLong(RandomNumber(16));
        short pinCode = Short.parseShort(RandomNumber(4));
        Account account = new Account(paymentSystem, cardNumber, pinCode);
        bankAccounts.add(account);
    }

    private String RandomNumber(int size) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int digit = rand.nextInt(10);
            res.append(digit);
        }
        return res.toString();
    }
}