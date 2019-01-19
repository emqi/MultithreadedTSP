package pl.tsp;

import java.util.concurrent.*;

public class Fittest implements Callable<Tour> {
	
	Tour fittest;
	int i;
	Tour[] tours;
	
	public Fittest(Tour fittest, int i, Tour[] tours) {
		this.fittest=fittest;
		this.i=i;
		this.tours=tours;
	}
	
	public Tour getTour(int index) {
        return tours[index];
    }
	
	public Tour call() {
		if (fittest.getFitness() <= getTour(i).getFitness()) {
			fittest = getTour(i);
		}
		return fittest;
	}
}
