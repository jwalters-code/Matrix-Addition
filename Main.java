/*
This code is provided to give you a
starting place. It should be modified.
No further imports are needed.
To earn full credit, you must also
answer the following question:

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

*/

/*List of classes that you will write:
•	Main – contains the main method.
•	TODO ThreadOperation – extends Thread and performs submatrix addition

Instructions for Part 1
For part 1 you need to create both of the above classes.

1.	TODO In the main method of Main, instantiate four ThreadOperation objects, 
start them, and join them. 
2.	TODO In Main.java, write a static method named print2dArray that takes a two-dimensional array 
as input and prints it out with the rows and columns lined up. You must use System.out.printf.
3.	TODO Instantiate a test 2d array with any values you like in main and use it to verify that 
print2dArray works.
4.	TODO The filename should be given through the command prompt and passed into main via String[] args
5.	TODO Open and connect to the file using a Scanner.
6.	TODO Read in the number of rows and columns and save these in local variables in main.
7.	TODO Read in the first and second matrices (two-dimensional arrays) from the file. I recommend 
writing a method to accomplish this task and calling the method twice (once for each matrix). 
Consider using this method header: 

public static int[][] matrixFromFile(int rows, int columns, Scanner file_reader)

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
		
		System.out.println();
		
		
		
	}

}