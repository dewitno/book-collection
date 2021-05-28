import java.util.HashMap;
import ecs100.*;
/**
 * Holds a collection of books in a hashmap
 * Allows a user to add, find, print all, edit from a menu
 * Maybe delete if time possible
 * prevent user from adding dupe?
 *
 * @author dewitno
 * @version 27/05/2021
 */
public class Books
{
    // fields
    private HashMap<Integer, Book> booksMap;        // declaring the hasmap
    private int currBookId;                 // store the current id of book being added
    private int bookId;
    private String bookName;
    
    /**
     * Constructor for objects of class Books
     */
    public Books()
    {
        // initialise instance variables
        booksMap = new HashMap<Integer, Book>();       // initialise hashmap
        
        // creating books
        Book b1 = new Book(1, "Pet Semetary", "Stephen King", 76);
        Book b2 = new Book(2, "1984", "George Orwell", 66);
        Book b3 = new Book(3, "The subtle knife", "Phillip Pullman", 42);
        Book b4 = new Book(4, "The subtle art of not giving a F@*!", "Mark Mason", 21);
        
        // add books to collection
        booksMap.put(1, b1);
        booksMap.put(2, b2);
        booksMap.put(3, b3);
        booksMap.put(4, b4);
                        
        this.currBookId = 4;        // initialis the book id
        
        //this.menu();
    }
    
    /**
     * adds a book to the map
     */
    public void addBook() {
        final int MAX_QUANTITY = 99;
        int quantity = -1;
        
        // ask the user for details
        String name = UI.askString("Title: ");
        String author = UI.askString("Author: ");
        
        // check boundaries for the number of books added to stock
        do {
            quantity = UI.askInt("Quantity: ");
        } while (0 > quantity || quantity > MAX_QUANTITY);
        
        // add a book image for display in the gui
        String imgFileName = UIFileChooser.open("Choose Image File: ");
        
        // increment the book id counter and add book to hashmap
        this.currBookId++;
        booksMap.put(this.currBookId, new Book(currBookId, name, author, quantity, imgFileName));
    }
    
    /**
     * Takes user input and sets it to book name
     */
    public String bookTitle(String title){
        this.bookName = title;
        return this.bookName;
    }
    
    /**
     * Finds a book based on title
     */
    public void findBook(){
        do {
            bookId++;
        } while (bookId < currBookId || booksMap.get(bookId).getName().equals(bookName));   // find book on title
        UI.println("Title: " + bookName);                               // prints out book name
        UI.println("Author: " + booksMap.get(bookId).getAuthor());      // prints out author name 
        UI.println("In stock: " + booksMap.get(bookId).getQty());    // prints out quantity in stock 
        booksMap.get(bookId).displayBook();     // shows book cover on canvas
    }
    
    /**
     * prints detail of all books
     */
    public void printAll(){
        // traversing map
        for (int bookId : booksMap.keySet()) {
            UI.println(bookId + " Details: ");
            UI.println(booksMap.get(bookId).getName() + " " );
            UI.println(booksMap.get(bookId).getAuthor() + " " );
            UI.println(booksMap.get(bookId).getQty() + " " );
        }
    }
    
    /**
     * Menu to print and call appropriate methods
     */
    public void menu() {
        // print menu and force choice
        String choice;
        do {
            UI.println("(A)dd a book");
            UI.println("(F)ind a book");
            UI.println("(P)rint all");
            UI.println("(Q)uit");
            
            choice = UI.askString("Enter a choice: ");
            
            if (choice.equalsIgnoreCase("A")) {
                addBook();
            } else if (choice.equalsIgnoreCase("F")) {
                findBook();
            } else if (choice.equalsIgnoreCase("P")) {
                printAll();
            } else if (choice.equalsIgnoreCase("Q")) {
                UI.println("Goodbye");
                UI.quit();
            } else {
                UI.println("THAT IS NOT A CHOICE YOU KNUCKLEHEAD!");
            }
        } while (!choice.equalsIgnoreCase("Q"));
    }
}