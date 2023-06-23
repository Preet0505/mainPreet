package mainc;

public interface Remider {

	public default float remider(float x, float y ) {
		float n;
		n=x % y;
		return n;
	}
}
