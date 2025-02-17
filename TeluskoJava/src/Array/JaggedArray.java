package Array;

public class JaggedArray{
	public static void main(String[] args)
	{
		// static initialization
		int p[][] = {
				{5,6,7,8},
				{1,2},
				{9,10,11},
				{}
		};
		printArray(p);
		
		int p2[][] = new int[3][];
		p2[0] = new int[4];
		p2[1] = new int[2];
		p2[2] = new int[3];
		printArray(p2);
	}
	
	private static void printArray(int[][] array){
		System.out.println();

		// For each loops works amazingly well for jagged arrays
		for(int[] row : array) {
			for(int i : row)
				System.out.print(i + " ");
			System.out.println();
		}
	}		
}