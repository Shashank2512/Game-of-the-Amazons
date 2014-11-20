/*
 * @author : Ashish Khatkar and Prasant Chidella
 */
import java.util.ArrayList;
public class Moves
{
	public static ArrayList<Board> mov= new ArrayList<Board>();
	public static char WHITE = 'W';
	public static char BLACK = 'B';
	public static int pos[][];
	/*shoots arrow*/
	public int get_size()
	{
		//for(Board b : mov)
			//System.out.println(b.get_board());
		return mov.size();
	}
	public ArrayList<Board> return_moves()
	{
		return mov;
	}
	public void clean_mov()
	{
		mov=new ArrayList<>();
	}
	public void shoot_arrow(Board b, int amazon, int posx, int posy, char player)
	{
		/*down*/
		int r=b.row;
		int c=b.col;
		//System.out.println("Entering: "+ b.toString());
		Board next = new Board(b);
		next.board[posx][posy] = player;
		next.board[pos[amazon][0]][pos[amazon][1]] = ' ';
		if(player == WHITE)
		{
			next.locWhiteAmazon[amazon][0] = posx;
			next.locWhiteAmazon[amazon][1] = posy;
		}
		else
		{
			next.locBlackAmazon[amazon][0] = posx;
			next.locBlackAmazon[amazon][1] = posy;
		}
		/*down*/
		for(int i=posx+1; i<r; ++i)
		{
			if(next.board[i][posy]==' ')
			{
				Board finish = new Board(next);
				finish.board[i][posy] = 'A';
				//finish.heuristic_val=h.compute_heuristic(finish);
				mov.add(finish);
			}
			else
				break;
		}
		/*up*/
		for(int i=posx-1; i>=0; --i)
		{
			if(next.board[i][posy]==' ')
			{
				Board finish = new Board(next);
				finish.board[i][posy] = 'A';
				//finish.heuristic_val=h.compute_heuristic(finish);
				mov.add(finish);
			}
			else
				break;
		}
		/*left*/
		for(int j=posy-1; j>=0; --j)
		{
			if(next.board[posx][j]==' ')
			{
				Board finish = new Board(next);
				finish.board[posx][j] = 'A';
				//finish.heuristic_val=h.compute_heuristic(finish);
				mov.add(finish);
			}
			else
				break;
		}
		/*right*/
		for(int j=posy+1; j<c; ++j)
		{
			if(next.board[posx][j]==' ')
			{
				Board finish = new Board(next);
				finish.board[posx][j] = 'A';
				//finish.heuristic_val=h.compute_heuristic(finish);
				mov.add(finish);
			}
			else
				break;
		}
		/*left up*/
		{
			int i=posx-1, j=posy-1;
			while(i>=0 && j>=0)
			{
				if(next.board[i][j]==' ')
				{
					Board finish = new Board(next);
					finish.board[i][j] = 'A';
					//finish.heuristic_val=h.compute_heuristic(finish);
					mov.add(finish);
					--i;
					--j;
				}
				else
					break;
			}
		}
		/*left down*/
		{
			int i=posx+1, j=posy-1;
			while(i<r && j>=0)
			{
				if(next.board[i][j]==' ')
				{
					Board finish = new Board(next);
					finish.board[i][j] = 'A';
					//finish.heuristic_val=h.compute_heuristic(finish);
					mov.add(finish);
					++i;
					--j;
				}
				else
					break;
			}
		}
		/*right up*/
		{
			int i=posx-1, j=posy+1;
			while(i>=0 && j<c)
			{
				if(next.board[i][j]==' ')
				{
					Board finish = new Board(next);
					finish.board[i][j] = 'A';
					//finish.heuristic_val=h.compute_heuristic(finish);
					mov.add(finish);
					--i;
					++j;
				}
				else
					break;
			}
		}
		/*right down*/
		{
			int i=posx+1, j=posy+1;
			while(i<r && j<c)
			{
				if(next.board[i][j]==' ')
				{
					Board finish = new Board(next);
					finish.board[i][j] = 'A';
					//finish.heuristic_val=h.compute_heuristic(finish);
					mov.add(finish);
					++i;
					++j;
				}
				else
					break;
			}
		}
		//System.out.println("Exiting: "+ b.toString());
	}
	public void gen_move(Board b, char player)
	{
		pos = player==WHITE ? b.locWhiteAmazon : b.locBlackAmazon;
		int r=b.row;
		int c=b.col;
		for(int amazon = 0; amazon<4; ++amazon)
		{
			int posx=pos[amazon][0];
			int posy=pos[amazon][1];
			/*down*/
			for(int i=posx+1; i<r; ++i)
			{
				if(b.board[i][posy] == ' ')
					shoot_arrow(b, amazon, i, posy, player);
				else
					break;
			}
			/*up*/
			for(int i=posx-1; i>=0; --i)
			{
				if(b.board[i][posy] == ' ')
					shoot_arrow(b, amazon, i, posy, player);
				else
					break;
			}
			/*left*/
			for(int j=posy-1; j>=0; --j)
			{
				if(b.board[posx][j] == ' ')
					shoot_arrow(b, amazon, posx, j, player);
				else
					break;
			}
			/*right*/
			for(int j=posy+1; j<c; ++j)
			{
				if(b.board[posx][j] == ' ')
					shoot_arrow(b, amazon, posx, j, player);
				else
					break;
			}
			/*left up*/
			{
				int i=posx-1, j=posy-1;
				while(i>=0 && j>=0)
				{
					if(b.board[i][j] == ' ')
					{
						shoot_arrow(b, amazon, i, j, player);
						i--;
						j--;
					}
					else
						break;
				}
			}
			/*right down*/
			{
				int i=posx+1, j=posy+1;
				while(i<r && j<c)
				{
					if(b.board[i][j] == ' ')
					{
						shoot_arrow(b, amazon, i, j, player);
						i++;
						j++;
					}
					else
						break;
				}
			}
			/*right up*/
			{
				int i=posx-1, j=posy+1;
				while(i>=0 && j<c)
				{
					if(b.board[i][j] == ' ')
					{
						shoot_arrow(b, amazon, i, j, player);
						i--;
						j++;
					}
					else
						break;
				}
			}
			/*left down*/
			{
				int i=posx+1, j=posy-1;
				while(i<r && j>=0)
				{
					if(b.board[i][j] == ' ')
					{
						shoot_arrow(b, amazon, i, j, player);
						i++;
						j--;
					}
					else
						break;
				}
			}
		}
	}
}
