package resources;

public abstract class State {
	
	// A state needs to be able to give its own state

	// public abstract State state();
	
	// it also needs to be able to give its "distance" to another state
	// can be though of as a cost to get to that state
	
	public abstract double distance(State other);
	
}
