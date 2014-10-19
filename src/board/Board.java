package board;

/**
 * Represents a single state in the game
 */
public class Board {

	public static final int EMPTY = 0;
	public static final int ARROW = 1;
	public static final int AMAZON = 2;
	
//	arrays storing the current positions of all eight amazons
	private int[][] whiteAmazons = new int[4][2];
	private int[][] blackAmazons = new int[4][2];
	
	private int[][] board;
	
	private int rows;
	private int cols;
	
	/**
	 * Constructor that takes the size of the board as arguments
	 * @param rows rows
	 * @param cols columns
	 */
	public Board(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		
		board = new int[rows][cols];
		
		placeAmazons();
	}
	
	/**
	 * marks positions on board that have amazons initially and
	 * stores positions of all eight amazons in the two arrays
	 * @param rows rows
	 * @param cols columns
	 */
	private void placeAmazons() {
		whiteAmazons[0] = new int[] {(rows/2)/2 + 1, 0};
		board[(rows/2)/2 + 1][0] = AMAZON;
		whiteAmazons[1] = new int[] {0, (cols/2)/2 + 1};
		board[0][(cols/2)/2 + 1] = AMAZON;
		whiteAmazons[2] = new int[] {0, cols - (cols/2)/2 + 1};
		board[0][cols - 1 - ((cols/2)/2 + 1)] = AMAZON;
		whiteAmazons[3] = new int[] {(rows/2)/2 + 1, cols - 1};
		board[(rows/2)/2 + 1][cols - 1] = AMAZON;
		
		blackAmazons[0] = new int[] {rows - (rows/2)/2 + 1, 0};
		board[rows - 1 - ((rows/2)/2 + 1)][0] = AMAZON;
		blackAmazons[1] = new int[] {rows - 1, (cols/2)/2 + 1};
		board[rows - 1][(cols/2)/2 + 1] = AMAZON;
		blackAmazons[2] = new int[] {rows - 1, cols - (cols/2)/2 + 1};
		board[rows - 1][cols - 1 - ((cols/2)/2 + 1)] = AMAZON;
		blackAmazons[3] = new int[] {rows - (rows/2)/2 + 1, cols - 1};
		board[rows - 1 - ((rows/2)/2 + 1)][cols - 1] = AMAZON;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int i = 0; i < cols; i++) {
			sb.append(i);
			sb.append(" ");
		}
		sb.append("\n");
		for (int i = 0; i < rows; i++) {
			sb.append(i);
			sb.append(" ");
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == AMAZON) {
					sb.append("A ");
				} else if (board[i][j] == ARROW) {
					sb.append("O ");
				} else {
					sb.append("  ");
				}
			}
			sb.append("\n");
		}
		return sb .toString();
	}
}
