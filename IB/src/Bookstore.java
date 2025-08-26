import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Bookstore class is the main class for the Bookstore example.
 *
 * @author
 * @version 1.0
 */
public class Bookstore {
    // instance variables
    BookFile bf;

    /**
     * Main method
     */
    public static void main(String[] args) {
        new Bookstore();
    }

    /**
     * Constructor for objects of class Bookstore
     */
    public Bookstore() {
        // sequentially
        bf = new BookFile();
        showMenu();
    }

    /**
     * showMenu method - displays the start menu in the Terminal.
     */
    public void showMenu() {
        InputOutput.output("=========================");
        InputOutput.output("Welcome to the Bookstore");
        InputOutput.output("=========================");
        InputOutput.output("");
        InputOutput.output("Select one of the following actions:");
        InputOutput.output("a) List all the books in the bookstore");
        InputOutput.output("b) Add a book to the bookstore");
        InputOutput.output("c) Sort books by price (descending)");
        InputOutput.output("d) Sort books by price (ascending)");
        InputOutput.output("e) Find book with title");
        InputOutput.output("f) Exit");
        InputOutput.output("");
        InputOutput.output("");

        char selection = InputOutput.inputChar("Which action do you want to perform? ");

        switch (selection) {
            case 'a':
                listAllBooks();
                break;
            case 'b':
                addBook();
                break;
            case 'c':
                sortByPrice(true);
                break;
            case 'd':
                sortByPrice(false);
                break;
            case 'e':
                findBookTitle();
                break;
            case 'f':
                System.exit(0);
                break;
            default:
                break;
        }
    }

    /**
     * listAllBooks method - lists all the books of the bookstore in the terminal.
     */
    public void listAllBooks() {
        // sequentially
        bf.outputAllBooksToTerminal();
        InputOutput.output("");
        InputOutput.input("Press ANY BUTTON to continue.");
        InputOutput.output("");
        showMenu();
    }

    /**
     * addBook method - allows the user to add a book through the terminal
     */
    public void addBook() {
        InputTerminal addBook = new InputTerminal();
        Book b = addBook.bookEntry();

        bf.writeToBookFile(b);

        InputOutput.output("");
        InputOutput.input("Press ANY BUTTON to continue.");
        InputOutput.output("");
        showMenu();
    }

    /**
     * sortByPrice method
     *
     * @param ascending whether the Bookstore list is sorted in an ascending or descending way.
     */
    public void sortByPrice(boolean ascending) {
        Book[] books = readBookFile();
        if (books == null || books.length == 0) {
            System.out.println("There are no books in the bookstore to sort.");
        } else {
            if (ascending) {
                books = BubbleSort.bubbleSortA(books, true);
                System.out.println("");
                System.out.println("Sorted books by price (ascending):");
                System.out.println("");
            } else {
                books = BubbleSort.bubbleSortA(books, false);
                System.out.println("");
                System.out.println("Sorted books by price (descending):");
                System.out.println("");
            }

            for (int i = books.length - 1; i >= 0; i--) {
                int id = books[i].getId();
                String title = books[i].getTitle();
                int pages = books[i].getPages();
                int price = books[i].getPrice();
                int chapters = books[i].getChapters();
                String author = books[i].getAuthor();

                System.out.println("");
                System.out.println("----------------------");
                System.out.println("ID:" + id);
                System.out.println("TITLE:" + title);
                System.out.println("PAGES:" + pages);
                System.out.println("PRICE ($):" + price);
                System.out.println("CHAPTERS:" + chapters);
                System.out.println("AUTHOR(S):" + author);
                System.out.println("============");
            }

            System.out.println("");
            InputOutput.input("Press ANY BUTTON to continue.");
            System.out.println("");
            showMenu();
        }
    }

    public void findBookTitle() {
        System.out.println("");
        System.out.println("Search for a book.");
        String searchParameter = InputOutput.input("Title to search: ");
        System.out.println("");

        Book[] books = readBookFile();
        int toShow = SequentialSearch.sequentialSearchTitle(searchParameter, books);

        do {
            if (toShow == -1) {
                System.out.println("There is no book in the bookstore with such a title.");
            } else {
                int id = books[toShow].getId();
                String title = books[toShow].getTitle();
                int pages = books[toShow].getPages();
                int price = books[toShow].getPrice();
                int chapters = books[toShow].getChapters();
                String author = books[toShow].getAuthor();

                System.out.println("");
                System.out.println("-----------------------");
                System.out.println("ID:" + id);
                System.out.println("TITLE:" + title);
                System.out.println("PAGES:" + pages);
                System.out.println("PRICE ($):" + price);
                System.out.println("CHAPTERS:" + chapters);
                System.out.println("AUTHOR(S):" + author);
                System.out.println(" ");
                System.out.println("");

                int tempLength = books.length - toShow - 1;
                Book[] temp = new Book[tempLength];
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = books[toShow + i + 1];
                }
                books = temp;
                toShow = SequentialSearch.sequentialSearchTitle(searchParameter, books);
            }
        } while (toShow != -1);

        System.out.println("");
        InputOutput.input("Press ANY BUTTON to continue.");
        System.out.println("");
        showMenu();
    }
    public Book[] readBookFile() {
        String FILENAME = "bookFile";
        Book[] arrayOfBooks = new Book[999];
        int length = 0;

        try {
            FileReader theBookFile = new FileReader(FILENAME);
            BufferedReader input = new BufferedReader(theBookFile);
            String line;

            while ((line = input.readLine()) != null) {
                length = length + 1;

                int token = line.indexOf(":");
                int nextToken = line.indexOf(":", token + 1);

                int id = Integer.parseInt(line.substring(0, token));
                String title = line.substring(token + 1, nextToken);

                token = nextToken;
                nextToken = line.indexOf(":", token + 1);

                int pages = Integer.parseInt(line.substring(token + 1, nextToken));

                token = nextToken;
                nextToken = line.indexOf(":", token + 1);

                int price = Integer.parseInt(line.substring(token + 1, nextToken));

                token = nextToken;
                nextToken = line.indexOf(":", token + 1);

                int chapters = Integer.parseInt(line.substring(token + 1, nextToken));

                token = nextToken;
                nextToken = line.indexOf(":", token + 1);

                String author = line.substring(token + 1, nextToken);

                Book entry = new Book(id, title, pages, price, chapters, author);
                arrayOfBooks[length - 1] = entry;
            }
        } catch (Exception e) {
            // bookFile does not exist or cannot be created.
            String err = e.toString();
            InputOutput.output("");
            InputOutput.output("The file does not exist or cannot be created.");
            InputOutput.output("");
        }

        Book[] properArrayOfBooks = new Book[length];

        for (int i = 0; i < length; i++) {
            properArrayOfBooks[i] = arrayOfBooks[i];
        }
        return properArrayOfBooks;
    }
}