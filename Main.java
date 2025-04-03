/*
Jade Walters
CSCI 2251
Assignment: Multithreading
Purpose: Pactice using multiple threads
Sources: none outside of class materials
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
			
			//instaniate ThreadOperation objects, pass info for addition
			ThreadOperation firstMatrix = new ThreadOperation(matrixA, matrixB, matrixC, 1);
			ThreadOperation secondMatrix = new ThreadOperation(matrixA, matrixB, matrixC, 2);
			ThreadOperation thirdMatrix = new ThreadOperation(matrixA, matrixB, matrixC, 3);
			ThreadOperation fourthMatrix = new ThreadOperation(matrixA, matrixB, matrixC, 4);
			
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
			
			//print solution matrix
			print2dArray(matrixC);
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