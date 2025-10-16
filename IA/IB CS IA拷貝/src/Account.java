public class Account {
    private String password;
    private String ID;
    private double cash;

    public Account(String ID, String password) {
        this.ID = ID;
        this.password = password;
        cash = 1000.00;
    }

    public String getPassword() {
        return password;
    }

    public String getID() {
        return ID;
    }

    public double getCash() {return cash;}
}
