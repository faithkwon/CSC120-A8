import java.util.ArrayList;

public class House extends Building implements HouseRequirements {

  // House attributes
  private ArrayList<Student> residents; 
  private boolean hasDiningRoom;
  private boolean hasElevator;
  private String nickname;

  /**
   * Constructor for House class
   * @param name name of the house
   * @param address location of the house
   * @param nFloors number of floors in the house
   * @param hasDiningRoom whether or not the house has a dining room
   */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /* overloading constructor -- includes a nickname */
  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElevator, String nickname) {
    super(name, address, nFloors);
    this.residents = new ArrayList<Student>();
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.nickname = nickname;
    System.out.println("You have built a house: 🏠");
  }

  /**
   * Accessor for hasDiningRoom
   * @return T/F depending on if the house has a dining room or not
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /**
   * Accessor for nResidents
   * @return number of residents in the house
   */
  public int nResidents() {
    return residents.size();
  }

  /**
   * Adds a new student to the list of residents
   * @param s student that is moving in
   */
  public void moveIn(Student s) {
    residents.add(s);
  }

  /* overloading moveIn -- takes in a list of students instead of just one */
  public void moveIn(ArrayList<Student> s) {
    residents.addAll(s);
  }

  /**
   * Removes a student from the list of residents
   * @param s student that is moving out
   * @return student that is moving out
   */
  public Student moveOut(Student s) {
    residents.remove(s);
    return s;
  }
  
  /**
   * Checks if a given student lives in a house
   * @param s student being checked
   * @return T/F depending on if the student lives in that house
   */
  public boolean isResident(Student s) {
    return residents.contains(s);
  }

  /**
   * House class-specific toString
   * @return nicely formatted summary of House
   */
  public String toString() {
    if (nickname == null) {
      return this.name + " has these students: " + residents.toString();
    }

    return this.name + ", AKA " + this.nickname + ", has these students: " + residents.toString();
  }
    
  
  /* overriding showOptions */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + moveIn(s)\n + moveOut(s)\n + isResident(s)");
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
    House kingHouse = new House("King House", "180 Elm", 4, true, true);
    Student faith = new Student("Faith", "99XXXX", 2027);

    if (kingHouse.hasDiningRoom()) {
      System.out.println(kingHouse.getName() + " has a dining room.");
    } else {
      System.out.println("No dining room.");
    }

    System.out.println(kingHouse.getName() + " has " + kingHouse.nResidents() + " residents.");
    kingHouse.moveIn(faith);
    System.out.println(kingHouse);

    System.out.println(kingHouse.getName() + " has " + kingHouse.nResidents() + " residents.");

    kingHouse.moveOut(faith);
    System.out.println(kingHouse);
    kingHouse.showOptions();

    kingHouse.enter();
    kingHouse.goUp();
    kingHouse.goUp();
    kingHouse.goToFloor(1);
    kingHouse.exit();

    // testing overloaded moveIn method
    ArrayList<Student> students = new ArrayList<Student>();
    Student a = new Student("a", "99XXXX", 2027);
    Student b = new Student("b", "99XXXX", 2026);
    students.add(a);
    students.add(b);

    kingHouse.moveIn(students);
    System.out.println(kingHouse);
  }

}