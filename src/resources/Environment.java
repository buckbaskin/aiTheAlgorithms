package resources;

public abstract class Environment<S extends State, E extends Environment<S,E>> extends AbstractResource{

	// The environment is representation of the arena in which the agent acts
	// There may be other agents, obstacles, etc.
	
	// This covers everything but the agent (see State for agent's state in the world)
	
	// updates the Environment based on the state/transition pair.
	// 	This can be where other agents are given a chance to act, the world changes, etc.
	
	public abstract Environment update(S s, E initial);
	
}
