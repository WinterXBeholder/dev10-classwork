public class Vault implements MoneyStorage {
    private double balance;
    private String description;

    public Vault(double startingBalance, String description) {
        this.balance = startingBalance;
        this.description = description;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount > 0.0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public double withdraw(double amount) {
        if (amount < 0.0) {
            return 0.0;

        }
        double result = Math.min(amount, balance);
        balance -= result;
        return result;
    }
}