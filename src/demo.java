/*
 * @author: Ashish Khatkar and Prasant Chidella
 */
public class demo 
{
	public static void main(String[] args) 
	{
		Board b = new Board(4);
		Beam_Search bs = new Beam_Search();
		bs.beam_search(b);
		/*Tree_Making tm=new Tree_Making();
		tm.construct_tree();
		System.out.println(tm.get_size());
		/*Board b = new Board();
		System.out.println(b.get_board());
		Moves move = new Moves();
		move.gen_move(b, 'W');
		//move.gen_move(b, 'B');
		System.out.println(move.get_size());*/
	}
}
