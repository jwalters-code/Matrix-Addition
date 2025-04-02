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
--I referenced a CodeSnippet video on YouTube for help with enum comparisons.
source: https://www.youtube.com/watch?v=2rJ2i3oRA-Y
*/

/* 

ThreadOperation.java Organization
I recommend formatting the ThreadOperation constructor as follows:
<<constructor>>ThreadOperation(A : int[][], B : int[][], C : int[][], String quadrant)
run() : void

A, B, and C all refer to complete matrices (no sub-matrices) of the same size. As long as the Thread is not 
accessing the same row and column as another Thread, there’s no problem!
*/

public class ThreadOperation extends Thread {

	//nstance variables
	private int[][] matrix1;
	private int[][] matrix2;
	private int quadrant;
	
	//default constructor
	public ThreadOperation() {
	}
	
	//constructor
	public ThreadOperation(int[][] matrix1, int[][] matrix2, int quadrant) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.quadrant = quadrant;
	}
	
	//run method
	public void run() {
		
	}
	
	/*TODO In ThreadOperation write a method named getQuadrantIndexes that determines the indexes needed to 
	iterate over one of the four quadrants. For instance, your method might take as input the row count, 
	column count, and a quadrant String, and then return 4 numbers in an array: row start, row end, column 
	start, column end. Although I’m demonstrating this method using a String to indicate the quadrant, an 
	integer would also work fine, and an enum with four values would be best.

	public static int[] getQuadrantIndexes(int rows, int columns, String quadrant)

	Called as int[] indexes = getQuadrantIndexes(rows, columns, "upper left");

	There are many different (and some better) ways to get the indexes, but this is the way that I think will 
	make sense to the most people. 

	So how do you actually calculate the indexes needed? You will need four conditions (if, elseif, elseif, else) 
	for the four quadrants. Figure out the pattern based on the following examples: */
	
	//method for returning relevant quadrant indexes with adjustments for index count start from 0
	public static int[] getQuadrantIndexes(int rows, int columns, int quadrant) {
		
		//calculate approximate half of both rows and columns
		int rowsHalf = rows/2;
		int columnsHalf = columns/2;
		
		//declare index variables
		int rowStart;
		int rowEnd;
		int columnStart;
		int columnEnd;
		
		//calculate start/end indexes for each quadrant
		//source: https://www.youtube.com/watch?v=2rJ2i3oRA-Y
		if(quadrant == 1) {
			
			//upper left quadrant
			rowStart = 0;
			rowEnd = rowsHalf - 1;
			columnStart = 0;
			columnEnd = columnsHalf - 1;
		}
	
		else if(quadrant == 2) {
			
			//upper right quadrant
			rowStart = rowsHalf;
			rowEnd = rows - 1;
			columnStart = 0;
			columnEnd = columnsHalf - 1;
		}
		
		else if(quadrant == 3) {
			
			//lower left quadrant
			rowStart = 0;
			rowEnd = rowsHalf - 1;
			columnStart = columnsHalf;
			columnEnd = columns - 1;
		}
		
		else {
			
			//lower right quadrant
			rowStart = rowsHalf;
			rowEnd = rows - 1;
			columnStart = columnsHalf;
			columnEnd = columns - 1;
		}
		
		//add start and end indexes to indexArray
		int[] indexArray = {rowStart, rowEnd, columnStart, columnEnd};
		return indexArray;
	}
}