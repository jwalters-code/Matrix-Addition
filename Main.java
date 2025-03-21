/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

Q1: TODO One of the goals of multi-threading
is to minimize the resource usage, such
as memory and processor cycles. In three
sentences, explain how multi-threaded
code accomplishes this goal. Consider
writing about blocking on I/O, multicore 
machines, how sluggish humans are,
threads compared to processes, etcetera,
and connect these issues to 
multi-threading.

*/

/*List of classes that you will write:
•	Main – contains the main method.
•	TODO ThreadOperation – extends Thread and performs submatrix addition

Instructions for Part 1
For part 1 you need to create both of the above classes.

NOTE: if you are using a static scanner or an object-oriented approach then you may not need to pass 
these arguments to the method.
*/
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) 
	{
		/*1.	TODO In the main method of Main, instantiate four ThreadOperation objects, 
				start them, and join them. */
				
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
		
		/*3.	TODO Instantiate a test 2d array with any values you like in main and use it to verify that 
		print2dArray works.*/
		int[][] testArray = {
			{1,2,3,4},
			{5,6,7,8}
		};
		
		print2dArray(testArray);
		
		//4.	TODO The filename should be given through the command prompt and passed into main via String[] args
		//5.	TODO Open and connect to the file using a Scanner.
		
		try {
			
			//read in from file
			File matrixData = new File(args[0]);
			Scanner dataReader = new Scanner(matrixData);
			
			//6.	TODO Read in the number of rows and columns and save these in local variables in main.
			int rows = dataReader.nextInt();
			int columns = dataReader.nextInt();
			
			//test code
			System.out.println(rows);
			System.out.println(columns);
			
			/*7.	TODO Read in the first and second matrices (two-dimensional arrays) from the file. I recommend 
			writing a method to accomplish this task and calling the method twice (once for each matrix).*/
			int[][] matrix1 = matrixFromFile(rows, columns, dataReader);
			int[][] matrix2 = matrixFromFile(rows, columns, dataReader);
			
			//Test code
			print2dArray(matrix1);
			print2dArray(matrix2);
			
			//close scanner
			dataReader.close();
		} 
		
		catch(IOException|ArrayIndexOutOfBoundsException e) {
			System.out.println("Enter a valid file");
			System.exit(1);
		}
	}
	
	/*2.	TODO In Main.java, write a static method named print2dArray that takes a two-dimensional array 
		as input and prints it out with the rows and columns lined up. You must use System.out.printf.*/
		
	static void print2dArray(int[][] printArray) {
		for(int r=0; r<printArray.length; r++) {
			for(int c=0; c<printArray[r].length; c++) {
				System.out.printf(" %d", printArray[r][c]);
			}
			System.out.printf("\n"); //new line
		}
	}
	
	/*7.	TODO Read in the first and second matrices (two-dimensional arrays) from the file. I recommend 
	writing a method to accomplish this task and calling the method twice (once for each matrix). 
	Consider using this method header: 

	public static int[][] matrixFromFile(int rows, int columns, Scanner file_reader)*/
	
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