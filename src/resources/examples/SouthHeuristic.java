package resources.examples;

import resources.AbstractResource;
import resources.Heuristic;

public class SouthHeuristic extends Heuristic<Location2D>{

	@Override
	public double h(Location2D curent, Location2D goal) {
		return Math.max(0.0, goal.y()-curent.y());
	}

	@Override
	public AbstractResource deepCopy() {
		return new SouthHeuristic();
	}

}
