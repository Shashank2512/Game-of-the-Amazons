import java.util.Arrays;

/*
 * @author : Ashish Khatkar and Prasant Chidella
 */
public class Board 
{
	
	public static int MAX = 4;
	public char [][] board;
	public int row, col;
	public int[][] locWhiteAmazon=new int[4][2];
	public int[][] locBlackAmazon=new int[4][2];
	//public int[][] arrow_loc=new int[MAX*MAX][2];
	
	public Board()
	{
		this(MAX);
	}
	
	public Board(int n) {
		row = n;
		col = n;
		board=new char[n][n];
		initialize(n);
	}
	
	public Board(Board tmp)
	{
		for(int i=0;i<4;++i)
		{
			this.locWhiteAmazon[i][0]=tmp.locWhiteAmazon[i][0];
			this.locWhiteAmazon[i][1]=tmp.locWhiteAmazon[i][1];
			this.locBlackAmazon[i][0]=tmp.locBlackAmazon[i][0];
			this.locBlackAmazon[i][1]=tmp.locBlackAmazon[i][1];
		}
		this.board=new char[MAX][MAX];
		for(int i=0;i<MAX;++i)
			for(int j=0;j<MAX;++j)
				this.board[i][j]=tmp.board[i][j];
		/*this.locWhiteAmazon=tmp.locWhiteAmazon;
		this.locBlackAmazon=tmp.locBlackAmazon;
		this.board=tmp.board;*/
		this.row=tmp.row;
		this.col=tmp.col;
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
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int i = 0; i < col; i++) {
			sb.append(i);
			sb.append(" ");
		}
		sb.append("\n");
		for (int i = 0; i < row; i++) {
			sb.append(i);
			sb.append(" ");
			for (int j = 0; j < col; j++) {
				sb.append(board[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	/*
	 * Initializing 10 X 10 amazon board
	 * W denotes White Amazon
	 * B denotes Black Amazon
	 * A denotes Arrow
	 */
	public void initialize(int n)
	{
		for(int i=0;i<n;++i)
			for(int j=0;j<n;++j)
					board[i][j]=' ';
		

		int wa0X = 0, wa0Y = 0;
		int wa1X = 0, wa1Y = 0;
		int wa2X = 0, wa2Y = 0;
		int wa3X = 0, wa3Y = 0;
		
		int ba0X = 0, ba0Y = 0;
		int ba1X = 0, ba1Y = 0;
		int ba2X = 0, ba2Y = 0;
		int ba3X = 0, ba3Y = 0;
		if (n == 4) {

			wa0X = 2; wa0Y = 0;
			wa1X = 3; wa1Y = 1;
			wa2X = 3; wa2Y = 2;    //	  0 1 2 3
			wa3X = 2; wa3Y = 3;    //	0   B B
							       //	1 B     B
			ba0X = 1; ba0Y = 0;    //	2 W     W
			ba1X = 0; ba1Y = 1;    //	3   W W
			ba2X = 0; ba2Y = 2;
			ba3X = 1; ba3Y = 3;
			
		} else if (n == 5) {

			wa0X = 3; wa0Y = 0;
			wa1X = 4; wa1Y = 1;
			wa2X = 4; wa2Y = 3;    //	  0 1 2 3 4
			wa3X = 3; wa3Y = 4;    //	0   B   B
							       //	1 B       B	
			ba0X = 1; ba0Y = 0;    //	2
			ba1X = 0; ba1Y = 1;    //	3 W       W
			ba2X = 0; ba2Y = 3;    //	4   W   W
			ba3X = 1; ba3Y = 4;
			
		} else if (n == 6) {

			wa0X = 3; wa0Y = 0;
			wa1X = 5; wa1Y = 2;	   //	  0 1 2 3 4 5
			wa2X = 5; wa2Y = 3;	   //	0     B B           
			wa3X = 3; wa3Y = 5;	   //	1            
							   	   //	2 B         B   
			ba0X = 2; ba0Y = 0;	   //	3 W         W  
			ba1X = 0; ba1Y = 2;	   //	4           
			ba2X = 0; ba2Y = 3;	   //	5     W W       
			ba3X = 2; ba3Y = 5;
			
		} else if (n == 7) {

			wa0X = 2; wa0Y = 0;
			wa1X = 0; wa1Y = 2;    //	  0 1 2 3 4 5 6
			wa2X = 0; wa2Y = 4;    //	0     B   B
			wa3X = 2; wa3Y = 6;    //	1 
							       //	2 B           B
			ba0X = 4; ba0Y = 0;    //	3
			ba1X = 6; ba1Y = 2;    //	4 W           W
			ba2X = 6; ba2Y = 4;    //	5
			ba3X = 4; ba3Y = 6;    //	6     W   W

		} else if (n == 10){
			 					   //	  0 1 2 3 4 5 6 7 8 9
			wa0X = 3; wa0Y = 0;	   //	0       B     B
			wa1X = 0; wa1Y = 3;	   //	1
			wa2X = 0; wa2Y = 6;	   //	2
			wa3X = 3; wa3Y = 9;	   //	3 B                 B
							   	   //	4
			ba0X = 6; ba0Y = 0;	   //	5
			ba1X = 9; ba1Y = 3;	   //	6 W                 W
			ba2X = 9; ba2Y = 6;	   //	7
			ba3X = 6; ba3Y = 9;	   //	8
			 					   //	9       W     W
		}

		locWhiteAmazon[0] = new int[] {wa0X, wa0Y};
		board[wa0X][wa0Y]='W';
		locWhiteAmazon[1] = new int[] {wa1X, wa1Y};
		board[wa1X][wa1Y]='W';
		locWhiteAmazon[2] = new int[] {wa2X, wa2Y};
		board[wa2X][wa2Y]='W';
		locWhiteAmazon[3] = new int[] {wa3X, wa3Y};
		board[wa3X][wa3Y]='W';
		
		locBlackAmazon[0] = new int[] {ba0X, ba0Y};
		board[ba0X][ba0Y]='B';
		locBlackAmazon[1] = new int[] {ba1X, ba1Y};
		board[ba1X][ba1Y]='B';
		locBlackAmazon[2] = new int[] {ba2X, ba2Y};
		board[ba2X][ba2Y]='B';
		locBlackAmazon[3] = new int[] {ba3X, ba3Y};
		board[ba3X][ba3Y]='B';
		
	}
}