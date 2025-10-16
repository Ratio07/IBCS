import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StockSave {
    private List<Stock> stocks;
    public static final String FILENAME = "stockFile";
    public static final String DELIMITER = ","; //separate the fields


    public StockSave() {
        stocks = new ArrayList<>();
        loadStocks();
    }




    private void loadStocks(){
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                if (parts.length == 6) {
                    stocks.add(new Stock(parts[0].trim(), parts[1].trim(), Double.parseDouble(parts[2].trim()), Integer.parseInt(parts[3].trim()))); // Create Book with ID and Author
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading books: " + e.getMessage());
        }
    }

private void saveStocks(){
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))) {
        for (Stock stock: stocks) {
            bw.write(stock.getName()+ DELIMITER + " " + stock.getCode() + DELIMITER + " " + stock.getPrice() + DELIMITER + " " + stock.getNumberPurchased());
            bw.newLine();
        }
    } catch (IOException e) {
        System.out.println("Error saving books: " + e.getMessage());
    }

}

}
