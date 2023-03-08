package telran.tarakansRace.model;

import java.util.Random;

public class Tarakan implements Runnable {
	private int number;
	private int raceDistance;
	private int currentDistance;
	private long endTime;

	
	public Tarakan(int number, int raceDistance) {
		this.number = number;
		this.raceDistance = raceDistance;
		this.currentDistance = 0;
	}
	
	@Override
	public void run() {
        Random rand = new Random();

        for (int i = 0; i < raceDistance; i++) {
        	currentDistance++;
            System.out.println("Tarakan number: " + number + " runned distance - " + currentDistance);
            try {
                Thread.sleep(rand.nextInt(4) + 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Tarakan number:" + number + " finished!");
        setEndTime(System.currentTimeMillis());
        
        

	}
	public int getTarakanNumber() {
		return number;
	}


	@Override
	public String toString() {
		return "" + number;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

}
