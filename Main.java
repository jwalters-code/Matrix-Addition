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



/*
Instructions for Part 2
TODO Put it all together to read in the data from file, spawn four threads, and allocate the task of summing 
each quadrant pair to a separate thread.

TODO Consider which methods should be relocated from Main to ThreadOperation. What tools does ThreadOperation 
need to have access to in order to do its job?

TODO After the threads complete their computation, the results need to be stored in the matrix C, another 
2-dimensional array variable in main.

Your program should work for any size matrices.

Main.java should be organized as follows (Strongly consider using the following notes as comments):
•	TODO Your main method opens a text file using the file name from the command line, and reads in the number of rows, 
the number of columns, and two matrices, A and B, into two 2-dimensional array variables.
•	TODO Instantiate four ThreadOperation objects and pass them the information they need to sum up paired quadrants, 
including a reference to a result matrix C. Note that C should have the same dimensions as A and B.
•	Start up all the threads and use join to make sure they finish before printing.
•	Print out the summed matrix.

UML Diagram for Matrix Addition Part 2

You tell me!

TODO For part 2 you must turn in a UML diagram of your code, including the ways you modified Main and 
ThreadOperation to complete the assignment.


*/

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
	
		//open a text file using the file name from the command line, and read in the number of rows, 
		//the number of columns, and two matrices, A and B, into two 2-dimensional array variables.
		try {
			
			//read in from file
			File matrixData = new File(args[0]);
			Scanner dataReader = new Scanner(matrixData);
			
			//create rows, columns variables, scan in values
			int rows = dataReader.nextInt();
			int columns = dataReader.nextInt();
				
			//Read in the first and second matrices
			int[][] matrixA = matrixFromFile(rows, columns, dataReader);
			int[][] matrixB = matrixFromFile(rows, columns, dataReader);
			
			//close scanner
			dataReader.close();
			
			//Instantiate four ThreadOperation objects and pass them the information they need to sum up paired quadrants, 
			//including a reference to a result matrix C. Note that C should have the same dimensions as A and B
			
			int[][] matrixC = new int[rows][columns];  //result array
			
			//instaniate ThreadOperation objects
			ThreadOperation firstMatrix = new ThreadOperation(matrixA, matrixB, 1);
			ThreadOperation secondMatrix = new ThreadOperation(matrixA, matrixB, 2);
			ThreadOperation thirdMatrix = new ThreadOperation(matrixA, matrixB, 3);
			ThreadOperation fourthMatrix = new ThreadOperation(matrixA, matrixB, 4);
			
			//start threads
			firstMatrix.start();
			secondMatrix.start();
			thirdMatrix.start();
			fourthMatrix.start();
			
			//join threads
			try{
				firstMatrix.join();
				secondMatrix.join();
				thirdMatrix.join();
				fourthMatrix.join();
			}
			catch(InterruptedException e) {
				System.out.println("Interrupted" + e);
			}
		} 
		
		catch(IOException|ArrayIndexOutOfBoundsException e) {
			System.out.println("Enter a valid file");
			System.exit(1);
		}
	}
	
	//method prints out formatted 2d array	
	static void print2dArray(int[][] printArray) {
		for(int r=0; r<printArray.length; r++) {
			for(int c=0; c<printArray[r].length; c++) {
				System.out.printf(" %d", printArray[r][c]);
			}
			System.out.printf("\n"); //new line
		}
	}
		
	//method for scanning in 2d array from file
	public static int[][] matrixFromFile(int rows, int columns, Scanner dataReader) {
		int[][] tempArray = new int[rows][columns];
		for(int r=0; r<tempArray.length; r++) {
			for(int c=0; c<tempArray[r].length; c++) {
				tempArray[r][c] = dataReader.nextInt();
			}
		}
		return tempArray;
	}
}