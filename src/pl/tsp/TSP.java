//Generuje rozwiazanie

package pl.tsp;

import java.util.Scanner;
import java.net.*;
import java.io.*;

public class TSP {

    public static void main(String[] args){
    	System.out.println("What's your role?");
    	System.out.println("Choose 1 to become a server: ");
    	System.out.println("Choose 2 to become a client: ");
    	Scanner scanner = new Scanner(System.in);
    	int choice = scanner.nextInt();
    	if(choice == 1)
    		System.out.println("You've become a server");
    	else if(choice == 2)
    		System.out.println("You've become a client");

    	final long startTime = System.nanoTime();
        // Create and add our cities
        City city = new City(-15, 37);
        TourManager.addCity(city);
        City city2 = new City(144, 240);
        TourManager.addCity(city2);
        City city3 = new City(-80, 173);
        TourManager.addCity(city3);
        City city4 = new City(33, 11);
        TourManager.addCity(city4);
        City city5 = new City(4, -94);
        TourManager.addCity(city5);
        City city6 = new City(16, 18);
        TourManager.addCity(city6);
        City city7 = new City(155, 33);
        TourManager.addCity(city7);
        City city8 = new City(301, 140);
        TourManager.addCity(city8);
        City city9 = new City(40, -120);
        TourManager.addCity(city9);
        City city10 = new City(55, 144);
        TourManager.addCity(city10);
        City city11 = new City(3, 17);
        TourManager.addCity(city11);
        City city12 = new City(-60, -80);
        TourManager.addCity(city12);
        City city13 = new City(-112, 80);
        TourManager.addCity(city13);
        City city14 = new City(33, 233);
        TourManager.addCity(city14);
        City city15 = new City(77, -40);
        TourManager.addCity(city15);
        City city16 = new City(15, 12);
        TourManager.addCity(city16);
        City city17 = new City(202, -66);
        TourManager.addCity(city17);
        City city18 = new City(25, -41);
        TourManager.addCity(city18);
        City city19 = new City(121, 20);
        TourManager.addCity(city19);
        City city20 = new City(97, 114);
        TourManager.addCity(city20);
        City city21 = new City(160, -20);
        TourManager.addCity(city21);
        City city22 = new City(193, 45);
        TourManager.addCity(city22);
        City city23 = new City(97, 97);
        TourManager.addCity(city23);
        City city24 = new City(-12, 20);
        TourManager.addCity(city24);
        City city25 = new City(115, 66);
        TourManager.addCity(city25);
        City city26 = new City(43, -53);
        TourManager.addCity(city26);
        City city27 = new City(8, 29);
        TourManager.addCity(city27);
        City city28 = new City(164, -183);
        TourManager.addCity(city28);
        City city29 = new City(72, 12);
        TourManager.addCity(city29);
        City city30 = new City(200, -39);
        TourManager.addCity(city30);

        // Initialize population
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolve population for 100 generations
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 500; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // Print final results
        final long duration = System.nanoTime() - startTime;
        System.out.println("Finished in " + duration*0.000000001 + " second(s).");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}