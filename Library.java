import java.util.Hashtable;
import java.util.ArrayList;

public class Library extends Building implements LibraryRequirements {

  // Library attributes
  private Hashtable<String, Boolean> collection;
  private boolean hasElevator;

  /**
   * Constructor for the Library class
   * @param name name of the library
   * @param address location of the library
   * @param nFloors number of floors in the library
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>();
    this.hasElevator = hasElevator;
    System.out.println("You have built a library: 📖");
  }

  /**
   * Adds a title to the collection
   * @param title name of the book
   */
  public void addTitle(String title) {
    collection.put(title, true);
  }

  /* overloading addTitle -- adding an ArrayList of titles to collection instead of just one */
  public void addTitle(ArrayList<String> titles) {
    for (int i = 0; i < titles.size(); i++) {
      collection.put(titles.get(i), true);
    }
  }

  /**
   * Removes a title from the collection
   * @param title name of the book
   */
  public String removeTitle(String title) {
    collection.remove(title);
    return title;
  }

  /**
   * Checks out a title
   * @param title name of the book
   */
  public void checkOut(String title) {
    collection.replace(title, true, false);
  }

  /* overloading checkOut -- checking out multiple titles instead of just one */
  public void checkOut(ArrayList<String> titles) {
    for (int i = 0; i < titles.size(); i++) {
      collection.replace(titles.get(i), true, false);
    }
  }

  /**
   * Returns a title
   * @param title name of the book
   */
  public void returnBook(String title) {
    collection.replace(title, false, true);
  }

  /**
   * Checks if the collection has a specific title
   * @param title name of the book
   */
  public boolean containsTitle(String title) {
    return collection.containsKey(title);
  }

  /**
   * Checks if a specific title is available
   * @param title name of the book
   */
  public boolean isAvailable(String title) {
    return collection.get(title) == true;
  }

  /* Prints out the library's collection */
  public void printCollection() {
    System.out.println(collection.toString());
  }

  /* overriding showOptions */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + addTitle(title)\n + removeTitle(title)\n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)\n + printCollection()");
  }

  /* overriding goToFloor */
  public void goToFloor(int n) {
    if (hasElevator == true) {
      super.goToFloor(n);
    } else {
      if (Math.abs(n - this.activeFloor) == 1) {
        super.goToFloor(n);
      } else {
        throw new RuntimeException("You cannot go to floor #" + n + " in one action without an elevator. Please select an adjacent floor.");
      }
    }
  }
  
  // Main method
  public static void main(String[] args) {
    Library lib = new Library("Neilson", "Smith College", 4, true);
    
    lib.addTitle("book1"); 
    lib.addTitle("book2");

    lib.printCollection();

    if (lib.containsTitle("book2")) {
      System.out.println(lib.getName() + " has book2 in its collection.");
    } else {
      System.out.println("Book2 not in collection.");
    }

    lib.removeTitle("book2");
    lib.checkOut("book1");

    if (lib.isAvailable("book1")) {
      System.out.println("Book1 is currently available.");
    } else {
      System.out.println("Book1 is currently checked out.");
    }

    lib.printCollection();

    lib.returnBook("book1");

    lib.printCollection();

    lib.showOptions();
    lib.enter();
    lib.goUp();
    lib.goUp();
    lib.goToFloor(1);
    lib.exit();

    // testing overloaded addTitle and checkOut methods
    ArrayList<String> books = new ArrayList<>();
    books.add("a");
    books.add("b");

    lib.addTitle(books);
    lib.printCollection();
    lib.checkOut(books);
    lib.printCollection();
  }

}