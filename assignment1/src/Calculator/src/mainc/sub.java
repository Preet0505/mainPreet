package mainc;

public interface sub{
	public default int sub(int x, int y) {
		int n;
		n=x-y;
		return n;
	}
	
}
