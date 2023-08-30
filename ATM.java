import java.io.IOException;
import java.util.HashMap;

public class ATM {
    private HashMap<String, Double> accounts;

    public ATM() {
        this.accounts = new HashMap<String, Double>();
    }

    public void openAccount(String email, Double initialDeposit) throws IOException {
        if (!accounts.containsKey(email)) {
            accounts.put(email, initialDeposit);
        } else {
            throw new IOException("This email is already associated with an account.");
        }
    }
}