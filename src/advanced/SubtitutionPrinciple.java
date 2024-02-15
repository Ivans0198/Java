package advanced;

import java.util.ArrayList;
import java.util.List;

public class SubtitutionPrinciple {

    // Liskov subtitution principle.
    // Manteniable and reduceble code.
    // If you have a variable of a given type you can assign it to a value that is a subtype of that type

    public static void main(String[] args) {
        Building building = new Building();
        Office office = new Office();
        build(building);
        build(office); // I can send an Office because is subtype of Building. This is substitution principle
                       // It does not apply to list.

        List<Building> buildings = new ArrayList<>();
        buildings.add(new Building());
        buildings.add(new Office());
        buildings.add(new House());

        List<Office> offices = new ArrayList<>();
        offices.add(new Office());
        offices.add(new Office());

        List<House> houses = new ArrayList<>();
        houses.add(new House());
        houses.add(new House());

        buildBuildings(buildings);
        // buildBuildings(offices); Error, because this principle does not apply to list


        // WILDCARD IS ESSENTIALLY AN UNKNOWN TYPE
        buildBuildingsWildcard(offices); // good use of the wildcard to solve the error
        buildBuildingsWildcard(houses);
        buildBuildingsWildcard(buildings);

        // I can also send a parent class
        addHouseToList(houses);
        //addHouseToList(buildings); // Error Required List<House> but Provided: List<Building>

        addHouseToListWildcard(houses);
        addHouseToListWildcard(buildings); // Now I can send houses and also the super type of House

        // It is not idea use wildcard to return methods
    }

    static void build(Building building) {
        System.out.println("Constructing a new " + building.toString());
    }

    static void buildBuildings(List<Building> buildings) {
        buildings.forEach(System.out::println);
    }

    static void buildBuildingsWildcard(List<? extends Building> buildings) {  // in-variables extends
        buildings.forEach(System.out::println);
    }

    static void addHouseToList(List<House> buildings) {
        buildings.add(new House());
    }

    static void addHouseToListWildcard(List<? super House> buildings) {  // out-variables super
        buildings.add(new House());
    }
}

class Building {

    @Override
    public String toString() {
        return ("Building");
    }
}

class Office extends Building {

    @Override
    public String toString() {
        return ("Office");
    }
}

class House extends Building {

    @Override
    public String toString() {
        return ("House");
    }
}

