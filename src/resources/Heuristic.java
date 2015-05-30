package resources;

public abstract class Heuristic<S extends State> extends AbstractResource {

	// estimates the distance between two states (current and goal)
	
	public abstract double h(S curent, S goal);
	
}
