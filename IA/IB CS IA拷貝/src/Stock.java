public class Stock {
    private String name;
    private String code;
    private double price;
    private int numberPurchased;
    private double value;

    public Stock(String n,  String c, double p, int a){
        this.name = n;
        this.code = c;
        this.price = p;
        this.numberPurchased = a;
        this.value = p*a;
    }
    public String getName() {return name;}
    public String getCode() {return code;}
    public double getPrice() {return price;}
    public int getNumberPurchased() {return numberPurchased;}
    public double getValue() {return value;}


}
