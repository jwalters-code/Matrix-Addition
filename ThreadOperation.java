

public class ThreadOperation extends Thread {
	
	/* TODO Each ThreadOperation will take as input (through the constructor) 
	two matrices and a quadrant indicator. The indicator could be a String, an int, 
	an enum or a set of indexes. It's up to you.*/
	
	private int rows;
	private int columns;
	private int[][] matrix1 = new int[rows][columns];
	private int[][] matrix2 = new int[rows][columns];
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
}