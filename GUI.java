import ecs100.*;
/**
 * Class to handle GUI functionanality
 *
 * @author dewitno
 * @version 27/05/2021
 */
public class GUI
{
    
    /**
     * Constructor for objects of class GUI
     */
    public GUI()
    {
        // initialise instance variables
        Books bk = new Books();
        UI.initialise();
        UI.addButton("Add", bk::addBook);
        UI.addButton("Find", bk::findBook);
        UI.addButton("All", bk::printAll);
        UI.addButton("Quit", UI::quit);
    }

}
