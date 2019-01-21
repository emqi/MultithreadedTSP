//Przechowuje miasta

package pl.tsp;

import java.util.ArrayList;
import java.io.Serializable;

public class TourManager implements Serializable {

    // Holds our cities
    public static ArrayList destinationCities = new ArrayList<City>();

    // Adds a destination city
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    // Get a city
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    // Get the number of destination cities
    public static int numberOfCities(){
        return destinationCities.size();
    }
}