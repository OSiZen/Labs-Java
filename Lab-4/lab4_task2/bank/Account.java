package lab4_task2.bank;

public class Account implements Transaction {
    private String cardType;
    private long cardNumber;
    private short pinCode;
    private double balance;
    private boolean isBlocked;

    public Account(String cardType, long cardNumber, short pinCode) {
        this.cardType = cardType;
        this.cardNumber = cardNumber;
        this.isBlocked = false;
        this.pinCode = pinCode;
        this.balance = 0;
    }

    public void displayInfo(String type) {
        System.out.println("\nПлатiжна система: " + cardType);
        System.out.println(isBlocked() ? "Номер карти: " + cardNumber + " - ЗАБЛОКОВАНО!"  : "Номер карти: " + cardNumber);
        if ("full".equals(type)) {
            System.out.println("PIN-код: " + pinCode);
        }
        System.out.println("Баланс: " + balance);
    }

    @Override
    public void set(double money) {
        balance += money;
    }

    @Override
    public void get(double money) {
        balance -= money;
    }

    public String getCardType() {
        return cardType;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public short getPinCode() {
        return pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void blockAccount() {
        isBlocked = true;
    }

    public void unblockAccount() {
        isBlocked = false;
    }
}