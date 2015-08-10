package alphabeta;

import java.util.List;

import resources.Environment;
import resources.Pair;
import resources.State;

public abstract class NodeOrder <S extends State, E extends Environment<S, E>> {
	
	// this method is the public facing method to order the children of a given state
	// For high breadth-trees, the proper node evaluation order can make or break algorithm performance
	
	public List<Pair<S,E>> order(List<Pair<S,E>> state_children) {
		List<Pair<S,E>> sorted_children = state_children;
    	sorted_children.sort((child1, child2) -> heuristic(child1, child2));
        return sorted_children;
	}
	
	// this heuristic is a comparison statistic for the relative merit of two children of a given S
	
	abstract int heuristic(Pair<S, E> child1, Pair<S, E> child2);

}
