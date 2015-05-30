package resources.examples.transitions;

import resources.AbstractResource;
import resources.Pair;
import resources.Transition;
import resources.examples.environments.Map2D;
import resources.examples.states.Location2D;

public class East1 extends Transition2D {

	@Override
	public Pair<Location2D, Map2D> act(Location2D initial, Map2D world) {
		Location2D l = new Location2D(initial.x()-1.0,initial.y());
		Map2D m = (Map2D) world.deepCopy();
		return new Pair<Location2D,Map2D>(l,m);
	}

	@Override
	public AbstractResource deepCopy() {
		return new East1();
	}

}
