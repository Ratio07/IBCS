import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AccountSave {
    private List<Account> accounts;
    private static final String FILENAME = "accFile"; // No extension
    private static final String DELIMITER = ","; // To separate fields in the file

    public AccountSave() {
        accounts = new ArrayList<>();
        loadAccounts();
    }

    public void addAccount(Account acc) {
        accounts.add(acc);
        saveAccount();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    private void loadAccounts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                if (parts.length == 2) {
                    accounts.add(new Account(parts[0].trim(), parts[1].trim())); // Create Account with ID and password
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading account: " + e.getMessage());
        }
    }

    public boolean checkAccount(String id, String password){
        boolean b = false;
        for(Account acc : accounts) {
            if (id.equals(acc.getID()) && password.equals(acc.getPassword())) {
                b = true;
            }
        }
        return b;
    }


    private void saveAccount() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
            for (Account acc : accounts) {
                bw.write(acc.getID() + DELIMITER + " " + acc.getPassword() + DELIMITER + " " +acc.getCash());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving account: " + e.getMessage());
        }
    }

}