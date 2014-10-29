/*
 * @author : Ashish Khatkar and Prasant Chidella
 */
public class Board 
{
	public static int MAX = 6;
	public char [][] board=new char[MAX][MAX];
	public int row, col;
	public int[][] locWhiteAmazon=new int[4][2];
	public int[][] locBlackAmazon=new int[4][2];
	//public int[][] arrow_loc=new int[MAX*MAX][2];
	public Board()
	{
		row=MAX;
		col=MAX;
		initialize();
	}
	public Board(Board tmp)
	{
		this.locWhiteAmazon=tmp.locWhiteAmazon;
		this.locBlackAmazon=tmp.locBlackAmazon;
		this.board=tmp.board;
		this.row=tmp.row;
		this.col=tmp.col;
	}
	/*
	 * Initializing 10 X 10 amazon board
	 * W denotes White Amazon
	 * B denotes Black Amazon
	 * A denotes Arrow
	 */
	public void initialize()
	{
		for(int i=0;i<MAX;++i)
			for(int j=0;j<MAX;++j)
					board[i][j]=' ';
		locWhiteAmazon[0] = new int[] {(row/2)/2 + 1, 0};
		board[(row/2)/2 + 1][0]='W';
		locWhiteAmazon[1] = new int[] {0, (col/2)/2 + 1};
		board[0][(col/2)/2 + 1]='W';
		locWhiteAmazon[2] = new int[] {0, col - 1 - (col/2)/2 + 1};
		board[0][col - 1 - (col/2)/2 + 1]='W';
		locWhiteAmazon[3] = new int[] {(row/2)/2 + 1, col - 1};
		board[(row/2)/2 + 1][col - 1]='W';
		
		locBlackAmazon[0] = new int[] {row - 1 - (row/2)/2 + 1, 0};
		board[row - 1 - (row/2)/2 + 1][0]='B';
		locBlackAmazon[1] = new int[] {row - 1, (col/2)/2 + 1};
		board[row - 1][(col/2)/2 + 1]='B';
		locBlackAmazon[2] = new int[] {row - 1, col - 1 - (col/2)/2 + 1};
		board[row - 1][col - 1 - (col/2)/2 + 1]='B';
		locBlackAmazon[3] = new int[] {row - 1 - (row/2)/2 + 1, col - 1};
		board[row - 1 - (row/2)/2 + 1][col - 1]='B';
		/*for(int i=0;i<MAX;++i)
		{
			for(int j=0;j<MAX;++j)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}*/
	}
	/*
	 * add arrow at position (x,y)
	 */
	public void add_arrow(int x, int y)
	{
		board[x][y]='A';
	}
	public String get_board()
	{
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<MAX;++i)
		{
			for(int j=0;j<MAX;++j)
			{
				sb.append(board[i][j]+" ");
				//sb.append(' ');
				//sb.append(' ');
			}
			sb.append("\n");
		}
		return sb.toString();
	}
}
