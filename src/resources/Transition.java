package resources;

public abstract class Transition<S extends State, E extends Environment<S,E>> extends AbstractResource {

	// A Transition can be thought of as a possible move
	
	// A transition must, when given an initial state+environment, return the next state+environment after the action
	
	public Pair<S,E> actOn(S initial, E world) {
		Pair<S,E> toReturn = act(initial,world);
		toReturn.a.parent(initial);
		return toReturn;
	}
	
	protected abstract Pair<S,E> act(S inital, E world);
	
	// A transition must know if it is useful, i.e. valid
	// 	returns true if it changes the state in a useful way to the user.
	
	public boolean is_valid(S initial, E world) {
		// returns true if the distance between two states is non-zero
		// does not consider the distance between Environments, even if that is a useful measure in one way or another.
		return initial.distance(act(initial, world).a()) != 0.0;
	}
	
}

