package resources.examples;

import resources.AbstractResource;
import resources.Environment;
import resources.State;
import resources.Transition;

public class Map2D extends Environment<Location2D,Map2D> {
	
	double max_x,max_y;
	
	public Map2D(double x, double y) {
		max_x = x;
		max_y = y;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Environment<Location2D,Map2D> update(Location2D s, Map2D initial) {
		return (Environment<Location2D, Map2D>) initial.deepCopy();
	}

	@Override
	public AbstractResource deepCopy() {
		return new Map2D(xBound(),yBound());
	}
	
	public double xBound() {
		return max_x;
	}
	public double yBound() {
		return max_y;
	}
	
}
