import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public Building getBuilding(int i) {
        return this.buildings.get(i);
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        
        myMap.addBuilding(new Building("Seelye Hall", "2 Seelye Drive #1, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Wright Hall", "5 Chapin Way, Northampton, MA 01063", 3));
        
        myMap.addBuilding(new House("King House", "180 Elm Street, Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new House("Morrow House", "Mandelle Road, Northampton, MA 01063", 4, false, false, "BOTQ")); // testing overloading constructor -- house has a nickname
        myMap.addBuilding(new House("Capen House", "26 Prospect Street, Northampton, MA 01063", 3, false, false));
        myMap.addBuilding(new House("Chapin House", "3 Chapin Way, Northampton, MA 01063", 3, true, false));
        
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive, Northampton, MA 01063", 4, true));
        myMap.addBuilding(new Library("Hillyer Library", "22 Elm Street, Northampton, MA 01063", 2, true));
        
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 2, 20, 10, 10, 10));
        myMap.addBuilding(new Cafe("CC Cafe", "100 Elm Street Northampton, MA 01063", 20, 10, 10, 10)); // testing overloading constructor -- one floor cafe
        
        System.out.println(myMap);
    }
    
}
