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
Q1: One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore 
machines, how sluggish humans are,
threads compared to processes, etcetera,
and connect these issues to 
multi-threading.

Multi-threaded code minimizes resource usage by maximizing memory because less memory is required to run threads than 
processors so running multiple threads on a single processor requires less memory than running single threads on multiple 
processors.  It also maximizes efficiency when there are I/O factors, such as waiting for input from a slow, human user, 
because it allows the processor to do other tasks during the wait time instead of bringing the entire program to a halt.  
Finally, it maximizes memory usage because threads can easily work on the same objects and use the same address space.
*/

import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		
		//instaniate ThreadOperation objects
		ThreadOperation firstMatrix = new ThreadOperation();
		ThreadOperation secondMatrix = new ThreadOperation();
		ThreadOperation thirdMatrix = new ThreadOperation();
		ThreadOperation fourthMatrix = new ThreadOperation();
		
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
		
		//create test array and test print2dArray method
		int[][] testArray = {
			{1,2,3,4},
			{5,6,7,8}
		};
		print2dArray(testArray);
		
		try {
			
			//read in from file
			File matrixData = new File(args[0]);
			Scanner dataReader = new Scanner(matrixData);
			
			//create rows, columns variables, scan in values
			int rows = dataReader.nextInt();
			int columns = dataReader.nextInt();
			
			/*//test code
			System.out.println(rows);
			System.out.println(columns);*/
			
			//Read in the first and second matrices
			int[][] matrix1 = matrixFromFile(rows, columns, dataReader);
			int[][] matrix2 = matrixFromFile(rows, columns, dataReader);
			
			/*//Test code
			print2dArray(matrix1);
			print2dArray(matrix2);*/
			
			//close scanner
			dataReader.close();
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