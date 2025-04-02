/*
Jade Walters
CSCI 2251
Assignment: Multithreading
Purpose: Pactice using multiple threads
Sources: 
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
	private int[][] matrix3; //result matrix
	private int quadrant;
	
	//constructor
	public ThreadOperation(int[][] matrix1, int[][] matrix2, int[][] matrix3, int quadrant) {
		this.matrix1 = matrix1;
		this.matrix2 = matrix2;
		this.matrix3 = matrix3;
		this.quadrant = quadrant;
	}
	
	//run method
	@Override
	public void run() {
		int[] startEnd = getQuadrantIndexes(matrix1.length, matrix1[0].length, quadrant);
		for(int r=startEnd[0]; r<startEnd[1]; r++) {
			for(int c=startEnd[2]; c<startEnd[3]; c++) {
				matrix3[r][c] = matrix1[r][c] + matrix2[r][c];
			}
		}
		
	}
	
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
		if(quadrant == 1) {
			
			//upper left quadrant
			rowStart = 0;
			rowEnd = rowsHalf;
			columnStart = 0;
			columnEnd = columnsHalf;
		}
	
		else if(quadrant == 2) {
			
			//upper right quadrant
			rowStart = rowsHalf;
			rowEnd = rows;
			columnStart = 0;
			columnEnd = columnsHalf;
		}
		
		else if(quadrant == 3) {
			
			//lower left quadrant
			rowStart = 0;
			rowEnd = rowsHalf;
			columnStart = columnsHalf;
			columnEnd = columns;
		}
		
		else {
			
			//lower right quadrant
			rowStart = rowsHalf;
			rowEnd = rows;
			columnStart = columnsHalf;
			columnEnd = columns;
		}
		
		//add start and end indexes to indexArray
		int[] indexArray = {rowStart, rowEnd, columnStart, columnEnd};
		return indexArray;
	}
	
	/*
	//method for adding matrixes WHERE TO PUT HOW TO GET STARTS/END OUT?
	public void addMatrix(int rows, int columns, int quadrant) {
		int[] startEnd = getQuadrantIndexes(int rows, int columns, int quadrant);
		for(int r=startEnd[0]; r<startEnd[1]; r++) {
			for(int c=startEnd[2]; c<startEnd[3]; c++) {
				matrixC[r][c] = matrix1[r][c] + matrix2[r][c];
			}
		}
	}*/
}