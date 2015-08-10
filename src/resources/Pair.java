package resources;

public class Pair<A,B> {
	
	public final A a;
	public final B b;
	
	public Pair(A one, B two) {
		a = one;
		b = two;
	}
	
	public A a() {
		return a;
	}
	public B b() {
		return b;
	}

}
