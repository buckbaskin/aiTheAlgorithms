package resources.examples.heuristics;

import resources.AbstractResource;
import resources.Heuristic;
import resources.examples.states.Location2D;

public class TaxiDistance extends Heuristic<Location2D>{

	@Override
	public double h(Location2D curent, Location2D goal) {
		return Math.abs(goal.y()-curent.y())+Math.abs(goal.x()-curent.y());
	}

	@Override
	public AbstractResource deepCopy() {
		return new TaxiDistance();
	}

}
