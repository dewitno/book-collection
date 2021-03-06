import ecs100.*;
/**
 * Support class of Book
 * A Book contains an id, name, author, quantity, front cover image
 *
 * @author dewitno
 * @version 27/05/2021
 */
public class Book
{
    // ifields
    private int id;
    private String name;
    private String author;
    private int quantity;
    private String image;
    static final String DEFAULT_IMAGE = "imgs/Book.png";
    
    private double locX, locY;
    
    /**
     * Constructor for objects of class Book
     */
    public Book(int id, String nm, String auth, int qty, String img) {
        // initialise instance variables
        this.id = id;
        this.name = nm;
        this.author = auth;
        this.quantity = qty;
        this.image = img;
    }
    
    /**
     * Constructor overloading
     */
    public Book(int id, String nm, String author, int qty) {
        this(id, nm, author, qty, DEFAULT_IMAGE);
    }
    
    /**
     * Getter of id
     * 
     * @return int the id
     */
    public int getId() {
        return this.id;
    }
    
    /**
     * Getter of name
     * 
     * @return String the name
     */
    public String getName() {
        return this.name;
    }
    
    /**
     * Getter of author
     * 
     * @return String the author
     */
    public String getAuthor() {
        return this.author;
    }
    
    /**
     * Getter of quantity
     * 
     * @return int the quantity
     */
    public int getQty() {
        return this.quantity;
    }
    
    /**
     * display image on our gui
     */
    public void displayBook() {
        locX = 100;
        locY = 100;
        final double WIDTH = 100;
        final double HEIGHT = 100;
        
        UI.drawImage(this.image, locX, locY, WIDTH, HEIGHT);
    }
}
