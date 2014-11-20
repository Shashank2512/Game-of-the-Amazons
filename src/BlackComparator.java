import java.util.Comparator;


public class BlackComparator implements Comparator<Board>{

	@Override
	public int compare(Board arg0, Board arg1) {
		return -Integer.compare(arg0.heuristic_val, arg1.heuristic_val);
	}

}
