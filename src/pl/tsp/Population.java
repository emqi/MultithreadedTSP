//Przechowuje populacje

package pl.tsp;

import java.util.concurrent.*;
import java.io.Serializable;

public class Population implements Serializable {

    // Holds population of tours
    Tour[] tours;

    // Construct a population
    public Population(int populationSize, boolean initialise) {
        tours = new Tour[populationSize];
        // If we need to initialise a population of tours do so
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < populationSize(); i++) {
                Tour newTour = new Tour();
                newTour.generateIndividual();
                saveTour(i, newTour);
            }
        }
    }
    
    // Saves a tour
    public void saveTour(int index, Tour tour) {
        tours[index] = tour;
    }
    
    // Gets a tour from population
    public Tour getTour(int index) {
        return tours[index];
    }

    public Tour getFittest() {
        Tour fittest = tours[0];
        Future<Tour> future;
        ExecutorService executor = Executors.newFixedThreadPool(1);
        future = executor.submit(new Fittest(fittest, tours));
        try {
        	fittest = future.get();
        }
        catch (InterruptedException | ExecutionException e) {
        	e.printStackTrace();
        }
        executor.shutdown();
        return fittest;
    }

    // Gets population size
    public int populationSize() {
        return tours.length;
    }
    
    /*//Gets the best tour in the population 
    public Tour getFittest() {
        Tour fittest = tours[0];
        // Loop through individuals to find fittest
        for (int i = 1; i < populationSize(); i++) {
            if (fittest.getFitness() <= getTour(i).getFitness()) {
                fittest = getTour(i);
            }
        }
        return fittest;
    }
    // Gets population size
    public int populationSize() {
        return tours.length;
    }*/
}