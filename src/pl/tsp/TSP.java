//Generuje rozwiazanie

package pl.tsp;

import java.util.ArrayList;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class TSP {

    public static void main(String[] args){
    	int port = 3333;
    	System.out.println("What's your role?");
    	System.out.println("Choose 1 to become a server: ");
    	System.out.println("Choose 2 to become a client: ");
    	Scanner scanner = new Scanner(System.in);
    	int choice = scanner.nextInt();
    	scanner.close();
    	if(choice == 1) {
    		System.out.println("You've become a server");
    		try {
    	        ServerSocket welcomeSocket = new ServerSocket(port);
    	            
    	            // Create the Client Socket
    	            Socket clientSocket = welcomeSocket.accept();
    	            System.out.println("Socket Established...");
    	            // Create input and output streams to client
    	            ObjectOutputStream outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
    	            ObjectInputStream inFromClient = new ObjectInputStream(clientSocket.getInputStream());

    	            TourManager.destinationCities = (ArrayList)inFromClient.readObject();
    	            
    	            // Initialize population
    	            Population pop = new Population(50, true);
    	            System.out.println("Initial distance: " + pop.getFittest().getDistance());
    	            
    	            // Evolve population for 100 generations
    	            pop = GA.evolvePopulation(pop);
    	            for (int i = 0; i < 500; i++) {
    	                pop = GA.evolvePopulation(pop);
    	            }
    	        

    	    } catch (Exception e) {
    	        System.err.println("Server Error: " + e.getMessage());
    	        System.err.println("Localized: " + e.getLocalizedMessage());
    	        System.err.println("Stack Trace: " + e.getStackTrace());
    	        System.err.println("To String: " + e.toString());
    	    }
    	}
    	else if(choice == 2) {
    		System.out.println("You've become a client");
    		try {
    	        // Create the socket
    	        Socket clientSocket = new Socket("192.168.0.59", port);
    	        // Create the input & output streams to the server
    	        ObjectOutputStream outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
    	        ObjectInputStream inFromServer = new ObjectInputStream(clientSocket.getInputStream());

    	        /*City city = new City(-15, 37);
    	        City city2 = new City(144, 240);
    	        City city3 = new City(-80, 173);
    	        City city4 = new City(33, 11);
    	        City city5 = new City(4, -94);;
    	        City city6 = new City(16, 18);
    	        City city7 = new City(155, 33);
    	        City city8 = new City(301, 140);
    	        City city9 = new City(40, -120);
    	        City city10 = new City(55, 144);
    	        City city11 = new City(3, 17);
    	        City city12 = new City(-60, -80);
    	        City city13 = new City(-112, 80);
    	        City city14 = new City(33, 233);
    	        City city15 = new City(77, -40);
    	        City city16 = new City(15, 12);
    	        City city17 = new City(202, -66);
    	        City city18 = new City(25, -41);
    	        City city19 = new City(121, 20);
    	        City city20 = new City(97, 114);
    	        City city21 = new City(160, -20);
    	        City city22 = new City(193, 45);
    	        City city23 = new City(97, 97);
    	        City city24 = new City(-12, 20);
    	        City city25 = new City(115, 66);
    	        City city26 = new City(43, -53);
    	        City city27 = new City(8, 29);
    	        City city28 = new City(164, -183);
    	        City city29 = new City(72, 12);
    	        City city30 = new City(200, -39);
    	        
    	        outToServer.writeObject(city);
    	        outToServer.writeObject(city2);
    	        outToServer.writeObject(city3);
    	        outToServer.writeObject(city4);
    	        outToServer.writeObject(city5);
    	        outToServer.writeObject(city6);
    	        outToServer.writeObject(city7);
    	        outToServer.writeObject(city8);
    	        outToServer.writeObject(city9);
    	        outToServer.writeObject(city10);
    	        outToServer.writeObject(city11);
    	        outToServer.writeObject(city12);
    	        outToServer.writeObject(city13);
    	        outToServer.writeObject(city14);
    	        outToServer.writeObject(city15);
    	        outToServer.writeObject(city16);
    	        outToServer.writeObject(city17);
    	        outToServer.writeObject(city18);
    	        outToServer.writeObject(city19);
    	        outToServer.writeObject(city20);
    	        outToServer.writeObject(city21);
    	        outToServer.writeObject(city22);
    	        outToServer.writeObject(city23);
    	        outToServer.writeObject(city24);
    	        outToServer.writeObject(city25);
    	        outToServer.writeObject(city26);
    	        outToServer.writeObject(city27);
    	        outToServer.writeObject(city28);
    	        outToServer.writeObject(city29);
    	        outToServer.writeObject(city30);*/
    	        
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
    	        
    	        outToServer.writeObject(TourManager.destinationCities);
    	        

    	        /* Print out the recived Message */
    	        System.out.println("Message: " );
    	        System.out.println("Index: " );
    	        System.out.println("Average: ");


    	        clientSocket.close();

    	    } catch (Exception e) {
    	        System.err.println("Client Error: " + e.getMessage());
    	        System.err.println("Localized: " + e.getLocalizedMessage());
    	        System.err.println("Stack Trace: " + e.getStackTrace());
    	    }
    	}

    	/*final long startTime = System.nanoTime();
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
        System.out.println(pop.getFittest());*/
    }
}