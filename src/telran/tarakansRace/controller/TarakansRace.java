package telran.tarakansRace.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import telran.tarakansRace.model.Tarakan;

public class TarakansRace {

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		int tarakansCount;
		int raceDistance;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the number of tarakans: ");
		tarakansCount = Integer.parseInt(br.readLine());
		System.out.print("Enter the race distance: ");
		raceDistance = Integer.parseInt(br.readLine());
		
		//tasks create
		Tarakan[] tasks = new Tarakan[tarakansCount];
		for (int i = 0; i < tasks.length; i++) {
			tasks[i] = new Tarakan(i+1, raceDistance);
		}
		//Threads create
		Thread[] threads = new Thread[tasks.length];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(tasks[i]);
		}
		
		//Threads start
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		
		//waiting for end
		for (int i = 0; i < threads.length; i++) {
			threads[i].join();
		}
		
		//calculate winner
		Tarakan winner = null;
		for (int i = 0; i < tasks.length; i++) {
			if(winner == null || tasks[i].getEndTime() < winner.getEndTime())
			{
				winner = tasks[i];
			}
		}
		
		System.out.println("Congratulations to tarakan #" + winner + " (winner)");

	}

}
