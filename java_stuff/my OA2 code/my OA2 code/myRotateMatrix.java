public class Rotate {
	public int[][] Solution(int[][] matrix, int flag) {
		// if matrix is null return itself
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return matrix;
			
		int rowNum = matrix.length;     // number of rows
		int colNum = matrix[0].length;  // number of columns
		int[][] result = new int[colNum][rowNum];    // new 2D array to store the rotated matrix
		
		for(int i = 0; i < colNum; ++i)
			for(int j = 0; j < rowNum; ++j)
				// if flag equals 0, then clockwise rotate; if flag is 1, rotate anticlockwise
				result[i][j] = flag == 0 ? matrix[rowNum - 1 - j][i] : matrix[j][colNum - 1 - i];
		
		return result;
	}
}