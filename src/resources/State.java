package resources;

public abstract class State extends AbstractResource {
	
	// A state needs to be able to give its own state

	// public abstract State state();
	
	// it also needs to be able to give its "distance" to another state
	// can be though of as a cost to get to that state
	
	private State parent;
	
	public abstract double distance(State other);
	
	public double g() {
		if(parent == null) { // initial node
			return 0.0;
		}
		else { // return the distance to the parent + the distance from the parent to the start
			return distance(parent)+parent.g();
		}
	}
	
}
