//Przechowuje populacje

package pl.tsp;

import java.util.concurrent.*;
import java.util.List;
import java.util.ArrayList;

public class Population {

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

    // Gets the best tour in the population - CHYBA TO TRZEBA ZROWNOLEGLIC
    public Tour getFittest() {
        Tour fittest = tours[0];
        // Loop through individuals to find fittest
        synchronized (fittest) {
        	final ExecutorService executor = Executors.newFixedThreadPool(1);
        	final List<Future<?>> futures = new ArrayList<>();
        	for (int i = 1; i < populationSize(); i++) {
        		final Integer innerI = new Integer(i);
        		Future<?> future = executor.submit(new Runnable() {
        		    public void run() {
        		    	if (fittest.getFitness() <= getTour(innerI).getFitness()) {
        		            setFitness(innerI, fittest);
        				}
        		    }
        		});
        		futures.add(future);
        	}
        	try {
        		for (Future<?> future : futures) {
        			future.get();
        		}
        	}catch (InterruptedException | ExecutionException e) {
        		e.printStackTrace();
        	}
        }
        return fittest;
    }

    // Gets population size
    public int populationSize() {
        return tours.length;
    }
    
    public Tour setFitness (int i, Tour fittest) {
			fittest = getTour(i);
			return fittest;
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