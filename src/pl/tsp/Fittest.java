package pl.tsp;

import java.util.concurrent.*;

public class Fittest implements Callable<Tour> {
	
	Tour fittest;
	int i;
	Tour[] tours;
	
	public Fittest(Tour fittest, Tour[] tours) {
		this.fittest=fittest;
		this.tours=tours;
	}
	
	public Tour getTour(int index) {
        return tours[index];
    }
	
	public int populationSize() {
        return tours.length;
    }
	
	public Tour call() {
		for (int i = 1; i < populationSize(); i++) {
			if (fittest.getFitness() <= getTour(i).getFitness()) {
				fittest = getTour(i);
			}
		}
		return fittest;
	}
}
