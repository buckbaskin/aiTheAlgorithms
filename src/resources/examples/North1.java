package resources.examples;

import resources.AbstractResource;
import resources.Pair;
import resources.Transition;

public class North1 extends Transition2D {

	@Override
	public Pair<Location2D, Map2D> act(Location2D initial, Map2D world) {
		Location2D l = new Location2D(initial.x(),initial.y()+1.0);
		Map2D m = (Map2D) world.deepCopy();
		return new Pair<Location2D,Map2D>(l,m);
	}

	@Override
	public AbstractResource deepCopy() {
		return new North1();
	}

}
