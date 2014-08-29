package RobotMoves;
import java.util.ArrayList;

class Position {
	public int x;
	public int y;
	public static final int MAX_ROW = 8;
	public static final int MAX_COL = 8;
	public Position(int x, int y) {
		if(x > MAX_ROW || y > MAX_COL) {
			throw new IllegalArgumentException();
		}
		this.x = x;
		this.y = y;
	}
}
public class RobotMoves {
	
	public int countAllPaths(Position robot, Position dest, int row, int col) {
		if(row == dest.x || col == dest.y) {
			return 1;
		}
		return countAllPaths(robot, dest, row + 1, col) + countAllPaths(robot, dest, row, col + 1);
	}
	public int countWithObstracles(ArrayList<Position> obstracles, Position robot, Position dest, int row, int col) {
		if(obstracles.contains(new Position(row, col))) {
			return 0;
		}
		if(col == dest.y) {
			for(int i = row; i < dest.x; i++) {
				if(obstracles.contains(new Position(i, col))) {
					return 0;
				}
			}
			return 1;
		}
		if(row == dest.x) {
			for(int i = col; i < dest.y; i++) {
				if(obstracles.contains(new Position(row, i))) {
					return 0;
				}
			}
			return 1;
		}
		return countWithObstracles(obstracles, robot, dest, row + 1, col) +
				countWithObstracles(obstracles, robot, dest, row, col + 1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
