package resources.examples.heuristics;

import resources.AbstractResource;
import resources.Heuristic;
import resources.examples.states.Location2D;

public class CartesianDistance extends Heuristic<Location2D>{

	@Override
	public double h(Location2D curent, Location2D goal) {
		return curent.distance(goal);
	}

	@Override
	public AbstractResource deepCopy() {
		return new CartesianDistance();
	}

}
