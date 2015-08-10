package resources.examples.states;

import resources.AbstractResource;
import resources.State;

public class Location2D extends State {

	double x,y;
	
	public Location2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Location2D() {
		this(0.0,0.0);
	}
	
	// GETTER
	public Location2D get() {
		return new Location2D(x(),y());
	}
	
	// SETTER
	public void set(Location2D input) {
		this.x(input.x());
		this.y(input.y());
	}

	@Override
	public double distance(State other) {
		try {
			Location2D l = (Location2D) other;
			double dx = l.x()-x();
			double dy = l.y()-y();
			return Math.sqrt(dx*dx+dy*dy);
		}
		catch (ClassCastException cce) {
			return Double.MAX_VALUE;
		}
	}
	
	public double x() {
		return x;
	}
	private double x(double new_x) {
		return x = new_x;
	}
	public double y() {
		return y;
	}
	private double y(double new_y) {
		return y = new_y;
	}

	@Override
	public AbstractResource deepCopy() {
		return new Location2D(x(),y());
	}
	
	@Override
	public String toString() {
		return "{"+x()+","+y()+"}";
	}

}
