/*
 * @author: Ashish Khatkar and Prasant Chidella
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
public class Beam_Search
{
	/*
	 * To do : Add beam search code
	 * Say black_moves are 1, white_moves are 5 is better than black_moves = 45 and white_moves = 50
	 */
	//public static ArrayList<Board> win;
	public static ArrayList<ArrayList<Board>> win;
	public static final int beam_size = 50;
	public static int inf = 100000000;
	public static ArrayList<Board> gamesWon = new ArrayList<Board>();
	public static ArrayList<Board> gamesLost = new ArrayList<Board>();
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
		b.parent = null;
		win = new ArrayList<ArrayList<Board>> ();
		//win.add(b);
		char player = 'W';
		LinkedList<Board> queue = new LinkedList<Board> ();
		queue.addFirst(b);
		boolean flag=true;
		while(true)
		{
			ArrayList<Board> next = new ArrayList<Board> ();
//			System.out.println(queue.size());
//			System.out.println(queue.getFirst());
//			System.out.println(queue.getFirst().parent);
//			System.out.println(next.size());
			while(!queue.isEmpty())
			{
				Board tp = queue.getLast();
				queue.removeLast();
				Moves next_moves = new Moves();
				next_moves.gen_move(tp, player);
				ArrayList<Board> ar = next_moves.return_moves();
				next_moves.clean_mov();
				for(Board tmp : ar)
				{
//					tmp.parent = tp;
					Moves tmp_moves = new Moves();
					tmp_moves.gen_move(tmp, player=='W'?'B':'W');
					int opp_player_size = tmp_moves.get_size();
					tmp_moves.clean_mov();
					tmp_moves.gen_move(tmp, player);
					int cur_player_size = tmp_moves.get_size();
					tmp_moves.clean_mov();
					if(player=='W')
					{
						if(opp_player_size==0) {
							tmp.heuristic_val = -inf;
							gamesWon.add(tmp);
						}
						else
							tmp.heuristic_val = opp_player_size - cur_player_size;
					}
					else
					{
						if(opp_player_size==0) {
							tmp.heuristic_val = inf;
//							gamesLost.add(tmp);
						}
						else
							tmp.heuristic_val = cur_player_size - opp_player_size;
					}
					tmp.parent = tp;
					next.add(tmp);
				}
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
				if(cnt > beam_size)
					break;
			}
			win.add(to_add);
			player = player=='W'?'B':'W';

			if (queue.isEmpty()) {
				break;
			}
		}
//		System.out.println(player);
		System.out.println(gamesWon.size());

		System.out.println(printPath(gamesWon.get(0)));
	}

	public static String printPath(Board b) {
		Stack s = new Stack<Board>();
		StringBuilder sb = new StringBuilder();
		while (b.parent != null) {
			s.push(b);
			b = b.parent;
		}
		while (!s.isEmpty()) {
			sb.append(s.pop());
			sb.append("\n");
		}
		return sb.toString();
	}
}