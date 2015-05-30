package resources;

public abstract class Heuristic extends AbstractResource {

	// estimates the distance between two states (current and goal)
	
	public abstract double h(State curent, State goal);
	
}
