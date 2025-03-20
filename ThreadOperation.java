/*
Jade Walters
CSCI 2251
Assignment 4: Tic Tac Toe
Purpose: Create a tic tac toe game using classes
Sources: --I got help with using an enum in a constructor 
from StackOverflow (I had trouble finding it on a proper 
tutorial website).
source: 
https://stackoverflow.com/questions/32733084/pass-a-simple-enum-into-a-constructor-in-java
*/

public class ThreadOperation extends Thread {
	
	/* TODO Each ThreadOperation will take as input (through the constructor) 
	two matrices and a quadrant indicator. The indicator could be a String, an int, 
	an enum or a set of indexes. It's up to you.*/
	
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