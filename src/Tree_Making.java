/*
 * @author : Ashish Khatkar and Prasant Chidella
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Tree_Making
{
	public static ArrayList<ArrayList<Board>> tree=new ArrayList<ArrayList<Board>>();
	public static ArrayList<Board> par=new ArrayList<Board>();
	public ArrayList<ArrayList<Board>> get_tree()
	{
		return tree;
	}
	public void add_move(ArrayList<Board> child)
	{
		tree.add(child);
	}
	public void construct_tree()
	{
		boolean player_white=true;
		Board tmp=new Board();
		Moves move=new Moves();
		//move.gen_move(b, player_white?'W':'B');
		ArrayList<Board> bache;
		//add_move(bache);
		LinkedList<Board> queue=new LinkedList<Board>();
		queue.addLast(tmp);
		int cnt=0;
		int var_1=1, var_2=0;
		while(!queue.isEmpty() && cnt<=50000)
		{
			cnt++;
			tmp=queue.getFirst();
			queue.removeFirst();
			var_1--;
			tmp.heuristic_val=Heuristic_Function.compute_heuristic(tmp);
			tmp.black_moves=Heuristic_Function.get_black_size();
			tmp.white_moves=Heuristic_Function.get_white_size();
			par.add(tmp);
			move.gen_move(tmp, player_white==true?'W':'B');
			bache=move.return_moves();
			var_2+=bache.size();
			add_move(bache);
			if(var_1==0)
			{
				player_white=!player_white;
				var_1=var_2;
				var_2=0;
			}
			queue.addAll(bache);
			move.clean_mov();
		}
		System.out.println(player_white);
		System.out.println(tree.get(par.size()-1).size());
		System.out.println(par.get(par.size()-1));
		int add=0;
		for(ArrayList<Board> ar:tree)
		{
			add+=ar.size();
		}
		System.out.println(add);
			//for(Board c : ar)
				//System.out.println(c.toString());
		//}
	}
	public long get_size()
	{
		return tree.size();
	}
}

