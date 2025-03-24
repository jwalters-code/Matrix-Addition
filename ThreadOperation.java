/*
Jade Walters
CSCI 2251
Assignment: Multithreading
Purpose: Pactice using multiple threads
Sources: --I got help with using an enum in a constructor 
from StackOverflow (I had trouble finding it on a proper 
tutorial website).
source: 
https://stackoverflow.com/questions/32733084/pass-a-simple-enum-into-a-constructor-in-java
*/

public class ThreadOperation extends Thread {

	//nstance variables
	private int[][] matrix1;
	private int[][] matrix2;
	private Quadrant quadrant;
	
	//https://stackoverflow.com/questions/32733084/pass-a-simple-enum-into-a-constructor-in-java
	enum Quadrant {
		ONE,
		TWO,
		THREE,
		FOUR
	}
	
	//default constructor
	public ThreadOperation() {
	}
	
	//constructor
	public ThreadOperation(int[][] matrix1, int[][] matrix2, Quadrant quadrant) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.quadrant = quadrant;
	}
}