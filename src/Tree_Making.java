/*
 * @author : Ashish Khatkar and Prasant Chidella
 */
import java.util.*;
import java.io.*;
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
		while(!queue.isEmpty() && cnt<=85000)
		{
			cnt++;
			tmp=queue.getFirst();
			queue.removeFirst();
			var_1--;
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
		//for(ArrayList<Board> ar:tree)
		//{
			//for(Board c : ar)
				//System.out.println(c.toString());
		//}
	}
	public long get_size()
	{
		return (long)tree.size();
	}
}

