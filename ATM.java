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
}