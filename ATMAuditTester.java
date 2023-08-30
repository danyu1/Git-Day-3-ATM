import java.io.IOException;

public class ATMAuditTester {
    public static void main(String[] args) throws IOException {
        ATM bank = new ATM();
        bank.openAccount("danieltonyh06@gmail.com", 100.0);
        bank.openAccount("test@gmail.com", 50.0);
        System.out.println(bank.checkBalance("danieltonyh06@gmail.com"));
        System.out.println(bank.depositMoney("danieltonyh06@gmail.com", 50.0));
        System.out.println(bank.withdrawMoney("danieltonyh06@gmail.com", 25.0));
        bank.transferMoney("danieltonyh06@gmail.com", "test@gmail.com", 25.0);
        System.out.println("Daniel Balance: " + bank.checkBalance("danieltonyh06@gmail.com") + "\nTest Balance: "
                + bank.checkBalance("test@gmail.com"));
        bank.audit();
        bank.openAccount("test2@gmail.com", 100000.0);
        bank.withdrawMoney("test@gmail.com", 20.0);
        bank.audit();
    }
}
