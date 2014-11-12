public class Box {

	private int value;
	private boolean N, W, S, E;
	public Box (int value, boolean N, boolean W, boolean S, boolean E) {
		this.setValue(value);
		this.setN(N);
		this.setW(W);
		this.setS(S);
		this.setE(E);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public boolean isN() {
		return N;
	}
	public void setN(boolean n) {
		N = n;
	}
	public boolean isW() {
		return W;
	}
	public void setW(boolean w) {
		W = w;
	}
	public boolean isS() {
		return S;
	}
	public void setS(boolean s) {
		S = s;
	}
	public boolean isE() {
		return E;
	}
	public void setE(boolean e) {
		E = e;
	}
}
