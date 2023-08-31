import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.io.PrintWriter;

public class ATM {
    private HashMap<String, Double> accounts;

    // initializes an atm and creates a new hashmap to store key value pairs of
    // email and balance to that email
    public ATM() {
        this.accounts = new HashMap<String, Double>();
    }

    // create a new account by intiializing it to a hashmap with a given amount,
    // throws error if userId already exists
    public void openAccount(String userId, Double amount) throws IOException {
        if (amount < 0) {
            throw new IOException("You cannot open an account with a negative balance lol?");
        }
        if (!accounts.containsKey(userId)) {
            accounts.put(userId, amount);
        } else {
            throw new IOException("This email is already associated with an account.");
        }
    }

    // if balance of an account is 0 the key of the hashmap is deleted
    public void closeAccount(String userId) throws IOException {
        if (!accounts.containsKey(userId)) {
            throw new IOException("Account does not exist.");
        }
        double balance = 0.0;
        balance = accounts.get(userId);
        if (accounts.get(userId) <= 0.0) {
            accounts.remove(userId);
        } else {
            throw new IOException("Must withdraw money before closing an account.");
        }
    }

    // returns the balance of a given userId
    public double checkBalance(String userId) throws IOException {
        if (accounts.containsKey(userId)) {
            return accounts.get(userId);
        } else {
            throw new IOException("Account does not exist.");
        }
    }

    // uadds money to the given userId balance
    public double depositMoney(String userId, double amount) throws IOException {
        double balance = 0;
        if (accounts.containsKey(userId) && amount > 0) {
            balance = accounts.get(userId);
            balance += amount;
            accounts.put(userId, balance);
        } else {
            throw new IOException("Invalid Deposit Value. Or account does not exist.");
        }
        return balance;
    }

    // removes money from the given userId's balance
    public double withdrawMoney(String userId, double amount) throws IOException {
        if (!accounts.containsKey(userId)) {
            throw new IOException("Account Does Not Exist.");
        }
        double balance = 0;
        if (accounts.get(userId) >= amount && amount > 0) {
            balance = accounts.get(userId);
            balance -= amount;
            accounts.put(userId, balance);
            return balance;
        } else {
            throw new IOException("You're Broke AF");
        }
    }

    // transfers balance from an account to another account updating appropriate
    // values
    public boolean transferMoney(String fromAccount, String toAccount, double amount) throws IOException {
        try {
            withdrawMoney(fromAccount, amount);
            depositMoney(toAccount, amount);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // creates a text file called AccountAudit.txt that reveals all the accounts
    // with their respective balances
    public void audit() throws FileNotFoundException {
        PrintWriter pw = new PrintWriter("AccountAudit.txt");
        for (HashMap.Entry<String, Double> entry : accounts.entrySet()) {
            pw.print("Email: " + entry.getKey());
            pw.print("  Balance: " + entry.getValue());
            pw.print("\n");
        }
        pw.close();
    }
}