/*
	find path in a 2D matrix maze
	time complexity: O(m*n)
	space complexity: O(m*n) probably min(m, n) + 1 (diagonal length + 1)
*/
public class Point{
	public int row;
	public int col;
	public Point(int _row, int _col){
		row = _row;
		col = _col;
	}
}

public class MatrixMaze{
	public static int Solution(int[][] maze){
		if(maze == null || maze.length == 0 || maze[0].length == 0) return 0;
		if(maze[0][0] == 9) return 1;
		int rowNum = maze.length;
		int colNum = maze[0].length;
		// four direction around current point, (down, right, up, left)
		int[][] direction = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		LinkedList<Point> myQ = new LinkedList<Point>();
		myQ.offer(new Point(0, 0));
		while(!myQ.isEmpty()){
			Point crt = myQ.poll();
			for(int i = 0; i < 4; ++i){
				int tmpRow = crt.row + direction[i][0];
				int tmpCol = crt.col + direction[i][1];
				if(tmpRow >= 0 && tmpCol >= 0 && tmpRow < rowNum && tmpCol < colNum && maze[tmpRow][tmpCol] > 0){
					if(maze[tmpRow][tmpCol] == 9) return 1;
					myQ.offer(new Point(tmpRow, tmpCol));
					maze[tmpRow][tmpCol] = -1;
				}
			}
		}
		return 0;
	}
}