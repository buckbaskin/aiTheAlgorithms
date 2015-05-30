package resources.examples.transitions;

import resources.Transition;
import resources.examples.environments.Map2D;
import resources.examples.states.Location2D;

public abstract class Transition2D extends Transition<Location2D, Map2D>{
	
	public boolean inEnv(Location2D loc, Map2D m) {
		if (loc.x() >= 0.0 && loc.x() <= m.xBound()) {
			if (loc.y() >= 0.0 && loc.y() <= m.yBound()) {
				return true;
			}
		}
		return false;
	}

}
