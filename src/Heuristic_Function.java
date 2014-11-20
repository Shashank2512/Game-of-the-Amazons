/*
 * @author: Ashish Khatkar and Prasant Chidella
 */
public class Heuristic_Function
{
	public static int black_size, white_size;
	public static int compute_heuristic(Board b)
	{
		return mobility_evaluator(b);
	}
	/*
	 * To do : Optimize it to use less memory and avoid generating boards unnecessarily
	 * Lower the heuristic more favorable to White Amazon
	 */
	private static int mobility_evaluator(Board b)
	{
		Moves mov=new Moves();
		mov.gen_move(b, 'W');
		white_size=mov.get_size();
		mov.clean_mov();
		mov.gen_move(b, 'B');
		black_size=mov.get_size();
		mov.clean_mov();
		return black_size-white_size;
	}
	public static int get_black_size()
	{
		return black_size;
	}
	public static int get_white_size()
	{
		return white_size;
	}
}
