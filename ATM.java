import java.io.IOException;
import java.util.HashMap;

public class ATM {
    private HashMap<String, Double> accounts;

    public ATM() {
        this.accounts = new HashMap<String, Double>();
    }

    public void openAccount(String userId, Double amount) throws IOException {
        if (!accounts.containsKey(userId)) {
            accounts.put(userId, amount);
        } else {
            throw new IOException("This email is already associated with an account.");
        }
    }

    public void closeAccount(String userId) throws IOException {
        double balance = 0.0;
        balance = accounts.get(userId);
        if (accounts.get(userId) <= 0.0) {
            accounts.remove(userId);
        } else {
            throw new IOException("Must withdraw money before closing an account.");
        }
    }

    public double checkBalance(String userId) throws IOException {
        if (accounts.containsKey(userId)) {
            return accounts.get(userId);
        } else {
            throw new IOException();
        }
    }

    public double depositMoney(String userId, double amount) throws IOException {
        double balance = 0;
        if (accounts.containsKey(userId)) {
            balance = accounts.get(userId);
            balance += amount;
            accounts.put(userId, balance);
        } else {
            throw new IOException();
        }
        return balance;
    }

    public double withdrawMoney(String userId, double amount) throws IOException {
        double balance = 0;
        if (accounts.get(userId) >= amount) {
            balance = accounts.get(userId);
            balance -= amount;
            accounts.put(userId, balance);
            return balance;
        } else {
            throw new IOException("You're Broke AF");
        }
    }
}