import java.io.IOException;

public class ATMAuditTester {
    public static void main(String[] args) throws IOException {
        ATM bank = new ATM();
        // open 2 bank accounts
        bank.openAccount("danieltonyh06@gmail.com", 100.0);
        bank.openAccount("test@gmail.com", 50.0);
        // check balance of account 1
        System.out.println(bank.checkBalance("danieltonyh06@gmail.com"));
        // deposit money into account 1
        System.out.println(bank.depositMoney("danieltonyh06@gmail.com", 50.0));
        // withdraw money from account 1
        System.out.println(bank.withdrawMoney("danieltonyh06@gmail.com", 25.0));
        // transfer money from account 1 to account 2
        bank.transferMoney("danieltonyh06@gmail.com", "test@gmail.com", 25.0);
        // check balance of account 1 after the transfer
        System.out.println("Account1 Balance: " + bank.checkBalance("danieltonyh06@gmail.com") + "\nAccount2 Balance: "
                + bank.checkBalance("test@gmail.com"));
        bank.audit();
        // open a third account
        bank.openAccount("test2@gmail.com", 100000.0);
        // withdraw money from account 2
        bank.depositMoney("test@gmail.com", 100.0);
        bank.audit();
    }
}
