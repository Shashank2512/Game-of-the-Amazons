/*
 * @author: Ashish Khatkar and Prasant Chidella
 */
import java.util.*;
public class Beam_Search 
{
	/*
	 * To do : Add beam search code
	 * Say black_moves are 1, white_moves are 5 is better than black_moves = 45 and white_moves = 50
	 */
	//public static ArrayList<Board> win;
	public static ArrayList<ArrayList<Board>> win;
	public static final int beam_size = 10000;
	public static int inf = 100000000;
	public static ArrayList<ArrayList<Board>> compute_heuristic_path(Board b)
	{
		beam_search(b);
		return win;
	}
	public static boolean goal_reached(Board b)
	{
		if(b.black_moves==0 && b.white_moves==0)
			return true;
		return false;
	}
	public static void beam_search(Board b)
	{
		win = new ArrayList<ArrayList<Board>> ();
		//win.add(b);
		char player = 'W';
		LinkedList<Board> queue = new LinkedList<Board> ();
		queue.addFirst(b);
		boolean flag=true;
		while(!queue.isEmpty())
		{
			ArrayList<Board> next = new ArrayList<Board> ();
			while(!queue.isEmpty())
			{
				Board tp = queue.getLast();
				queue.removeLast();
				Moves next_moves = new Moves();
				next_moves.gen_move(b,player);
				for(Board tmp : next_moves.return_moves())
				{
					Moves tmp_moves = new Moves();
					tmp_moves.gen_move(tmp, player=='W'?'B':'W');
					int opp_player_size = tmp_moves.get_size();
					tmp_moves.clean_mov();
					tmp_moves.gen_move(tmp, player);
					int cur_player_size = tmp_moves.get_size();
					if(player=='W')
					{
						if(opp_player_size==0)
							tmp.heuristic_val = -inf;
						else
							tmp.heuristic_val = opp_player_size - cur_player_size;
					}
					else
					{
						if(opp_player_size==0)
							tmp.heuristic_val = inf;
						else
							tmp.heuristic_val = cur_player_size - opp_player_size;
					}
					tmp.parent = tp;
					next.add(tmp);
				}
				/*next_moves.gen_move(b, player=='W'?'B':'W');
				int opp_player_size = next_moves.get_size();
				next_moves.clean_mov();
				next_moves.gen_move(b, player);
				int cur_player_size = next_moves.get_size();
				next.addAll(next_moves.return_moves());
				/*if(next_moves.return_moves().size()==0)
				{
					flag=false;
					break;
				}*/
			}
			if(player=='W')
				Collections.sort(next, new WhiteComparator());
			else
				Collections.sort(next, new BlackComparator());
			int cnt=0;
			ArrayList<Board> to_add=new ArrayList<Board>();
			for(Board tz : next)
			{
				queue.add(tz);
				cnt++;
				to_add.add(tz);
				if(cnt>1000)
					break;
			}
			win.add(to_add);
			player = player=='W'?'B':'W';
		}
		System.out.println(player);
	}
}